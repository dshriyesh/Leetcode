class Solution {
    public boolean find132pattern(int[] nums) {
        int max=Integer.MIN_VALUE;
        Stack<Integer> st= new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            if (nums[i] < max) {
                return true;
            }
            while(!st.isEmpty() && st.peek()<nums[i]){
               max=st.pop();
            }
            st.add(nums[i]);
        }
        return false;
    }
}