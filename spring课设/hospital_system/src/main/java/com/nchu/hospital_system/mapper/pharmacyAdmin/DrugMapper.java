package com.nchu.hospital_system.mapper.pharmacyAdmin;

import com.nchu.hospital_system.bean.Drug;
import com.nchu.hospital_system.bean.DrugPurchase;
import com.nchu.hospital_system.bean.GetDrug;
import com.nchu.hospital_system.bean.Prescription;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DrugMapper {

    @Insert("insert into drug values(#{id},#{classify},#{stock},#{name})")
    int add(Drug drug);

    @Select("select * from drug")
    List<Drug> getAll();

    @Select("select * from drug where id=#{id}")
    Drug get(int id);

    @Delete("delete from drug where id=#{id}")
    int delete(int id);

    @Update("update drug set classify=#{classify},stock=#{stock},name=#{name} where id=#{id}")
    int update(Drug drug);

    @Select("select * from drug where classify=#{classify}")
    List<Drug> classifyDrugs(String classify);

    @Select("select * from drug where classify='注射剂类药品'")
    List<Drug> getInjectDrugs();

    @Select("select * from drugpurchase")
    List<DrugPurchase> getPurchases();

    @Select("select * from prescription")
    List<Prescription> getPrescription();

    @Delete("delete from prescription where doctor=#{arg0} and patient=#{arg1} and drugid=#{arg2}")
    int deletePrescription(String doctor, String patient, int drugid);

    @Insert("insert into getdrug values(#{arg0},#{arg1},#{arg2})")
    int addGetDrug(int drugid, String patietn, int quantity);

    @Select("select * from getdrug")
    List<GetDrug> getGetdrugHistory();
}
