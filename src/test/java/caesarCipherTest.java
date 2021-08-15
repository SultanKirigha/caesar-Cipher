import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class caesarCipherTest {
    @Test
    public void createCipher_instanceOfCipher(){
        Cipher cipher = new Cipher("test string");
        //noinspection ConstantConditions
        assertTrue(cipher instanceof Cipher);
    }

    @Test
    public void runGetInput_returnString_String(){
        Cipher cipher = new Cipher("test string");
        assertEquals("test string", cipher.getInputString());
    }

    @Test
    public void runEncrypt_receiveInput_String(){
        Cipher cipher = new Cipher("test");
        //noinspection ConstantConditions
        assertTrue(cipher.encryptText("right", 1) instanceof String);
    }

    @Test
    public void runEncyrpt_shiftLettersBy1_String() {
        Cipher cipher = new Cipher("a");
        assertEquals("b", cipher.encryptText("right",1));
    }

    @Test
    public void runEncrypt_shiftLettersBy2_String() {
        Cipher cipher = new Cipher("a");
        assertEquals("c", cipher.encryptText("right",2));
    }

    @Test
    public void runEncrypt_shiftLettersBeyondZ_String() {
        Cipher cipher = new Cipher("z");
        assertEquals("a", cipher.encryptText("right",1));
    }

    @Test
    public void runEncrypt_dealingWithEncryptWhitespaces_String() {
        Cipher cipher = new Cipher("a b");
        assertEquals("c d", cipher.encryptText("right",2));
    }

    @Test
    public void runEncrypt_dealingWithNonAlphabets_String() {
        Cipher cipher = new Cipher("1-2.3");
        assertEquals("1-2.3", cipher.encryptText("right",3));
    }

    @Test
    public void runEncrypt_shiftLettersToLeftBy1_String() {
        Cipher cipher = new Cipher("b");
        assertEquals("a", cipher.encryptText("left",1));
    }

    @Test
    public void runEncrypt_shiftLettersLeftBeyondA_String() {
        Cipher cipher = new Cipher("a");
        assertEquals("z", cipher.encryptText("left",1));
    }

    @Test
    public void runDecrypt_receiveInput_String(){
        Cipher cipher = new Cipher("test");
        //noinspection ConstantConditions
        assertTrue(cipher.decryptText("right", 1) instanceof String);
    }

    @Test
    public void runDecrypt_decryptShiftBy1_String() {
        Cipher cipher = new Cipher("z");
        assertEquals("a", cipher.decryptText("right",1));
    }

    @Test
    public void runDecrypt_decryptShiftBy2_String() {
        Cipher cipher = new Cipher("cd");
        assertEquals("ef", cipher.decryptText("right",2));
    }

    @Test
    public void runDecrypt_decryptShiftBeyondA_String() {
        Cipher cipher = new Cipher("fyyfhp fy ifbs");
        assertEquals("attack at dawn", cipher.decryptText("left",5));
    }

    @Test
    public void runDecrypt_decryptWithWhitespace_String() {
        Cipher cipher = new Cipher("a b c");
        assertEquals("z a b", cipher.decryptText("left",1));
    }

    @Test
    public void runDecrypt_decryptToTheRight_String() {
        Cipher cipher = new Cipher("z");
        assertEquals("a", cipher.decryptText("right",1));
    }

    @Test
    public void runDecrypt_dealingWithNonAlphabets_String() {
        Cipher cipher = new Cipher("1-2.3");
        assertEquals("1-2.3", cipher.decryptText("right",3));
    }
}
