class Solution_Q2_Lvl3_foobar{
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
                int ComplementOf_I_J=i-j;
                Ans[i][j]= Ans[i][j] + Ans[ComplementOf_I_J][j-1];
            }
            
            j++;
        }

        
        return Ans[n][n] - 1;
    }

	public static void main(String[] args) {
        System.out.println(solution(5));
    }
	
	}