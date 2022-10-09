package src.c_2015;
/*

隔行变色
Excel表的格子很多，为了避免把某行的数据和相邻行混淆，可以采用隔行变色的样式。
小明设计的样式为:第1行蓝色，第2行白色，第3行蓝色，第4行白色，
现在小明想知道，从第21行到第50行一共包含了多少个蓝色的行。
请你直接提交这个整数，千万不要填写任何多余的内容。
*/


//奇数行是蓝色
public class _01隔行变色 {
    public static void main(String[] args) {

        int ans = 0;
        for (int i = 21; i <= 50; i++) {
            if (i % 2 != 0) {
                ans++;
            }

        }
        System.out.println(ans);

    }
}
