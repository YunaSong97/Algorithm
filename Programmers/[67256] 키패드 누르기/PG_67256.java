class Hand{
    static class Left {
        Num pos;
        public Left(Num pos){
            this.pos = pos;
        }
    }

    static class Right {
        Num pos;
        public Right(Num pos){
            this.pos = pos;
        }
    }
}

class Num{
    int x; int y;

    public Num(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class PG_67256 {
    String answer = "";
    public String solution(int[] numbers, String hand) {
        Hand.Left left = new Hand.Left(new Num(1, 4));
        Hand.Right right = new Hand.Right(new Num(3, 4));
        Num num;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                num = new Num(numbers[i] % 3 + 3, numbers[i] / 3);
            } else if(numbers[i] == 0){
                num = new Num(2, 4);
            }else {
                num = new Num(numbers[i] % 3, numbers[i] / 3 + 1);
            }
            push(num, left, right, hand);
        }

        return answer;
    }

    private int getDist(Num a, Num b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private void push(Num num, Hand.Left left, Hand.Right right, String hand){
        if (num.x == 1) {
            left.pos = num;
            answer=answer+"L";
        } else if (num.x == 3) {
            right.pos = num;
            answer=answer+"R";

        }else{
            if(getDist(left.pos, num)<getDist(right.pos, num)){
                left.pos = num;
                answer=answer+"L";

            }else if(getDist(left.pos, num)>getDist(right.pos, num)){
                right.pos = num;
                answer=answer+"R";

            }else{
                if(hand.equals("right")){
                    right.pos = num;
                    answer=answer+"R";

                }else{
                    left.pos = num;
                    answer=answer+"L";

                }
            }
        }
    }
}