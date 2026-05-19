class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) {
                matches++;
            }
        }

        int l = 0;

        // sliding window
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            // add right character
            int indexR = s2.charAt(r) - 'a';
            count2[indexR]++;

            if (count1[indexR] == count2[indexR]) {
                matches++;
            }

            else if (count1[indexR] + 1 == count2[indexR]) {
                matches--;
            }

            // remove left character
            int indexL = s2.charAt(l) - 'a';
            count2[indexL]--;

            if (count1[indexL] == count2[indexL]) {
                matches++;
            }

            else if (count1[indexL] - 1 == count2[indexL]) {
                matches--;
            }

            l++;
        }

        return matches == 26;
    }
}
