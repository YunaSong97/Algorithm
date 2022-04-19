class PG_43162 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visit = BooleanArray(n) { false }
        for(x in 0 until n){
            if(!visit[x]){
                dfs(x, computers, visit)
                answer++
            }
        }
        return answer
    }
    private fun dfs(x : Int, computers: Array<IntArray>, visit : BooleanArray){
        visit[x] = true
        computers[x].forEachIndexed{index, connected ->
            if(connected==1 && !visit[index]){
                dfs(index, computers, visit)
            }
        }
    }
}