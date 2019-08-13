package com.nchu.hospital_system.mapper.pharmacyAdmin;

import com.nchu.hospital_system.bean.DrugPurchase;
import org.apache.ibatis.annotations.Insert;

public interface DrugPurchaseMapper {
    @Insert("insert into drugpurchase values(#{drugid},#{drugstoreid},#{amount})")
    int purchaseDrug(DrugPurchase drugPurchase);
}
