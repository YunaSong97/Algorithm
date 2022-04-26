import java.util.Stack;

class PG_64061 {
    int answer = 0;

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<Integer>();

        for (int i = 0; i < moves.length; i++) {
            int now = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                if (board[j][now] != 0) {
                    put(basket, board[j][now]);
                    board[j][now] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    private void put(Stack<Integer> basket, int newDoll){
        if (!basket.isEmpty() && basket.peek() == newDoll) {
            answer += 2;
            basket.pop();
        }
        else{
            basket.add(newDoll);
        }
    }
}
