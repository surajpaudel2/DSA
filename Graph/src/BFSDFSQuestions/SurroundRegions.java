package BFSDFSQuestions;

public class SurroundRegions {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (!visited[i][0] && board[i][0] == 0) {
                dfs(board, visited, i, 0);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (!visited[i][board[0].length - 1] && board[i][board[0].length - 1] == 0) {
                dfs(board, visited, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (!visited[0][i] && board[0][i] == 0) {
                dfs(board, visited, 0, i);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (!visited[board.length - 1][i] && board[board.length - 1][i] == 0) {
                dfs(board, visited, board.length - 1, i);
            }
        }

        fillWithX(board, visited);
    }

    int[] rows = {0, 0, 1, -1};
    int[] cols = {1, -1, 0, 0};

    public void dfs(char[][] board, boolean[][] visited, int row, int col) {
        if (row >= board.length || row < 0 || col >= board[row].length || col < 0) {
            return;
        }

        if (board[row][col] == 'X') {
            return;
        }

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            dfs(board, visited, row + rows[i], col + cols[i]);
        }
    }

    public void fillWithX(char[][] board, boolean[][] visited) {
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
