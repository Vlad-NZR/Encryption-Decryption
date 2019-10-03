package encryptdecrypt;

public class UnicodeAlgorithm implements EncDecAlgorithm {
    @Override
    public String encryptMessage(String in,int k) {
        String result;
        char ch;
        char[] out = new char[in.length()];
        for (int i = 0; i < in.length(); i++) {
            ch = in.charAt(i);
            ch += k;
            out[i] = ch;
        }
        result = new String(out);
        return result;
    }

    @Override
    public String decryptMessage(String in, int k) {
        String result;
        char ch;
        char[] out = new char[in.length()];
        for (int i = 0; i < in.length(); i++) {
            ch = in.charAt(i);
            ch -= k;
            out[i] = ch;
        }
        result = new String(out);
        return result;
    }
}
