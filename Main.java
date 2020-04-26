package com.company;

public class Main {

    public static List InsertList(List h, List e) {
        // Write a RECURSIVE InsertList( ) method in Java FIRST and
        // USE the Java code to help you write the assembler subroutine !!!
        /*
        1. If the head node is Null, then insert the data in the head node.
        2. else, if the input data is less than the start node, then insert the node at the start
        3. if the input data is greater than the start node, till you get the right position to insert, move the temporary pointer. If the temporary pointer’s next value is null, then insert the node at the end.
        4. If the element lies between any two values, then connect the node to the previous node and the next node ie, t->next = temp->next and temp->next = t.
         */
        //base case
        if (h == null)
            {  // Base case
                e.next = null;
                return(e);    // New elem is the head
            }
        else if (h.value > e.value) {
            e.next = h;
            return(e);
        }
        else {
            // Recursion
            List help = InsertList(h.next, e);
            // Insert elem in shorter list
            h.next = help;  // Link return list AFTER
            // the first elem in orig. list
            return (h);      // head is unchanged
        }
    }

    public static void PrintList(List h)
    {
        if ( h == null )
            return;
        else
        {
            System.out.print(h.value + " ");
            PrintList(h.next);
        }
    }


    public static void main(String[] args)
    {
        int[] v = {30, 50, 10, 40, 20};
        List head = null;
        List elem;

        for ( int i = 0; i < v.length; i++ )
        {
            elem = new List();

            elem.value = v[i];
            elem.next  = elem;	// **** Put some junk in next

            head = InsertList(head, elem);
            System.out.print("List = ");
            PrintList( head );
            System.out.println();
        }
    }

}
