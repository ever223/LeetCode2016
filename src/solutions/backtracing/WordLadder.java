package solutions.backtracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-08 21:59.
 * @DESCRIPTION:
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        if (wordList.size() == 0) {
            return 0;
        }

        ArrayList<String> wordQueue = new ArrayList<>();
        ArrayList<Integer> distanceQueue = new ArrayList<>();

        wordQueue.add(beginWord);
        distanceQueue.add(1);
        wordList.add(endWord);
        Integer minDistance = Integer.MAX_VALUE;
        while (!wordQueue.isEmpty()) {
            String str = wordQueue.remove(0);
            Integer currentDistance = distanceQueue.remove(0);
            if (str.equals(endWord)) {
                minDistance = Math.min(minDistance, currentDistance);
            }
            for (int i = 0; i < str.length(); i ++) {
                char[] currCharArr = str.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    currCharArr[i] = j;
                    String temp = new String(currCharArr);
                    if (wordList.contains(temp)) {
                        wordQueue.add(temp);
                        distanceQueue.add(currentDistance  + 1);
                        wordList.remove(temp);
                    }
                }
            }
        }
        return minDistance < Integer.MAX_VALUE ? minDistance : 0;
    }



    // 超时
    public int ladderLength1(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null
                || beginWord.length() == 0
                || endWord == null
                || endWord.length() == 0
                || wordList == null
                || wordList.size() == 0) {
            return 0;
        }

        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        if (wordList.contains(endWord)) {
            wordList.remove(endWord);
        }

        List<String> ladder = new ArrayList<>();
        ladder.add(beginWord);
        return ladderLength(endWord, ladder, new ArrayList<String>(wordList));
    }
    public int ladderLength(String endWord, List<String> ladder, List<String> wordList) {
        String lastWord = ladder.get(ladder.size() - 1);
        if (isLadder(lastWord, endWord)) {
            return ladder.size() + 1;
        }
        if (wordList.size() == 0) {
            return 0;
        }
        int minLen = 0;
        for(int i = 0; i < wordList.size(); i ++) {
            String word = wordList.get(i);
            if (isLadder(lastWord, word)) {
                ladder.add(word);
                wordList.remove(i);
                int tempLen = ladderLength(endWord, ladder, wordList);
                if(tempLen != 0) {
                    if (minLen != 0) {
                        minLen = Math.min(minLen, tempLen);
                    } else {
                        minLen = tempLen;
                    }
                }
                ladder.remove(ladder.size() - 1);
                wordList.add(i, word);
            }
        }
        return minLen;
    }
    public boolean isLadder(String s1, String s2) {
        boolean diffOne = false;
        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffOne) {
                    return false;
                } else {
                    diffOne = true;
                }
            }
        }
        return true;
    }



}
