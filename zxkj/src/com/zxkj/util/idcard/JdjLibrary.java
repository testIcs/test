package com.zxkj.util.idcard;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface JdjLibrary extends Library  
{
	JdjLibrary INSTANCE = (JdjLibrary)Native.loadLibrary("JdjDll", JdjLibrary.class);
	
	void readIdCard(int iPort, Pointer pointer);
}
