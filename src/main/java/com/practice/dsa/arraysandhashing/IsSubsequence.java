package main.java.com.practice.dsa.arraysandhashing;

public class IsSubsequence {
    public static boolean isSubsequence(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.isEmpty()) return true;
        int t2 = 0;
        for(char c : s2.toCharArray()) {
            if(c == s1.charAt(t2)) {
                t2++;
            }
        }
        return t2 == s1.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("", "ahbgdc"));    // true
        System.out.println(isSubsequence("ace", "abcde"));  // true
        System.out.println(isSubsequence("aec", "abcde"));  // false
    }
}
