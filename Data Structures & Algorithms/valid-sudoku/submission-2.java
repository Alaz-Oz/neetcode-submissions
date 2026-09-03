class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            int[] freqR = new int[10];
            int[] freqC = new int[10];
            for(int j = 0; j < 9; j++){
                char r = board[i][j];
                if (r != '.') {
                    freqR[r - '0']++;
                    if (freqR[r - '0'] > 1) return false;

                }

                char c = board[j][i];
                if (c == '.') continue;

                freqC[c - '0']++;
                if (freqC[c - '0'] > 1) return false;
            }
        }


        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int[] freqR = new int[10];
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        char r = board[i * 3 + k][j * 3 + l];

                        if (r == '.') continue;
                        freqR[r - '0']++;
                        if (freqR[r - '0'] > 1) return false;
                    }
                }

            }
        }

        return true;

    }
}
