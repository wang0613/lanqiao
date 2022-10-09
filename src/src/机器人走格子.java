package src;

/*
在一个格子中 机器人向右或向下走

有多少种走法
 */
public class 机器人走格子 {
    public static void main(String[] args) {

        System.out.println(f(6,6));
    }
    static int f(int x,int y){
        if (x == 1 || y ==1 ) return 1;

        return f(x-1,y)+f(x,y-1);

    }
}
