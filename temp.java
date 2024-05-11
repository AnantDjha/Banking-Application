public class temp {

   static void func(int val)
    {
        if(val == 0)
        {
            return ;
        }
        System.out.println(val);
        func(val-1);
        System.out.println(val);

    }
    static int sumOfDigits(int n)
    {
        if(n == 0)
        {
            return 0;
        }
        return n%10+sumOfDigits(n/10);
    }

    static int reverse(int num)
    {
        int sum = 0;
        while(num != 0)
        {
            int rem = num%10;
            sum = sum*10 + rem;
            num = num/10;
        }
        return sum;
    }

    static int rev(int num)
    {
        if(num%10 == num)
        {
            return num;
        }
        int digits = (int) Math.log10(num);
        return (num%10) *(int )Math.pow(10,digits) + rev(num/10);
    }


    static boolean palin(String s)
    {
        if(s.length() <= 1)
        {
            return true;
        }
        if(s.charAt(0) != s.charAt(s.length()-1))
        {
            return false;
        }
        return palin(s.substring(1,s.length()-1));
    }

    static int zeroCount(int n , int c)
    {
        if(n%10 == n)
        {
            return c;
        }
        if(n%10 == 0)
        {
            return zeroCount(n/10,c+1);
        }
        else{
            return zeroCount(n/10,c);
        }

    }
    public static void main(String[] args) {
//      func(5);
//        System.out.println(sumOfDigits(1342));
//        System.out.println(reverse(12345));
//        System.out.println(rev(12345));
//        System.out.println(palin("malayalam"));
        System.out.println(zeroCount(124,0));
    }

}
