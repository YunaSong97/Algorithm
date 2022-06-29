package PG;

import java.util.*;

class PG_72412{
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        for (String dev : info) {
            String[] token = dev.split(" ");
            String str = token[0].substring(0, 2) + token[1].substring(0, 2) + token[2].substring(0, 2) + token[3].substring(0, 2);

            ArrayList<Integer> list = new ArrayList<>();
            if (!hashMap.containsKey(str)) {
                list.add(Integer.parseInt(token[4]));
            } else {
                list = hashMap.get(str);
                list.add(Integer.parseInt(token[4]));
            }
            hashMap.put(str, list);
        }

        for (Map.Entry<String, ArrayList<Integer>> entrySet : hashMap.entrySet()) {
            Collections.sort(entrySet.getValue());
        }

        int cnt = 0;
        for (String q : query) {
            String[] token = q.split(" ");
            for (int i = 0; i < 4; i++) {
                if (token[i * 2].equals("-")) {
                    token[i * 2] = "";
                }
            }
            for (Map.Entry<String, ArrayList<Integer>> entrySet : hashMap.entrySet()) {
                String entryKey = entrySet.getKey();
                ArrayList<Integer> entryValue = entrySet.getValue();

                if (entryKey.contains(token[0].substring(0, Math.min(2, token[0].length()))) && entryKey.contains(token[2].substring(0, Math.min(2, token[2].length()))) && entryKey.contains(token[4].substring(0, Math.min(2, token[4].length()))) && entryKey.contains(token[6].substring(0, Math.min(2, token[6].length())))) {
                    int idx = binarySearch1(entryValue, Integer.parseInt(token[7]), 0, entryValue.size() - 1);
                    answer[cnt] += entryValue.size() - idx;
                }
            }
            cnt++;

        }

        return answer;
    }

    int binarySearch1(ArrayList<Integer> arr, int key, int low, int high) {
        int mid;

        if(low <= high) {
            mid = (low + high) / 2;

            if(key <= arr.get(mid)) {
                return binarySearch1(arr, key ,low, mid-1);
            } else {
                return binarySearch1(arr, key, mid+1, high);
            }
        }

        return low;
    }
}
