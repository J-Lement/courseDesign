package com.nchu.hospital_system.mapper.pharmacyAdmin;

import com.nchu.hospital_system.bean.DrugClassify;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DrugClassifyMapper {
    @Select("select * from drugclassify")
    List<DrugClassify> getClassify();
}
