package com.springboot.utils.mysqltool.dao;

import com.springboot.domain.Nation;
import com.springboot.domain.Province;
import com.springboot.utils.mysqltool.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ProvinceDao
 * TODO
 * @description dao层
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since
 */
public class ProvinceDao {

    //添加国家统计信息
    public void addProvince(Province province) throws SQLException {

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "insert into province(province, date, current_diagnosis, cumulative_diagnosis, suspected, cured, acute, dead)values(?,?,?,?,?,?,?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, province.getProvince());
        ptmt.setString(2, province.getDate());
        ptmt.setInt(3, province.getCurrent_diagnosis());
        ptmt.setInt(4, province.getCumulative_diagnosis());
        ptmt.setInt(5, province.getSuspected());
        ptmt.setInt(6, province.getCured());
        ptmt.setInt(7, province.getAcute());
        ptmt.setInt(8, province.getDead());

        ptmt.execute();
    }
}
    