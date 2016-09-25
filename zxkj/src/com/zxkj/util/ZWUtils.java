package com.zxkj.util;

import java.io.IOException;

import com.zkteco.biometric.FingerprintCaptureListener;
import com.zkteco.biometric.FingerprintSensor;
import com.zkteco.biometric.FingerprintSensorErrorCode;

public class ZWUtils 
{
	//the width of fingerprint image
		static int width = 0;
		
		//the height of fingerprint image
		static int height = 0;
		
		//for verify test
		private static byte[] lastRegTemp = new byte[2048];
		
		//the length of lastRegTemp
		private static int cbRegTemp = 0;
		
		//pre-register template
		private static byte[][] regtemparray = new byte[3][2048];
		
		//Register
		private static boolean bRegister = false;
		
		//Identify
		private static boolean bIdentify = true;
		
		//finger id
		private static int iFid = 1;
		
		//must be 3
		static final int enroll_cnt = 3;
		
		//the index of pre-register function
		private static int enroll_idx = 0;
		
		private static FingerprintSensor fingerprintSensor = null;
		
		private static void FreeSensor()
		{
			if (null != fingerprintSensor)
			{
				fingerprintSensor.stopCapture();
				fingerprintSensor.closeDevice();
				fingerprintSensor.destroy();
				fingerprintSensor = null;
			}
		}
		
