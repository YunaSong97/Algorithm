public class PG_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x;//세로
        int y;//가로

        for(int i=1; i<=brown+yellow/2; i++){
            if((brown+yellow)%i==0){
                x=i;
                y=(brown+yellow)/i;
                if((x-2)*(y-2)==yellow){
                    answer[0] = y;
                    answer[1] = x;
                    break;
                }
            }
        }
        return answer;
    }
}
