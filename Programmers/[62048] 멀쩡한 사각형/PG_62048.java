class PG_62048 {
    public long solution(int w, int h) {
        long answer = 0;

        for (int j = 1; j <= w; j++) {
            answer +=  (long) Math.floor(h - ((h / (double)w) * j)); //나누는 수에 double 하면 실수 결과값
        }

        return answer*2;
    }
}