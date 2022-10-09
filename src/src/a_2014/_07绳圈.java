package src.a_2014;

/*
标题:绳圈
今有100根绳子，当然会有200个绳头。
如果任意取绳头两两配对，把所有绳头都打结连接起来。最后会形成若干个绳圈(不考 虑是否套在一起)。

我们的问题是:请计算最后将形成多少个绳圈的概率最大?


注意:结果是一个整数，请通过浏览器提交该数字。不要填写多余的内容。

 */
public class _07绳圈 {
    public static void main(String[] args) {
        double[][] f = new double[101][101];
        f[1][1] = 1;//一个圈组成一个

        for (int sheng = 2; sheng <= 100; sheng++) {
            f[sheng][1] = f[sheng - 1][1] * (sheng - 1) * 2 / (2*sheng-1);
            for (int quan = 2; quan <= sheng; quan++) {
                f[sheng][quan] = (f[sheng - 1][quan] * (sheng - 1) * 2 + f[sheng - 1][quan - 1]) / (2 * sheng - 1);

            }

        }
        double max = -1;
        int ans = -1;

        for (int i = 1; i <=100; i++) {
            if (f[100][i]>max){
                max = f[100][i];
                ans = i;
            }

        }
        System.out.println(ans);
    }
}
