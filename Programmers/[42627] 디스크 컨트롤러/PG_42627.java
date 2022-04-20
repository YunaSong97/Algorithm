import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class PG_42627 {//SJF 소요시간 짧은거 우선
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0; //수행 직후 시간
        int job_count=0; //수행된 갯수
        int job = 0; //처리할 요청 번호

        Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));//요청시간 오름차순
        PriorityQueue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));//소요시간 오름차순

        while(job_count<jobs.length){
            while(job<jobs.length && jobs[job][0]<=time){
                queue.add(jobs[job++]);
            }
            if(queue.isEmpty()){
                //요청 없으면 다음 요청으로 시간을 바꿔줌
                time = jobs[job][0];
            }else{
                //요청이 있으면 수행시간 작은거부터 처리
                int[] job_do = queue.poll();
                time += job_do[1];//요청 끝난 시간
                answer += time - job_do[0];
                job_count++;
            }
        }

        return answer/jobs.length;
    }
}