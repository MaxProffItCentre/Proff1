package dao;

import java.util.List;

import data.OrderPositions;

public interface OrderPositionsDao {
    Long create(OrderPositions obj);
    OrderPositions read(Long id);
    void update(OrderPositions obj);
    void delete(OrderPositions obj);
    List<OrderPositions> findAll();

}
