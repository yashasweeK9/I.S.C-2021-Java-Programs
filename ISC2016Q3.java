import java.util.Scanner;
public class ISC2016Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char check = str.charAt(str.length()-1);
        if(isValid(str, check)) {
            System.out.print(process(str, check));
        } else {
            System.out.println("INVALID INPUT!");
        }
        sc.close();
    }
    private static boolean isValid(String str, char check) {
        if(check!='.' && check!='!' && check!='?')
            return false;
        return true;    
    }
    private static String process(String str, char check) {
        String tokens[] = str.split("\\.|\\?|\\!|\\s|\\,");
        String prefix = "\n", suffix = "";
        int count = 0;
        for(int index=0;index<tokens.length;index++) {
            String word = tokens[index];
            if(begEndVowel(tokens[index])) {
                prefix += word + " ";
                count++;
            }
            else
                suffix += word + " ";
            }
            return "NUMBER OF WORDS BEGINNING AND ENDING WITH A VOWEL = " + count + prefix + suffix.trim() + check;
        }
    
    private static boolean begEndVowel(String word) { // To Check If A Word is to Start and End with a Vowel
        int len = word.length();
        char init = word.charAt(0);
        if(len==1) {
            return isVowel(init);
        } else {
            char fin = word.charAt(len-1);
            return isVowel(init) && isVowel(fin);
        }           
    }

    private static boolean isVowel(char ch) {
       String lis = "AEIOU";
       if(lis.indexOf(ch)!=-1)
                return true;
            else
                return false;
    }
}