public class AverageThread extends Thread {
    private Data sharedData;
    private int[] numbers;

    public AverageThread(Data d, int[] numbers) {
        this.sharedData = d;
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int n : numbers) sum += n;
        this.sharedData.setAverage((double) sum / numbers.length);
    }
}