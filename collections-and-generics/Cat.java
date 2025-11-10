public class Cat implements Comparable<Cat> {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{name=" + name + ", age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cat) {
            Cat otherCat = (Cat)obj;
            if(name.equals(otherCat.getName()))
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Cat otherCat) {
        return name.compareTo(otherCat.getName());
    }

}
