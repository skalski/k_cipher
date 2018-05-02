import handler.Binary;
import handler.Cipher;

public class Main {

    public static void main(String[] args) {
        String testText = "This is a test";
        String testKey = "xy56c5ewghjb32ntjdgyztusd67utgjh4wnbegdztz2367u587tgsjhdhxhts6dwgjh";

        Cipher encryption = new Cipher(
                Binary.stringToBinary(testKey),
                Binary.stringToBinary(testText)
        );

        Cipher decryption = new Cipher(
                Binary.stringToBinary(testKey),
                Binary.stringToBinary(Binary.binaryToString(encryption.encrypt()))
        );

        System.out.println(Binary.binaryToString(decryption.decrypt()));

    }
}
