package com.trailblazers.freewheelers.web;

import com.trailblazers.freewheelers.model.Account;
import com.trailblazers.freewheelers.model.Item;
import com.trailblazers.freewheelers.model.ReserveOrder;
import com.trailblazers.freewheelers.service.AccountService;
import com.trailblazers.freewheelers.service.ItemService;
import com.trailblazers.freewheelers.service.ReserveOrderService;
import com.trailblazers.freewheelers.service.impl.AccountServiceImpl;
import com.trailblazers.freewheelers.service.impl.ItemServiceImpl;
import com.trailblazers.freewheelers.service.impl.ReserveOrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping(ReserveController.URL)
public class ReserveController {

    static final String URL = "/reserve";

    ItemService itemService = new ItemServiceImpl();
    AccountService accountService = new AccountServiceImpl();
    ReserveOrderService reserveOrderService = new ReserveOrderServiceImpl();

    @RequestMapping(method = RequestMethod.GET)
    public void get(Model model) {
    }

    //TODO: display all orders of customers instead
    @RequestMapping(method = RequestMethod.POST, params="reserve=Reserve Item")
    public void reserveItem(Model model, Principal principal, @ModelAttribute Item item){
        Item itemToReserve =  itemService.get(item.getItemId());
        String userName = principal.getName();
        Account account =  accountService.getAccountIdByName(userName);
        Date rightNow = new Date();

        ReserveOrder reserveOrder = new ReserveOrder(account.getAccount_id(), itemToReserve.getItemId(), rightNow );

        reserveOrderService.save(reserveOrder);
        itemService.decreaseQuantityByOne(itemToReserve);

        model.addAttribute("item", itemToReserve);
    }
}
