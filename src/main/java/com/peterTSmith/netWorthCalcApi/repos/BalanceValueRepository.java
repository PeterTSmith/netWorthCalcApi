package com.peterTSmith.netWorthCalcApi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peterTSmith.netWorthCalcApi.objects.BalanceValue.BalanceValue;

public interface BalanceValueRepository extends JpaRepository<BalanceValue, Long> {
    
}