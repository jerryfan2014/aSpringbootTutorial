package com.kangda.po;

public class UserAddress {
    private Long id;
    private Long userId;
    private String address;

    private String postCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
