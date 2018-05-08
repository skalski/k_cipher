import handler.Binary;
import handler.Cipher;
import key.KeyHandler;

public class Main {

    public static void main(String[] args) {
        String testText = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr," +
                " sed diam nonumy eirmod tempor invidunt ut labore et dolore magna" +
                " aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo" +
                " dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus" +
                " est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet," +
                " consetetur sadipscing elitr, sed diam nonumy eirmod tempor" +
                " invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua" +
                ". At vero eos et accusam et justo duo dolores et ea rebum." +
                " Stet clita kasd gubergren, no sea takimata sanctus est" +
                " Lorem ipsum dolor sit amet.";

        String passwordToHash = "password";
        String testKey = KeyHandler.getKey(passwordToHash);

        System.out.println(testKey);

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
