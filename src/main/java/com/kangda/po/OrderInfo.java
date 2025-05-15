package com.kangda.po;

//@Data
public class OrderInfo {
    private Long id;
    private String orderCustName;
    private Double orderPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCustName() {
        return orderCustName;
    }

    public void setOrderCustName(String orderCustName) {
        this.orderCustName = orderCustName;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
