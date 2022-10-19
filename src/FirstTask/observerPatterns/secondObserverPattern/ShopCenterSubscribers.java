package FirstTask.observerPatterns.secondObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ShopCenterSubscribers {
    ShopCenter shopCenter;
    List<Employee> employees = new ArrayList<>();

    public boolean addSubscribers(Employee employee) {
        employees.add(employee);
        return employees.contains(employee);
    }

    public boolean removeSubscribers(Employee employee) {
        employees.remove(employee);
        return !employees.contains(employee);
    }

    public void notifySubscribers(String message) {
        for(Employee employee : employees) {
            System.out.println(employee.getName() + " " + message);
        }
    }
}
