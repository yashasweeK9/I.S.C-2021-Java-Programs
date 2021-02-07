import java.util.Scanner;
public class ISC2016Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INPUT : N = ");
        int input = sc.nextInt();
        String str = Integer.toString(input);
        int digits = str.length();
        str += str;
        boolean flag = true;
        System.out.print("OUTPUT : ");
        for(int index=0;index<digits;index++){
            int copy = Integer.parseInt(str.substring(index, index+digits)); 
            if(!isPrimeNumber(copy))
                flag = false;
            System.out.println(copy);
        }
        if(flag)
            System.out.println(input+" IS A CIRCULAR PRIME");
        else
            System.out.println(input+" IS NOT A CIRCULAR PRIME");
        sc.close();    
    }
    
    public static boolean isPrimeNumber(int n){
        if(n<2) return false;
        else if(n==2)return true;
        else if(n%2==0) return false;
        else{
            int limit=(int)Math.sqrt(n);
            for( int divisor=3; divisor<=limit;divisor+=2){
                if(n%divisor==0) return false;
            }
        }
        return true;
    }
}
