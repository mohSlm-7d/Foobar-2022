/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elevator_maintenancecode;

/**
 *
 * @author DELL
 */
public class Code2 {
    private static void Swap(String [] array, int i, int j){
            String temp= array[i];
            array[i]= array[j];
            array[j]= temp;            
        }    
     private static int[] FillSplitArray(String Str){
         int i=0;
         int[] temp = new int[3];
         String[] StrVal= Str.split("\\.");
         while(i< temp.length){
             if(i>= StrVal.length){
                 temp[i]= -1;
             }
             else{
                 temp[i]= Integer.valueOf(StrVal[i]);
             }
             i++;
         }
         return temp;
     }
    
    public static String[] solution(String[] l) {
        int ValAt[]= null;        
        int MinVal[]= null;
        
        int i=0, j=1; 
        int MinIndx=0;
        while(i< l.length){
            MinIndx= i;
            MinVal=FillSplitArray(l[i]);
            while(j< l.length){
                j=j+1;
                ValAt=FillSplitArray(l[j]);
                int k=0;
                while(ValAt[k] == MinVal[k] && k < MinVal.length){
                    k++;
                }
                if(ValAt[k] < MinVal[k]){
                    MinIndx= j;
                    MinVal= ValAt;
                }
                j++;
            }
            Swap(l, i, MinIndx);
            i++;
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
        
        System.out.println("Hello, World!\n\nAfter 2: \n"); 
        for(int i=0; i<l.length; i++){
            System.out.println(l[i]);
        }
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
        
       /* String [] arrTest= test.split("\\.");
        
        System.out.println("arrTest.length"+arrTest.length);
        for(int k=0; k<arrTest.length; k++){
            System.out.println("arrTest["+k+"]= "+arrTest[k]);
        }
        System.out.println("arrTest.length"+arrTest.length);*/
        
        String[] temp= new String [2];
        temp[0]= "Mohammad";
        temp[1]="Salman";
        
        
        System.out.println("Before: ");
         for(int i=0; i<l.length; i++){
            System.out.println(l[i]);
        }
       
        
        l= temp;
        
        System.out.println("After: ");
         for(int i=0; i<l.length; i++){
            System.out.println(l[i]);
        }
       
        
        
    }
}
