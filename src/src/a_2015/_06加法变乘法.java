package src.a_2015;

/*
加法变乘法
我们都知道: 1+2+3+ ... + 49 = 1225
现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015
比如:
1+2+3+.. . +10*11+12+. .. +27*28+29+...+49 = 2015
就是符合要求的答案。
请你寻找另外一个可能的答案，并把位置靠前的那个乘号左边的数字提交(对于示例，就是提交10)
注意:需要你提交的是一个整数，不要填写任何多余的内容。*/

//16

//枚举两个*号的位置
public class _06加法变乘法 {
    public static void main(String[] args) {


        //枚举第一个*号的位置
        //46*47 + 48*49 是可行的
        for (int i = 1; i <= 46; i++) {

            //如果在1的位置上  1*2+3*  j=i+2
            for (int j = i + 2; j <= 48; j++) {
                //若果改造后式子-原来的式子== 差值
                if ((i * (i + 1) - (i + i + 1)) + (j * (j + 1) - (j + j + 1)) == 2015 - 1225) {
                    System.out.println(i + " " + j);
                    //10 27
                    //16 24
                }


            }

        }


    }
}
