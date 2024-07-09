import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
 
public class SecureRandomGen
{
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
         
        // Get 128 random bytes
        byte[] randomBytes = new byte[128];
        secureRandomGenerator.nextBytes(randomBytes);
         
        //Get random integer
        int r = secureRandomGenerator.nextInt();
         
        //Get random integer in range
        int randInRange = secureRandomGenerator.nextInt(999999);
        
        System.out.print(randInRange);
    }
}