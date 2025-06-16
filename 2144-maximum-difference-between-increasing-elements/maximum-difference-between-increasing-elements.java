class Solution {
    public int maximumDifference(int[] nums) {
        int maxdiff=-1;
        int min_sofar=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>min_sofar){
                maxdiff=Math.max(maxdiff,nums[i]-min_sofar);
                
            }
            else{
                min_sofar=nums[i];
            }
        }
        return maxdiff;
    }
}