import java.util.Scanner;

public class CaesarCipherDecoding{

    static Scanner input = new Scanner(System.in);


    public static void main(String[] args){
        System.out.print("Enter cipher text: ");
        String cipher = input.nextLine();

        System.out.print("Enter shift: ");
        int shift = input.nextInt();

        String plain = decryption(cipher, shift);
        System.out.println("Plain text is: " + plain);

    }
    public static String decryption(String cipher,int shift){


        String c = cipher.toLowerCase();
        char chr [] = c.toCharArray();
        int key = shift;

        int index;
        String str="";
        char plain;

        for (int i = 0; i < chr.length; i++){

            index = chr[i] -97;
            index = (index - key + 26) % 26;
            plain = (char) (index + 97);
            str = str + plain;
        }
        return str;
    }
}
