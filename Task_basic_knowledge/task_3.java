public class task_3 {
    static int dig_root(int n)
    {
        int root = 0;
        while (n > 0 || root > 9)
        {
             if (n == 0) {
                n = root;
                root = 0;
            }
             
            root += n % 10;
            n /= 10;
        }
        return root;
    }
      

    public static void main(String argc[])
    {
        int n = 16;
        System.out.println(dig_root(n));
    }
}
