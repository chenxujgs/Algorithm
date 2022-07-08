package suanfa.likou.A20220707;

/**
 * @author cxj
 * @date 2022/2/28
 * @description
 */
public class likou43 {
    public static void main(String[] args) {
        System.out.println(new likou43().multiply("00", "123"));
    }
    public String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
            return "0";
        }
        int n1=num1.length();
        int n2=num2.length();
        int[] temp=new int[n1+n2];
        for (int i = n1-1; i >=0 ; i--) {
            for (int j = n2-1; j >=0 ; j--) {
                int pro = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                temp[i+j+1]+=pro;
            }
        }

        int add=0;
        for (int i = n1+n2-1; i >=0 ; i--) {
           temp[i]+=add;
           add=temp[i]/10;
           temp[i]%=10;
        }
        
        StringBuffer sb=new StringBuffer();

        for (int i = 0;i<n1+n2 ; i++) {
            sb.append(temp[i]);
        }
        num1 = new String(sb);
        if (num1.length() > 0 && num1.charAt(0) == '0')//结果最多只会出现首位是0的情况
            num1=num1.substring(1);
        return num1;
    }
}
