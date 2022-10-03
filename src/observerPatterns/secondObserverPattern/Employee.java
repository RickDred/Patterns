package observerPatterns.secondObserverPattern;

import java.util.List;

public class Employee {
    private String name;
    private String profession = null;
    private final EmployeeSubscriberController employeeController = new EmployeeSubscriberController(this);

    public Employee(String name) {
        setName(name);
    }

    public Employee(String name, String profession) {
        this(name);
        setProfession(profession);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void subscribeToShopCenter(ShopCenter shopCenter) {
        if(employeeController.addSubscription(shopCenter)) {
            System.out.println(name + " you successfully subscribe to shop center");
        }
        else {
            System.out.println(name + " sorry, something get wrong");
        }
    }

    public void unsubscribeToShopCenter(ShopCenter shopCenter) {
        if(employeeController.removeSubscription(shopCenter)) {
            System.out.println(name + " you successfully unsubscribe from shop center");
        }
        else {
            System.out.println(name + " sorry, something get wrong");
        }
    }

    public void mySubscriptions() {
        List<ShopCenter> shopCenterList = employeeController.allSubscriptions();
        System.out.print(name + " subscriptions:");
        for(ShopCenter shopCenter : shopCenterList) {
            System.out.println(shopCenter.getName() + ", ");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}