/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution_q3_lvl3;

/**
 *
 * @author M7md_2
 */
public class Solution_Q3_Lvl3 {

    /**
     * @param args the command line arguments
     */
    
    public static int solution(int[] l) {
        // Your code here.
        if(l.length <= 2){
            return 0;
        }
        int size= l.length; // +1
        int []Sln= new int[size];
        int Sum=0;
        for(int i=0; i<size; i++){
            for(int j= i+1; j< size; j++){
                if(l[j] % l[i] == 0 ){
                    for(int k= j+1; k<size; k++){
                        if(l[k] % l[j] == 0 ){
                            Sln[i]+=1;                            
                            Sum+=1;
                         }
                    }
                }
                
            }
            if(i>0)
                Sln[i]+= Sln[i-1];
        }
        /*for(int i=0; i< size; i++){
            System.out.println(Sln[i]+"\t");
        }*/
        return Sln[size-1];
        //return Sum;
    }
    
    
    
    public static void main(String[] args) {
        int size= 6;
        int [] l= new int[size];
        for(int i=0; i< size; i++){
            l[i]= i+ 1;
        }
        System.out.println(solution(l));
        
        size=3;
        l=new int [size];
        l[0]=1;
        l[1]=1;
        l[2]=1;
        System.out.println(solution(l));
        //System.out.println(solution(l));
        // TODO code application logic here
    }
    
}
