//20437번. 문자열 게임 2
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> idx;
    static int maxLen, minLen;
    static HashMap<Character, ArrayList<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = stoi(br.readLine());
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                            'n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for (int t = 0; t < testCase; t++) {
            maxLen = Integer.MIN_VALUE;
            minLen = Integer.MAX_VALUE;
            char[] words = br.readLine().toCharArray();
            map = new HashMap<>();
            int k = stoi(br.readLine());
            for (int i = 0; i < words.length; i++) {
                if(map.containsKey(words[i])) { //map에 키가 존재하면,
                    ArrayList<Integer> key = map.get(words[i]);
                    key.add(i);
                    map.put(words[i], key);
                } else { //map에 키가 존재하지 않으면, key에 맞는 value로, 새 arraylist를 할당시켜 줌.
                    map.put(words[i], new ArrayList<>(Arrays.asList(i)));
                }
            }
            for (int i = 0; i < alphabet.length; i++) {
                //해당 알파벳이 단어안에 있고, 그 갯수가 k보다 크거나 같으면,
                if(map.containsKey(alphabet[i]) && map.get(alphabet[i]).size() >= k) {
                    idx = map.get(alphabet[i]);
                    Collections.sort(idx);
                    for (int j = 0; j < idx.size() - k + 1; j++) {
                        int wordLen = idx.get(j+k-1) - idx.get(j) + 1;// 단어 길이이므로, idx 차이에서 + 1
                        minLen = Math.min(wordLen, minLen);
                        maxLen = Math.max(wordLen, maxLen);
                    }
                }
            }
            if(maxLen == Integer.MIN_VALUE || minLen == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(minLen + " " + maxLen);
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}