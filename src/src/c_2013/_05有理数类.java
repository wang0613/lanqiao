package src.c_2013;

/*
标题:有理数类
有理数就是 可以表示为两个整数的比值的数字。一般情况下，我们用近似的小数表示。但有些时候，不允许出现误差，必须用两个整数来表示一个有理数。
这时，我们可以建立一个“有理数类”， 下面的代码初步实现了这个目标。为了简明，它只提供了加法和乘法运算。

class Rational {
        private long ra;
        private long rb;

        private long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);

        }

        public Rational(long a, long b) {
            ra = a;
            rb = b;
            long k = gcd(ra, rb);
            if (k > 1) { //需要约分
                ra /= k;
                rb /= k;
            }
        }

        //加法
        public Rational add(Rational x) {
            return ; //填空位置
        }

        //乘法
        public Rational mul(Rational x) {
            return new Rational(ra * x.ra, rb * x.rb);
        }

        public String toString() {
            if (rb == 1) return "" + ra;
            return ra + "/" + rb;

        }


    }
    请补全加法的代码

    测试代码：
        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 6);
        Rational c = a.add(b);
        System.out.println(a + "+" + b + "=" + c);
 */
public class _05有理数类 {
    public static void main(String[] args) {

        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 6);
        Rational c = a.add(b);
        System.out.println(a + "+" + b + "=" + c);

    }

    static class Rational {
        private long ra;//分子
        private long rb; //分母

        private long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);

        }

        public Rational(long a, long b) {
            ra = a;
            rb = b;
            long k = gcd(ra, rb); //求公约数
            if (k > 1) { //需要约分
                ra /= k;
                rb /= k;
            }
        }

        //加法
        public Rational add(Rational x) {
            //首先约分 分母一直 分子相加减
            // 01:  约分后的分母 / 原来的分母     看提升了多少倍     分子乘对应的倍数 然后两个分子相加
            long r_b = (this.rb * x.rb) / this.rb;
            long x_b = (this.rb * x.rb) / x.rb;

            //02 当前的分子*对应的分母 + 对应的分子*当前的分母
//            (this.ra * x.rb) +(x.ra*this.rb);
            return new Rational((this.ra * x.rb) +(x.ra*this.rb), this.rb * x.rb); //填空位置
        }

        //乘法
        public Rational mul(Rational x) {
            return new Rational(ra * x.ra, rb * x.rb);
        }

        //打印结果
        public String toString() {
            if (rb == 1) return "" + ra;
            return ra + "/" + rb;

        }


    }
}