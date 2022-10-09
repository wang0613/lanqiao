package src.a_2017;

/*
X星球的一处迷宫游乐场建在某个小山坡上。
它是由10x10相互连通的小房间细成的。
房间的地板.上写着个很大的字母 。
我们假设玩家是面朝.上坡的方向站立，则:

L表示走到左边的房间，
R表示走到右边的房间，
U表示走到上坡方向的房间，
D表示走到下坡方向的房间。

X星球的居民有点懒，不愿意费力思考。
他们更喜欢玩运气类的游戏。这个游戏也是如此!
开始的时候，直升机把100名玩家放入一个个小房间内。
玩家一定要按照地上的字母移动。
迷宫地图如下:
UDDLUULRUL
UURLLLRRRU
RRUURLDLRD
RUDDODUUUU
URUDLLRRUU
DURLRLDLRL
ULLURLLRDU
RDLULLRDDD
UUDDUDUDLL
ULRDLUURRR
请你计算-下,最后，有多少玩家会走出迷宫?
而不是在里边兜圈子。

暴力dfs+标记
标记已经走过的路线，如果已经走过 false
 */
public class _01迷宫 {
    //存放数据
    static String[] data = new String[10];
    static int ans;
    static int[][] vis = new int[10][10]; //标记已经走过的路线

    public static void main(String[] args) {

        data[0] = "UDDLUULRUL";
        data[1] = "UURLLLRRRU";
        data[2] = "RRUURLDLRD";
        data[3] = "RUDDODUUUU";
        data[4] = "URUDLLRRUU";
        data[5] = "DURLRLDLRL";
        data[6] = "ULLURLLRDU";
        data[7] = "RDLULLRDDD";
        data[8] = "UUDDUDUDLL";
        data[9] = "ULRDLUURRR";


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                clr(vis);//清理已经走过的路线·

                //做标记，是否已经经走过的
                boolean flag = solve(i, j);
                if (flag)
                    ans++;

            }

        }
        System.out.println(ans);

    }

    //初始化已走到路线为0
    private static void clr(int[][] vis) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                vis[i][j] = 0;

            }

        }

    }

    static boolean solve(int i, int j) {
        //如果已经走到边界，说明可以走出
        if (i < 0 || i > 9 || j < 0 || j > 9) {
            return true;
        }
        //已经走过了，直接return false
        if (vis[i][j] == 1) {
            return false;
        }
        vis[i][j] = 1;//走过的路线 设置为1
        //走得路线
        switch (data[i].charAt(j)) {
            case 'U': //向上
                return solve(i - 1, j);
            case 'D':
                return solve(i + 1, j);
            case 'L'://左边
                return solve(i, j - 1);
            case 'R':
                return solve(i, j + 1);
            default:
                return false;
        }


    }
}
