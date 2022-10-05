class Testing_Solution {
    
    public static int solution(int n) {
        if(n <= 2){
            return 0;
        }
        int[][] Ans = new int[n+1][n+1];
        
        Ans[0][0]= 1;
        /*for(int i=1; i<= n; i++){
            for(int j=0; j<= n; j++){
                
                
                Ans[i][j]= Ans[i-1][j];
                
                if(j>= i){
                    int ComplementOf_J= j - i;
                    Ans[i][j]= Ans[i][j] + Ans[i-1][ComplementOf_J];
                }
                
                
            }
        }*/
        int i=0, j=1;
        while(i< n+1){
            if(j>= n+1){
                j=1;
                i++;
                continue;
            }
            
            /*if(i==0 && j != 0){
                Ans[i][j]=1;
            }*/
            Ans[i][j]= Ans[i][j-1];
            if(i>= j){
                Ans[i][j]= Ans[i][j] + Ans[i-j][j-1];
            }
            j++;
        }
        
        for(i=0; i<=n; i++){
            for(j=0; j<=n; j++){
                System.out.print(Ans[i][j]+"\t");
            }
            System.out.println();
        }
        return Ans[n][n] - 1;
    }
    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}