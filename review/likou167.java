package suanfa.likou.review;

public class likou167 {
    public static void main(String[] args) {
        int[] ints = likou167.twoSum(new int[]{2, 3,4}, 6);
        for (int i = 0; i <ints.length ; i++) {
            System.out.println(ints[i]);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
           int left=0,right=numbers.length-1;
           int sum=0;
           int[] result=new int[2];
           while(left!=right){
               sum=numbers[left]+numbers[right];
               if(sum>target){
                   right--;
               }else if(sum<target){
                   left++;
               }else {
                   result[0]=left+1;
                   result[1]=right+1;
                   break;
               }
           }
        return result;
    }
}
