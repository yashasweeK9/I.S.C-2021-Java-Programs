import java.util.Scanner;
public class ISC2016Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INPUT: M = ");
        int m = sc.nextInt();
        System.out.print("OUTPUT: ");
        if(isValid(m)) {
            int matrix[][] = input_2D(sc, m);
            System.out.println("ORIGINAL MATRIX"+displayMatrix(matrix));
            matrix = matrixSort(matrix);
            System.out.println("REARRANGED MATRIX"+displayMatrix(matrix));
            System.out.println("SUM OF THE DIAGONAL ELEMENTS: "+DiagSumPrint(matrix));    
        }
        else
             System.out.println("OUT OF RANGE!");

        sc.close();
    }
    
    private static boolean isValid(int length) {
        if(length>10 || length<3)
            return false;
        return true;    
    }

    private static int[][] input_2D(Scanner obj, int length) {
        obj = new Scanner(System.in);
        int matrix[][] = new int[length][length];
        for(int i=0;i<length;i++) {
            for(int j=0;j<length;j++) {
                matrix[i][j]=obj.nextInt();
            }
        }
        obj.close();
        return matrix;
    }

    private static int[] bubbleSort(int row[]) {
        boolean Swapped;
        for(int i=0;i<row.length-1;i++) {
            Swapped = false;
            for(int j=0;j<row.length-i-1;j++) {
                if(row[j]>row[j+1]) {
                    int temp = row[j];
                    row[j] = row[j+1];
                    row[j+1] = temp;
                    Swapped = true;
                }
            }
            if(!Swapped)
                break;
        }
        return row;
    }
    
    private static int[][] matrixSort(int matrix[][]) {
        int m = matrix.length;
        int temp[] = new int[(m-2)*(m-2)];
        int index = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<m;j++) {
                if(i!=0 && (i!=m-1) && (j!=0) && (j!=m-1)) {
                    temp[index]=matrix[i][j];
                    index++;
                }
            }    
        }
        temp = bubbleSort(temp);
        index = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<m;j++) {
                if(i!=0 && (i!=m-1) && (j!=0) && (j!=m-1)) {
                    matrix[i][j]=temp[index];
                    index++;
                }
            }    
        }
        return matrix;
    }

    private static String displayMatrix(int matrix[][]) {
        int m = matrix.length;
        String disp = "\n";
        for(int i=0;i<m;i++) {
            for(int j=0;j<m;j++) {
                disp += (matrix[i][j]+"\t");
            }
            disp+="\n";
        }
        return disp;
    }

    private static int DiagSumPrint(int matrix[][]) {
        int m = matrix.length;
        int sum = 0;
        String disp = "DIAGONAL ELEMENTS\n";
        for(int i=0;i<m;i++) {
            for(int j=0;j<m;j++) {
                if(i==j || j==m-i-1) {
                    disp += (matrix[i][j]);
                    sum += matrix[i][j];
                }
                disp+= "\t";
            }
            disp+="\n";
        }
        System.out.println(disp);
        return sum;
    }
}
