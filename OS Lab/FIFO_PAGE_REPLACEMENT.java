import java.util.*;
public class FIFO {
    static int countPageFault(int pages[],int n,int frames)
    {
        int pageFaults = 0;
        HashSet<Integer> st = new HashSet<>(frames);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(st.size() < frames)
            {
                if(!st.contains(pages[i]))
                {
                    pageFaults++;
                    st.add(pages[i]);
                    q.add(pages[i]);
                }
            }
            else
            {
                if(!st.contains(pages[i]))
                {
                    int ele = q.peek();
                    q.poll();
                    pageFaults++;
                    st.remove(ele);
                    st.add(pages[i]);
                    q.add(pages[i]);
                }
            }
        }
        return pageFaults;
    }

    public static void main(String args[])
    {
        int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        int frames = 4;
        int n = pages.length;
        System.out.println("Page faults: " + countPageFault(pages,n,frames));

    }
}
