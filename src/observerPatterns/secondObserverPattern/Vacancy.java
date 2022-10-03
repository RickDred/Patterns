package observerPatterns.secondObserverPattern;

public class Vacancy {
    private String name;
    private String description = null;
    private double salary;
    private String requirements = null;

    public Vacancy(String name, double salary) {
        setName(name);
        setSalary(salary);
    }

    public Vacancy(String name, double salary, String description) {
        this(name, salary);
        setDescription(description);
    }

    public Vacancy(String name, double salary, String description, String requirements) {
        this(name, salary, description);
        setRequirements(requirements);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", requirements='" + requirements + '\'' +
                '}';
    }
}
