class Solution {
    public String smallestSubsequence(String s) {
        boolean[] bool= new boolean[26];
        int[] position= new int[26];
        for(int i=0;i<s.length();i++){
            position[s.charAt(i)-'a']=i;
        }
        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (bool[ch - 'a']) continue;
            while(!st.isEmpty() && ch<st.peek() && position[st.peek()-'a']>i){
                bool[st.pop()-'a']=false;
            }
            st.push(ch);
            bool[ch-'a']=true;
        }
        StringBuilder str= new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.reverse().toString(); 
    }
}