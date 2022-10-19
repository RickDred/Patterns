package FirstTask.observerPatterns.secondObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSubscriberController {
    private Employee employee;
    private List<ShopCenter> subscriptions = new ArrayList<>();

    public EmployeeSubscriberController(Employee employee) {
        this.employee = employee;
    }

    public boolean addSubscription(ShopCenter shopCenter) {
        if(shopCenter.getShopCenterSubscribers().addSubscribers(employee)) {
            subscriptions.add(shopCenter);
            return subscriptions.contains(shopCenter);
        }
        return false;
    }

    public boolean removeSubscription(ShopCenter shopCenter) {
        if(shopCenter.getShopCenterSubscribers().removeSubscribers(employee)) {
            subscriptions.remove(shopCenter);
            return !subscriptions.contains(shopCenter);
        }
        return false;
    }

    public List<ShopCenter> allSubscriptions() {
        return subscriptions;
    }
}
