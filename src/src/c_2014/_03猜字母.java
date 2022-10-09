package src.c_2014;

/*
标题:猜字母
把abcd.. . s共19个字母组成的序列重复拼接106次，得到长度为2014的串。


接下来删除第1个字母(即开头的字母a)，以及第3个，第5个等所有奇数位置的字母。
得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。
答案是一个小写字母，请通过浏览器提交答案。不要填写任何多余的内容。
 */
public class _03猜字母 {
    public static void main(String[] args) {

        char[] a = new char[2014];

        int index = 0;
        //循环 106*19=2014
        for (int i = 0; i < 106; i++) {

            for (int j = 0; j < 19; j++) {
                //循环将 字母添加到数组中
                a[index++] = (char) ('a' + j);
            }
        }

        int len = 2014;
        while (len != 1) {
            int k = 0;
            //替换 每次移动两个 将奇数的坐标
            for (int i = 1; i < len; i += 2) {
                a[k++] = a[i];
            }
            //key为新的数组的长度
            len = k;
        }
        System.out.println(a[0]);
    }
}
