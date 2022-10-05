/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foobarelevator_maintenance;

/**
 *
 * @author DELL
 */
public class FooBarElevator_Maintenance {

    /**
     * @param args the command line arguments
     */
     private static void Swap(String [] array, int i, int j){
            String temp= array[i];
            array[i]= array[j];
            array[j]= temp;            
        }
     private static String[] FillSplitArray(String[] array){
         int i=0;
         String[] temp = new String[3];
         while(i< temp.length){
             if(i>= array.length){
                 temp[i]= "-1";
             }
             else{
                 temp[i]= array[i];
             }
             i++;
         }
         return  temp;
     }
    private static int Partition(String []array, int low, int high, int BasedOn){
        String pivot = array[low];
        String[] PivotVal= pivot.split("\\.");
        PivotVal=FillSplitArray(PivotVal);
        
        while(low< high){
            String[] HighVal= array[high].split("\\.");
            HighVal=FillSplitArray(HighVal);
            
            while(Integer.valueOf(HighVal[BasedOn]) > Integer.valueOf(PivotVal[BasedOn]) && low < high ){
                high=high-1;
            }
            if(low != high ){
                array[low]=array[high];
                low=low+1;
            }
            
            String[] LowVal= array[low].split("\\.");
            LowVal=FillSplitArray(LowVal);
            
            while(Integer.valueOf(LowVal[BasedOn]) < Integer.valueOf(PivotVal[BasedOn])  && low < high){
                low=low+1;
            }
            if(low != high ){
                array[high]=array[low];
                high=high-1;
            }           
        
        }
        
        array[high]= pivot;
        return low;
        
    }
    private static void QuickSort(String [] array, int first, int last, int BasedOn){
        
        if(first < last){
            int pivotLoc= Partition(array, first, last, BasedOn);
            
            QuickSort(array, first, pivotLoc-1, BasedOn);
            QuickSort(array, pivotLoc+1, last, BasedOn);
        }
        
    }
    
    public static String[] solution(String[] l) {
        // Your code here
        int i=0, j=0;      
        int[] IndxsOfZeros= new int[l.length];
        
        while(i< l.length){
            String[] CheckZero=l[i].split("\\.");
            if(Integer.valueOf(CheckZero[0]) == 0){
                IndxsOfZeros[j]= i;
                j++;
            }
            i++;
        }
        
        int count=j;
        j--;
        i=0;
        
        while(j>=0){
            Swap(l, i, IndxsOfZeros[j]);            
            j--;
            i++;
        }
        
        if( count  < l.length -1){
           
            //
            //
            //QuickSort(l, count, l.length-1, 2);
            QuickSort(l, 0, count-1, 1);
            QuickSort(l, 0, count-1, 2);
            
            int k= count;
            int digit= Integer.valueOf(l[i].split("\\.")[1]);
            String []Split= null;
            int Size=0;
            while(i< l.length){
                Size= l[i].split("\\.").length;
                Split= l[i].split("\\.");
                if(Integer.valueOf(Split[1])!= digit){
                    break;
                }
                else{
                    k++;
                }
                i++;
            }
            QuickSort(l, count, l.length-1, 1);
            //k=count;
            
            digit= Integer.valueOf(l[i].split("\\.")[0]);
            Split= null;
            Size=0;
            while(i< l.length){
                Size= l[i].split("\\.").length;
                Split= l[i].split("\\.");
                if(Integer.valueOf(Split[0])!= digit){
                    break;
                }
                else{
                    k++;
                }
                i++;
            }
            //QuickSort(l, count, k-1, 1);
            //QuickSort(l, count, k-1, 2);
            System.out.println("testing....."+ (k-1));
        }
        
        
        return l;
    }
    public static void main(String[] args) {
        
        String [] l= new String [5];
        l[0]="1.1.2";
        l[1]= "1.0";
        l[2]="1.3.3";
        l[3]="1.0.12";
        l[4]="1.0.2";
        
        System.out.println("Hello, World!\n\nTESETCASE 2: \n");
        
        for(int i=0; i<l.length; i++){
            System.out.println(l[i]);
        }
        
        l= solution(l);
        
         
        System.out.println("Hello, World!\n\nTESETCASE 1: \n");
        l= new String [8];
        l[0]="1.11";
        l[1]="2.0.0";
        l[2]="1.2";
        l[3]="2";
        l[4]="0.1";
        l[5]="1.2.1";
        l[6]="1.1.1";
        l[7]="2.0";
        String test= l[4];
        for(int i=0; i<l.length; i++){
            System.out.println(l[i]);
        }
        
        System.out.println("Hello, World!");
        
        for(int i=0; i<l.length; i++){
            System.out.println(l[i]);
        }
        
        l= solution(l);
        System.out.println("Hello, World!");
        System.out.println("Hello, World!");
        System.out.println("\n\n\n\n");
        for(int i=0; i<l.length; i++){
            System.out.println(l[i]);
        }
        
        String [] arrTest= test.split("\\.");
        
        System.out.println("arrTest.length"+arrTest.length);
        for(int k=0; k<arrTest.length; k++){
            System.out.println("arrTest["+k+"]= "+arrTest[k]);
        }
        System.out.println("arrTest.length"+arrTest.length);
    }
    
}
