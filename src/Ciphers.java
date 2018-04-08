import java.util.*;

public class Ciphers {
    public static void main(String[] args) {
        String message = "Enter s to use Substitution Cipher or # to exit";
        System.out.println(message);
        Scanner input = new Scanner(System.in);

        String in = input.next();

        while(!in.equals("#")) {

            if (in.equals("s")) {
                substitutionCipher();
            }
            System.out.println(message);
            in = input.next();
        }
    }

    private static void substitutionCipher(){
        System.out.println("Enter the message you want to encode");
        Scanner input = new Scanner(System.in);

        ArrayList<String> tokenArray = new ArrayList<String>();
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        ArrayList<Integer> encodedArray = new ArrayList<Integer>();
        ArrayList<Integer> decodedArray = new ArrayList<Integer>();

        String nextToken = input.nextLine();

        StringTokenizer tokens = new StringTokenizer(nextToken, " ");

        while(tokens.hasMoreTokens()) {
            String string1 = tokens.nextToken();
            tokenArray.add(string1);
            tokenArray.add(" ");
        }
        int arrayLength = tokenArray.size();
        for(int i = 0; i < arrayLength; i++) {
            String word = tokenArray.get(i); //token[i];
            int[] tempArray = lettersToInts(word);
            for(int j = 0; j < tempArray.length; j++){
                intArray.add(tempArray[j]);
            }
        }
        //Debugger to make sure all elements are in intArray
//        for(int i = 0; i < intArray.size(); i++){
//            System.out.print(intArray.get(i));
//        }
//        System.out.println();
//        
//        for(int i = 0; i < intArray.size(); i++) {
//            System.out.print(intsToLetters(intArray.get(i)));
//        }
//        System.out.println();
        System.out.println("Encode:");
        for(int i = 0; i < intArray.size(); i++) {
            int encode = substitutionEncode(intArray.get(i), 3);
            encodedArray.add(encode);
            System.out.print(encodedArray.get(i));
        }
        System.out.println();
        System.out.println("Encoded message:");
        for(int i = 0; i < encodedArray.size(); i++){
            char encodedMessage = intsToLetters(encodedArray.get(i));
            System.out.print(encodedMessage);
        }
        System.out.println();
        System.out.println("Decode:");
        for(int i = 0; i < encodedArray.size(); i++){
            int decode = substitutionDecode(encodedArray.get(i), 3);
            decodedArray.add(decode);
            System.out.print(decodedArray.get(i));
        }
        System.out.println();
        for(int i = 0; i < decodedArray.size(); i++) {
            char letter = intsToLetters(decodedArray.get(i));
            System.out.print(letter);
        }
        System.out.println("\n\n");
    }

    public static int[] lettersToInts(String word){
        int[] result = new int[word.length()];
        for(int i = 0; i < word.length(); i++){
            result[i] = word.charAt(i) - 'a';
        }
        return result;
    }

    public static char intsToLetters(int number) {
        char result = (char) (number + 'a');
        return result;
    }

    public static int substitutionEncode(int letter, int shift) {
        int result = letter + shift;
        return result;
    }

    public static int substitutionDecode(int letter, int shift) {
        int result = letter - shift;
        return result;
    }
}
