class Golomb {
    
    int index;
    private int processedArr[];

    public Golomb( int index ) {
    this.index = index;
    }

    private void process () {
        assert( index > 0 ): "Negative or Zero Index Not Allowed!";
        int outputArr[] = new int [index];
        outputArr[0]=1;
        
        if ( index > 1 )
            outputArr[1]=2;

        if ( index > 2 )
            outputArr[2]=2;

        if ( index > 3 ) {       
            int repeat=0;
            for ( int readCursor=1, writeCursor=3; writeCursor < index; writeCursor++ ) {
                        if ( repeat <= 0 ) {
                        readCursor++;
                        repeat = outputArr[readCursor]; 
                    }
                        outputArr[writeCursor]=readCursor+1;
                        repeat--;
                    }
                }
        processedArr=outputArr;
        }

    public void display () {
        process();
        String output="[| ";
        for(int n : processedArr){
            output += n + " | ";
        }
        output += "\b]";
        System.out.println(output);
    }
}

class GolombTest {
    public static void main(String[] args) {
    Golomb a = new Golomb(30);
    a.display();     
    }
}