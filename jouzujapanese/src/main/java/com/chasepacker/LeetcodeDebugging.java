package com.chasepacker;


public class LeetcodeDebugging{

    public class ListNode
    {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public ListNode deleteDuplicates(ListNode head) {

        //If head is null or is only element in list, then no action is necessary
        if(head == null || head.next == null)
        {return head;}

        int dupe;

        //Special case, if head is a duplicate
        if(head.val == head.next.val)
        {
            dupe = head.val;
            
            //Move head until it is no longer duplicate or end of list
            while(head.next != null && head.val == head.next.val)
            {head = head.next;}

            head = head.next;//Move head one more time to get to next non-repeating element

            //if tail is still a dupe, return null
            if(head.val == dupe)
            {return null;}
        }

        //Start iterating through rest of list
        ListNode cur = head.next;//Main progress
        ListNode trail = head;//Stays one behind

        while(cur.next != null)
        {  
            //Go until a node equals its next node
            while(cur.next != null && cur.val != cur.next.val)
            {
                cur = cur.next;
                trail = trail.next;
            }

            System.out.println("Dupe found at " + cur.val);
            System.out.println("Trail is at " + trail.val);

            //Check to make sure we aren't on the last node
            if(cur.next != null)
            {
                //Keep track of the dupe value to check later
                dupe = cur.val;

                //Move only cur to find where the duplicate ends
                while(cur.next != null && cur.val == cur.next.val)
                {cur = cur.next;}

                cur = cur.next;//Move cur one more time to get to next non-repeating element

                System.out.println("Dupe ended at " + cur.val);

                //if cur.val is still dupe, it means we reached the end of the list, so cut the list off at trailer
                if(cur.val == dupe)
                {
                    trail.next = null;
                    return head;
                }
                else
                {
                    trail.next = cur;//Trail should be last non-repeating element, so connect to next element after repeating one
                }
            }
  
        }

        return head;  
    }


    public static void main(String[] args)
    {
        LeetcodeDebugging ld = new LeetcodeDebugging();
        ListNode head = ld.new ListNode(1);
        ListNode cur = head;
        cur.next = ld.new ListNode(2);
        cur = cur.next;
        cur.next = ld.new ListNode(3);
        cur = cur.next;
        cur.next = ld.new ListNode(3);
        cur = cur.next;
        cur.next = ld.new ListNode(4);
        cur = cur.next;
        cur.next = ld.new ListNode(4);
        cur = cur.next;
        cur.next = ld.new ListNode(5);
        cur = cur.next;

        System.out.println("Starting Process***********************************");

        head = ld.deleteDuplicates(head);

        System.out.println("Results***********************************");

        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }

        head = ld.new ListNode(1);
        cur = head;
        cur.next = ld.new ListNode(1);
        cur = cur.next;
        cur.next = ld.new ListNode(1);
        cur = cur.next;
        cur.next = ld.new ListNode(2);
        cur = cur.next;
        cur.next = ld.new ListNode(3);

        System.out.println("Starting Process***********************************");

        head = ld.deleteDuplicates(head);

        System.out.println("Results***********************************");

        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
        
    }
}