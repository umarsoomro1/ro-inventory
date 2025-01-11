package com.project.roinventory.controller;

import com.project.roinventory.Models.SaleDetail;
import com.project.roinventory.service.SalesService;
import com.project.roinventory.Models.MonthlySaleSummary;
import com.project.roinventory.Models.YearlySalesSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/add_sale")
    public ResponseEntity<Void> addSaleAndDetails(@RequestParam String customerName, @RequestParam String contactInfo,
                                                  @RequestParam String address, @RequestParam String email,
                                                  @RequestParam int itemId, @RequestParam int quantitySold) {
        salesService.addSaleAndDetails(customerName, contactInfo, address, email, itemId, quantitySold);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/sale_details")
    public ResponseEntity<List<SaleDetail>> getCustomerPurchaseHistory() {
        List<SaleDetail> purchaseHistory = salesService.getCustomerPurchaseHistory();
        return ResponseEntity.ok(purchaseHistory);
    }

    @GetMapping("/monthly-summary")
    public ResponseEntity<List<MonthlySaleSummary>> getMonthlySalesSummary() {
        List<MonthlySaleSummary> monthlySummary = salesService.getMonthlySalesSummary();
        return ResponseEntity.ok(monthlySummary);
    }

    @GetMapping("/yearly-summary")
    public ResponseEntity<List<YearlySalesSummary>> getYearlySalesSummary() {
        List<YearlySalesSummary> yearlySummary = salesService.getYearlySalesSummary();
        return ResponseEntity.ok(yearlySummary);
    }

    @GetMapping("/total-sales")
    public ResponseEntity<Integer> getTotalSalesNumber() {
        int totalSales = salesService.getTotalSalesNumber();
        return ResponseEntity.ok(totalSales);
    }
}
