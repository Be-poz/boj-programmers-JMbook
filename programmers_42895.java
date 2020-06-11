package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.HashSet;

//n으로 표현
class programmers_42895 {
    HashSet<Integer> check = new HashSet<Integer>();
    ArrayList<Integer>[] cache = new ArrayList[9];
    
    public int add(int left, int right) {
        return left + right;
    }
    
    public int sub(int left, int right) {
        return left - right;
    }
    
    public int mul(int left, int right) {
        return left * right;
    }
    
    public int div(int left, int right) {
        if (right == 0) return 0;
        return left / right;
    }
    
    public void addCache(int digit, int ret) {
        if (!check.contains(ret)) {
            check.add(ret);
            cache[digit].add(ret);
        }
    }
    
    public void cal(int digit, int left, int right) {
        addCache(digit, add(left, right));
        addCache(digit, sub(left, right));
        addCache(digit, mul(left, right));
        addCache(digit, div(left, right));
    }
    
    public void init(int N) {
        int temp = N;
        for (int i = 1; i < 9; i++) {
            cache[i] = new ArrayList<Integer>();
            cache[i].add(temp);
            temp *= 10;
            temp += N;
        }
    }
    
    public int solution(int N, int number) {
        
        if (N==number) {
            return 1;
        }
        
        int temp = N;
        for (int i = 1; i < 9; i++) {
            if (temp == number) return i;
            cache[i] = new ArrayList<Integer>();
            cache[i].add(temp);
            check.add(temp);
            temp *= 10;
            temp += N;
        }
        
        for (int digit = 1; digit < 9; digit++) {
            for (int i = 1; i < digit; i++) {
                int j = digit - i;
                for (int left : cache[i]) {
                    for (int right : cache[j]) {
                        cal(digit, left, right);
                        if (check.contains(number)) {
                            return digit;
                        }
                    }
                }
            }
        }
        return -1;
    }
}









