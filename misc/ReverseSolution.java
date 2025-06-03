import java.io.*;
import java.security.KeyStore;
import java.util.*;

class ListNode {
   public int val;
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}

class ReverseSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = null,s = null;
        for (int i=0; i<7; i++) {
            int val = sc.nextInt();
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                s = node;
            }else {
                s.next = node;
                s = node;
            }
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        ListNode node = partition(head,5);
    }
    static boolean isEqual(ListNode n1, ListNode n2) {
        return n1.next == n2.next;
    }
    public static ListNode listIntersectionPoint(ListNode head1, ListNode head2) {
        ListNode isNode = null;
        ListNode temp1 = head1,temp2 = head2;
        while (temp1 != null) {
            while (temp2 != null) {
                if (isEqual(temp1,temp2)) {
                    isNode = temp1.next;
                    break;
                }
                temp2 = temp2.next;
            }
            if (isNode != null) break;
            temp1 = temp1.next;
        }
        return isNode;
    }

    public static ListNode partition( ListNode head , int x) {
        ListNode sHead = null,s = null;
        ListNode bHead = null,b = null;
        ListNode eHead = null,e = null;

        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                ListNode node = new ListNode(temp.val);
                if (sHead == null) {
                    sHead = node;
                    s = node;
                }else {
                    s.next = node;
                    s = node;
                }
            }else if (temp.val > x) {

                ListNode node = new ListNode(temp.val);
                if (bHead == null) {
                    bHead = node;
                    b = node;
                }else {
                    b.next = node;
                    b = node;
                }
            }else {
                ListNode node = new ListNode(temp.val);
                if (eHead == null) {
                    eHead = node;
                    e = node;
                }else {
                    e.next = node;
                    e = node;
                }
            }
            temp = temp.next;
        }

        s.next = eHead;
        e.next = bHead;


        while(sHead != null) {
            System.out.print(sHead.val+" ");
            sHead = sHead.next;
        }
        System.out.println();

        return head;
    }

    public static ListNode sumLists1( ListNode head1 , ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = null;

        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + carry;
            int rem = sum % 10;
            ListNode node = new ListNode(rem);

            if (head == null) {
                head = node;
            }else {
                node.next = head;
                head = node;
            }

            head1 = head1.next;
            head2 = head2.next;
            carry = sum/10;
        }

        while (head1 != null) {
            int sum = head1.val + carry;
            int rem = sum%10;
            ListNode node = new ListNode(rem);
            node.next = head;
            head = node;

            head1 = head1.next;
            carry = sum/10;
        }

        while (head2 != null) {
            int sum = head2.val + carry;
            int rem = sum%10;
            ListNode node = new ListNode(rem);
            node.next = head;
            head = node;

            head2 = head2.next;
            carry = sum/10;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }

        return head;
    }

    static ListNode reverse(ListNode head) {
        if ( head == null) return head;
        ListNode p = null, c = head, n = c.next;
        while (n != null) {
            c.next = p;

            p = c;
            c = n;
            n = n.next;
        }
        c.next = p;
        head = c;

        return head;
    }

    public ListNode reverseEvenElements(ListNode head){
        return reverseEven(head,null);
    }

    public boolean detectAndRemoveCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
                return true;
            }
        }
        return false;
    }

    public ListNode oddEvenLinkedList(ListNode head) {
        ListNode oddHead = new ListNode(Integer.MIN_VALUE);
        ListNode oddTail = oddHead;

        ListNode evenHead = new ListNode(Integer.MIN_VALUE);
        ListNode evenTail = evenHead;

        int index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                oddTail.next = head;
                oddTail = head;
            }else {
                evenTail.next = head;
                evenTail = head;
            }
            head = head.next;
            index++;
        }

        oddTail.next = evenHead;
        evenTail.next = null;

        return oddHead;
    }

    static ListNode reverseEven(ListNode head, ListNode prev) {
        // Base case
        if (head == null)
            return null;

        ListNode temp;
        ListNode curr;
        curr = head;

        // Reversing nodes until curr node's value
        // turn odd or Linked list is fully traversed
        while (curr != null && curr.val % 2 == 0)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // If elements were reversed then head
        // pointer needs to be changed
        if (curr != head)
        {
            head.next = curr;

            // Recur for the remaining linked list
            curr = reverseEven(curr, null);
            return prev;
        }

        // Simply iterate over the odd value nodes
        else
        {
            head.next = reverseEven(head.next, head);
            return head;
        }
    }



    /*
    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        Node curr = head;

        // Traverse original linked list to store new nodes
        // corresponding to original linked list
        while (curr != null) {
            mp.put(curr, new Node(curr.val,null,null));
            curr = curr.next;
        }

        curr = head;

        // Loop to update the next and random pointers
        // of new nodes
        while (curr != null) {

            // Update the next pointer of new node
            Node newNode = mp.get(curr);
            newNode.next = mp.get(curr.next);

            // Update the random pointer of new node
            newNode.random = mp.get(curr.random);

            curr = curr.next;
        }

        // Return the head of the clone
        return mp.get(head);
    }

     */
}
