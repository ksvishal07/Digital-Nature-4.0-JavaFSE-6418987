package ObserverPattern.Code;

import java.util.*;

interface Observer {
    void update(String stock, double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String stock, double price);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers(String stock, double price) {
        for (Observer observer : observers) {
            observer.update(stock, price);
        }
    }
    public void setStockPrice(String stock, double price) {
        System.out.println("Stock price updated: " + stock + " = $" + price);
        notifyObservers(stock, price);
    }
}

class MobileApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("[MobileApp] " + stock + " price updated to $" + price);
    }
}

class WebApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("[WebApp] " + stock + " price updated to $" + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("AAPL", 195.5);
        stockMarket.setStockPrice("GOOGL", 2850.0);

        stockMarket.removeObserver(mobileApp);
        stockMarket.setStockPrice("AAPL", 200.0);
    }
}
