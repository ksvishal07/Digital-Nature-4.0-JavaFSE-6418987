

import java.util.List;

public class MovingAverageForecaster {
    private int windowSize;

    public MovingAverageForecaster(int windowSize) {
        this.windowSize = windowSize;
    }

    public double forecast(List<Double> data) {
        if (data.size() < windowSize) {
            throw new IllegalArgumentException("Not enough data points for the given window size.");
        }
        double sum = 0.0;
        for (int i = data.size() - windowSize; i < data.size(); i++) {
            sum += data.get(i);
        }
        return sum / windowSize;
    }
}
