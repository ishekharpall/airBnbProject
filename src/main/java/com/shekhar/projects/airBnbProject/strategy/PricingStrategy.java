package com.shekhar.projects.airBnbProject.strategy;


import com.shekhar.projects.airBnbProject.Entity.Inventory;

import java.math.BigDecimal;
public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
