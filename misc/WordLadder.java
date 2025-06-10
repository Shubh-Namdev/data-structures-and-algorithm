import java.io.*;
import java.util.*;

class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        boolean isEndWordPresent = false;
        for (String word : wordList) {
            set.add(word);
            if (word.equals(endWord)) isEndWordPresent = true;
        }
        if (!isEndWordPresent) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int shortestPath = 0;

        while (!q.isEmpty()) {
            shortestPath += 1;
            int size = q.size();
            while (size-- > 0) {
                String word = q.remove();

                for (int i=0; i<word.length(); i++) {
                    char []wordArr = word.toCharArray();
                    char ch = wordArr[i];

                    for (char j='a'; j<='z'; j++) {
                        wordArr[i] = j;
                        String newWord = new String(wordArr);

                        if (!set.contains(newWord)) continue;
                        if (newWord.equals(endWord)) return shortestPath+1;
                        set.remove(newWord);
                        q.add(newWord);
                    }
                    wordArr[i] = ch;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String beginWord = scanner.nextLine();
        String endWord = scanner.nextLine();

        int n = scanner.nextInt();
        List<String> wordList = new ArrayList<String>();

        for (int i = 0; i < n; ++i) {
            String word = scanner.next();
            wordList.add(word);
        }
        scanner.close();
        int result = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
