package encryptdecrypt;

public class ShiftAlgorithm implements EncDecAlgorithm {
    @Override
    public String encryptMessage(String in, int k) {
        String result;
        String alphabetLower =("abcdefghijklmnopqrstuvwxyz");
        String alphabetUpper = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        char ch;
        char[]out = new char[in.length()];
        int n;

        for (int i = 0; i < in.length(); i++){
            ch = in.charAt(i);
            if(ch >= 'a'&& ch <='z'){
                n = alphabetLower.indexOf(ch);
                ch = alphabetLower.charAt((n + k)%26);
                out[i]=ch;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                n = alphabetUpper.indexOf(ch);
                ch = alphabetUpper.charAt((n + k)%26);
                out[i]=ch;
            }
            else {
                out[i]=ch;
            }
        }
        result = new String(out);
        return result;
    }

    @Override
    public String decryptMessage(String in, int k) {
        String result;
        String alphabetLower =("abcdefghijklmnopqrstuvwxyz");
        String alphabetUpper = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        char ch;
        char[]out = new char[in.length()];
        int n;
        int key = 26 - k;

        for (int i = 0; i < in.length(); i++){
            ch = in.charAt(i);
            if(ch >= 'a'&& ch <='z'){
                n = alphabetLower.indexOf(ch);
                ch = alphabetLower.charAt((n + key)%26);
                out[i]=ch;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                n = alphabetUpper.indexOf(ch);
                ch = alphabetUpper.charAt((n + key)%26);
                out[i]=ch;
            }
            else {
                out[i]=ch;
            }
        }
        result = new String(out);
        return result;
    }
}
