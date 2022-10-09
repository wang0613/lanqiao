package src.p_04字符串专题;

/*
RabinKarp：
    使用hash--->滚动hash

如何求Hash值
    C0*31^2+C1*31+C2

((0+c0)*31+C1)*31+C2
 */
public class _11字符串匹配_RabinKarp {
    static long seed = 31;

    public static void main(String[] args) {
        String s = "ABABABA";
        String p = "ABA";
        match(p,s);
    }

    /**
     * @param p 模式
     * @param s 原串
     */
    static void match(String p, String s) {
        long hash_p = hash(p);//求p的hash值
        int p_len = p.length();
        for (int i = 0; i + p_len <= s.length(); i++) {
            //i作为起点，长度为plen的子串的hash值
            long hash_i = hash(s.substring(i, i + p_len));
            if (hash_i == hash_p) {
                System.out.println("match: " + i);
            }
        }
    }


    /**
     * 给定一个字符串，求出对应的的hash值
     * 使用100000个字符串产生冲突数，大概在0-3波动，使用100百万不同的字符串，冲突大概在110+范围波动
     */
    static long hash(String str) {
        long hash = 0;

        for (int i = 0; i != str.length(); i++) {
            //遍历每一个字符串，在上一个的基础上*种子
            hash = seed * hash + str.charAt(i);

        }
        return hash % Long.MAX_VALUE;
    }
}
