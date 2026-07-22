class Solution {
    public int numOfSubarrays(int[] arr, int k, int t) {
        int sum = 0;
        int count = 0;

        for(int i = 0; i < k; i++){
            sum  += arr[i];
        }
        if(sum / k >= t){
            count++;
        }
        for(int i = k; i < arr.length; i++){
             sum = sum - arr[ i - k] + arr[i];
             if(sum / k >= t){
                count++;
             }
        }
        return count;
        
    }
}