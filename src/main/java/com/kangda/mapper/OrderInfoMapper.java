package com.kangda.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangda.po.OrderInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    @Select("SELECT count(*) FROM order_info WHERE id > #{maxId} ")
    public Long getOrderCounter(Long maxId);


    @Select("SELECT max(id) FROM order_info WHERE id > #{maxId} ")
    public Long getMaxId(Long maxId);

}
