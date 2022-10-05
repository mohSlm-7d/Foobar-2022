/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M7md_2
 */

import java.lang.Math;

public class Solution {
     private static boolean AngleIsFound(double angle, double[] Angles, int size, int quadrant, int[] player, int[] target){
        int i=0;
        if(quadrant == 1){
            if(player[1] == target[1]){
                return true;
            }
        }
        while(i< size){
            if(Angles[i] == angle ){                
                return true;
            }
            i++;
        }
        return false;
    }
    
    public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {
        //Your code here
        double OriginalWidth= dimensions[0];
        double OriginalHeight= dimensions[1];
        double ShootingRange_X= your_position[0] + distance;
        double ShootingRange_Y= your_position[1] + distance;
        /*if(distance == 10000){
            return 0;
        }*/
        /*if(dimensions[0] == 1 && dimensions[1] == 1){
            return 1;
        }
        if(trainer_position[0] == your_position[0] && trainer_position[1] == your_position[1]){
            return 0;
        } 
        if(trainer_position[0] > dimensions[0] || trainer_position[1] > dimensions[1]){
            return 0;
        }
        if(your_position[0] > dimensions[0] || your_position[1] > dimensions[1]){
            return 0;
        }
        if(trainer_position[0] == dimensions[0] -1 && trainer_position[1] == dimensions[1] -1){
            return 0;
        }
        
        if(Math.sqrt( Math.pow(trainer_position[0] - your_position[0], 2) + Math.pow(trainer_position[1] - your_position[1], 2) ) > distance){
            return 0;
        }*/
        
        Double Mirror_OnX= new Double(Math.ceil(ShootingRange_X / OriginalWidth) );
        Double Mirror_OnY= new Double(Math.ceil(ShootingRange_Y / OriginalHeight) );
        Double Positions= new Double(Mirror_OnX * Mirror_OnY);
        
        double[] Angles_Of_Directions= new double[Positions.intValue() * 4];
        
        
        int [][][][] TrainerPositions= new int[4][Mirror_OnX.intValue()][Mirror_OnY.intValue()][2];
        
       
        
        int InWidthBeforePos= trainer_position[0];
        int InWidthAfterPos= dimensions[0] - InWidthBeforePos;
        
        int InHeightBelowPos= trainer_position[1];
        int InHeightAbovePos= dimensions[1] - InHeightBelowPos;
        
        for(int i=0; i< Mirror_OnX.intValue(); i++){
            for(int j=0; j< Mirror_OnY.intValue(); j++){
                if(i==0 && j==0){
                    TrainerPositions[0][0][0]= trainer_position;
                }
                else if(j==0){
                    if(i% 2 ==0){
                        TrainerPositions[0][i][j][0]= i * dimensions[0] + InWidthBeforePos;
                    }
                    else{
                        TrainerPositions[0][i][j][0]= i * dimensions[0] + InWidthAfterPos;
                    }
                    TrainerPositions[0][i][j][1]= TrainerPositions[0][i-1][j][1];
                }
                else{
                    if(j % 2 == 0){
                        TrainerPositions[0][i][j][0]= TrainerPositions[0][i][j-1][0];
                        TrainerPositions[0][i][j][1]= j * dimensions[1] + InHeightBelowPos;
                    }
                    else{
                        TrainerPositions[0][i][j][0]= TrainerPositions[0][i][j-1][0];
                        TrainerPositions[0][i][j][1]= j * dimensions[1] + InHeightAbovePos;
                    }
                    
                }
            }
        }
        
        
        for(int Q=1; Q<4; Q++){
            for(int i=0; i<Mirror_OnX.intValue(); i++){
                for(int j=0; j<Mirror_OnY.intValue(); j++){
                    if(Q == 1){
                        TrainerPositions[Q][i][j][0]= TrainerPositions[0][i][j][0] * -1;
                        TrainerPositions[Q][i][j][1]= TrainerPositions[0][i][j][1] ;
                    }
                    else if(Q == 2){
                        TrainerPositions[Q][i][j][0]= TrainerPositions[0][i][j][0] * -1 ;
                        TrainerPositions[Q][i][j][1]= TrainerPositions[0][i][j][1] * -1 ;
                    }
                    else{
                        TrainerPositions[Q][i][j][0]= TrainerPositions[0][i][j][0] ;
                        TrainerPositions[Q][i][j][1]= TrainerPositions[0][i][j][1] * -1;
                    }
                }
            }
        }
         
        int CountDirections= 0;
        double CheckDist;
        double x;
        double y;
        
         for(int Q=0; Q<4; Q++){
            for(int i=0; i<Mirror_OnX.intValue(); i++){
                for(int j=0; j<Mirror_OnY.intValue(); j++){
                    CheckDist= Math.sqrt( Math.pow(TrainerPositions[Q][i][j][0] - your_position[0], 2) + Math.pow(TrainerPositions[Q][i][j][1] - your_position[1], 2) );
                    x= TrainerPositions[Q][i][j][0];
                    y= TrainerPositions[Q][i][j][1];
                    double Player_X=your_position[0];
                    double Player_Y= your_position[1];
                    
                    /*if(Q==1 && j==0 && TrainerPositions[Q][i][j][1]== your_position[1] ){
                        continue;
                    }
                    if(Q==3 && i==0 && TrainerPositions[Q][i][j][0] == your_position[0]){
                        i=1;
                        
                    }*/
                    
                    if(Q==0 && i==0 && j==0 ){
                        CheckDist= Math.sqrt( Math.pow(TrainerPositions[Q][i][j][0] - your_position[0], 2) + Math.pow(TrainerPositions[Q][i][j][1] - your_position[1], 2) );
                        x= TrainerPositions[0][0][0][0];
                        y= TrainerPositions[0][0][0][1];
                        
                        if(CheckDist <= distance){
                            //System.out.println((CountDirections+1)+": ["+TrainerPositions[Q][i][j][0]+", "+TrainerPositions[Q][i][j][1]+"]"); 
                            Angles_Of_Directions[CountDirections++]= Math.atan2(y , x);
                        }
                        
                    }
                    
                   /*else if(Math.atan2(y, x) == Math.atan2( -1* Player_Y , -1* Player_X ) ){
                        continue;
                    }*/
                   
                   
                   
                    else if(TrainerPositions[Q][i][j][0] != your_position[0] && TrainerPositions[Q][i][j][1] != your_position[1]){
                         CheckDist= Math.sqrt( Math.pow(TrainerPositions[Q][i][j][0] - your_position[0], 2) + Math.pow(TrainerPositions[Q][i][j][1] - your_position[1], 2) );
                         x= TrainerPositions[Q][i][j][0];
                         y= TrainerPositions[Q][i][j][1];
                         if(CheckDist <= distance){
                             if(!AngleIsFound(Math.atan2(y , x), Angles_Of_Directions, CountDirections, Q, trainer_position, your_position)){
                                 //System.out.println((CountDirections+1)+": ["+TrainerPositions[Q][i][j][0]+", "+TrainerPositions[Q][i][j][1]+"]"); 
                                 Angles_Of_Directions[CountDirections++]= Math.atan2(y , x);
                              }
                          }
                       }
                }
            }
        }
        
        return CountDirections;
    }
    
    
    public static void main(String[] args){
        int[] dimensions=new int[2];
        int[] your_position= new int[2];
        int[] trainer_position= new int[2];
        int distance;
        
        
        System.out.println("Hello, World!");
        
        //[3,2], [1,1], [2,1], 4
        
        dimensions[0]= 3;
        dimensions[1]= 2;
        
        your_position[0]= 1;
        your_position[1]= 1;
        
        trainer_position[0]= 2;
        trainer_position[1]= 1;
        
        distance= 4;
        
        System.out.println(solution(dimensions, your_position, trainer_position, distance) );
        
        
        //
        dimensions[0]=300;
        dimensions[1]=275;
        
        your_position[0]= 150;
        your_position[1]= 150;
        
        trainer_position[0]= 100;
        trainer_position[1]= 185;
        
        distance= 500;
        
        System.out.println(solution(dimensions, your_position, trainer_position, distance));
        
        
        //
        dimensions[0]=2;
        dimensions[1]=5;
        
        your_position[0]= 1;
        your_position[1]= 2;
        
        trainer_position[0]= 1;
        trainer_position[1]= 4;
        
        distance= 11;
        
        System.out.println(solution(dimensions, your_position, trainer_position, distance));
        
        
        
        //
        dimensions[0]=23;
        dimensions[1]=10;
        
        your_position[0]= 6;
        your_position[1]= 4;
        
        trainer_position[0]= 3;
        trainer_position[1]= 2;
        
        distance= 23;
        
        System.out.println(solution(dimensions, your_position, trainer_position, distance));
        
        
        
        //
        dimensions[0]= 4;
        dimensions[1]= 4;
        
        your_position[0]= 1;
        your_position[1]= 1;
        
        trainer_position[0]= 2;
        trainer_position[1]= 2;
        
        distance= 6;
        
        System.out.println(solution(dimensions, your_position, trainer_position, distance));
        
        
        
        
    } 
    
}