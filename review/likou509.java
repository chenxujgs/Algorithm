package suanfa.likou.review;

public class likou509 {
    public static void main(String[] args) {
        System.out.println(likou509.fib(4));
    }
    public static int fib(int n) {
         if(n<2) return n;
         int[] res=new int[n+1];
         res[0]=0;
         res[1]=1;
         res[2]=1;
        if(n<2) return res[n];
        for (int i = 3; i <n+1 ; i++) {
            res[i]=res[i-1]+res[i-2]+res[i-3];
        }
        return res[n];
    }
}
