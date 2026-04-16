public class MinThread extends Thread {
    private Data sharedData;
    private int[] numbers;
   
    public MinThread(Data d, int[] numbers) {
        this.sharedData = d;
        this.numbers = numbers;
    }
    
    @Override
    public void run() {
        int min = numbers[0];
        for (int n : numbers) if (n < min) min = n;
        this.sharedData.setMin(min);
    }
}