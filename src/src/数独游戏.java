package src;

/*

 */
public class 数独游戏 {
    static char[][] map = {{'0','6','1','0','3','0','0','2','0'},
            {'0','5','0','0','0','8','1','0','7'},
            {'0','0','0','0','0','7','0','3','4'},
            {'0','0','9','0','0','6','0','7','8'},
            {'0','0','3','2','0','9','5','0','0'},
            {'5','7','0','3','0','0','9','0','0'},
            {'1','9','0','7','0','0','0','0','0'},
            {'8','0','2','4','0','0','0','6','0'},
            {'0','4','0','0','1','0','2','5','0'}};/*new  char[9][9]*/;
    static int n=9 ;  //棋盘大小

    public static void main(String[] args) {
        dfs(map,0,0);


    }

    static void dfs(char[][] table, int x, int y) {
        if (x == 9) {
            print();
            System.exit(0);
        }

        if (table[x][y] == '0') {
            for (int i = 0; i < 10; i++) {
                if (check(table, x, y, i)) {
                    table[x][y] = (char) ('0' + i);
                    //处理下一状态
                    dfs(table, x + (y + 1) / 9, (y + 1) % 9);

                }
            }
            //回溯
            table[x][y] = '0';
        } else {
            dfs(table, x + (y + 1) / 9, (y + 1) % 9);
        }
    }

    private static void print() {
        for (int i = 0; i <n; i++) {
            System.out.println(new String(map[i]));
        }

    }

    private static boolean check(char[][] table, int x, int y, int k) {
        //检查同行和同列
        for (int i = 0; i < 9; i++) {
            if (table[x][i] == (char) ('0' + k)) return false;
            if (table[i][y] == (char) ('0' + k)) return false;
        }
        //检查小九宫格
        for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
            for (int m = (y / 3) * 3; m < (y / 3 + 1) * 3; m++) {
                if (table[i][m] == (char) ('0' + k)) return false;
            }

        }
        return true;


    }


}