		public static final void makeZWImg(final String filePath) 
				throws IOException
		{
			if (fingerprintSensor != null)
			{
				return;
			}
			
			cbRegTemp = 0;
			bRegister = false;
			bIdentify = false;
			iFid = 1;
			enroll_idx = 0;
			
			fingerprintSensor = new FingerprintSensor();
			
			int ret = fingerprintSensor.getDeviceCount();
			
			if (ret < 0)
			{
				FreeSensor();
				return;
			}
			
			ret = fingerprintSensor.openDevice(0);
			
			if (ret != FingerprintSensorErrorCode.ERROR_SUCCESS)
			{
				FreeSensor();
				return;
			}
			
			fingerprintSensor.setFakeFunOn(1);
			
			width = fingerprintSensor.getImageWidth();
			height = fingerprintSensor.getImageHeight();
			
			final FingerprintCaptureListener listener = new FingerprintCaptureListener() 
			{
				@Override
				public void captureError(int arg0) {
				}
				
				@Override
				public void captureOK(byte[] arg0) {
					try {
						writeBitmap(arg0, width, height, filePath);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				@Override
				public void extractOK(byte[] arg0) {
					if (fingerprintSensor.getFakeFunOn() == 1)
					{
						int fakeStatus = fingerprintSensor.getFakeStatus();
						if ((fakeStatus & 31) != 31)
						{
							return;
						}
					}
					if(bRegister)
					{
						int[] fid = new int[1];
						int[] score = new int [1];
		                int ret = fingerprintSensor.IdentifyFP(arg0, fid, score);
		                if (ret == 0)
		                {
		                    bRegister = false;
		                    enroll_idx = 0;
		                    return;
		                }
		                if (enroll_idx > 0 && fingerprintSensor.MatchFP(regtemparray[enroll_idx-1], arg0) <= 0)
		                {
		                    return;
		                }
		                System.arraycopy(arg0, 0, regtemparray[enroll_idx], 0, 2048);
		                enroll_idx++;
		                if (enroll_idx == 3) {
		                	int[] _retLen = new int[1];
		                    _retLen[0] = 2048;
		                    byte[] regTemp = new byte[_retLen[0]];
		                    
		                    if (0 == (ret = fingerprintSensor.GenRegFPTemplate(regtemparray[0], regtemparray[1], regtemparray[2], regTemp, _retLen)) &&
		                    		0 == (ret = fingerprintSensor.DBAdd(iFid, regTemp))) {
		                    	iFid++;
		                    	cbRegTemp = _retLen[0];
		                        System.arraycopy(regTemp, 0, lastRegTemp, 0, cbRegTemp);
		                    } else {
		                    }
		                    bRegister = false;
		                } else {
		                }
					}
					else
					{
						if (bIdentify)
						{
							int[] fid = new int[1];
							int[] score = new int [1];
							int ret = fingerprintSensor.IdentifyFP(arg0, fid, score);
		                    if (ret == 0)
		                    {
		                    }
		                    else
		                    {
		                    }
		                        
						}
						else
						{
							if(cbRegTemp <= 0)
							{
							}
							else
							{
								int ret = fingerprintSensor.MatchFP(lastRegTemp, arg0);
								if(ret > 0)
								{
								}
								else
								{
								}
							}
						}
					}
				}
			};
			
			fingerprintSensor.setFingerprintCaptureListener(listener);
			
			boolean bRet = fingerprintSensor.startCapture();
			
	        if (!bRet)
	        {
	     	    FreeSensor();
				return;
	        }
		}
		
		public static byte[] changeByte(int data) 
		{
			byte b4 = (byte) ((data) >> 24);
			byte b3 = (byte) (((data) << 8) >> 24);
			byte b2 = (byte) (((data) << 16) >> 24);
			byte b1 = (byte) (((data) << 24) >> 24);
			byte[] bytes = { b1, b2, b3, b4 };
			return bytes;
		}
		
		public static void writeBitmap(byte[] imageBuf, int nWidth, int nHeight,
				String path) throws IOException 
		{
			java.io.FileOutputStream fos = new java.io.FileOutputStream(path);
			java.io.DataOutputStream dos = new java.io.DataOutputStream(fos);

			int bfType = 0x424d; // 位图文件类型（0—1字节）
			int bfSize = 54 + 1024 + nWidth * nHeight;// bmp文件的大小（2—5字节）
			int bfReserved1 = 0;// 位图文件保留字，必须为0（6-7字节）
			int bfReserved2 = 0;// 位图文件保留字，必须为0（8-9字节）
			int bfOffBits = 54 + 1024;// 文件头开始到位图实际数据之间的字节的偏移量（10-13字节）

			dos.writeShort(bfType); // 输入位图文件类型'BM'
			dos.write(changeByte(bfSize), 0, 4); // 输入位图文件大小
			dos.write(changeByte(bfReserved1), 0, 2);// 输入位图文件保留字
			dos.write(changeByte(bfReserved2), 0, 2);// 输入位图文件保留字
			dos.write(changeByte(bfOffBits), 0, 4);// 输入位图文件偏移量

			int biSize = 40;// 信息头所需的字节数（14-17字节）
			int biWidth = nWidth;// 位图的宽（18-21字节）
			int biHeight = nHeight;// 位图的高（22-25字节）
			int biPlanes = 1; // 目标设备的级别，必须是1（26-27字节）
			int biBitcount = 8;// 每个像素所需的位数（28-29字节），必须是1位（双色）、4位（16色）、8位（256色）或者24位（真彩色）之一。
			int biCompression = 0;// 位图压缩类型，必须是0（不压缩）（30-33字节）、1（BI_RLEB压缩类型）或2（BI_RLE4压缩类型）之一。
			int biSizeImage = nWidth * nHeight;// 实际位图图像的大小，即整个实际绘制的图像大小（34-37字节）
			int biXPelsPerMeter = 0;// 位图水平分辨率，每米像素数（38-41字节）这个数是系统默认值
			int biYPelsPerMeter = 0;// 位图垂直分辨率，每米像素数（42-45字节）这个数是系统默认值
			int biClrUsed = 0;// 位图实际使用的颜色表中的颜色数（46-49字节），如果为0的话，说明全部使用了
			int biClrImportant = 0;// 位图显示过程中重要的颜色数(50-53字节)，如果为0的话，说明全部重要

			dos.write(changeByte(biSize), 0, 4);// 输入信息头数据的总字节数
			dos.write(changeByte(biWidth), 0, 4);// 输入位图的宽
			dos.write(changeByte(biHeight), 0, 4);// 输入位图的高
			dos.write(changeByte(biPlanes), 0, 2);// 输入位图的目标设备级别
			dos.write(changeByte(biBitcount), 0, 2);// 输入每个像素占据的字节数
			dos.write(changeByte(biCompression), 0, 4);// 输入位图的压缩类型
			dos.write(changeByte(biSizeImage), 0, 4);// 输入位图的实际大小
			dos.write(changeByte(biXPelsPerMeter), 0, 4);// 输入位图的水平分辨率
			dos.write(changeByte(biYPelsPerMeter), 0, 4);// 输入位图的垂直分辨率
			dos.write(changeByte(biClrUsed), 0, 4);// 输入位图使用的总颜色数
			dos.write(changeByte(biClrImportant), 0, 4);// 输入位图使用过程中重要的颜色数

			for (int i = 0; i < 256; i++) 
			{
				dos.writeByte(i);
				dos.writeByte(i);
				dos.writeByte(i);
				dos.writeByte(0);
			}

			for(int i=0;i<nHeight;i++)
				dos.write(imageBuf, (nHeight-1-i)*nWidth, nWidth);
			dos.flush();
			dos.close();
			fos.close();
		}
}
