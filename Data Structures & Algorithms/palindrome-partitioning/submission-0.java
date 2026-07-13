class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());
        return ans;
    }

    public void backtrack(int index, String s, List<String> curr) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
        }
        for (int i = index; i < s.length(); i++) {
            if (ispalindrome(index, i, s)) {
                curr.add(s.substring(index, i + 1));
                backtrack(i + 1, s, curr);
                curr.remove(curr.size() - 1);

            }
        }
    }

    public boolean ispalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

}