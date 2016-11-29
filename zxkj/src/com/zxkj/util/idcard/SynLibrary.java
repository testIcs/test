package com.zxkj.util.idcard;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface SynLibrary extends Library  
{
	SynLibrary INSTANCE = (SynLibrary)Native.loadLibrary("SynIDCardAPI", SynLibrary.class);
	
	int Syn_FindReader();
	
	int Syn_OpenPort(int iPort);
	
	int Syn_ClosePort(int iPort);
}
