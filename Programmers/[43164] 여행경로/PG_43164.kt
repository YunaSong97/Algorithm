class PG_43164  {
    private lateinit var visit : MutableList<Boolean>
    private var allRoute : MutableList<String> = arrayListOf()
    //Array vs List
    //https://youjourney.github.io/archivers/ARRAYLIST

    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()

        visit = MutableList(tickets.size) { false }
        dfs("ICN", 0, "ICN", tickets)

        allRoute.sort()
        answer = allRoute[0].split(" ").toTypedArray()
        return answer
    }
    private fun dfs(start: String, cnt : Int, route: String, tickets: Array<Array<String>>){
        if(cnt == tickets.size){//경로 발견
            allRoute.add(route)

        }
        for(i in tickets.indices){
            if(start == tickets[i][0] && !visit[i]){
                visit[i]=true
                dfs(tickets[i][1], cnt+1, route + " " +tickets[i][1], tickets)
                visit[i]=false
            }
        }
    }
}
