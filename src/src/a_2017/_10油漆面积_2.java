package src.a_2017;


/*
X星球的一批考古机器人正在一片废墟上考古。
　　该区域的地面坚硬如石、平整如镜。
　　管理人员为方便，建立了标准的直角坐标系。

　　每个机器人都各有特长、身怀绝技。它们感兴趣的内容也不相同。
　　经过各种测量，每个机器人都会报告一个或多个矩形区域，作为优先考古的区域。

　　矩形的表示格式为(x1,y1,x2,y2)，代表矩形的两个对角点坐标。

　　为了醒目，总部要求对所有机器人选中的矩形区域涂黄色油漆。
　　小明并不需要当油漆工，只是他需要计算一下，一共要耗费多少油漆。

　　其实这也不难，只要算出所有矩形覆盖的区域一共有多大面积就可以了。
　　注意，各个矩形间可能重叠。

　　本题的输入为若干矩形，要求输出其覆盖的总面积。
输入格式
　　第一行，一个整数n，表示有多少个矩形(1<=n<10000)
　　接下来的n行，每行有4个整数x1 y1 x2 y2，空格分开，表示矩形的两个对角顶点坐标。
　　(0<= x1,y1,x2,y2 <=10000)
输出格式
　　一行一个整数，表示矩形覆盖的总面积面积。
样例输入
3
1 5 10 10
3 1 20 20
2 7 15 17
样例输出
340
样例输入
3
5 2 10 6
2 7 12 10
8 1 15 15
样例输出
128
 */

import java.util.Arrays;
import java.util.Scanner;

//线段树+扫描线+矩形面积(经典模板)
public class _10油漆面积_2 {
    static int n;
    static int[] X;// = new int[N << 1];//记录所有的横坐标
    static Line[] lines;// = new Line[N]; //扫描线


    //辅助的数据结构： 扫描线
    static class Line implements Comparable<Line> {
        int x1, x2, h, f; //左右坐标，纵坐标，f=1为入边，f=-1为出边

        Line() {

        }

        Line(int _l, int _r, int _h, int _f) {
            x1 = _l;
            x2 = _r;
            h = _h;
            f = _f;
        }

        //按照高度排序
        @Override
        public int compareTo(Line o) {
            if (h < o.h) {
                return -1;
            } else if (h > o.h) {
                return 1;
            } else
                return 0;
        }


    }

    //线段树的定义
    static class SegTree {
        int pl, pr, cnt, len;//左端点，右端点，被覆盖次数，两个端点之间被覆盖的长度

        SegTree() {

        }

        SegTree lson, rson;
    }

    //构建区间树
    static SegTree buildSegTree(int pl, int pr) {
        SegTree t = new SegTree();
        t.pl = pl;
        t.pr = pr;
        if (pl == pr) return t;
        int mid = ((pl + pr) >> 1);
        t.lson = buildSegTree(pl, mid);
        t.rson = buildSegTree(mid + 1, pr);
        return t;
    }

    static void updateLength(SegTree pTree, int tl, int tr) {
        if (pTree.cnt > 0) {
            pTree.len = X[tr] - X[tl - 1]; //将区间树上的端点，反入到x中求得二维坐标上实际的横坐标

        } else if (tl == tr) {
            pTree.len = 0;
        } else { //负数
            pTree.len = pTree.lson.len + pTree.rson.len;

        }
    }

    static void update(SegTree tree, int pl, int pr, int value) {
        int tl = tree.pl;
        int tr = tree.pr;
        if (pl <= tl && pr >= tr) {
            tree.cnt += value;
            updateLength(tree, tl, tr);
            return;
        }
        int m = (tl + tr) >> 1;
        if (pl <= m) {
            update(tree.lson, pl, pr, value);
        }
        if (pr > m) {
            update(tree.rson, pl, pr, value);

        }
        updateLength(tree, tl, tr);


    }

    static int ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        X = new int[n*2];
        lines = new Line[n*2];
        int x1, y1, x2, y2;
        int index = 0;
        for (int i = 0; i < n; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            X[index] = x1;
            lines[index] = new Line(x1, x2, y1, 1); //高度1
            index++;


            X[index] = x2;
            lines[index] = new Line(x1, x2, y2, -1); //高度2
            index++;


        }
        //大体上就有了2n个横坐标，2n条水平线段
        Arrays.sort(X);//所有横坐标点 排序
        Arrays.sort(lines); //扫描线排序，从低到高
        //离散化坐标
        int X_end = unique(X);//去重返回值是一个迭代器，他指向的是去重后容器中不重复元素的最后一个元素
        //PR=X_end
        //初始化线段树
        SegTree root =buildSegTree(1,X_end);
        //从高到底，遍历扫描线
        for (int i = 0; i < index-1; i++) {
            //二分查找，记录下标，代表是第几个点
            int pl = Arrays.binarySearch(X,0,X_end+1,lines[i].x1);
            int pr = Arrays.binarySearch(X,0,X_end+1,lines[i].x2);

            update(root,pl+1,pr,lines[i].f);
            ans+=root.len*(lines[i+1].h-lines[i].h); //宽度*高度
        }
        System.out.println(ans);


    }

    //去重
    private static int unique(int[] x) {
        int index = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i] == x[index]){
                continue;
            }else {
                index++;
                x[index] = x[i];
            }

        }
        return index;

    }


}
