package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

import static com.javarush.task.task14.task1408.Country.*;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(BELARUS);
        hen.getCountOfEggsPerMonth();
        //System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if (country == BELARUS)
                hen = new BelarusianHen();
            else if (country == MOLDOVA)
                hen = new MoldovanHen();
            else if (country == RUSSIA)
                hen = new RussianHen();
            else if (country == UKRAINE)
                hen = new UkrainianHen();

            return hen;
        }
    }

}
