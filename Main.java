import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap cac so (cach nhau bang dau cach): ");
        String[] input = sc.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Data sharedData = new Data() ;

        AverageThread t1 = new AverageThread(sharedData, numbers);
        MinThread     t2 = new MinThread(sharedData, numbers);
        MaxThread     t3 = new MaxThread(sharedData, numbers);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Average:" + (int) sharedData.getAverage());
        System.out.println("Min:" + sharedData.getMin());
        System.out.println("Max:" + sharedData.getMax());
    }
}



