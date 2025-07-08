
package Algorithms_DataStructures.FinancialForecasting;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecastFutureValue(double currentValue, double growthRate, int yearsLeft) {
        // Base case
        if (yearsLeft == 0) {
            return currentValue;
        }
        // Recursive step
        return forecastFutureValue(currentValue, growthRate, yearsLeft - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 10000; // ₹10,000
        double annualGrowthRate = 0.07; // 7% growth
        int years = 5;

        double futureValue = forecastFutureValue(presentValue, annualGrowthRate, years);
        System.out.printf("Projected value after %d years: ₹%.2f\n", years, futureValue);
    }
}