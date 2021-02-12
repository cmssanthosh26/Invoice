package numericalmethods;
import java.util.Scanner;
public class ArrayProblem {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the first array size");
        int n1=scanner.nextInt();
        int[] array1=new int[n1];
        System.out.println("Enter first array elements");
        for(int i=0;i<n1;i++)
        {
            array1[i]=scanner.nextInt();
        }
        System.out.println("Enter the second array size");
        int n2=scanner.nextInt();
        int[] array2=new int[n2];
        System.out.println("Enter second array elements");
        for(int i=0;i<n2;i++)
        {
            array2[i]=scanner.nextInt();
        }
        int[] array3=new int[n1+n2];
        int i=0;
        int j=array2.length-1;
        int k=0;
        while(i<n1 && j>=0)
        {
            if(array1[i]<array2[j])
                array3[k++]= array1[i++];
            else
                array3[k++]=array2[j--];
        }
        for(;i<n1;i++)
        {
            array3[k++]=array1[i];
        }
        for(;j>=0;j--)
        {
            array3[k++]=array2[j];
        }
        System.out.println();
        for(int m=0;m<array3.length;m++)
            System.out.print(array3[m]+" ");
    }
}
