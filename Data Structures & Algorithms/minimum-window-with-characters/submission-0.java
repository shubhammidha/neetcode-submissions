class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();

        int l = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for(int r=0; r<s.length(); r++){

            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && countT.get(c).intValue() == window.get(c).intValue()){
                have++;
            }

            while(have == need){
                if((r - l + 1) < minLen){
                    minLen = r - l + 1;
                    start = l;
                }

                //shrink window
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if(countT.containsKey(leftChar) && countT.get(leftChar) > window.get(leftChar)){
                    have --;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
