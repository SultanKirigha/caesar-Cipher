import java.util.Scanner;

public class CaesarCipherEncoding{

    static Scanner input = new Scanner(System.in);


    public static void main(String[] args){

        System.out.println("Enter A text: ");
        String plain = input.nextLine();

        System.out.print("Enter shift key: ");
        int shift = input.nextInt();
        String cipher = encode(plain,shift);


        System.out.println("Cipher text is:  " + cipher);

    }
    public static String encode(String plain,int shift){


        String p = plain.toLowerCase();
        char chr [] = p.toCharArray();
        int key = shift;

        int number;
        String str="";
        char cipher;

        for (int i = 0; i < chr.length; i++){

            number = chr[i] -97;
            number = (number + key + 26) % 26;
            cipher = (char) (number + 97);
            str = str + cipher;
        }
        return str;
    }
}