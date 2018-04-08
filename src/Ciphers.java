import java.util.*;

public class Ciphers {
    public static void main(String[] args) {
        String message0 = "Enter e to encode a message or d to decode a message";
        String message1 = "Enter s to use Substitution Cipher or # to exit";
        System.out.println(message0);
        Scanner input = new Scanner(System.in);

        String in = input.next();

        while(!in.equals("#")) {
            
            if(in.equals("e") || in.equals("E")) {
                System.out.println(message1);
                in = input.next();

                if (in.equals("s") || in.equals("S")) {
                    substitutionCipherEncode();
                }
                
            }
            else if(in.equals("d") || in.equals("D")){
                System.out.println(message1);
                in = input.next();
                
                if(in.equals("s") || in.equals("S")){
                    substitutionCipherDecode();
                }
            }
            System.out.println(message0);
            in = input.next();
        }
    }

    private static void substitutionCipherEncode(){
        String encode = "encode";
        String[] tokenArray = getMessage(encode);

        ArrayList<Integer> encodedArray = new ArrayList<Integer>();
        
        int[] intArray = getInts(tokenArray);
        int shiftSize = subCipherKey();
        
        System.out.println("Encode:");
        for(int i = 0; i < intArray.length; i++) {
            int encodeInt = substitutionEncode(intArray[i], shiftSize);
            encodedArray.add(encodeInt);
        }
        System.out.println();
        System.out.println("Encoded message:");
        for(int i = 0; i < encodedArray.size(); i++){
            char encodedMessage = intsToLetters(encodedArray.get(i));
            System.out.print(encodedMessage);
        }
        System.out.println("\n\n");
    }
    
    private static void substitutionCipherDecode(){
        String decode = "decode";
        String[] tokenArray = getMessage(decode);
        ArrayList<Integer> decodedArray = new ArrayList<Integer>();

        int[] intArray = getInts(tokenArray);
        int shiftSize = subCipherKey();

        System.out.println("Decoded message:");
        for(int i = 0; i < intArray.length; i++){
            int decodedMessage = substitutionDecode(intArray[i], shiftSize);
            decodedArray.add(decodedMessage);
        }
        System.out.println();
        for(int i = 0; i < decodedArray.size(); i++) {
            char letter = intsToLetters(decodedArray.get(i));
            System.out.print(letter);
        }
        System.out.println("\n\n");
        
    }
    
    private static int subCipherKey(){
        System.out.println("Enter a number, this will be your encryption/decryption key so don't lose it!");
        Scanner key = new Scanner(System.in);
        return key.nextInt();
    }

    private static int[] lettersToInts(String word){
        int[] result = new int[word.length()];
        for(int i = 0; i < word.length(); i++){
            result[i] = word.charAt(i) - 'a';
        }
        return result;
    }

    private static char intsToLetters(int number) {
        return (char) (number + 'a');
    }

    private static int substitutionEncode(int letter, int shift) {
        return letter + shift;
    }

    private static int substitutionDecode(int letter, int shift) {
        return letter - shift;
    }
    
    private static String[] getMessage(String message) {
        System.out.println("Enter the message you want to "+message);
        Scanner input = new Scanner(System.in);

        ArrayList<String> tokenTempArray = new ArrayList<String>();

        String nextToken = input.nextLine();

        StringTokenizer tokens = new StringTokenizer(nextToken, " ");

        while (tokens.hasMoreTokens()) {
            String string1 = tokens.nextToken();
            tokenTempArray.add(string1);
            tokenTempArray.add(" ");
        }
        
        String[] tokenArray = new String[tokenTempArray.size()];
        for(int i = 0; i < tokenTempArray.size(); i++) {
            tokenArray[i] = tokenTempArray.get(i);
        }

        return tokenArray;
    }

    private static int[] getInts(String[] messageArray) {
        int arrayLength = messageArray.length;
        ArrayList<Integer> intTempArray = new ArrayList<Integer>();
        for(int i = 0; i < arrayLength; i++) {
            String word = messageArray[i]; //token[i];
            int[] tempArray = lettersToInts(word);
            for(int j = 0; j < tempArray.length; j++){
                intTempArray.add(tempArray[j]);
            }
        }
        int[] intArray = new int[intTempArray.size()]; 
        for(int i = 0; i < intTempArray.size(); i++) {
            intArray[i] = intTempArray.get(i);
        }
        
        return intArray;
    }        
}
