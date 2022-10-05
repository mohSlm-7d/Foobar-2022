/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staircase_problem_lvl3_q2;

/**
 *
 * @author M7md_2
 */
import java.math.BigInteger;
public class Staircase_Problem_Lvl3_Q2 {

    /**
     * @param args the command line arguments
     */
    public static int solution(int n) {
        // Your code here
        BigInteger[] StaircaseOpt= new BigInteger[n+1];
        
        for(int i=0; i<= n; i++){
            if(i<3){
                StaircaseOpt[i]=BigInteger.valueOf(0);
            }
            else if(i==3 || i==4){
                StaircaseOpt[i]=BigInteger.valueOf(1);
            }
            
            else{
                //BigInteger Sum= new BigInteger("0");
                StaircaseOpt[i]= BigInteger.ZERO;
                int j;
                for(j=3; j<i; j++){
                    StaircaseOpt[i]= StaircaseOpt[i].add(StaircaseOpt[j]);
                }
                j=(j-1) - 3;
                BigInteger Sub= new BigInteger("0");
                Sub =BigInteger.valueOf(j);
                //Sub= BigInteger.valueOf(i-3);
                StaircaseOpt[i]= StaircaseOpt[i].subtract(BigInteger.ONE);
                //StaircaseOpt[i]=Sum;
            }
        }
        for(int i=0; i<=n; i++){
            System.out.println(StaircaseOpt[i]);
        }
        return StaircaseOpt[n].intValue();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(solution(200));
        BigInteger sum=new BigInteger("0");
        for(int i=1;i <=197; i++){
            sum= sum.add(BigInteger.valueOf(i));
        }
        
        System.out.println(sum.multiply(BigInteger.valueOf(200)));
    }
    
}
