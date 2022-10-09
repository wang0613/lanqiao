package src.c_2017;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/*
为丰富同学们的业余文化生活，某高楼学生会创办了3个兴趣小组
(以下称A组，B组，C组)
每个小组的学生名单分别在[A.txt]，[B.txt] 和[C.txt]中。
每个文件中存储的是学生的学号。
由于工作需要，我们现在想知道:

既参加了A组，又参加了B组，但是没有参加C组的同学一共有多少人?
请你统计该数字并通过浏览器提交答案。
注意:答案是一个整数，不要提交任何多余的内容。
 */
public class _02兴趣小组 {
    static Set<String> a = new HashSet<>();
    static Set<String> b = new HashSet<>();
    static Set<String> c = new HashSet<>();
    static int ans = 0;

    public static void main(String[] args) throws IOException {


        read(a, "c://");
        read(b, "c://");
        read(c, "c://");

        for (String a : a) {

            if (b.contains(a) && !(c.contains(a))) {
                ans++;
            }


        }

    }

    public static void read(Set<String> strs, String path) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader(path));


        while (br.readLine() != null) {
            String s = br.readLine();
            String[] s1 = s.split(",");
            for (int i = 0; i < s1.length; i++) {
                //去除空格 加入set
                String trim = s1[i].trim();
                if (trim.length() > 0)
                    strs.add(trim);

            }
        }
        br.close();


    }
}
