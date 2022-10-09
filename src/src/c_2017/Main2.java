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
public class Main2 {
    //1：封装一个持有状态和水平的类
    static class StateAndLevel {
        StringBuilder state; //记录当前的状态
        int level; //演变的步数
        int pos; //空杯子的位置

        public StateAndLevel(StringBuilder state, int level, int pos) {
            this.state = state;
            this.level = level;
            this.pos = pos;
        }
    }


    static StringBuilder start; //起始状态
    static StringBuilder target; //目标状态
    //所以的状态，用于判重
    static Set<String> allState = new HashSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = new StringBuilder(sc.nextLine());
        target = new StringBuilder(sc.nextLine());

        //添加队列，用于判重
        Queue<StateAndLevel> q = new LinkedList<>();

        //2：初始化一个初始状态，
        q.add(new StateAndLevel(start, 0, start.indexOf("*")));
        //将初始状态 添加到集合中
        allState.add(start.toString());

        //3:不断弹出 队首，一步步演化为相邻状态，
        while (!q.isEmpty()) {
            StateAndLevel front = q.poll(); //弹出队首

            int level = front.level;//步数
            StringBuilder state = front.state;//当前的状态

            //和目标值记比对，如果相同就 break
            if (target.toString().equals(state.toString())) {
                System.out.println(level); //输出演变的步数
                break;
            }
            //若果不相同，演变状态，添加到set集合(提前判重)
            int pos = front.pos;
            for (int i = -3; i <= 3; i++) {
                if (i == 0) continue;
                //如果*位置加上i 是大于0的 并且 小于状态的长度
                if (pos + i >= 0 && pos + i < state.length()) {
                    //属于合法演变，拷贝出当前的状态
                    StringBuilder new_state = new StringBuilder(state);
                    //swap
                    swap(new_state,pos,pos+i);


                    //判断重复，如果没有，将新的状态 加入到队列中
                    if (!(allState.contains(new_state.toString()))){
                        //步数+1， *号位置就是pos+i
                        q.add(new StateAndLevel(new_state,level+1,pos+i));
                        allState.add(new_state.toString());
                    }
                }
            }
        }


    }

    //交换位置
    private static void swap(StringBuilder new_state, int i, int j) {
       char t =  new_state.charAt(i);
       new_state.setCharAt(i,new_state.charAt(j));
       new_state.setCharAt(j,t);

    }
}
