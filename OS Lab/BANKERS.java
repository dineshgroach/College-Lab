import java.util.*;
public class Bankers {
    int nr,np,need[][],avail[][],alloc[][],max[][];

    void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of process and resources");
        np = sc.nextInt();
        nr = sc.nextInt();
        need = new int[np][nr];
        avail = new int[1][nr];
        alloc = new int[np][nr];
        max = new int[np][nr];
        System.out.println("Enter the alloc matrix");
        for(int i = 0; i < np; i++)
        {
            for(int j = 0; j < nr; j++)
            {
                alloc[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the max matrix");
        for(int i = 0; i < np; i++)
        {
            for(int j = 0; j < nr; j++)
            {
                max[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the availiable matrix");
        for(int i = 0; i < nr ; i++)
        {
            avail[0][i] = sc.nextInt();
        }
        // will calculate the need matrix now
        for(int i = 0; i < np; i++)
        {
            for(int j = 0; j < nr; j++)
            {
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }
    }

    boolean isvalid(int idx)
    {
        for(int i = 0; i < nr; i++)
        {
            if(avail[0][i] < need[idx][i])
                return false;
        }
        return true;
    }

    void isSafe()
    {
        input();
        int j = 0;
        boolean chk[] = new boolean[np];
        while(j < np)
        {
            boolean isallot = true;
            for(int i = 0; i < np; i++)
            {
                if(!chk[i] && isvalid(i))
                {
                    chk[i] = true;
                    isallot = false;
                    for(int k = 0; k < nr; k++)
                    {
                        avail[0][k] += alloc[i][k];
                    }
                    System.out.println("Allocated Process" + (i + 1));
                    j++;
                }
            }
            if(isallot) break;
        }
        if(j == np)
        {
            System.out.println("Safe Sequence Exists");
        }
        else
        {
            System.out.println("Deadlock exsist");
        }
    }

    public static void main(String[] args)
    {
        Bankers bnk = new Bankers();
        bnk.isSafe();
    }
}
