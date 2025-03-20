public class KnapSack {
    private int maxVal = 0;
    public void solve(int[] w, int[] v, int cap) {
        findMax(0, 0, 0, w, v, cap);
        System.out.println("Max value: " + maxVal);
    }
    private void findMax(int idx, int curW, int curV, int[] w, int[] v, int cap) {
        if (curW > cap) return;
        if (idx == w.length) {
            maxVal = Math.max(maxVal, curV);
            return;
        }
        findMax(idx + 1, curW + w[idx], curV + v[idx], w, v, cap);
        findMax(idx + 1, curW, curV, w, v, cap);
    }
    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {10, 15, 40};
        int cap = 6;
        new KnapSack().solve(w, v, cap);
    }
}
