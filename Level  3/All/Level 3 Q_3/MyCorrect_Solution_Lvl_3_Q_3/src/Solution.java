/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M7md_2
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    
   public static int solution(int[] l) {
        // Your code here.
        if(l.length == 2){
            return 0;
        }
        
        int size= l.length;
        int Sum=0;
        for(int i=0; i<size; i++){
            for(int j= i+1; j< size; j++){
                if(l[j] % l[i] == 0 ){
                    for(int k= j+1; k<size; k++){
                        if(l[k] % l[j] == 0 ){
                            Sum+=1;
                         }
                     }
                 }
             }
        }
        
        
        return Sum;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int size=6;
        int Test[]= new int[size];
        for(int i=0; i< size; i++){
            Test[i]= i+1;
        }
        System.out.println(Solution.solution(Test));
        
        System.out.println("Test case: Size= "+size);
        size = 2000;
        Test= new int[size];
        for(int i=0; i< size; i++){
            Test[i]= i+1;
        }
        System.out.println(Solution.solution(Test));
    }
    
}
