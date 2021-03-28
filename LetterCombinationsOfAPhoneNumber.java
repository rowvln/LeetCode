/*
    Letter Combinations of a Phone Number:

    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        // store our answers
        ArrayList<String> result = new ArrayList<>();
        
        // check for input and call DFS
        if(digits != null && digits.length() > 0){
            // map digits from 2-9 on a telephones numpad
            String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            // perform dfs on the map
            dfs(digits, map, result, new StringBuilder(), 0);
        }
        return result;
    }
    
    public void dfs(String digits, String[] map, ArrayList<String> result, StringBuilder sb, int index){
        // when we reach the end of the phone number(digits), add the valid letter combination to result
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        // get the current digits and what letter it represents
        int digit = Character.getNumericValue(digits.charAt(index));
        String letters = map[digit];
        
        //
        for(int i =0; i < letters.length(); i++){
            char ch = letters.charAt(i);
            sb.append(ch);
            dfs(digits, map, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}