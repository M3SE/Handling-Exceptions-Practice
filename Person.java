public class Person {
    private String name;
    private int age;

    // Constructor with parameter validation
    public Person(String name, int age) {
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Name must be non-null, non-empty, and no longer than 40 characters.");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        this.name = name;
        this.age = age;
    }

    // Getters for name and age
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public static void main(String[] args) {
        try {
            Person person = new Person("John Doe", 25);
            System.out.println("Created person: " + person.getName() + ", " + person.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Person invalidPerson = new Person("", 25);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: Name must be non-null, non-empty, and no longer than 40 characters.
        }

        try {
            Person invalidPerson = new Person("John Doe", 130);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: Age must be between 0 and 120.
        }
    }
}
