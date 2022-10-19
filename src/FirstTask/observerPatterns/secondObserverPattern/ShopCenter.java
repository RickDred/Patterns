package FirstTask.observerPatterns.secondObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ShopCenter {
    private String name;
    private final List<Vacancy> vacancies = new ArrayList<>();
    private final ShopCenterSubscribers shopCenterSubscribers = new ShopCenterSubscribers();

    public ShopCenter(String name) {
        setName(name);
    }

    public void addVacancy(Vacancy vacancy) {
        vacancies.add(vacancy);
        String message = "Hey, new vacancy was added";
        onDataChange(message);
    }
    public void addVacancy(String name, double salary) {
        Vacancy vacancy = new Vacancy(name, salary);
        addVacancy(vacancy);
    }
    public void addVacancy(String name, double salary, String description) {
        Vacancy vacancy = new Vacancy(name, salary, description);
        addVacancy(vacancy);
    }
    public void addVacancy(String name, double salary, String description, String requirements) {
        Vacancy vacancy = new Vacancy(name, salary, description, requirements);
        addVacancy(vacancy);
    }

    public void removeVacancy(Vacancy vacancy) {
        vacancies.remove(vacancy);
        String message = "Sorry this " + vacancy.getName() + " vacancy was deleted";
        onDataChange(message);
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public ShopCenterSubscribers getShopCenterSubscribers() {
        return shopCenterSubscribers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void onDataChange(String message) {
        shopCenterSubscribers.notifySubscribers(message);
    }
}
