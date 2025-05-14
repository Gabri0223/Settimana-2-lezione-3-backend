
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> prodotti= Arrays.asList(
                new Product(123L, "Libro 1", "Book", 170.31),
                new Product(456L, "Libro 2", "Book", 10.65),
                new Product(789L, "Libro 3", "Book", 150.39),
                new Product(101112L,"Macchina 1","Boys",30000.0),
                new Product(13141516L,"Passeggino","Baby",300.0)
        );

        Customer compratore1 =new Customer(1,"Mauro",123456789L);
        Customer compratore2= new Customer(2,"Alessio",1011121314L);
        Customer compratore3=new Customer(1,"Gabriele",1516171819L);

        List<Order> ordini=Arrays.asList(
                new Order(161718L,"Non Consegnato", LocalDate.now(),null,Arrays.asList(prodotti.get(0),prodotti.get(1)), compratore1),
        new Order(192021L,"consegnato",LocalDate.of(2025,03,30),LocalDate.now(),Arrays.asList(prodotti.get(4),prodotti.get(3)),compratore2)

        );
        List<Product> Listamodificata=
               prodotti.stream()
               .filter(p->p.getCategory().toLowerCase().equals("book") && p.getPrice()>100)
               .toList();
        System.out.println(Listamodificata);

        List<Order> ordiniBambini= ordini.stream()
        .filter(p->p.getProducts().stream().anyMatch(p1->"baby".equals(p1.getCategory().toLowerCase()))).toList();
        System.out.println(ordiniBambini);

        List<Product>prodottiScontati=
                prodotti.stream()
                        .filter(p->p.getCategory().toLowerCase().equals("boys")).map(b->new Product(b.getId(),b.getName(),b.getCategory(),b.getPrice()*0.9))
                        .toList();
        System.out.println(prodottiScontati);
}
}