package com.nchu.hospital_system.mapper.pharmacyAdmin;

import com.nchu.hospital_system.bean.PharmacyAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PharmacyAdminMapper {

    @Select("select * from pharmacyadmin where account=#{account}")
    public PharmacyAdmin getPharmacyAdminByAccount(String account);
}
