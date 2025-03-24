import java.util.*;
class Job {
    int id, dead, profit;
    Job(int id, int dead, int profit) {
        this.id = id;
        this.dead = dead;
        this.profit = profit;
    }
}
public class JobSeq {
    static void schedule(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int[] slot = new int[n];
        Arrays.fill(slot, -1);
        for (Job job : jobs) {
            for (int j = Math.min(n, job.dead) - 1; j >= 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = job.id;
                    break;
                }
            }
        }
        System.out.println("Jobs: " + Arrays.toString(slot));
    }
    public static void main(String[] args) {
        Job[] jobs = {new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27), 
                      new Job(4, 1, 25), new Job(5, 3, 15)};
        schedule(jobs, 3);
    }
}
