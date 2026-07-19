class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(0, s, ans, curr);
        return ans;
        
    }
    public void backtrack(int index, String s, List<String> ans, List<String> curr){
          
          if(index == s.length() && curr.size() == 4){
              ans.add(String.join(".", curr));
              return;
          }
          if(curr.size() == 4){
             return;
          }

          for(int i = index; i < Math.min(index + 3, s.length()); i++){
               String segment = s.substring(index, i + 1);
                if(valid(segment)){
                     curr.add(segment);
                     backtrack(i + 1, s, ans, curr);
                     curr.remove(curr.size() - 1);
                }
          }
    }
    public boolean valid(String segment){
        if(segment.length() > 1 && segment.charAt(0) == '0'){
              return false;
        }
        int num = Integer.parseInt(segment);
        return num >=0 && num <= 255;
    }
}