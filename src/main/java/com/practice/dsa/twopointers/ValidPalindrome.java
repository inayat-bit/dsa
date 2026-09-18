package main.java.com.practice.dsa.twopointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        String lowerCase = s.toLowerCase();
        if(lowerCase.isEmpty()) return true;
        while (left < right) {
            while(left < right && !Character.isLetterOrDigit(lowerCase.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(lowerCase.charAt(right))) right--;
            if(lowerCase.charAt(left) != lowerCase.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome(" ")); // true
        System.out.println(isPalindrome("0P")); // false
        System.out.println(isPalindrome("Madam")); // true
    }
}
