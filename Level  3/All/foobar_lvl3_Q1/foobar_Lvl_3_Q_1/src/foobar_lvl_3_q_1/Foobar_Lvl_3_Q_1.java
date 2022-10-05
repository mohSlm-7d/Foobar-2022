/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foobar_lvl_3_q_1;

/**
 *
 * @author DELL
 */
public class Foobar_Lvl_3_Q_1 {

    /**
     * @param args the command line arguments
     */
    
    public static String solution(String x, String y) {
        // Your code here
        String Replication="0";
        
        while(Integer.valueOf(x) > 1 || Integer.valueOf(y) > 1){
            String Check_X=String.valueOf(Integer.valueOf(x) - Integer.valueOf(y));
            String Check_Y=String.valueOf(Integer.valueOf(y) - Integer.valueOf(x));
            
             if( Integer.valueOf(Check_X) <= 0 && Integer.valueOf(Check_Y) <= 0 ){
                break;
              }
            if(Integer.valueOf(Check_X) >= 1 && Integer.valueOf(Check_X) < Integer.valueOf(Check_Y)){
                x= Check_X;
                Replication=String.valueOf(Integer.valueOf(Replication) + 1);
            }
            
            else {                
                if(Integer.valueOf(Check_Y) >= 1 && Integer.valueOf(Check_Y) <=  Integer.valueOf(Check_Y)){
                    y= Check_Y;
                    Replication=String.valueOf(Integer.valueOf(Replication) + 1);
                }               
                
            }
        }
        if(Integer.valueOf(Replication) == 0){
            Replication="impossible";
        }
        
        return Replication;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(solution("4", "7"));
    }
    
}
