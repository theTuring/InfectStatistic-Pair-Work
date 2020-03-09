package com.springboot.mapper;

import com.springboot.domain.Nation;
import com.springboot.domain.Province;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * NationMapper
 * TODO
 * @description NationMapper
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.8
 */
@Mapper
public interface NationMapper {

    //查询全部
    @Select("select * from nation")
    List<Nation> getAllNation();

    //日期date查找
    @Select("SELECT * FROM nation WHERE date =#{date}")
    Nation queryNationByDate(String date);

    //添加国家统计信息
    @Insert("INSERT INTO nation (date, current_diagnosis, cumulative_diagnosis, suspected, cured, acute, dead) "
            + "VALUES (#{date}, #{current_diagnosis}, #{cumulative_diagnosis}, #{suspected}, #{cured}, #{acute}, #{dead})")
    int insertNation(Nation nation);

}
    