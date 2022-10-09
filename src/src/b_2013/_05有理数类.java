package src.b_2013;

/*
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

    static class Rational {
        private long ra;
        private long rb;

        //求最大公约数
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
            //分子*对方的分母
            return new Rational(this.ra * x.rb + this.rb * x.ra, this.rb * x.rb); //填空位置
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

    public static void main(String[] args) {
        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 6);
        Rational c = a.add(b);
        System.out.println(a + "+" + b + "=" + c);
    }
}
