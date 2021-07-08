package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;
        Solution other = (Solution) obj;
        return (other.first == null && first == null || other.first.equals(first)) &&
                (other.last == null && last == null || other.last.equals(last));
    }

    public int hashCode() {
        return 31 * (first == null? 0: first.hashCode()) + (last == null? 0: last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

        s.add(new Solution("Donald", null));
        System.out.println(s.contains(new Solution("Donald", null)));

    }
}
