import java.util.Scanner;
public class num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a;
        a= new int[n];
        float sum=0;
        int k=0;
        for (int i=0; i<n;i ++)
        {
            a[i]= sc.nextInt();
            sum=sum+a[i];

        }
        sum=sum/n;
        for(int i=0;i<n;i++)
        {
            if(a[i]>=sum)
            {
                k++;
            }
        }
        System.out.println(sum + " " + k);

    }
}