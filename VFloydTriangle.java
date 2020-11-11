import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class VFloydTriangle {
    public static void main(String[] args) throws IOException {
        try {
        Scanner sc = new Scanner(System.in); //Scanner Object sc for Input
        FileWriter fr = new FileWriter("output.txt",true); {
            System.out.println("Enter Size of an Intended Vertical Floyd Triangle :)");
            System.out.print("[Input Size Here]: "); // Input Size Here
            int size = sc.nextInt(); //To Store size of the Triangle
            fr.write(VFT(size)); //Function Call
            sc.close(); //Closing the Scanner Object
            fr.close(); //Closing the File Writer Object
            System.out.print("Successfully Registered A Vertical Floyd Triangle of Size "+size); //Operation Successfull           
        }
    }
        catch(Exception e) { // Catching Errors
            System.out.println("Something Went Wrong:(\n"+e); // Operation Failed
        }
    }
    public static final String VFT (int size) {
        String processedString = "\n"; //The Final String
        int stateVar;
        for(int row=1;row<=size;row++) { //Traversing Through the Rows
            stateVar = row;
            processedString += stateVar+"\t";
            for(int col=1;col<row;col++) { //Traversing through the Columns
                stateVar += size-col;
                processedString += stateVar+"\t";
            }
            processedString += "\n";
        }
        return processedString; //Returning the Output String
    }
}