package src.a_2016;


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
public class _01煤球数量 {
    public static void main(String[] args) {

        int p = 1; //上一层
        int plus = 2; //增量

        int sum = 1; //总和
        //第二层
        for (int i = 2; i <= 100; i++) {
            //加上每一层
            p = p + plus; //记录上一层
            sum += p; //第二层
            plus++; //每一层的增量

        }
        System.out.println(sum);
    }
}
