package com.springboot.mapper;

import com.springboot.domain.Nation;
import com.springboot.domain.Province;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ProvinceMapper
 * TODO
 * @description ProvinceMapper
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.8
 */
@Mapper
public interface ProvinceMapper {

    //查询全部
    @Select("select * from province")
    List<Province> getAllProvince();

    //添加省份统计信息
    @Insert("INSERT INTO province (province, date, current_diagnosis, cumulative_diagnosis, suspected, cured, acute, dead) "
            + "VALUES (#{province}, #{date}, #{current_diagnosis}, #{cumulative_diagnosis}, #{suspected}, #{cured}, #{acute}, #{dead})")
    int insertProvince(Province province);
}
    