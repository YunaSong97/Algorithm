import java.util.*;

class PG_64065 {
    public int[] solution(String s) {
        int[] answer;
        String[] temp;
        ArrayList<String> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();

        temp = s.split("[{]|}|,");

        for (String value : temp) {
            if (!Objects.equals(value, ",") && !Objects.equals(value, "")) {
                list.add(value);
            }
        }

        Set<String> set = new HashSet<>(list);
        for (String str : set) {
            map.put(Collections.frequency(list, str), str);
        }

        int size = set.size();
        answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i]= Integer.parseInt(map.get(size-i));
        }

        return answer;
    }
}

