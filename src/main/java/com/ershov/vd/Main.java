package com.ershov.vd;

public class Main {

    private static StringBuilder out;

    public static String main(String[] args) {
        out = new StringBuilder();
        boolean checkValid = checkValid(args[0]);
        if (checkValid) {
            parse(args[0]);
        } else {
            return "-1";
        }
        return out.toString();
    }

    public static boolean checkValid(String str) {
        int countNum = 0;
        int count = 0;
        int countleft = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                countNum++;
                if ((i + 1) == str.length()) {
                    return false;
                } else if (str.charAt(i + 1) != '[') {
                    return false;
                }
            } else {
                if (c == ']') {
                    count--;
                } else if (c == '[') {
                    countleft++;
                    count++;
                }
            }
        }
        return count == 0 && countNum == countleft;
    }

    private static void parse(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                i += repeat(Integer.parseInt(String.valueOf(str.charAt(i))), str.substring(i + 1));
            } else {
                out.append(str.charAt(i));
            }
        }
    }

    private static int repeat(int count, String str) {
        int j = 0;
        int stack = 0;
        for (; j < str.length(); j++) {
            if (str.charAt(j) == ']') {
                stack--;
            } else if (str.charAt(j) == '[') {
                stack++;
            }
            if (stack == 0) {
                break;
            }
        }
        for (int i = 0; i < count; i++) {
            parse(str.substring(1, j));
        }
        return j+1;
    }
}
