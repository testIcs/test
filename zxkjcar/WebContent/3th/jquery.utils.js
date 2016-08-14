/**
 * jQuery 扩展
 */
(function($)
{
    Date.prototype.format = function(format)
    {
        var o = {
            "M+" : this.getMonth() + 1,
            "d+" : this.getDate(),
            "h+" : this.getHours(),
            "m+" : this.getMinutes(),
            "s+" : this.getSeconds(),
            "q+" : Math.floor((this.getMonth() + 3) / 3),
            "S" : this.getMilliseconds()
        }
        if (/(y+)/.test(format))
        {
            format =
                    format.replace(RegExp.$1, (this.getFullYear() + "")
                            .substr(4 - RegExp.$1.length));
        }
        for (var k in o)
        {
            if (new RegExp("(" + k
                    + ")").test(format))
            {
                format =
                        format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                                    : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    };

    var charToEntity, entityToChar, charToEntityRegex, entityToCharRegex;

    function addCharacterEntities(newEntities)
    {
        var charKeys = [], entityKeys = [], key, echar;
        for (key in newEntities)
        {
            echar = newEntities[key];
            entityToChar[key] = echar;
            charToEntity[echar] = key;
            charKeys.push(echar);
            entityKeys.push(key);
        }
        charToEntityRegex = new RegExp('(' + charKeys.join('|')
                    + ')', 'g');
        entityToCharRegex = new RegExp('(' + entityKeys.join('|')
                    + '|&#[0-9]{1,5};'
                    + ')', 'g');
    }

    function resetCharacterEntities()
    {
        charToEntity = {};
        entityToChar = {};
        // add the default set
        addCharacterEntities({
            '&amp;' : '&',
            '&gt;' : '>',
            '&lt;' : '<',
            '&quot;' : '"',
            '&#39;' : "'"
        });
    }

    function htmlEncodeReplaceFn(match, capture)
    {
        return charToEntity[capture];
    }

    function htmlDecodeReplaceFn(match, capture)
    {
        return (capture in entityToChar) ? entityToChar[capture] : String
            .fromCharCode(parseInt(capture.substr(2), 10));
    }

    $.extend({
        /**
         * Date, Object, String, Number, Boolean, Regexp, Function, undefined,
         * null, Math
         * 
         * @param {}
         *            arg
         * @param {}
         *            type
         * @return {}
         */
        isTypeOf : function(arg, type)
        {
            try
            {
                var otype = $.type(arg);
                if (type.toLowerCase() === otype.toLowerCase())
                {
                    return true;
                }
                return false;
            }
            catch (e)
            {
                return false;
            }
        },
        isString : function(arg)
        {
            return this.isTypeOf(arg, 'string');
        },
        isObject : function(arg)
        {
            return this.isTypeOf(arg, 'object');
        },
        isDate : function(arg)
        {
            return this.isTypeOf(arg, 'date');
        },
        isObjectArray : function(obj)
        {
            function isArraylike(obj)
            {
                var length = obj.length, type = jQuery.type(obj);

                if (jQuery.isWindow(obj))
                {
                    return false;
                }

                if (obj.nodeType === 1 && length)
                {
                    return true;
                }

                return type === "array" || type !== "function"
                        && (length === 0 || typeof length === "number" && length > 0
                                && (length - 1) in obj);
            }
            return isArraylike(obj);
        },
        ellipsis : function(value, length, word)
        {
            if (value && value.length > length)
            {
                if (word)
                {
                    var vs = value.substr(0, length - 2), index =
                            Math.max(vs.lastIndexOf(' '), vs.lastIndexOf('.'),
                                vs.lastIndexOf('!'), vs.lastIndexOf('?'));
                    if (index !== -1 && index >= (length - 15))
                    {
                        return vs.substr(0, index) + "...";
                    }
                }
                return value.substr(0, length - 3) + "...";
            }
            return value;
        },
        htmlDecode : function(value)
        {
            resetCharacterEntities();
            return (!value) ? value : String(value).replace(entityToCharRegex,
                htmlDecodeReplaceFn);
        },
        htmlEncode : function(value)
        {
            resetCharacterEntities();
            return (!value) ? value : String(value).replace(charToEntityRegex,
                htmlEncodeReplaceFn);
        }
    });
    $.fn.extend({
        /**
         * Form序列化添加自定义属性，不包含form已存在的属性
         * 
         * @param {}
         *            fields [{name:'abc',value:'abc'}]
         * @return {}
         */
        serialize : function(fields)
        {
            function isExist(arr, obj)
            {
                var exist = false;
                $.each(arr, function(i, ar)
                {
                    if (obj.name == ar.name)
                    {
                        exist = true;
                    }
                });
                return exist;
            }
            if (fields && $.isObjectArray(fields))
            {
                var fds = [], serializeArray = this.serializeArray();

                $.each(fields, function(idx, field)
                {
                    $.each(serializeArray, function(idex, serialize)
                    {
                        if (field.name != serialize.name)
                        {
                            if (!isExist(fds, field))
                            {
                                fds.push(field);
                            }
                        }
                    });
                });
                fds = serializeArray.concat(fds);
                return jQuery.param(fds);
            }
            else
            {
                return jQuery.param(this.serializeArray());
            }
        }
    });
})(jQuery);