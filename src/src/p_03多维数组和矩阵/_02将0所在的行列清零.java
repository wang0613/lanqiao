package src.p_03多维数组和矩阵;

import java.util.Arrays;

/*
如果矩阵中东某个元素为0，则将其所在的行和列清零
1 2 3 4
5 6 0 8
9 0 11 12
12 14 15 16
 */
//使用数组记录位置
public class _02将0所在的行列清零 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4,},
                {5, 6, 0, 8},
                {9, 0, 11, 12},
                {13, 14, 15, 16}};

        solve(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));

        }
    }

    private static void solve(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        //记录那些行出现了0
        int[] rowRecord = new int[M];
        int[] colRecord = new int[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0){
                    //将行列标记为1
                    rowRecord[i] = 1; //标记当前行和当前列为1
                    colRecord[j] = 1;
                }

            }

        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                //如果当前行和当前列为0，这个元素应该变为0
                if (rowRecord[i] == 1 || colRecord[j] == 1) {
                    matrix[i][j] = 0;
                }

            }

        }


    }
}
