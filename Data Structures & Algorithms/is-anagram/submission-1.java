class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()){
            char arrs[] = s.toCharArray();
            char arrt[] = t.toCharArray();

            Arrays.sort(arrs);
            Arrays.sort(arrt);

            boolean result = Arrays.equals(arrs, arrt);

            return result;
        }
        return false;
    }
}
