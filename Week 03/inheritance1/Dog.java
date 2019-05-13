public class Dog implements OurComparable {
    private String name;
    private int size;

    public Dog() {
        this("Bin", 16);
    }

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println(this.name + " Woof");
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Object o) {
        return this.getSize() - ((Dog) o).getSize();
    }
}

