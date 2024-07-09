import java.io.BufferedReader;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES_ECB_NOPADDING {
	
	private static final String key = "password12345678";
	
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
		    	SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		    	Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
		    	cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		        byte[] encrypted = cipher.doFinal(value.getBytes());
		        PrintHex(encrypted,"0x",",");
		        return Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public static String decrypt(String encrypted) {
	    try {
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	 
	        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
	        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
	        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
	        PrintHex(original,"0x",",");
	        return new String(original);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	 
	    return null;
	}

	public static void main(String[] args) {
		String originalString = "OKKKKKKKKKKKKKKK";
		String encryptedString = "";
		
        System.out.println("Original String to encrypt - " + originalString);
        System.out.println("Encrypted String - " + (encryptedString = AES_ECB_NOPADDING.encrypt(originalString)));
        System.out.println("After decryption - " + AES_ECB_NOPADDING.decrypt(encryptedString));

	}

}
