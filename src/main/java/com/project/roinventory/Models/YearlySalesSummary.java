package com.project.roinventory.Models;

public class YearlySalesSummary {

    private int year;
    private double totalSales;
    private double totalCost;
    private double yearlyProfitMargin;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getYearlyProfitMargin() {
        return yearlyProfitMargin;
    }

    public void setYearlyProfitMargin(double yearlyProfitMargin) {
        this.yearlyProfitMargin = yearlyProfitMargin;
    }
}
