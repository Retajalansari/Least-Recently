// Group 1
// Retaj Alansari 1911692
// Shatha Alryani 1911569
// Ghadi Hassan 1911463
// Ebtihal Hani 1915361
// Maha Hussain 1915358

import java.util.Scanner;
import java.util.ArrayList;

public class LeastRecentlyUsedReplacementAlgorithm {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //get the number of frames from the user
        System.out.print("Enter the number of frames: ");
        int frames_no = input.nextInt();

        //get the length of the Reference string from the user
        System.out.print("Please enter the length of the Reference string: ");
        int ref_length = input.nextInt();

        //get the reference string from the user and store it in array
        System.out.println("Please enter the reference string: ");
        int refStr_array[] = new int[ref_length];
        for (int i = 0; i < ref_length; i++) {
            refStr_array[i] = input.nextInt();
        }

        //create a stack (implemented by an array list) 
        //stack capacity = frames number
        ArrayList<Integer> stack = new ArrayList<>(frames_no);

        int top_index = 0; //specify the index of the top
        int fault = 0; //counter to count the number of page faultes
        int hit = 0; //counter to count the number of page hits

        //for each page in the reference string
        for (int page : refStr_array) {
            //if: the current page does not exist in the stack
            if (!stack.contains(page)) {

                //if: the stack is full
                if (stack.size() == frames_no) {
                    //then i must choose a victim and remove it
                    /*  the victim (least recently used page) is always at
                       the bottom of the stack */
                    stack.remove(0);
                    //add the current page at the top of the stack
                    stack.add(frames_no - 1, page);
                } //else: the stack is not full
                else {
                    //add the current page at the top of the stack
                    stack.add(top_index, page);
                    //increment top index
                    top_index++;
                }

                //increment page faults counter
                fault++;

            } //else: the current page exist in the stack
            else {
                // remove the current page from the stack
                stack.remove((Object) page);
                //put the current page at the top of the stack
                stack.add(stack.size(), page);
                //increment page hits counter
                hit++;
            }
        }

        //print the number of page faults
        System.out.println("The number of page faults: " + fault);

        //print the number of page hits
        System.out.println("The number of hits: " + hit);

        //print the final contents of the stack 
        System.out.print("Pages currently in memory: ");
        System.out.print("[");
        for (int p : stack) {
            System.out.print(p + ",");
        }
        System.out.print("]\n");

    }

}
