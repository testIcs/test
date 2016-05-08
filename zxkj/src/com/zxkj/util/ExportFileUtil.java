package com.zxkj.util;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportFileUtil {	
	/**
	 * 导出excel文件
	 * @param sheetName sheet名称
	 * @param headList  表头
	 * @param dataList
	 * @param path
	 */
	public static void exportExcel(String sheetName,List<ArrayList<String>> dataList,String path){
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet(sheetName);       
    	// 创建一个居中格式  
        HSSFCellStyle style = wb.createCellStyle();  
        // 第三步，在sheet中循环添加表行,注意老版本poi对Excel的行数列数有限制short  
        for (int i = 0; i < dataList.size(); i++)  
        {  
        	HSSFRow row = sheet.createRow((int) i);        	
        	ArrayList<String> rowList = dataList.get(i);        	      	
    		// 第四步，创建单元格，并设置值表头 设置表头居中  
    		for (int j = 0; j < rowList.size() ; j++) {
           	 	HSSFCell cell = row.createCell((short) j);  
                cell.setCellValue(rowList.get(j));  
                if(i==0){  
                	cell.setCellStyle(style);
        		} 
        	}                      
        }  
        // 第五步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream(path);  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        } 
	}
}
