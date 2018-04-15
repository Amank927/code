package arrays;

public class RotateArray
{
    public static void main(String[] args)
    {
        int arr[] = new int[7];

        for (int i=1 ;i<= 7;i++)
        {
            arr[i-1] = i;
        }
        int d = 3;
        int len = arr.length;
        reverse(arr, 0, d-1);
        reverse(arr, d, len -1);
        reverse(arr, 0, len -1);
        for (int i=0; i<len ;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void reverse(int arr[], int start, int end)
    {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}
