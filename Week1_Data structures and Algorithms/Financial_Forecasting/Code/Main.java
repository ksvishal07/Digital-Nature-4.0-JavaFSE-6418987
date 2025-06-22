

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FinancialData financialData = new FinancialData();
        String filePath = "Financials.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] columns = line.split(",");
                if (columns.length > 8) {
                    String salesStr = columns[8].replaceAll("[^0-9.]+", "");
                    if (!salesStr.isEmpty()) {
                        try {
                            double sales = Double.parseDouble(salesStr);
                            financialData.addDataPoint(sales);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading dataset: " + e.getMessage());
            return;
        }

        int windowSize = 3;
        MovingAverageForecaster forecaster = new MovingAverageForecaster(windowSize);
        double forecast = forecaster.forecast(financialData.getData());
        System.out.printf("Next period forecast (Moving Average): %.2f$", forecast);
    }
}
