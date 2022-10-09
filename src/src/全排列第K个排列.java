package src;

public class 全排列第K个排列 {
    final static int k = 3;
    static int count = 0;

    public static void main(String[] args) {
        String s = "123";
        char[] chars = s.toCharArray();
        permutation("",chars);
    }

    static void permutation(String prefix, char[] arr) {
        if (prefix.length() == arr.length) {
            count++;
            if (count == k) {
                System.out.println("·····" + prefix);
                System.exit(0);

            }
        }
        //每次都从头扫描，只要该字符 可用， 我们就附加到前缀后面，前缀变长了
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (count(prefix.toCharArray(), ch) < count(arr, ch)) {
                permutation(prefix + ch, arr);
            }

        }
    }

    static int count(char[] arr, char ch) {
        int cnt = 0;
        for (char c : arr) {
            if (c == ch) {
                cnt++;
            }
        }
        return cnt;
    }


}
