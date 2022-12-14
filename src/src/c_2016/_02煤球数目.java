package src.c_2016;

/*
煤球数目
        有一堆煤球，堆成三角棱锥形。具体:
        第一层放1个，
        第二层3个(排列成三角形)，
        第三层6个(排列成三角形)
        第四层10个(排列成三角形)，
        如果共有100层， 共有多少个煤球?
        请填表示煤球总数目的数字。
        注意:你提交的应该是个整数， 不要填写任何多余的内容或说明性文字。
        */

//100层， 共有多少个煤球?
// 1 (2)3 (3)6 (4)10
public class _02煤球数目 {
    public static void main(String[] args) {
        int p = 1; //第一层 上一层
        int plus = 2; //第二层的增量
        int sum = 1; //总和

        for (int i = 2; i <= 100; i++) {
            p = (p + plus);

            sum += p;
            plus++;

        }
        System.out.println(sum);

    }
}
