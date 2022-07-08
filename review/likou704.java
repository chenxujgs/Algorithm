package suanfa.likou.review;

public class likou704 {
    public static void main(String[] args) {
        //System.out.println(10/2);
        System.out.println(likou704.search(new int[]{0,5,6,9}, 2));
    }
    public static int search(int[] nums, int target) {
          int start=0,end=nums.length-1,mid=0;
          while(start<=end){
              mid=(start+end)>>1;
              if(target>nums[mid]){
                  start=mid+1;
              }else if(target<nums[mid]){
                  end=mid-1;
              }else{
                  return mid;
              }
          }
        return -1;
    }
}
