public class Testing_MyCorrect_Solution_Q2_Lvl3_foobar{
	public static int solution(int n) {
        if(n <= 2){
            return 0;
        }
        int[][] Ans = new int[n+1][n+1];
        
        Ans[0][0]= 1;
        int i=0, j=1;
        
        while(i< n+1){
            if(j>= n+1){
                j=1;
                i++;
                continue;
            }
            
            Ans[i][j]= Ans[i][j-1];
            if(i>= j){
                int ComplementOf_I=i-j;
                Ans[i][j]= Ans[i][j] + Ans[ComplementOf_I][j-1];
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