package com.wadestevens.content.controllers;

import com.wadestevens.content.models.Inventory;
import com.wadestevens.content.models.data.InventoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryDao inventoryDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        //  The inventoryDao.findAll gathers all that is in the database and displays them.
        model.addAttribute("inventories", inventoryDao.findAll());
        model.addAttribute("title", "Inventory List");

        return "inventory/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddInventoryForm(Model model){

        // The new Inventory gathers all the fields as an object and passes it to *{inventory}.
        model.addAttribute("title", "Add Inventory");
        model.addAttribute(new Inventory());

        return "inventory/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Inventory newInventory,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Inventory");

            return "inventory/add";
        }
        // This retrieves all the data passed back from the Inventory newInventory and stores into inventoryDao.
        inventoryDao.save(newInventory);

        return "redirect:";
    }

    @RequestMapping(value= "remove", method = RequestMethod.GET)
    public String displayRemoveInventoryForm(Model model) {

        // Retrieves all the data from database and displays them in the remove view for deletion.
        model.addAttribute("title", "Remove Item");
        model.addAttribute("inventories", inventoryDao.findAll());
        return "inventory/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveInventoryForm(@RequestParam int[] inventoryIds ) {

        // This sifts out the marked items and deletes them from the data base inventory.
        for (int inventoryId : inventoryIds) {
            inventoryDao.delete(inventoryId);
        }

        return "redirect:";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginGet(Model model) {
//
//        model.addAttribute("username", "Login");
//        model.addAttribute("password", "Log In");
//        model.addAttribute("code", null);
//
//        return "redirect:";
//    }

}