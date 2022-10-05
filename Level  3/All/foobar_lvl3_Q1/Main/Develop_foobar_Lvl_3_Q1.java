/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package develop_foobar_lvl_3_q1;

/**
 *
 * @author DELL
 */
import java.math.*;
public class Develop_foobar_Lvl_3_Q1 {

    /**
     * @param args the command line arguments
     */
    
     private static BigInteger Min(BigInteger val_1, BigInteger val_2){
        if(val_1.compareTo(val_2) == -1) {
            return val_1;
        }
        return val_2;
    }
    public static String solution(String x, String y) {
        // Your code here
        BigInteger X= new BigInteger(x);
        BigInteger Y= new BigInteger(y);
                
        BigInteger X_Length= new BigInteger(x);
        X_Length= X_Length.add(new BigInteger("1"));
        
        BigInteger Y_Length= new BigInteger(y);
        Y_Length= Y_Length.add(new BigInteger("1"));
        
        BigInteger Check_X= new BigInteger(x);
        BigInteger Check_Y= new BigInteger(y);
        
        Check_X= Check_X.mod(new BigInteger("2"));
        Check_Y= Check_Y.mod(new BigInteger("2"));
        if(Check_X.compareTo(BigInteger.ZERO) <= 0 && Check_Y.compareTo(BigInteger.ZERO) <= 0){
            return "impossible";
        }
        
        BigInteger [][]Opt=new BigInteger[X_Length.intValue()][Y_Length.intValue()];
        
       if(X.longValue() == 1 && Y.longValue() == 1 ){
            return "1";
        }
       /*if(Integer.valueOf(y) == 1 && Integer.valueOf(x) > 1){
           return x;
       }
       else if(Integer.valueOf(y) > 1 && Integer.valueOf(x) == 1){
           return y;
       }*/
        if(X.longValue() == Y.longValue() || Y.longValue() == 0 || X.longValue() == 0){
            return "impossible";
        }   
        for(BigInteger i=new BigInteger("0"); i.longValue()< X_Length.longValue(); i=i.add(new BigInteger("1"))){
            for(BigInteger j=new BigInteger("0"); j.longValue()< Y_Length.longValue(); j=j.add(new BigInteger("1"))){
             if(i.compareTo(BigInteger.ZERO)==0 || j.compareTo(BigInteger.ZERO)==0){
                   Opt[(int)i.longValue()][(int)j.longValue()]= BigInteger.valueOf(0);
               }
               
               else if(i.compareTo(BigInteger.ONE) == 0 && j.compareTo(BigInteger.ONE) == 0){
                   Opt[(int)i.longValue()][(int)j.longValue()] = new BigInteger("0");
               }
               
             else if(i.add(j).longValue() > X.longValue() && i.add(j).longValue() < Y.longValue()){
                 Opt[(int)i.longValue()][(int)j.longValue()]= new BigInteger("0");
             }
             else{
                 Opt[(int)i.longValue()][(int)j.longValue()]= (Min(Opt[(int)i.subtract(new BigInteger("1")).longValue()][(int)j.longValue()], Opt[(int)i.longValue()][(int)j.subtract(new BigInteger("1")).longValue()]).add(new BigInteger("1")) );
             }
            }
        }
        if(Opt[(int)X.longValue()][(int)Y.longValue()].compareTo(BigInteger.ZERO) <= 0){
            return "impossible";
        }
          System.out.println("\n\nPrinting: ");
        
        for(int i=0; i< X_Length.intValue(); i++){
            for(int j=0; j< Y_Length.intValue(); j++){
                System.out.print(Opt[i][j]+"\t");
            }
            System.out.println();
        }
        return Opt[(int)X.longValue()][(int)Y.longValue()].toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(solution("4", "7"));
        
        System.out.println(solution("2", "1"));

        System.out.println(solution("2", "4"));

        System.out.println(solution("1500", "2000"));

        String val="1", val2= "1";
        for(int i=0; i<=100; i++){
            System.out.println("Generate "+i+" : ");
            System.out.println("( "+val+", "+val2+" )");
            val= String.valueOf(Integer.valueOf(val) + Integer.valueOf(val2));
            System.out.println("Generate "+(++i)+" : ");
            System.out.println("( "+val+", "+val2+" )");
            val2= String.valueOf(Integer.valueOf(val2) + Integer.valueOf(val));
        }
        
        
        
        /*String test="7";
        //test+=1;
        System.out.println("Test: "+ test);
        
        test= String.valueOf(Integer.valueOf(test) + 1);
        System.out.println("Test: "+ test);*/
        
        
      
    }
    
}
