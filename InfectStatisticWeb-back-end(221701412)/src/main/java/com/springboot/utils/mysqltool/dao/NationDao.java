package com.springboot.utils.mysqltool.dao;

import com.springboot.domain.Nation;
import com.springboot.utils.mysqltool.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NationDao {

    //添加国家统计信息
    public void addNation(Nation nation) throws SQLException {

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "insert into nation(date, current_diagnosis, cumulative_diagnosis, suspected, cured, acute, dead)values(?,?,?,?,?,?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, nation.getDate());
        ptmt.setInt(2, nation.getCurrent_diagnosis());
        ptmt.setInt(3, nation.getCumulative_diagnosis());
        ptmt.setInt(4, nation.getSuspected());
        ptmt.setInt(5, nation.getCured());
        ptmt.setInt(6, nation.getAcute());
        ptmt.setInt(7, nation.getDead());

        ptmt.execute();
    }
}


