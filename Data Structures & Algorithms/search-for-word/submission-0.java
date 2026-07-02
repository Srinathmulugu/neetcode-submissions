class Solution {
    boolean ans = false;
    public boolean exist(char[][] board, String word) {
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                find(board,word, i, j,0);
                if(ans) return true;
            }
        }
        return ans;

    }
    public void find(char[][] board, String s, int i, int j, int index) {
         if( index >= s.length()){
            ans = true;
            return;
         }
         if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != s.charAt(index)){
              return;
         }
         char temp = board[i][j];
         board[i][j] = '#';
         find(board, s, i+1, j, index + 1);
         find(board, s, i-1, j, index + 1);
         find(board, s, i, j+1, index + 1);
         find(board, s, i, j-1, index + 1);
         board[i][j] = temp;
         
    }
}
