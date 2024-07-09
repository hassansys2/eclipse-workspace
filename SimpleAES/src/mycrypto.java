import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class mycrypto {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
//            System.out.println(	"myKey : " + myKey + ", Length : " + myKey.length() +"\n" + 
//            					"myKey.getBytes(\"UTF-8\") : " + new String(myKey.getBytes("UTF-8")) + ", Length : " + new String(myKey.getBytes("UTF-8")).length() + "\n" + 
//            					"myKey.getBytes()	: " + new String(myKey.getBytes()) + ", Length : " + new String(myKey.getBytes()).length() + "\n" +
//            					"Array.copyof(myKey.getBytes(\"UTF-8\"),16) : " + new String(Arrays.copyOf(myKey.getBytes(), 16)) + " Length : " + new String(Arrays.copyOf(myKey.getBytes(), 16)).length() + "\n");
//            
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    public static void main(String[] args)
    {
        final String mysecretKey = "ssshhhhhhhhhhh!!!!";
        
        String originalString = "howtodoinjava.com";
        String encryptedString = mycrypto.encrypt(originalString, mysecretKey) ;
        String decryptedString = mycrypto.decrypt(encryptedString, mysecretKey) ;
        
        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}