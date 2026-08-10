package com.prasad;

public class App 
{
    public double divide(int a, int b){
        return a/b;
    }

    public String reverseString(String str){
        int ptr = str.length() - 1;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            ans.append(str.charAt(ptr));
            ptr--;
        }

        return ans.toString();
    }
}
