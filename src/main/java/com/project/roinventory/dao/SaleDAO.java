package com.project.roinventory.dao;

import com.project.roinventory.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSaleAndDetails(String customerName, String contactInfo, String address, String email, int itemId, int quantitySold) {
        String sql = "{call AddSaleAndUpdateInventory(?, ?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, customerName, contactInfo, address, email, itemId, quantitySold);
    }

    public List<SaleDetail> getCustomerPurchaseHistory() {
        String sql = "SELECT \n" +
                "    S.Sale_ID,\n" +
                "    C.Name AS Customer_Name,\n" +
                "    C.Contact_Info,\n" +
                "    I.Item_ID,\n" +
                "    I.Category,\n" +
                "    S.Quantity,\n" +
                "    S.Total_Amount,\n" +
                "    S.Sale_Date\n" +
                "FROM \n" +
                "    Sales S\n" +
                "JOIN \n" +
                "    Customers C ON S.Customer_ID = C.Customer_ID\n" +
                "JOIN \n" +
                "    Inventory I ON S.Item_ID = I.Item_ID";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SaleDetail.class));
    }

    public List<MonthlySaleSummary> getMonthlySalesSummary() {
        String sql = "SELECT * FROM MonthlySalesSummary";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MonthlySaleSummary.class));
    }

    public List<YearlySalesSummary> getYearlySalesSummary() {
        String sql = "SELECT * FROM YearlySalesSummary";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(YearlySalesSummary.class));
    }

    // Function to get total sales number
    public int getTotalSalesNumber() {
        String sql = "SELECT GetTotalSalesNumber()";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public int deleteSale(int id) {
        String sql = "DELETE FROM sales WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateSale(int id, int inventoryId, int quantitySold, double totalPrice) {
        String sql = "UPDATE sales SET inventory_id = ?, quantity_sold = ?, total_price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, inventoryId, quantitySold, totalPrice, id);
    }
}
