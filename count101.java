import java.io.FileReader;
import java.io.IOException;
//`import java.io.BufferedReader;
class count101 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("input101.txt"); 
        int expected[] = {49,48,49}; // A.S.C.I.I Values of the Searched String.
        int size = expected.length; // Length of the String
        int counter, tally; counter = tally = 0; // Counter : To count no. of Occurances in the File. Tally : To keep track of the progress of matching.
        int i;
        while((i=reader.read())!=-1) { // Traversing Through the File
            if(i==expected[tally]) {
                tally++; // Updating the Tracker

                if(tally==size){
                    counter++; // Updating the Occurance Count
                    tally=1;
                }
            }
            else
                tally=0; 
        }
        reader.close(); // Closing the File Reader
        System.out.println("No. of 101's in the Given File is: "+counter); //Print Statement
    }
}