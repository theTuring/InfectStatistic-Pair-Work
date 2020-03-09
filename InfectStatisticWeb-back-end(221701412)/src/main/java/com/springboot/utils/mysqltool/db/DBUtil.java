//DBUtil类

package com.springboot.utils.mysqltool.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBUtil
 * TODO
 * @description 数据库连接驱动类
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.9
 */
public class DBUtil {

    //mysql的url
    private static final String URL ="jdbc:mysql://localhost:3306/infectstatistic?serverTimezone=UTC";

    //mysql的用户名
    private static final  String USERNAME = "root";

    //password
    private static final  String PWD = "123456";

    private static Connection conn = null;

    static {

        try {
            // 1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获得数据库的连接
            conn = DriverManager.getConnection(URL, USERNAME, PWD);
        }

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}
