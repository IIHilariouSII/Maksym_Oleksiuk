import java.util.Arrays;
public class task_4 {
    public static void chkPair_for(int A[], int size, int x, int count)
    {
        for (int i = 0; i < (size - 1); i++) {
            for (int j = (i + 1); j < size; j++) {
                if (A[i] + A[j] == x) {
                    count++;
                }
            }
        }
        System.out.println("Amount of pairs (for): " + count);
    }

    public static int chkPair_stream(int A[], int x){
        return (int)Arrays.stream(A).flatMap(i -> Arrays.stream(A).filter(j -> i + j == x )).count() / 2;
    }
 
    public static void main(String[] args)
    {
 
        int A[] = { 1, 3, 6, 2, 2, 0, 4, 5 };
        int x = 5;
        int size = A.length;
        int count = 0;
 
        chkPair_for(A, size, x, count);
        System.out.println("Amount of pairs (stream): " + chkPair_stream(A, x));
    } 
}

