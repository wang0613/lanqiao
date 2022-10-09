package src.a_2017;

/*
有 N种物品和一个容量为 V的背包，每种物品只能装1件。
第i种物品的费用是v，价值是w。
求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。


 */
public class 背包 {
    public static void main(String[] args) {
        int max = 10;          //最大载重

        int[] w = {0, 3, 4, 5};//重量

        int[] v = {0, 4, 5, 2};//价格

        //创建二维数组，实现所有情况:横向以此是背包载重，纵向是物品列表,将每次最优结果填充到该数组中
        int[][] maxValue = new int[w.length][max];

        //外层是背包的容量，依次从0-max，一个个测试
        for (int i = 0; i < max; i++) {

            //每一次背包确定载重时，依次拿物品来装，取得当前载重最高价值
            for (int n = 0; n < w.length; n++) {
                if (i == 0 || n == 0) {//起始状态

                    maxValue[n][i] = 0;

                } else {//否则，开始判断当前物品能否放到当前载重的背包中
                    if (i < w[n]) {//当前物品重量是超过载重的,则使用上一次最优结果
                        maxValue[n][i] = maxValue[n - 1][i];
                    } else {
                        //否则，可以放也可以不放，分别计算放 和 不放 的结果
                        int v1 = maxValue[n - 1][i];//不放，就是上次最大值了
                        int v2 = maxValue[n - 1][i - w[n]] + v[n];//放，则将上一次最大价值加上本次价值
                        maxValue[n][i] = Math.max(v1, v2);

                    }
                }

            }

        }
        for (int n = 0; n < w.length; n++) {
            for (int i = 0; i < max; i++) {
                System.out.print(maxValue[n][i] + "\t");
            }
            System.out.println();
        }
        System.out.println(maxValue[w.length - 1][max - 1]);


    }
}
