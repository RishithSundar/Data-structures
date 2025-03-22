import java.util.Arrays;
class Job {
    char id;
    int deadline, profit;
    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class JobSeq {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };
        Arrays.sort(jobs, (j1, j2) -> j2.profit - j1.profit);
        int maxDeadline = 0;
        for (Job j : jobs) maxDeadline = Math.max(maxDeadline, j.deadline);
        char[] result = new char[maxDeadline];
        boolean[] filled = new boolean[maxDeadline];
        int totalProfit = 0;
        for (Job j : jobs) {
            for (int k = Math.min(maxDeadline, j.deadline) - 1; k >= 0; k--) {
                if (!filled[k]) {
                    result[k] = j.id;
                    filled[k] = true;
                    totalProfit += j.profit;
                    break;
                }
            }
        }
        System.out.print("Jobs: ");
        for (char id : result) if (id != 0) System.out.print(id + " ");
        System.out.println("\nProfit: " + totalProfit);
    }
}
