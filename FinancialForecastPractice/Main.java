import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current value (₹): ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.1 for 10%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double future = Forecast.futureValue(currentValue, growthRate, years);
        System.out.printf("Predicted Future Value after %d years: ₹%.2f\n", years, future);

        sc.close();
    }
}
