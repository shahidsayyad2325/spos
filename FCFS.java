import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        // Variable declarations
        int i, no_p;
        int burst_time[], arrival_time[], TT[], WT[];
        float avg_wait = 0, avg_TT = 0;

        // Array initializations
        burst_time = new int[50];
        arrival_time = new int[50];
        TT = new int[50];
        WT = new int[50];
        WT[0] = 0;

        // Scanner object for user input
        Scanner s = new Scanner(System.in);

        // Input: Number of processes
        System.out.println("Enter the number of processes: ");
        no_p = s.nextInt();

        // Input: Arrival Time and Burst Time for each process
        System.out.println("\nEnter Arrival Time and Burst Time for processes:");
        for (i = 0; i < no_p; i++) {
            System.out.print("\tP" + (i + 1) + " Arrival Time: ");
            arrival_time[i] = s.nextInt();
            System.out.print("\tP" + (i + 1) + " Burst Time: ");
            burst_time[i] = s.nextInt();
        }

        // Calculation: Waiting Time for each process
        for (i = 1; i < no_p; i++) {
            // Waiting time is the maximum of 0 and the difference between the previous completion time and the arrival time
            WT[i] = Math.max(0, WT[i - 1] + burst_time[i - 1] - arrival_time[i]);
            avg_wait += WT[i];
        }
        avg_wait /= no_p; // Average waiting time

        // Calculation: Turn Around Time for each process
        for (i = 0; i < no_p; i++) {
            TT[i] = WT[i] + burst_time[i];
            avg_TT += TT[i];
        }
        avg_TT /= no_p; // Average Turn Around time

        // Output: Display the process details
        System.out.println("\n****************************************************************");

        System.out.println("\tProcesses:");

        System.out.println("****************************************************************");
        System.out.println(" Process\tArrival Time\tBurst Time\tWaiting Time\tTurn Around Time");
        for (i = 0; i < no_p; i++) {
            System.out.println("\tP" + (i + 1) + "\t " + arrival_time[i] + "\t\t " + burst_time[i] + "\t\t " + WT[i] + "\t\t " + TT[i]);
        }
        System.out.println("\n----------------------------------------------------------------");

        // Output: Display the average waiting time and average turn around time
        System.out.println("\nAverage waiting time : " + avg_wait);
        System.out.println("\nAverage Turn Around time : " + avg_TT + "\n");
    }
}
