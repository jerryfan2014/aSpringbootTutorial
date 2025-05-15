package com.kangda.service.db.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangda.mapper.OrderInfoMapper;
import com.kangda.po.OrderInfo;
import com.kangda.service.db.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    public Long getOrdersAdded(Long maxId) {
        return orderInfoMapper.getOrderCounter(maxId);
    }

    @Override
    public Long getMaxId(Long maxId) {
        return orderInfoMapper.getMaxId(maxId);
    }
}
