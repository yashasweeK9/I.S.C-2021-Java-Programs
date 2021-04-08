import java.util.Scanner;
class FascinatingDriver {
    public static void main(String args[]) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("INPUT:\tm=");
            int m = sc.nextInt();
            System.out.print("      \tn=");
            int n = sc.nextInt();
            sc.close();
            System.out.print("\nOUTPUT:\t");
            MyFascinating obj = new MyFascinating(m,n);
            if(obj.isValid()) {
                System.out.println("THE FASCINATING NUMBERS IN THE GIVEN RANGE:");
                System.out.println("       \t"+obj.display());
                System.out.println("       \tTHE FREQUENCY OF FASCINATING NUMBERS ARE: "+obj.frequency);
            } else {
                System.out.println("INVALID INPUT!");
            }
        } catch(Exception e) {
            System.out.println("PROGRAM CRASHED! PROGRAM TERMINATED SUCCESSFULLY");
        }
    }
}
class MyFascinating {
    private int m,n;
    public int frequency;
    MyFascinating(int m, int n) {
        this.m = m;
        this.n = n;
    }
    
    public boolean isValid() {
        if(m<100 || m>10000)
            return false;
        if(n<100 || n>10000)
            return false;
        if(m>=n)
            return false;
        return true;
    }
    
    private boolean isFascinating(int candidate) {
        String conc = (candidate)+""+(candidate*2)+""+(candidate*3)+"";
        int digits[] = toIntegerArr(conc);
        boolean isAlreadyPresent = false;
        for(int i=1;i<=9;i++) {
            isAlreadyPresent = false;
            for(int j=0;j<digits.length;j++) {
                if(digits[j]==i) {
                    if(isAlreadyPresent)
                        return false;
                    else {
                        isAlreadyPresent = true;
                    }
                }
            }
            if(!isAlreadyPresent) {
                return false;
            }
        }
        return true;
    }
    
    private int[] toIntegerArr(String str) {
        int arr[] = new int [str.length()];
        for(int i=0;i<str.length();i++) {
            char digit = str.charAt(i);
            arr[i]= (digit-'0');
        }
        return arr;
    }
    
    public String display() {
        String output = "";
        int frequency= 0;
        for(int i=m;i<=n;i++) {
            if(isFascinating(i)) {
                frequency++;
                output += (i+" ");
            }
        }
        output = (frequency==0)?"NIL":output.trim()+"\n";
        this.frequency = frequency;
        return output;
    }
}


