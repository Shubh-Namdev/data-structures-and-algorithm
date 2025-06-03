import java.util.*;

public class CircularRace {
    static int circularRace(int n, ArrayList<Integer>gas, ArrayList<Integer>burn){
        int idx = -1;
        for (int i=0; i<n; i++) {
            idx = i;
            int unitOfGas = 0;
            int j = i,temp=i;
            do {
                unitOfGas += gas.get(j);

                if (unitOfGas - burn.get(j) >= 0) {
                    unitOfGas -= burn.get(j);
                    temp++;
                    j = temp%n;
                }else {
                    idx = -1;
                    break;
                }

            }while (j != i);
            if (idx != -1) break;
        }
        return idx+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ;
        ArrayList<Integer>gas = new ArrayList<Integer>();
        ArrayList<Integer>burn = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            gas.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            burn.add(sc.nextInt());
        }
        int ans = circularRace(n,gas,burn);
        System.out.print(ans);
        sc.close();
    }
}
