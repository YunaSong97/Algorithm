class PG_43163 {
    boolean[] visit;
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];

        dfs(words, begin, target, 0);

        return answer;
    }
    private void dfs(String[] words, String begin, String target, int depth){

        if(begin.equals(target)){//target 으로 바꿔지면
            answer = depth;
            return;
        }

        for(int i=0; i<words.length; i++){
            if(!visit[i]){
                if(canChange(words[i], begin)) {
                    visit[i]=true;
                    dfs(words, words[i], target, depth+1);
                    visit[i]=false;
                }
            }
        }
    }
    private boolean canChange(String str1, String str2){
        int diff_cnt = 0;
        for(int j=0; j<str1.length(); j++){//몇글자 다른지
            if(str1.charAt(j)!= str2.charAt(j)){
                diff_cnt++;
            }
        }
        //한글자만 다름
        return diff_cnt == 1;
    }

}