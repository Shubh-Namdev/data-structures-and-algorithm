import java.util.*;


public class Solution {
    // TODO: Create your data structure here
    List<Integer> solutions = new ArrayList<>();

    public void insert(int element) {
        solutions.add(element);
    }

    public int getMax() {
        int i =0,max = Integer.MIN_VALUE,maxIndex = 0;
        int listSize = this.solutions.size();

        while(i < listSize) {
            int element = this.solutions.get(i);
            if(element > max) {
                max = element;
                maxIndex = i;
            }
            i++;
        }
        this.solutions.remove(maxIndex);
        return max;
    }
};
