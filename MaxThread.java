public class MaxThread extends Thread {
    private Data sharedData;
    private int[] numbers;

    public MaxThread(Data d, int[] numbers) {
        this.sharedData = d;
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = numbers [0];
        for (int n : numbers) if (n > max) max = n;
        this.sharedData.setMax(max);
    }
}