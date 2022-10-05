// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.lang.Math;
public class Solution {   
    private static boolean AngleIsFound(double angle, double[] Angles, int size){
        int i=0;
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
        double ShootingRange_X= your_position[0] + trainer_position[0] + distance;
        double ShootingRange_Y= your_position[1] + trainer_position[1] + distance;
        
        if( (trainer_position[0] - your_position[0] ) * (trainer_position[0] - your_position[0]) + (trainer_position[1] - your_position[1] ) * (trainer_position[1] - your_position[1] )  > distance * distance || Math.pow(trainer_position[0] - your_position[0] ,2) + Math.pow(trainer_position[1] - your_position[1] ,2) == 0){
            return 0;
        }
        
        
        
        Double Mirror_OnX= new Double(Math.ceil(ShootingRange_X / OriginalWidth) );
        Double Mirror_OnY= new Double(Math.ceil(ShootingRange_Y / OriginalHeight) );
        Double Positions= new Double(Mirror_OnX * Mirror_OnY);
        
        double[] Angles_Of_Directions= new double[Positions.intValue() * 4];
        
        int [][][][] TrainerPositions= new int[4][Mirror_OnX.intValue()][Mirror_OnY.intValue()][2];
        
        int InWidthBeforePos= trainer_position[0];
        int InWidthAfterPos= dimensions[0] - InWidthBeforePos;
        
        int InHeightBelowPos= trainer_position[1];
        int InHeightAbovePos= dimensions[1] - InHeightBelowPos;
        
        int k=0;        
                
        for(int i=0; i< Mirror_OnX.intValue(); i++){
            for(int j=0; j< Mirror_OnY.intValue(); j++){
                /*if(i==0){
                    /////////////////0
                }*/
                
                
                if(i==0 && j==0){
                    TrainerPositions[0][i][j]= trainer_position;
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
                    TrainerPositions[0][i][j][0]= TrainerPositions[0][i][j-1][0];
                    
                    if(j % 2 == 0){
                        TrainerPositions[0][i][j][1]= j * dimensions[1] + InHeightBelowPos;                        
                    }
                    else{
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
                        TrainerPositions[Q][i][j][1]= TrainerPositions[0][i][j][1];
                        
                    }
                    else if(Q == 2){
                        TrainerPositions[Q][i][j][0]= TrainerPositions[0][i][j][0] * -1;
                        TrainerPositions[Q][i][j][1]= TrainerPositions[0][i][j][1] * -1;
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
                    
                    if(Q==0 && i==0 && j==0 ){
                        CheckDist= Math.sqrt( Math.pow(TrainerPositions[Q][i][j][0] - your_position[0], 2) + Math.pow(TrainerPositions[Q][i][j][1] - your_position[1], 2) );
                        x= TrainerPositions[0][0][0][0];
                        y= TrainerPositions[0][0][0][1];
                        
                        if(CheckDist <= distance){
                            Angles_Of_Directions[CountDirections++]= Math.atan2(y , x);
                        }
                        
                    }
                    
                    if(TrainerPositions[Q][i][j][0] == 0 && TrainerPositions[Q][i][j][1] == 0){
                        continue;
                    }
                    else if(TrainerPositions[Q][i][j][0] != your_position[0] && TrainerPositions[Q][i][j][1] != your_position[1]){
                        if(CheckDist <= distance && CheckDist > 0){
                             if(!AngleIsFound(Math.atan2(y , x), Angles_Of_Directions, CountDirections)){
                                      Angles_Of_Directions[CountDirections++]= Math.atan2(y , x);
                              }
                          }
                          
                      }
                }
            }
        }
        
        return CountDirections;
    }
    
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}