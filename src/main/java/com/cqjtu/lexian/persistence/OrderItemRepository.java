package com.cqjtu.lexian.persistence;

import com.cqjtu.lexian.domain.Order;
import com.cqjtu.lexian.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/** Created by dengxiaobing on 2017/9/22. */
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
  int countByCommentedAndOrder(int commented, Order order);

  int countByOrder_PayTimeAfterAndGoods_GoodsId(Date date, int goods_id);
}