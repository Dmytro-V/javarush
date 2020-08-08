package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int temp = number;
        List<Integer> rests = new ArrayList<>();
        do {
            int rest = temp % 3;
            rests.add(rest);
            temp = temp / 3;
            if (rest == 2) {
                temp++;
            }
        } while (temp >= 3);
        rests.add(temp);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rests.size() - 1; i++) {
            result.add(rests.get(i) == 2 ? -1 : rests.get(i));
        }
        int lastRest = rests.get(rests.size() - 1);
        if (lastRest == 2) {
            result.add(-1);
            result.add(1);
        } else {
            result.add(lastRest);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(number + " =");
        for (int i = 0; i < result.size(); i++) {
            switch (result.get(i)) {
                case 1:
                    sb.append(" + ");
                    break;
                case -1:
                    sb.append(" - ");
                    break;
                case 0:
                    continue;
            }
            sb.append((int) Math.pow(3, i));
        }


        System.out.println(sb.toString());
    }
}