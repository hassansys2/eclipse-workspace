public class HexToString {

	public static void main(String[] args) {
		//String str = "Hello This is Hassan Ahmad";
		//System.out.print(str.length());
		//System.out.print(new String(Base64.getDecoder().decode(Base64.getEncoder().encodeToString(str.getBytes()))));
		
		////////////////////////////////////////////////////////////
		String plainText = "password12345678";
		
		byte[] str = plainText.getBytes();
		System.out.println("str = " + new String(str));
		
		for(int i = 0; i < str.length ; i++)
		{
			System.out.print(String.format("%02X", str[i]));
			if(i+1 == str.length)
			{
				System.out.println("");
			}
			else
			{
				System.out.print("");
			}
		}
		//48,65,6C,6C,6F,20,57,6F,72,6C,64,20,41,45,53,0A
		//48,65,6C,6C,6F,20,57,6F,72,6C,64,20,41,45,53,0A
		//////////////////////////////////////////////////////////////
		//	0xFF in HEX Equals to 1111 1111 in Binary & 255 in Decimal
		//	The Java byte data type is an 8-bit signed two's complement integer. It has a minimum value of -128 and a maximum value of 127 (inclusive).
		// 	So It cann't store 0xFF Value in it.
		
		char[] newByte = {0x89,0xC6,0xAD,0x1F,0xAD,0xFB,0xBE,0x4B,0x77,0xD1,0x76,0xFC,0x75,0xC1,0x2D,0xAF,
							0xDD,0xF1,0xDC,0x58,0x36,0xF5,0x2F,0x92,0x4C,0x99,0x49,0x69,0xFB,0xB1,0x2C,0x3A};
		
		System.out.println("NewByte = " + new String(newByte));
		
		//////////////////////////////////////////////////////////////
		
		char x[] = {0x00,0x11,0x22,0x33,0x44,0x55,0x66,0x77,0x88,0x99,0xAA,0xBB,0xCC,0xDD,0xEE,0xFF};
		System.out.println(new String(x));
		
	}
}
