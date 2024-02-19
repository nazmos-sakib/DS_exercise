package exercise6_RMI.solution.task2.shopInterface;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class ProductDescription implements Serializable {
    
    private String title;
    private BigDecimal price;
    private String supplierId;
    
    public ProductDescription() {}

    public ProductDescription(String title, BigDecimal price, String supplierId) {
        this.title = title;
        this.price = price;
        this.supplierId = supplierId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public abstract String getPersons();
}
