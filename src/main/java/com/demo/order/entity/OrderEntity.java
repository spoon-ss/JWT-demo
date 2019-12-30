package com.demo.order.entity;

import com.demo.user.entity.UserEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "e_order")
public class OrderEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<OrderEntryEntity> orderEntries;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public OrderEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<OrderEntryEntity> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderEntryEntity> orderEntries) {
        this.orderEntries = orderEntries;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", orderEntries=" + orderEntries +
                ", user=" + user +
                '}';
    }
}
