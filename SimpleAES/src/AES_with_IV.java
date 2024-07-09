import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_with_IV {
	
	private static final String key = "password12345678";
	private static final String initVector = "encryptionIntVec";
	
	public static void PrintHex(byte[] byteArray,String prefix,String delimeter) {
		 for(int i = 0; i < byteArray.length ; i++)
			{
				System.out.print(String.format(prefix + "%02X", byteArray[i]));
				if(i+1 == byteArray.length)
				{
					System.out.println("");
				}
				else
				{
					System.out.print(delimeter);
				}
				
			}
	}
	 
	public static String encrypt(String value) {
	    try {
	        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	    	SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	 
	    	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	    	cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
	    	
	        byte[] encrypted = cipher.doFinal(value.getBytes());
	        PrintHex(encrypted, "0x", ",");
	        
	        return Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public static String decrypt(String encrypted) {
	    try {
	        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	 
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
	 
	        return new String(original);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	 
	    return null;
	}
	
	public static void main(String[] args)
    {  	
    	String originalString = "Hello World AES8";
        System.out.println("Original String to encrypt - " + originalString);
        String encryptedString = AES_with_IV.encrypt(originalString);
        System.out.println("Encrypted String - " + encryptedString);
        String decryptedString = AES_with_IV.decrypt(encryptedString);
        System.out.println("After decryption - " + decryptedString);
        
    }

}
