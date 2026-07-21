class Solution {
    String[] digitToChar = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return ans;
        }
        backtrack(0, "", digits);
        return ans;
    }

    private void backtrack(int i, String curr, String digits){
        if(curr.length() == digits.length()){
            ans.add(curr);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c: chars.toCharArray()){
            backtrack(i+1, curr+c, digits);
        }
    }
}
