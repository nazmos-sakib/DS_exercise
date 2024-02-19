package exercise6_RMI.solution.task2.shopInterface;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    private Integer id;
    private ProductDescription description;
    private int quantity;

    public Product() {
    }

    public Product(ProductDescription description, int quantity) {
        this.description = description;
        this.quantity = quantity;
    }

    public String getSupplierId() {
        return description.getSupplierId();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPersons() {
        return description.getPersons();
    }
    
    public String getTitle() {
        return description.getTitle();
    }
    
    public BigDecimal getPrice() {
        return description.getPrice();
    }
}
