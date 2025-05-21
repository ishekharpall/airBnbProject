package com.shekhar.projects.airBnbProject.strategy;



import com.shekhar.projects.airBnbProject.Entity.Inventory;

import java.math.BigDecimal;

public class BasePricingStrategy implements PricingStrategy{
    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
