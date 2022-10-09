package src.b_2015;

/*
立方变自身
观察下面的现貌，某个数字的立方，按位累加仍然等于自身。
1 ^ 3 = 1
8 ^ 3 = 512   5+1+2=8
17^ 3 = 4913   4+9+1+3=17
请你计算包括1,8, 17在内，符合这个性质的正整数-共有多少个?
请填写该数字，不要填写任何多余的内容或说明性的文字。

*/
//想清楚边界 99
//ans = 6;
public class _02立方变自身 {
    public static void main(String[] args) {

        //一个数的立方越大，越是不可能的等于本身
        int ans = 0;
        for (int i = 1; i <= 99; i++) {
            int num = i*i*i;
            //求num的几个数相加
            int sum = sum(num);

            if (i == sum){
                System.out.println(i+" "+num);
                ans++;
            }
        }
        System.out.println(ans);


    }

    //将num中的各个位相加
    private static int sum(int num) {
        String str = num + "";
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans += str.charAt(i)-'0';

        }
        return ans;
    }


}
