public class CeasarCipher {
    
    public static String encrypt(String word, int shift) {

        String encrypted = "";

        if(shift > 127){
            shift %= 127;
        }else if(shift < 0){
            shift = (shift % 127) + shift;
        }
        
        final int shifter = shift;

        encrypted += word.chars().mapToObj(c ->(char)(c + shifter)).reduce("", (s1, s2) -> s1 + s2, (s, c) -> s + c);
        
        return encrypted;
    }
    
    public static String decrypt(String word, int shift) {

        String decrypted = "";

        if(shift > 127){
            shift %= 127;
        }else if(shift < 0){
            shift = (shift % 127) + shift;
        }
        
        final int shifter = shift;

        decrypted += word.chars().mapToObj(c ->(char)(c - shifter)).reduce("", (c1, c2) -> c1 + c2, (s1, s2) -> s1 + s2);
        
        return decrypted;
    }
    
    public static void main(String[] args){
        String word = "Hello, today is going to be a lovely day! ('.')";
        String encryptedWord = encrypt(word, 10);
        System.out.println(encryptedWord);
        
        String decryptedWord = decrypt(encryptedWord, 10);
        System.out.println(decryptedWord);
    }
}

        // encrypted += word.chars().mapToObj(c ->(char)(c + shifter));/*.reduce((c, d) -> (char)(c + shifter));*/
