package com.inter.info.utils;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HandleMD5 {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HandleMD5.class);
	
	private String MDSixteen = "";
	
	
	//采用MD5的16位加密
	public String getMDSixteen(String strName){
		return MDSixteen;
	}
	
	//采用MD5的32位加密
	public String getMDThirtytwo(String strName){
		MessageDigest messageDigest = null;  
		  
        try {  
            messageDigest = MessageDigest.getInstance("MD5");  
  
            messageDigest.reset();  
  
            messageDigest.update(strName.getBytes("UTF-8"));  
        } catch (NoSuchAlgorithmException e) {  
        	logger.info("NoSuchAlgorithmException caught!");
        	logger.info(e.toString());
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();
            logger.info(e.toString());
        }  
  
        byte[] byteArray = messageDigest.digest();  
  
        StringBuffer md5StrBuff = new StringBuffer();  
  
        for (int i = 0; i < byteArray.length; i++) {              
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
            else  
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
        }  
  
        return md5StrBuff.toString(); 
	}
}
