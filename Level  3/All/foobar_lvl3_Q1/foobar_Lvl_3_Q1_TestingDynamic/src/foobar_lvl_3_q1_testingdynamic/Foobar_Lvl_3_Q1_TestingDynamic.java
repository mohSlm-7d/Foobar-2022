/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package foobar_lvl_3_q1_testingdynamic;

/**
 *
 * @author DELL
 */

import java.math.*;
public class Foobar_Lvl_3_Q1_TestingDynamic {


    /**
     * @param args the command line arguments
     */
    private static String Min(String val_1, String val_2){
        if(Integer.valueOf(val_1) < Integer.valueOf(val_2) ){
            return val_1;
        }
        return val_2;
    }
    public static String solution(String x, String y) {
        // Your code here
        BigInteger X_Length= new BigInteger(String.valueOf(Integer.valueOf(x) + 1) );
        BigInteger Y_Length= new BigInteger(String.valueOf(Integer.valueOf(y) + 1));
        String [][]Opt=new String[X_Length.intValue()][Y_Length.intValue()];
        for(int i=0; i< X_Length.intValue(); i++){
            for(int j=0; j< Y_Length.intValue(); j++){
             if(i==0 || j==0){
                   Opt[i][j]= "0";
               }
             else if(i + j > Integer.valueOf(x) || i+ j > Integer.valueOf(y) ){
                 Opt[i][j]= "0";
             }
             else if( i + j <= Integer.valueOf(x) && j-i >= 0){
                Opt[i][j]=  String.valueOf(Integer.valueOf(Opt[i][j-i]) + 1);//= Min(Opt[i][j-i], Opt[i-j][j]) + 1;
               }               
              
               else if( i + j <= Integer.valueOf(x) && i- j >= 0 ){
                Opt[i][j]= String.valueOf(Integer.valueOf(Opt[i-j][j]) + 1);
               }
               
               else if( i + j <= Integer.valueOf(y) && j-i >= 0){
                Opt[i][j]=  String.valueOf(Integer.valueOf(Opt[i][j-i]) + 1);//= Min(Opt[i][j-i], Opt[i-j][j]) + 1;
               }               
              
               else if( i + j <= Integer.valueOf(y) && i- j >= 0 ){
                Opt[i][j]= String.valueOf(Integer.valueOf(Opt[i-j][j]) + 1);
               }
            }
        }
        
          System.out.println("\n\nPrinting: ");
        
        for(int i=0; i< X_Length.intValue(); i++){
            for(int j=0; j< Y_Length.intValue(); j++){
                System.out.print(Opt[i][j]+"\t");
            }
            System.out.println();
        }
        return Opt[Integer.valueOf(x)][Integer.valueOf(y)];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(solution("4", "7"));
        
        
        /*String test="7";
        //test+=1;
        System.out.println("Test: "+ test);
        
        test= String.valueOf(Integer.valueOf(test) + 1);
        System.out.println("Test: "+ test);*/
        
        
      
    }
    
}
