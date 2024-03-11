import java.util.*;
public class CSCAN {
    static int disksize = 200;
    static  void cscan(int arr[],int n,int head)
    {
        int distance,currtrack,seek_time = 0;
        Vector<Integer> left = new Vector<>(),right = new Vector<>(),
                seekseq = new Vector<>();
        left.add(0);
        right.add(disksize - 1);
        for(int i = 0; i < n; i++)
        {
            if(arr[i] < head)
            {
                left.add(arr[i]);
            }
            else
            {
                right.add(arr[i]);
            }
        }
        left.sort(null);
        right.sort(null);
        for(int i = 0; i < right.size(); i++)
        {
            currtrack = right.get(i);
            distance = Math.abs(currtrack - head);
            seekseq.add(currtrack);
            seek_time += distance;
            head = currtrack;
        }
        head = 0;
        seek_time += (disksize - 1);
        for(int i = 0; i < left.size(); i++)
        {
            currtrack = left.get(i);
            distance = Math.abs(currtrack - head);
            seekseq.add(currtrack);
            seek_time += distance;
            head = currtrack;
        }
        System.out.println("Total seek time: " + seek_time);
        System.out.println("Seek Sequence");
        for (int i = 0; i < seekseq.size(); i++)
        {
            System.out.print(seekseq.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 176, 79, 34, 60,
                92, 11, 41, 114 };
        int head = 50;
        int n = arr.length;
        cscan(arr, n, head);
    }
}
