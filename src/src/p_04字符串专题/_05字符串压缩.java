package src.p_04字符串专题;

/*
将重复出现的字符，压缩为1个字符并加上出现的次数

样例：
aabbcccddd  a2b2c3d3
 */
public class _05字符串压缩 {
    public static void main(String[] args) {

        System.out.println(zipString("aabbcccddd"));

    }

    static String zipString(String str) {
        int count = 0;
        char last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            //处理第一个字符串
            if (sb.length() == 0) {
                sb.append(c);
                count++;
            } else {
                //如果和上一个字符相等
                if (last == c) {
                    count++;
                } else {
                    //先添加c 在添加数字
                    sb.append(count).append(c);
                    //重置为1
                    count = 1;
                }
            }
            //上一个字符替换为当前字符
            last = c;
        }
        //特殊处理最后一个字符的重复次数
        if (count >= 1) {
            sb.append(count);
        }


        if (sb.length() >= str.length()){
            return str;
        }

        return sb.toString();

    }
}
