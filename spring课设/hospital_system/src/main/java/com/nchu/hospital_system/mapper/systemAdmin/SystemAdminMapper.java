package com.nchu.hospital_system.mapper.systemAdmin;

import com.nchu.hospital_system.bean.SystemAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SystemAdminMapper {

    @Select("select * from systemadmin where account=#{account}")
    public SystemAdmin getSystemAdminByAccount(String account);
}
