import java.util.*;
public class LRU {
    static int countPageFault(int pages[],int n,int frames)
    {
        int pageFault = 0;
        HashSet<Integer> st = new HashSet<>(frames);
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if(st.size() < frames)
            {
                if(!st.contains(pages[i]))
                {
                    pageFault++;
                    st.add(pages[i]);
                }
                mp.put(pages[i],i);
            }
            else
            {
                if(!st.contains(pages[i]))
                {
                    pageFault++;
                    int lru = Integer.MAX_VALUE,val = 0;
                    Iterator<Integer> itr = st.iterator();
                    while(itr.hasNext())
                    {
                        int ele = itr.next();
                        if(mp.get(ele) < lru)
                        {
                            lru = mp.get(ele);
                            val = ele;
                        }
                    }
                    mp.remove(val);
                    st.remove(val);
                    st.add(pages[i]);
                }
                mp.put(pages[i],i);
            }
        }
        return pageFault;
    }

    public static void main(String[] args) {
        int frames = 4;
        int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        int n = pages.length;
        System.out.println("Page Faults : " + countPageFault(pages, n, frames));
    }
}
