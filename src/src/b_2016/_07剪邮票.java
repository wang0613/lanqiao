package src.b_2016;

/*
如下图,

有12张连在一起的12生肖的邮票。现在你要从中剪下5张来，要求必须是连着的。
    （仅仅连接一个角不算相连）

1   2   3   4
5   6   7   8
9   10  11  12

合格的剪法：
1   [2]   3   4
5   [6   7]  8
9   10  [11  12]

1   2  [3]   4
[5   6   7]   8
9   [10]  11  12


请你计算，一共有多少种不同的剪取方法。
输出
请填写表示方案数目的整数。
 */
//类似13年剪格子，剪格子限制数量为一半，此题限制5个格子
//dfs无法解决T字形连同方案
//本题的解决办法是： 任意找出5个格子，判断是否连通
//116
public class _07剪邮票 {
    static int[]a = {0,0,0,0,0,0,0,1,1,1,1,1};
    static int ans;
    static boolean[]vis = new boolean[12];
    //全排列
    static void f(int k, int[] path) {
        if (k == 12){
            if (check(path)){
                ans++;
            }

        }
        for (int i = 0; i < 12; i++) {
            if (i>0&&a[i] == a[i-1] && !vis[i-1]){
                continue;
            }
            if (!vis[i]){
                vis[i] = true;
                path[k] = a[i];

                f(k+1,path);
                vis[i] = false;
            }
        }

    }
    //检查是否连通
    static boolean check(int[]path){
        int[][] g = new int[3][4];

        //将排列，映射到二维矩阵上
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (path[i*4+j] == 1 ){
                    g[i][j] = 1;
                }else {
                    g[i][j] = 0;
                }
            }
        }
        int ctn = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (g[i][j] == 1) {
                    dfs(g,i,j);
                    ctn++;
                }
            }
        }
        return ctn == 1;
    }

    private static void dfs(int[][] g, int i, int j) {

        g[i][j] = 0;

        //向四周扩散
        if (i - 1 >= 0 && g[i - 1][j] == 1) {
            dfs(g, i - 1, j);
        }
        if (i + 1 <= 2 && g[i + 1][j] == 1) {
            dfs(g, i + 1, j);
        }
        if (j - 1 >= 0 && g[i][j - 1] == 1) {
            dfs(g, i, j - 1);
        }
        if (j + 1 <= 3 && g[i][j + 1] == 1) {
            dfs(g, i, j + 1);
        }
    }

    public static void main(String[] args) {
        int[] path = new int[12];
        f(0, path);
        System.out.println(ans);
    }
}
