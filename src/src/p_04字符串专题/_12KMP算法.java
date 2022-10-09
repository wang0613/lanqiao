package src.p_04字符串专题;

/*

 */
public class _12KMP算法 {
    public static void main(String[] args) {


    }

    /**
     * 暴力解法
     */
    static int indexOf(String s, String p) {
        int i = 0;
        int p2 = i;
        int j = 0; //key的点
        while (p2 < s.length()) {
            if (s.charAt(p2) == p.charAt(j)) {
                p2++;
                j++;
                //如果走到了尽头
                if (j == p.length()){
                    return i;
                }
            }else {
                i++;
                p2 = i; //扫描指针 以为起点
                j = 0;
            }
        }
        return -1;
    }
}