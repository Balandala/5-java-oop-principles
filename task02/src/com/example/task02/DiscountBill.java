package com.example.task02;

public class DiscountBill extends Bill {
    private final int discount;
    DiscountBill(int discount){
        this.discount = discount;
    }
    public int getDiscount(){
        return discount;
    }

    public long getDiscountSum(){
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return price - price * discount / 100;
    }

}
