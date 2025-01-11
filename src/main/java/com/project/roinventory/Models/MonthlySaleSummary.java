package com.project.roinventory.Models;

public class MonthlySaleSummary {

    private int year;
    private int month;
    private double totalSales;
    private double totalCost;
    private double monthlyProfitMargin;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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

    public double getMonthlyProfitMargin() {
        return monthlyProfitMargin;
    }

    public void setMonthlyProfitMargin(double monthlyProfitMargin) {
        this.monthlyProfitMargin = monthlyProfitMargin;
    }
}
