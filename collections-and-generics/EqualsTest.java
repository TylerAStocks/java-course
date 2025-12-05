
class Foo {
    private int fooValue;
    Foo(int val) { fooValue=val;}
    int getFooValue() {return fooValue;}



    @Override
    public boolean equals(Object o) {
        return (o instanceof Foo) && (((Foo)o).getFooValue() == this.fooValue);
    }

    @Override
    public int hashCode() {
        return fooValue*17; //using the same instance var as equals()
    }
}



public class EqualsTest {
    public static void main(String[] args) {
        Foo f1 = new Foo(2);
        Foo f2 = new Foo(2);

        System.out.println("" +f1.equals(f2)); // true
        System.out.println("" + f1.equals("SK")); // false
    }
}
