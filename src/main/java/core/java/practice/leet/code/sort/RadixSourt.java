package core.java.practice.leet.code.sort;

public class RadixSourt {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,1,2,3};
        int result = 0 ;
        for(int i : a){
            //System.out.println(i%10+" ==> ");

            result = result^i;
            System.out.println(result);
        }
        System.out.println(result);
    }
}
