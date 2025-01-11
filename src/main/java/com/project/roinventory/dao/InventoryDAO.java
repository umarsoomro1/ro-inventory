package com.project.roinventory.dao;

import com.project.roinventory.Models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addInventoryItem(String itemName, String category, int quantity, int reorderLevel, double pricePerUnit) {
        String sql = "{call AddInventoryItem(?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, itemName, category, quantity, reorderLevel, pricePerUnit);
    }

    public List<Inventory> getLowStockItems() {
        String sql = "SELECT * FROM Low_Stock_Items";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Inventory.class));
    }

    // Function to get total items in inventory
    public int getTotalItemsInInventory() {
        String sql = "SELECT GetTotalItemsInInventory()";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    // New method to get all inventory items
    public List<Inventory> getAllInventoryItems() {
        String sql = "SELECT * FROM Inventory";  // Assuming the table is called 'Inventory'
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Inventory.class));
    }

    public int deleteInventory(int id) {
        String sql = "DELETE FROM inventory WHERE Item_ID = ?";
        return jdbcTemplate.update(sql, id);
    }

    // Method to update an inventory item's details
    public int updateInventory(int id, String itemName, String category, int quantity, double price) {
        String sql = "{CALL UpdateInventory(?, ?, ?, ?, ?)}";
        return jdbcTemplate.update(sql, id, itemName, category, quantity, price);
    }
}
