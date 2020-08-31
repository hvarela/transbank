package com.prueba.transbank.infrastructure.entitys;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ventas")
public class SalesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "producId")
    private Integer producId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "price")
    private Double price;

    @Basic(optional = false)
    @Column(name = "amount")
    private Integer amount;


    public SalesEntity() {

    }

    public SalesEntity(Integer id) {
        this.id = id;
    }

    public SalesEntity(int id ,Integer productId, String name, Double price, Integer amount) {
        this.id = id;
        this.producId = productId;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProducId() {
        return this.producId;
    }

    public void setProducId(Integer producId) {
        this.producId = producId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SalesEntity{" +
                "id=" + id +
                ", producId=" + producId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
