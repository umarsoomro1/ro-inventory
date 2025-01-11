package com.project.roinventory.controller;

import com.project.roinventory.service.InventoryService;
import com.project.roinventory.Models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addInventoryItem(@RequestParam String itemName, @RequestParam String category,
                                                 @RequestParam int quantity, @RequestParam int reorderLevel,
                                                 @RequestParam double pricePerUnit) {
        inventoryService.addInventoryItem(itemName, category, quantity, reorderLevel, pricePerUnit);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<Inventory>> getLowStockItems() {
        List<Inventory> lowStockItems = inventoryService.getLowStockItems();
        return ResponseEntity.ok(lowStockItems);
    }

    @GetMapping("/total-items")
    public ResponseEntity<Integer> getTotalItemsInInventory() {
        int totalItems = inventoryService.getTotalItemsInInventory();
        return ResponseEntity.ok(totalItems);
    }

    // New endpoint to get all inventory items
    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventoryItems() {
        List<Inventory> allItems = inventoryService.getAllInventoryItems();
        return ResponseEntity.ok(allItems);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateInventory(@PathVariable int id,
                                                  @RequestBody Inventory inventory) {
        boolean isUpdated = inventoryService.updateInventory(id, inventory.getItemName(),
                inventory.getCategory(), inventory.getQuantity(), inventory.getPricePerUnit());
        if (isUpdated) {
            return ResponseEntity.ok("Inventory updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update inventory");
        }
    }

    // Endpoint to delete an inventory item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable int id) {
        boolean isDeleted = inventoryService.deleteInventory(id);
        if (isDeleted) {
            return ResponseEntity.ok("Inventory item deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete inventory item");
        }
    }
}

