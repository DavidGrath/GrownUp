package com.example.grownup;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Product {
    double price;
    Drawable productImage;
    String productName;
    String priceCurrency;

    public Product() {
        this.productName = "UNDEFINED";
        this.price = 0.0;
        //TODO find default "image not available" online
        this.productImage = null;
    }

    public Product(String productName, double price, Drawable productImage) {
        this.productName = productName;
        this.price = price;
        this.productImage =  productImage;
        DecimalFormat decimalFormat = new DecimalFormat("0");
        Currency currency = Currency.getInstance(Locale.US);
        String string = currency.getSymbol();
        priceCurrency = decimalFormat.format(price) + string;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public Drawable getProductImage() {
        return productImage;
    }
}
