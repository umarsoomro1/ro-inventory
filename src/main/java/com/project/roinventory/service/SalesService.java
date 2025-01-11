package com.project.roinventory.service;

import com.project.roinventory.Models.SaleDetail;
import com.project.roinventory.dao.SaleDAO;
import com.project.roinventory.Models.CustomerPurchaseHistory;
import com.project.roinventory.Models.MonthlySaleSummary;
import com.project.roinventory.Models.YearlySalesSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    private SaleDAO saleDAO;

    @Autowired
    public SalesService(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }

    public void addSaleAndDetails(String customerName, String contactInfo, String address, String email, int itemId, int quantitySold) {
        saleDAO.addSaleAndDetails(customerName, contactInfo, address, email, itemId, quantitySold);
    }

    public List<SaleDetail> getCustomerPurchaseHistory() {
        return saleDAO.getCustomerPurchaseHistory();
    }

    public List<MonthlySaleSummary> getMonthlySalesSummary() {
        return saleDAO.getMonthlySalesSummary();
    }

    public List<YearlySalesSummary> getYearlySalesSummary() {
        return saleDAO.getYearlySalesSummary();
    }

    // Function to get total sales number
    public int getTotalSalesNumber() {
        return saleDAO.getTotalSalesNumber();
    }
}
