class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        int mod = (int)1e9 + 7;

        int[] nse = new int[n];
        int[] pse = new int[n];
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                nse[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            nse[st.pop()] = n;
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                pse[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            pse[st.pop()] = -1;
        }
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            long total = (left * right) % mod;
            sum = (sum + (total * arr[i]) % mod) % mod;
        }

        return (int) sum;
    }
}
