public class task_4 {
    public static void chkPair(int A[], int size, int x, int count)
    {
        for (int i = 0; i < (size - 1); i++) {
            for (int j = (i + 1); j < size; j++) {
                if (A[i] + A[j] == x) {
                    count++;
                }
            }
        }
        System.out.println("Amount of pairs: " + count);
    }
 
    public static void main(String[] args)
    {
 
        int A[] = { 1, 3, 6, 2, 2, 0, 4, 5 };
        int x = 5;
        int size = A.length;
        int count = 0;
 
        chkPair(A, size, x, count);
         
    } 
}

