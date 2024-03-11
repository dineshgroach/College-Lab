import java.util.*;
public class Paging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ms,ps,nop,rempage,x,y,offset,np;
        int s[] = new int[20];
        int f[][] = new int[10][20];
        System.out.println("Enter the memory size");
        ms = sc.nextInt();
        System.out.println("Enter the page size");
        ps = sc.nextInt();
        nop = ms/ps;
        rempage = nop;
        System.out.println("Enter the no. of process required");
        np = sc.nextInt();
        for(int i = 1; i <= np; i++)
        {
            System.out.printf("Enter the no.of pages required for p[%d] - ",i);
            s[i] = sc.nextInt();
            if(s[i] > rempage)
            {
                System.out.println("Memory is full");
                break;
            }
            rempage -= s[i];
            System.out.printf("Enter the pagetable for p[%d]-");
            for(int j = 1; j <= s[i]; j++)
            {
                f[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the logical address to find the physical address");
        System.out.println("Enter the process no, page tabel and offse");
        x = sc.nextInt();
        y = sc.nextInt();
        offset = sc.nextInt();
        if(x > np || y > s[x] || offset >= ps)
        {
            System.out.println("Invalid process");
        }
        else
        {
            int pa = f[x][y] * ps + offset;
            System.out.println("Physical address is " + pa);
        }
        sc.close();
    }
}
