package com.springboot.utils.jsontool;

import com.google.gson.Gson;
import com.springboot.domain.JsonResultProvince;
import com.springboot.domain.JsonResultProvinceList;
import com.springboot.domain.Nation;
import com.springboot.mapper.NationMapper;
import com.springboot.service.NationService;
import com.springboot.utils.mysqltool.dao.NationDao;
import com.springboot.utils.urltool.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;


/**
 * AnalysisJson
 * TODO
 * @description 解析json的类
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.9
 */
public class AnalysisJson {



    //解析全国省份城市统计的json
    public static List<JsonResultProvince> ProvinceJson() {

        Gson gson=new Gson();

        //http://api.tianapi.com/txapi/ncovcity/index?key=6e07e5626fdebe0394ff896b6bdb52a3
        String json_temp = HttpRequest.sendGet("http://api.tianapi.com/txapi/ncovcity/index?key=6e07e5626fdebe0394ff896b6bdb52a3");

        //解析对象：第一个参数：待解析的字符串 第二个参数结果数据类型的Class对象
        JsonResultProvinceList jsonResultBooksList=gson.fromJson(json_temp, JsonResultProvinceList.class);

        return jsonResultBooksList.getNewslist();

    }

    //定时器执行的操作函数
    public static void TimerExecute() throws SQLException {

        //国家实体实例化
        Nation nation = new Nation();

        List<JsonResultProvince> list = ProvinceJson();

        for (int i=0; i<list.size(); i++){

            //date日期格式控制为日期格式，精确到日 2017-4-16
            DateFormat df1 = DateFormat.getDateInstance();
            nation.setDate(df1.format(new Date()));
            nation.setCurrent_diagnosis(nation.getCurrent_diagnosis()+list.get(i).getCurrentConfirmedCount());
            nation.setCumulative_diagnosis(nation.getCumulative_diagnosis()+list.get(i).getConfirmedCount());
            nation.setSuspected(nation.getSuspected()+list.get(i).getSuspectedCount());
            nation.setCured(nation.getCured()+list.get(i).getCuredCount());
            //暂时无法获得重症消息
            nation.setAcute(0);
            nation.setDead(nation.getDead()+list.get(i).getDeadCount());

        }

        //插入数据库
        NationDao nationDao = new NationDao();
        nationDao.addNation(nation);

    }

        public static void main(String[] args) throws SQLException {


            //System.out.println(ProvinceJson().get(0).getConfirmedCount());

            //TimerExecute();

    }


}
