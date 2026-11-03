
package Generics;

public class EqualsShit {

    int id;
    String name;

    public EqualsShit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
     * equals() is inherited from Java's Object class.
     *
     * Every Java class implicitly extends Object if it
     * doesn't explicitly extend another class.
     *
     * Here, we override Object's equals() method to define
     * our own logical equality condition.
     *
     * Object o:
     * - Accepts a reference to any Java object.
     * - Object is the parent class of all Java classes.
     *
     * @Override:
     * - Tells the compiler that we're overriding an
     *   inherited method.
     */
    @Override
    public boolean equals(Object o) {

        if(o==null)return false;
        if(!(o instanceof EqualsShit))return false;

        /*
         * Type casting:
         *
         * The parameter 'o' is declared as Object.
         * We cast it to EqualsShit so that we can access
         * its id field.
         *
         * 'other' now refers to the same object as 'o'.
         * No new object is created by this cast.
         */
        EqualsShit other = (EqualsShit) o;

        /*
         * 'this' refers to the current object, i.e.,
         * the object on which equals() was called.
         *
         * other refers to the object passed as an argument.
         *
         * We define two EqualsShit objects as logically
         * equal if their IDs are identical.
         *
         * Notice that we're intentionally ignoring name.
         */
        return this.id == other.id;
    }

    static void main() {

        // Creates two separate objects in heap memory.
        // Both objects have the same ID and name.
        EqualsShit x = new EqualsShit(101, "abc");
        EqualsShit y = new EqualsShit(101, "abc");

        /*
         * == compares object references.
         *
         * x and y point to two different objects.
         * Therefore, the result is false.
         */
        System.out.println(x == y); // false

        /*
         * equals() calls our overridden implementation.
         *
         * Inside equals():
         * this = x
         * o = y
         * other = y
         *
         * Comparison:
         * this.id == other.id
         * 101 == 101
         *
         * Therefore, the result is true.
         */
        System.out.println(x.equals(y)); // true
    }
}
