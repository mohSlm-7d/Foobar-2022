// Online Java Compiler
// Use this editor to write, compile and run your Java code online
 
class HelloWorld {
    private static void Swap(String [] array, int i, int j){
            String temp= array[i];
            array[i]= array[j];
            array[j]= temp;
            
        }
    private static int Partition(String []array, int low, int high){
        String pivot = array[low];
        String[] PivotVal= pivot.split("\\.");
        
        while(low< high){
            String[] HighVal= pivot.split("\\.");
            
            while(Integer.valueOf(HighVal[0]) >=  Integer.valueOf(PivotVal[0]) && low < high ){
                high--;
            }
            if(low != high){
                Swap(array, low, high);
                low++;
            }
            
            String[] LowVal= pivot.split("\\.");
            
            while(Integer.valueOf(LowVal[0]) < Integer.valueOf(PivotVal[0]) && low < high){
                low++;
            }
            if(low != high){
                Swap(array, low, high);
                high--;
            }           
        
        }
        
        array[high]= pivot;
        return low;
        
    }
    private static void QuickSort(String [] array, int first, int last){
        if(first < last){
            int pivotLoc= Partition(array, first, last);
            QuickSort(array, first, pivotLoc-1);
            QuickSort(array, pivotLoc+1, last);
        }
        
    }
    
    public static String[] solution(String[] l) {
        // Your code here
        QuickSort(l, 0, l.length-1);
        return l;
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String [] l= new String [8];
        l[0]="1.11";
        l[1]="2.0.0";
        l[2]="1.2";
        l[3]="2";
        l[4]="0.1";
        l[5]="1.2.1";
        l[6]="1.1.1";
        l[7]="2.0";
        
        for(int i=0; i<l.length; i++){
            System.out.println(l[i]);
        }
    }
}