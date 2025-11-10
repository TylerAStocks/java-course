public class Dog implements Comparable<Dog> {
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" + "name=" + name + ", age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dog) {
            Dog otherDog = (Dog)obj;
            if(name.equals(otherDog.getName()))
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Dog otherDog) {
        // delegate to string which implements Comparable<String>
        return name.compareTo(otherDog.getName());
    }
    
}
