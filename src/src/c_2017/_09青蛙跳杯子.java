package src.c_2017;


import java.util.*;

/*
标题:青蛙跳杯子
    X星球的流行宠物是青蛙，- -般有两种颜色:白色和黑色。
    X星球的居民喜欢把它们放在一排茶杯里， 这样可以观察它们跳来跳去。
    如下图，有一排杯子，左边的一个是空着的, 右边的杯子，每个里边有一只青蛙。
*WWWBBB
    其中，W字母表示白色青蛙，B表示黑色青蛙，*表示空杯子。
X星的青蛙很有些癖好，它们只做3个动作之一:
    1.跳到相邻的空杯子里。
    2.隔着1只其它的青娃(随便什么颜色)跳到空杯子里。I
    3.隔着2只其它的青蛙(随便什么颜色)跳到空杯子里。
对于.上图的局面，只要1步，就可跳成下图局面:
    WWW*BBB
本题的任务就是已知初始局面，询问至少需要几步,才能跳成另一个目标局面。
输入为2行，2个串，表示初始局面和目标局面。
输出要求为一个整数, 表示至少需要多少步的青蛙跳。
例如:
输入:
*WWBB
WWBB*
则程序应该输出:
    2
再例如：
输入：
WWW*BBB
BBB*WWW

则程序输出10
 */
//宽搜题 bfs
public class _09青蛙跳杯子 {

    //1:套路 封装一个持有状态和层次的类
    private static class StateAndLevel {
        StringBuilder state; //记录杯子中状态
        int level; //演化的步数
        int pos; //空杯子的位置

        public StateAndLevel(StringBuilder state, int level, int pos) {
            this.state = state;
            this.level = level;
            this.pos = pos;
        }

    }


    static StringBuilder start;
    static StringBuilder target;
    static Set<String> allState = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = new StringBuilder(sc.nextLine());
        target =  new StringBuilder(sc.nextLine());

        bfs(); //宽搜

    }

    //宽搜
    private static void bfs() {
        //创建队列
        Queue<StateAndLevel> q = new LinkedList<>();
        //2： 套路 将初始状态加入队列 给出空杯*的位置
        q.add(new StateAndLevel(start, 0, start.indexOf("*")));

        allState.add(start.toString()); //添加初始状态 用于判重

        //3: 套路 不停弹出队首，一步演化成相邻状态，加入队列(判断重复)
        while (!q.isEmpty()) {
            //弹出队首
            StateAndLevel front = q.poll();
            StringBuilder state = front.state;
            int level = front.level;

            //和目标值进行比对，如果成功，打印level 走了多少步
            //toString 比较内容
            if (state.toString().equals(target.toString())) {
                System.out.println(level);
                break;
            }

            int pos = front.pos; //空杯子的位置

            //可以演化出 若干个相邻的状态
            //WWW*WWW
            for (int i = -3; i <= 3; i++) {
                if (i == 0) continue; //偏移量

                //演化为相邻状态
                if (pos + i >= 0 && pos + i < state.length()) {
                    //拷贝出新状态
                    StringBuilder new_state = new StringBuilder(state);
                    //交换达到新的状态，
                    swap(new_state, pos, pos + i);

                    //判断重复，如果没有，将新的状态 加入到队列中
                    if (!(allState.contains(new_state.toString()))) {
                        //放入队列
                        q.add(new StateAndLevel(new_state, level + 1, pos + i));
                        //放入set
                        allState.add(new_state.toString());
                    }
                }
            }

        }


    }

    //交转状态
    private static void swap(StringBuilder a, int i, int j) {
        char t = a.charAt(i);
        a.setCharAt(i,a.charAt(j));
        a.setCharAt(j,t);

    }
}
