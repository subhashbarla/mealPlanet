package com.mealplanet.foodplatform.controller;

import com.mealplanet.foodplatform.model.MenuItem;
import com.mealplanet.foodplatform.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuItemController {
    @Autowired
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping("/add")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem savedMenuItem = menuItemService.addMenuItem(menuItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMenuItem);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        return ResponseEntity.ok(menuItems);
    }

    @GetMapping("/all/{restId}")
    public ResponseEntity<List<MenuItem>> getAllMenuItemsByRestaurantId(@PathVariable("restId") Long restId) {
        List<MenuItem> menuItems = menuItemService.getMenuItemsByRestaurant(restId);
        return ResponseEntity.ok(menuItems);
    }

    @DeleteMapping("/remove/{menuId}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("menuId") long menuId) {
        try {
            menuItemService.deleteMenuById(menuId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}