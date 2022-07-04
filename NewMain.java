/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ratajalansari
 */
public class NewMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int frames, pages, fault = 0, count = 0;
        System.out.print("Enter the number of frames: ");
        frames = input.nextInt();
        System.out.print("Enter the number of pages: "); // number of refrences
        pages = input.nextInt();

        int Refrencies[] = new int[pages];
        int tableList[] = new int[frames];
        for (int i = 0; i < pages; i++) { // for to assign to array
            Refrencies[i] = input.nextInt();

            // for to check if it is empty or not
            if (i < frames) {
                tableList[i] = Refrencies[i];
                fault++;

            } else {
                for (int z = 0; z < tableList.length; z++) {
                    if (tableList[z] != Refrencies[i]) {// if page isnt already in memory
                        count = count + 1;

                    }
                }
                int e = 0;
                if (e == frames) {
                    e = 0;

                }

                if (count == tableList.length) {
                    tableList[e] = Refrencies[i]; //
                    fault++;
                    e++;
                }

            }

        }

        for (int i : Refrencies) {
            System.out.println(i + " ");
        }

        System.out.println("%%%");
        for (int m : tableList) {

            System.out.println(m + " ");

        }
        System.out.println("%%%");
        System.out.println("Page Faults: " + fault);

    }
}
