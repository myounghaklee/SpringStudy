package jpaBook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id @GeneratedValue
    @Column(name ="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQunatity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQunatity() {
        return stockQunatity;
    }

    public void setStockQunatity(int stockQunatity) {
        this.stockQunatity = stockQunatity;
    }
}
