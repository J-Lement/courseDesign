package com.nchu.hospital_system.mapper.systemAdmin;

import com.nchu.hospital_system.bean.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Insert("insert into dept values(#{id},#{address},#{name},#{phone})")
    public int addDept(Dept dept);

    @Select("select * from dept")
    List<Dept> getAll();

    @Select("select * from dept where id=#{id}")
    Dept getDeptById(int id);

    @Update("update dept set name=#{name},address=#{address},phone=#{phone} where id=#{id}")
    int update(Dept dept);

    @Delete("delete from dept where id=#{id}")
    int delete(int id);
}
