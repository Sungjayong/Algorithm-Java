package com.company;

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> receivedMailCountMap = new LinkedHashMap<>();
        int[] answer = new int[id_list.length];

        for(String id : id_list) {
            reportMap.put(id, new HashSet<>());
            receivedMailCountMap.put(id, 0);
        }

        for(String r : report){
            String[] output = r.split(" ");
            String reporter = output[0];
            String reportee = output[1];
            Set<String> newSet = new HashSet<String>();
            newSet.addAll(reportMap.get(reportee));
            newSet.add(reporter);
            reportMap.put(reportee, newSet);
        }

        for(String id : id_list) {
            if(reportMap.get(id).size() >= k) {
                for(String receiver : reportMap.get(id)) {
                    receivedMailCountMap.put(receiver, receivedMailCountMap.get(receiver) + 1);
                }
            }
        }
        Collection<Integer> collection = receivedMailCountMap.values();
        answer = collection.stream().mapToInt(i->i).toArray();
        return answer;
    }
}