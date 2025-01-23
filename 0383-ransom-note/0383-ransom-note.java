import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr1 = new int[('z' - 0) + 1];
        int[] arr2 = new int[('z' - 0) + 1];

        for (int i = 0; i < ransomNote.length(); i++) {
            arr1[ransomNote.charAt(i) - 0]++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            arr2[magazine.charAt(i) - 0]++;
        }

        for (int i = ('a' - 0); i <= ('z' - 0); i++) {
            if (arr1[i] > arr2[i]) {
                return false;
            }
        }

        return true;
    }
}