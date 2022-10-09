package src.c_2019;

import java.util.HashSet;
import java.util.Set;

/*
一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成 的串。
例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
注意在计算时，只算本质不同的串的个数。 请问，字符串0100110001010001 有多少个不同的非空子串？

 */
public class _03不同子串 {
    public static void main(String[] args) {

        String str = "0100110001010001";
        Set<String> strings = new HashSet<>();

        //两层循环分别截取 ，使用set去重
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {

                String temp = str.substring(i,j);
                strings.add(temp);

            }
        }
        System.out.println(strings.size());


    }
}
