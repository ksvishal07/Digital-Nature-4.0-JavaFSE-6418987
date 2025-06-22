

import java.util.ArrayList;
import java.util.List;

public class FinancialData {
    private List<Double> data;

    public FinancialData() {
        this.data = new ArrayList<>();
    }

    public void addDataPoint(double value) {
        data.add(value);
    }

    public List<Double> getData() {
        return data;
    }
}
