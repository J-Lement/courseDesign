package com.nchu.hospital_system.mapper.pharmacyAdmin;

import com.nchu.hospital_system.bean.Drugstore;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DrugstoreMapper {

    @Insert("insert into drugstore values(#{id},#{address},#{phone},#{name})")
    int addDrugstore(Drugstore drugstore);

    @Select("select * from drugstore")
    List<Drugstore> getAllDrugstores();

    @Select("select * from drugstore where id=#{id}")
    Drugstore get(int id);

    @Update("update drugstore set address=#{address},phone=#{phone},name=#{name} where id=#{id}")
    int updateDrug(Drugstore drugstore);

    @Delete("delete from drugstore where id=#{id}")
    int delete(int id);
}
