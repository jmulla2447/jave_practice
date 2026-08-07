package core.java.practice.leet.code2;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappyNumber(long number){
        boolean isHappy = true;
        HashSet<Long> uniqueNextNumber = new HashSet<>();
        uniqueNextNumber.add(number);

        while ((number = generateNextNumber(number)) != 1L) {
            if (!uniqueNextNumber.add(number)) {
                isHappy = false;
                break;
            }
        }

        return isHappy;

    }

    private long generateNextNumber(long number){
        long sum = 0;
        while(number/10 != 0){
            sum += (long)Math.pow(number%10,2);
            number  = number/10;
        }
        sum += (long)Math.pow(number%10,2);
        return sum;
    }
}
