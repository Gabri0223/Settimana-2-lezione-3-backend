public class Customer {
    private Long id;
    private String name;
    private Integer tier;

    public Customer(Integer tier, String name, Long id) {
        this.tier = tier;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
