import java.util.*;

public class Utils {

    static int[] incrementNumber(int n, int arr[]){
        if ( arr[n-1] < 9) {
            arr[n-1] = arr[n-1] + 1;
            return arr;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }

        int num = Integer.parseInt(sb.toString());
        int res = num + 1;

        String newNum = String.valueOf(res);
        int []resArr = new int[newNum.length()];

        int k=resArr.length-1;
        while ( res != 0) {
            resArr[k] = res % 10;
            res = res/10;
            k--;
        }


        return resArr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println((int)Math.ceil(5.0/2));
        System.out.println((int)Math.floor(5.0/2));
        System.out.println((int)Math.round(5.0/2));



        //System.out.println(Integer.parseInt("-5"));
//        List<Long> li = new ArrayList<>();
//        li.add(4L);
//        li.add(5L);
//        li.add(2L);
//
//        List<Long> li2 = new ArrayList<>(li);
//
//        LL ll = new LL();
////        ll.addFirst(45);
////        ll.addFirst(23);
////        ll.addFirst(56);
////        ll.addLast(45);
////        ll.addLast(2);
//        ll.addLast(32);
//        //ll.removeFirst();
//        ll.removeLast();
//        ll.addFirst(34);
//        ll.addLast(45);
//        ll.removeLast();
//        ll.display();
    }
}
