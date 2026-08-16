package core.java.practice.java21;

public class StackOverflowError {

    public static void main(String[] args) {
        new StackOverflowError().stackOverflowProduce(1);
    }

    public void stackOverflowProduce(int count){
        if(count< 3000 ){
            System.out.println(count);
            stackOverflowProduce(count);
        }
    }

}
