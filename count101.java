import java.io.FileReader;
import java.io.IOException;
class count101 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("input.txt"); 
        int expected[] = {49,48,49}; // A.S.C.I.I Values of Each Character In The String to be Searched.
        int size = expected.length; // Length of the String to be Searched.
        int counter=0; // Counter : To count no. of Occurrences in the File.
        int tally=0; // Tally : To Keep Track of Progress of Matching.    
        int i;
        while((i=reader.read())!=-1) { // Traversing Through A File, Character By Character
            if(i==expected[tally]) {
                tally++; // Update the Tracker
                if(tally==size) { // To Check the Tracker doesn't exceed the original length of the String To Be Searched.
                    counter++; // Updating the Occurrence Counter
                    tally=1; // As the Matched String conatins the Index 0 of the Expected String.
                }
            }
            else
                tally=0; // Break the Match Streak 
        }
        reader.close(); // Closing the reader Object
        System.out.println("No. of 101's in the Given File is: "+counter); //Print Statement
    }
}
