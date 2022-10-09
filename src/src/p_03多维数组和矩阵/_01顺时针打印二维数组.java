package src.p_03多维数组和矩阵;

/*
1   2   3   4
5   6   7   8
9   10  11  12
13  14  15  16

输出1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
public class _01顺时针打印二维数组 {


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4,},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printMatrix(matrix);
    }


    static void printMatrix(int[][] matrix) {
        //行 列
        int leftRow = 0, leftCol = 0,
                //右边的行 例如
                rightRow = matrix.length - 1, rightCol = matrix[0].length - 1;


        while (leftRow <= rightRow && leftCol <= rightCol) {
            int r = leftRow;
            int c = leftCol;

            //最上面一条的边
            while (c <= rightCol) {
                System.out.print(matrix[r][c++] + " ");
            }
            //最右边一列
            c = rightCol; //恢复到最后一列
            r++;//第二2
            //右边竖的的一条边
            while (r <= rightCol) {
                System.out.print(matrix[r++][c] + " ");
            }
            //最下面一条边
            r = rightRow; //行号
            c--;
            while (c >= leftCol) {
                System.out.print(matrix[r][c--] + " ");
            }
            //最左边竖的一条边
            c = leftCol;
            r--;
            while (r > leftRow) {
                System.out.print(matrix[r--][c] + " ");
            }
            leftCol++;
            leftRow++;
            rightCol--;
            rightRow--;

        }
    }
}