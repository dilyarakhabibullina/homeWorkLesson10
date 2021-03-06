package ru.itpark.ulmart.repository;

import org.springframework.stereotype.Repository;
import ru.itpark.ulmart.domain.IPhone;
import ru.itpark.ulmart.domain.Product;
import ru.itpark.ulmart.domain.TShirt;
import ru.itpark.ulmart.domain.Skirts;
import ru.itpark.ulmart.domain.Slime;

@Repository
public class ProductRepository { // new BookRepository();
    private Product[] items = new Product[10]; // 10 - null
    private int nextIndex = 0;

    public ProductRepository(Product[] items, int nextIndex) {
        this.items = items;
        this.nextIndex = nextIndex;
    }

    public ProductRepository() {
        // FIXME: bad hack
        IPhone iPhone = new IPhone();
        iPhone.setName("iPhone новое поступление");
        iPhone.setPrice(64_000);
        iPhone.setModel("XR");
        iPhone.setOs("iOS");
        iPhone.setMemorySize(64);
        iPhone.setColor("Pink Gold");
        iPhone.setId(1);

        TShirt shirt = new TShirt();
        shirt.setName("Футболка Nike");
        shirt.setPrice(1_000);
        shirt.setSize(52);
        shirt.setColor("Black");
        shirt.setLength("Длинная");
        shirt.setId(2);

        Skirts skirts = new Skirts();
        skirts.setPrice(3_000);
        skirts.setName("Юбка");
        skirts.setColor("dark blue");
        skirts.setLength("midi");
        skirts.setStyle("office");
        skirts.setBrand("Prada");

        Slime slime = new Slime();
        slime.setName("Слайм");
        slime.setPrice(200);
        slime.setType ("happy pie with waffles");
        slime.setColor("white");
        slime.setFlavoring("тирамису");
        slime.setVolume(150);
        slime.setSupplements("waffles");


        add(iPhone);
        add(shirt);
        add(skirts);
        add(slime);
    }

    public Product[] getAll() {
        return items;
    }

    public void add(Product product) {
        // TODO: проверить размер (items)
        items[nextIndex] = product;
        nextIndex++;
    }

    public Product getById(int id) {
        for (Product item : items) {
            if (item != null && item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
