package src.a_2013;

import java.util.ArrayList;

/**
 * 标题:颠倒的价牌
 * 小李的店里专卖其它店中下架的样品电视机，可称为:样品电视专卖店。
 * 其标价都是4位数字(即千元不等)
 * 小李为了标价清晰、方便，使用了预制的类似数码管的标价签，只要用颜色笔涂数字就可以了(参见p1. jpg)。
 * 这种价牌有个特点,对一些数字，倒过来看也是合理的数字。如: 1 2 5 6 8 9 0都可以。这样一来，如果牌子挂倒了,有可能完全变成了另-个价格,
 * 比如: 1958倒着挂就是: 8561,差了几千元啊!!
 * 当然，多数情况不能倒读，比如，1110 就不能倒过来，因为0不能作为开始数字。
 * 有一天，悲剧终于发生了。某个店员不小心把店里的某两个价格牌给挂倒了。并且这两个价格牌的电视机都卖出去了!
 * 庆幸的是价格出入不大，其中一个价牌赔了2百多,另一个价牌却赚了8百多,综合起来，反而多赚了558元。
 * <p>
 * <p>
 * 请根据这些信息计算:赔钱的那个价牌正确的价格应该是多少?
 * 答案是一个4位的整数，请通过浏览器直接提交该数字。
 * 原价-翻转价格 = 插件    //9088
 */
public class P04颠倒的价牌 {
    public static void main(String[] args) {

        ArrayList<Price> a1 = new ArrayList<>();
        ArrayList<Price> a2 = new ArrayList<>();
        //枚举四位数，做简单筛选，
        for (int i = 1000; i < 10000; i++) {
            String s = "" + i;
            if (s.contains("3")||s.contains("4")||s.contains("7")){
                continue;
            }
            String re_an = reverse(s); //反转

            int i1 = Integer.parseInt(re_an); //翻转后的价格

            // -200 > plus > -300
            int plus = i1-i; //翻转价 - 原价 是赔是赚 = 差价
            //反转后赔了 200 到 300
            if (plus< -200 && plus> -300) {
                //将其颠倒，和原价最差，将陪200多的放入一个集合，将赚800多的放入一个集合
                a1.add(new Price(i,plus));
                //赚了800多的
            }else if (plus< 900 && plus> 800) {
                //将其颠倒，和原价最差，将陪200多的放入一个集合，将赚800多的放入一个集合
                a2.add(new Price(i,plus));
            }

        }


        //遍历两个集合，检查差价是否相加为558
        for (Price p : a1) {
            for (Price p1 : a2) {

                if (p.plus+p1.plus == 558){
                    //输出结果
                    System.out.println(p.p /*p.plus*/); //赔钱的
//                    System.out.println(p1.p+""+p1.plus);
                }

            }
        }



    }
    static class Price{
        int p; //原价
        int plus; //颠倒价-原价  = 差价

        public Price(int p, int plus) {
            this.p = p;
            this.plus = plus;
        }
    }


    //翻转   1958  8561
    private static String reverse(String s) {

        char[] ans = new char[s.length()];
        //从最后一个字符开始取， i 代表最后一个， j代表第一个
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = s.charAt(i); //取出每一个字符
            if (c == '9') ans[j] = '6';
            else if (c == '6') ans[j] = '9';
            else ans[j] = c;

        }



        return new String(ans); //转换结果
    }
}
