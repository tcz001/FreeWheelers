package com.trailblazers.freewheelers.mappers;

import com.trailblazers.freewheelers.model.ReserveOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReserveOrderMapper {

    @Insert(
        "INSERT INTO reserve_order (account_id, item_id, status, note, reservation_timestamp) " +
        "VALUES (#{account_id}, #{item_id}, #{status}, #{note}, #{reservation_timestamp})"
    )
    @Options(keyProperty = "order_id", useGeneratedKeys = true)
    Integer insert(ReserveOrder order);

    @Select(
        "SELECT order_id, account_id, item_id, status, note, reservation_timestamp " +
        "FROM reserve_order " +
        "WHERE order_id = #{order_id}"
    )
    ReserveOrder get(Long order_id);

    @Delete(
        "DELETE FROM reserve_order WHERE order_id = #{order_id}"
    )
    void delete(ReserveOrder reserveOrder);

    @Update(
        "UPDATE reserve_order " +
        "SET account_id=#{account_id}, item_id=#{item_id}, status=#{status}, note=#{note}, reservation_timestamp=#{reservation_timestamp} " +
        "WHERE order_id=#{order_id}"
    )
    void save(ReserveOrder reserveOrder);

    @Select(
        "SELECT order_id, account_id, item_id, status, note, reservation_timestamp " +
        "FROM reserve_order " +
        "ORDER BY account_id"
    )
    @Results(value = {
        @Result(property="order_id"),
        @Result(property="account_id"),
        @Result(property="item_id"),
        @Result(property="status"),
        @Result(property="note"),
        @Result(property="reservation_timestamp")
    })
    List<ReserveOrder> findAll();

    @Select(
            "SELECT order_id, account_id, item_id, status, note, reservation_timestamp " +
            "FROM reserve_order " +
            "WHERE account_id=#{account_id}"
    )
    @Results(value = {
            @Result(property="order_id"),
            @Result(property="account_id"),
            @Result(property="item_id"),
            @Result(property="status"),
            @Result(property="note"),
            @Result(property="reservation_timestamp")
    })
    List<ReserveOrder> findAllFor(Long account_id);

}
