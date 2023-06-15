package core.java.practice.leet.code;

public class FizzBuzz {


    public static String run(int N, int M) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        StringBuilder sequence = new StringBuilder();
        for (int i = N; i <= M; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                sequence.append("FizzBuzz,");
            } else if (i % 3 == 0) {
                sequence.append("Fizz,");
            } else if (i % 5 == 0) {
                sequence.append("Buzz,");
            } else {
                sequence.append(i + ",");
            }
        }
        sequence.delete(sequence.lastIndexOf(","),sequence.lastIndexOf(",")+1);

        return sequence.toString();
    }

}
