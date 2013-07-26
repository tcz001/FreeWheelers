package com.trailblazers.freewheelers.web;

import com.trailblazers.freewheelers.model.Account;
import com.trailblazers.freewheelers.model.Item;
import com.trailblazers.freewheelers.model.OrderStatus;

import java.util.Date;

public class ReservedOrderDetail  {

    private Item item;
    private Account account;
    private Date reserve_time;
    private OrderStatus status;
    private String note;
    private Long orderId;

    public ReservedOrderDetail(Long orderId, Account account, Item item, Date reserve_time, OrderStatus status, String note){
        this.orderId = orderId;
        this.item = item;
        this.account = account;
        this.reserve_time = reserve_time;
        this.status = status;
        this.note = note;
    }

    public ReservedOrderDetail() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getReserve_time() {
        return reserve_time;
    }

    public void setReserve_time(Date reserve_time) {
        this.reserve_time = reserve_time;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderStatus[] getStatusOptions() {
        return OrderStatus.values();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
