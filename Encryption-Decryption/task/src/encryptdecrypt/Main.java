package encryptdecrypt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String message = "";
        int key =0;
        String inputFileName = "";
        String outFileName = "" ;
        String mode ="";
        String algorith ="";
        Scanner s;
        Cipher cipher = new Cipher();
        for (int i =0,j = 1; j < args.length; i++,j++) {
            if (args[i].equals("-data")) {
                message = args[j];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[j]);
            }
            if (args[i].equals("-in")) {
                inputFileName = args[j];
            }
            if (args[i].equals("-out")) {
                outFileName = args[j];
            }
            if (args[i].equals("-mode")){
                mode = args[j];
            }
            if (args[i].equals("-alg")) {
                algorith = args[j];
            }

        }
            if(message.equals("")) {
                try {
                    s = new Scanner(new File(inputFileName));
                    message = s.nextLine();
                    s.close();
                }
                catch (IOException e){
                    System.out.println("Eror");
                }
            }
            if (message.equals("")&& inputFileName.equals("")){
                s = new Scanner(System.in);
                message = s.nextLine();
                key = s.nextInt();
                s.close();
            }
            if (algorith.equals("unicode")){
                cipher.setAlgorithm(new UnicodeAlgorithm());
            }
            else {
                cipher.setAlgorithm(new ShiftAlgorithm());
            }

            if(outFileName.equals("")) {

                if (mode.equals("dec")) {
                    System.out.println(cipher.algorithm.decryptMessage(message, key));
                } else {
                    System.out.println(cipher.algorithm.encryptMessage(message, key));
                }
            }
            else{
                if (mode.equals("dec")){

                    try {
                        File file = new File(outFileName);
                        FileWriter writer = new FileWriter(file);
                        writer.write(cipher.algorithm.decryptMessage(message, key));
                        writer.close();
                    }
                    catch (IOException e){
                        System.out.println("Eror");
                    }
                }
                else{
                    File file = new File(outFileName);
                    try(FileWriter writer = new FileWriter(file)) {
                        writer.write(cipher.algorithm.encryptMessage(message, key));
                    }
                    catch (IOException e){
                        System.out.println("Eror");
                    }

                }

            }

    }
}
