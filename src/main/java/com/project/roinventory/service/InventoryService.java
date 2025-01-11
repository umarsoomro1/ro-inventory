package com.project.roinventory.service;

import com.project.roinventory.dao.InventoryDAO;
import com.project.roinventory.Models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryDAO inventoryDAO;

    public void addInventoryItem(String itemName, String category, int quantity, int reorderLevel, double pricePerUnit) {
        inventoryDAO.addInventoryItem(itemName, category, quantity, reorderLevel, pricePerUnit);
    }

    public List<Inventory> getLowStockItems() {
        return inventoryDAO.getLowStockItems();
    }

    public int getTotalItemsInInventory() {
        return inventoryDAO.getTotalItemsInInventory();
    }

    // New method to get all inventory items
    public List<Inventory> getAllInventoryItems() {
        return inventoryDAO.getAllInventoryItems();
    }

    // Method to update inventory
    public boolean updateInventory(int id, String itemName, String category, int quantity, double price) {
        int result = inventoryDAO.updateInventory(id, itemName, category, quantity, price);
        return result > 0;
    }

    // Method to delete inventory
    public boolean deleteInventory(int id) {
        int result = inventoryDAO.deleteInventory(id);
        return result > 0;
    }
}
