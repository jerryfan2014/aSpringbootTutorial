package com.kangda.service.db;

import com.kangda.po.OrderInfo;

import java.util.List;

public interface OrderService {

    public Long getOrdersAdded(Long maxId) ;

    public Long getMaxId(Long maxId);
}
