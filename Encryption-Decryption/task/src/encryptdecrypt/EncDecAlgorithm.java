package encryptdecrypt;

public interface EncDecAlgorithm {
     String encryptMessage(String in, int k);
     String decryptMessage(String in, int k);


}
