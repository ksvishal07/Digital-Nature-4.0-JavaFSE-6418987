import java.util.*;

public class Financial_Forecasting {
    public static double forecastRecursive(double[] data, int yearsAhead) {
        if (yearsAhead == 0) return data[data.length - 1];
        double growthRate = averageGrowthRate(data);
        double[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length - 1] = newData[newData.length - 2] * (1 + growthRate);
        return forecastRecursive(newData, yearsAhead - 1);
    }

    public static double averageGrowthRate(double[] data) {
        double totalGrowth = 0;
        for (int i = 1; i < data.length; i++) {
            totalGrowth += (data[i] - data[i - 1]) / data[i - 1];
        }
        return totalGrowth / (data.length - 1);
    }

    public static double forecastRecursiveMemo(double[] data, int yearsAhead, Map<Integer, Double> memo) {
        if (yearsAhead == 0) return data[data.length - 1];
        if (memo.containsKey(yearsAhead)) return memo.get(yearsAhead);
        double growthRate = averageGrowthRate(data);
        double[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length - 1] = newData[newData.length - 2] * (1 + growthRate);
        double result = forecastRecursiveMemo(newData, yearsAhead - 1, memo);
        memo.put(yearsAhead, result);
        return result;
    }

    public static void main(String[] args) {
        double[] pastData = {1000, 1200, 1500, 1800, 2100};
        int yearsAhead = 3;
        double forecast = forecastRecursive(pastData, yearsAhead);
        System.out.printf("Forecast for %d years ahead (recursive): %.2f\n", yearsAhead, forecast);
        double forecastMemo = forecastRecursiveMemo(pastData, yearsAhead, new HashMap<>());
        System.out.printf("Forecast for %d years ahead (memoized): %.2f\n", yearsAhead, forecastMemo);
        System.out.println("\nAnalysis:");
        System.out.println("Recursive algorithm time complexity: O(n) for yearsAhead, but can be higher if not optimized.");
        System.out.println("Memoization avoids redundant calculations, making it efficient for larger yearsAhead.");
    }
}
