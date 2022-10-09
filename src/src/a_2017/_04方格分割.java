package src.a_2017;

/*
标题:方格分割
6x6的方格，沿着格子的边线剪开成两部分。
要求这两部分的形状完全相同。

如图: p1.png，p2.png, p3.png就是可行的分割法。
试计算:

包括这3种分法在内，一共有多少种不同的分割方法。
注意:旋转对称的属于同一种分割法。
请提交该整数，不要填写任何多余的内容或说明文字。


dfs+标注
初始化(3.3)中间两边一起走 必须对称
ans/4 算同一种方案
 */
public class _04方格分割 {
    static int ans;
    //四个方向  -1,0上    1,0下   0,-1左   0,1右
    static int[][] dire = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    static int[][] vis = new int[7][7]; //已经访问的点数

    public static void main(String[] args) {

        //初始dfs
        dfs(3, 3);

        //沿着中心线，进行对称分割，分四块，考虑旋转方案 需要/4
        System.out.println(ans / 4);

    }

    static void dfs(int i, int j) {
        //如果坐标到了边界上
        if (i == 6 || i == 0 || j == 6 || j == 0) {
            ans++;
            return;
        }
        //标记当前坐标为已经访问
        vis[i][j] = 1;

        //标记对称点 为已访问
        vis[6 - i][6 - j] = 1;

        //4个方向
        for (int k = 0; k < 4; k++) {
            int nx = i + dire[k][0]; //提取出横坐标的增量
            int ny = j + dire[k][1];

            //到达边界
            if (nx < 0 || nx > 6 || ny < 0 || ny > 6) continue;

            //如果新的坐标没有访问过
            if (vis[nx][ny] == 0) {
                dfs(nx, ny);
            }

        }

        //回溯
        vis[i][j] = 0;
        vis[6 - i][6 - j] = 0;
    }
}
