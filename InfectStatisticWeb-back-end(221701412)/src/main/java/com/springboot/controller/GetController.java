package com.springboot.controller;

import com.springboot.constant.ProvinceConstant;
import com.springboot.domain.Nation;
import com.springboot.domain.Province;
import com.springboot.service.NationService;
import com.springboot.service.ProvinceService;
import com.springboot.utils.datetool.DateResult;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.urltool.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * GetController
 * TODO
 * @description 所有的get请求的接口
 * 1./api/query/nation/all 查询全部的国家统计信息
 * 2./api/query/province/all 查询全部的国家省份统计信息
 * 3./api/init/province/all 初始化所有的省份状态(后端测试用前端勿用)
 * 将所有省份置为"date":"1970-1-1","current_diagnosis":0,"cumulative_diagnosis":0,"suspected":0,"cured":0,"acute":0,"dead":0
 * 4./api/query/nation/date/{date} 根据日期查询国家统计信息，返回国家实体
 * 5./api/query/province/date/province/{date}/{province} 根据日期和省份名查询国家省份统计信息，返回省份实体
 * 6./api/query/province/city/all 直接查询查看即时的国家省份城市统计信息（api获取）
 * 7./api/query/news 直接查询即时热点信息（api获取）
 * 8./api/query/nation/increase/{date} 根据日期查询国家统计信息，返回国家当日增加实体
 * 9./api/query/province/increase/{date}/{province} 根据日期查询国家省份统计信息，返回对应省份当日增加实体
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.8
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class GetController implements ProvinceConstant{

    @Autowired
    private NationService nationService;

    @Autowired
    private ProvinceService provinceService;

    //mysql单类型查询()
    @RequestMapping("query/nation/all")
    public JsonResult queryNationAll() {

        List<Nation> list = this.nationService.getAllNation();

        return JsonResult.ok(list);

    }

    //mysql单类型查询()
    @RequestMapping("query/province/all")
    public JsonResult queryProvinceAll() {

        List<Province> list = this.provinceService.getAllProvince();

        return JsonResult.ok(list);

    }

    //初始化所有的省份状态
    @RequestMapping("init/province/all")
    public JsonResult initProvinceAll() {

        //实例化省份的实体
        Province province = new Province();

        for(int i=0; i<PROVINCE_NUM; i++){

            province.setProvince(PROVINCES[i]);
            province.setDate(INIT_DATE);
            province.setCurrent_diagnosis(INIT_NUM);
            province.setCumulative_diagnosis(INIT_NUM);
            province.setSuspected(INIT_NUM);
            province.setAcute(INIT_NUM);
            province.setCured(INIT_NUM);
            province.setDead(INIT_NUM);

            int temp = provinceService.insertProvince(province);

        }

        return JsonResult.build(200,"success",null);

    }

    //mysql单类型查询()
    @RequestMapping("query/nation/date/{date}")
    public JsonResult queryNationByDate(@PathVariable String date) {

        Nation nation = this.nationService.queryNationByDate(date);

        return JsonResult.ok(nation);

    }

    //mysql单类型查询()
    @RequestMapping("query/province/date/province/{date}/{province}")
    public JsonResult queryProvinceByBoth(@PathVariable String date,
                                          @PathVariable String province) {

        Province province1 = this.provinceService.queryEvRecordByBoth(province, date);

        return JsonResult.ok(province1);

    }

    //api单类型查询()
    @RequestMapping("query/province/city/all")
    public String queryProvinceCityAll() {

        HttpRequest httpRequest = new HttpRequest();

        String temp = httpRequest.sendGet("http://api.tianapi.com/txapi/ncovcity/index?key=6e07e5626fdebe0394ff896b6bdb52a3");

        return temp;

    }

    //api单类型查询()
    @RequestMapping("query/news")
    public String queryNews() {

        HttpRequest httpRequest = new HttpRequest();

        String temp = httpRequest.sendGet("http://api.tianapi.com/txapi/ncov/index?key=6e07e5626fdebe0394ff896b6bdb52a3");

        return temp;

    }

    //mysql单类型查询()
    @RequestMapping("query/nation/increase/{date}")
    public JsonResult queryNationIncreaseByDate(@PathVariable String date) {

        List<Nation> list = this.nationService.getAllNation();

        Nation nation = this.nationService.queryNationByDate(date);

        Nation increase_nation = new Nation();

        int temp = 0;

        for(int i=0; i<list.size(); i++){

            if(nation.getDate().equals(list.get(i).getDate())){
                temp = i-1;
            }

        }

        increase_nation.setDate(date);
        increase_nation.setCurrent_diagnosis(nation.getCurrent_diagnosis()-list.get(temp).getCurrent_diagnosis());
        increase_nation.setCumulative_diagnosis(nation.getCumulative_diagnosis()-list.get(temp).getCumulative_diagnosis());
        increase_nation.setAcute(nation.getAcute()-list.get(temp).getAcute());
        increase_nation.setSuspected(nation.getSuspected()-list.get(temp).getSuspected());
        increase_nation.setCured(nation.getCured()-list.get(temp).getCured());
        increase_nation.setDead(nation.getDead()-list.get(temp).getDead());

        return JsonResult.ok(increase_nation);

    }

    //mysql单类型查询()
    @RequestMapping("query/province/increase/{date}/{province}")
    public JsonResult queryProvinceIncreaseByDate(@PathVariable String date,
                                                  @PathVariable String province) throws ParseException {

        DateResult dateResult = new DateResult();

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );

        Province province1 = this.provinceService.queryEvRecordByBoth(province, date);

        Date temp = sdf.parse(date);

        System.out.println(temp);

        String str = sdf.format(dateResult.moveTime(temp,-1));

        System.out.println(str);

        Province province2 = this.provinceService.queryEvRecordByBoth(province, str);

        Province increase_province = new Province();

        increase_province.setProvince(province);
        increase_province.setDate(date);
        increase_province.setCurrent_diagnosis(province1.getCurrent_diagnosis()-province2.getCurrent_diagnosis());
        increase_province.setCumulative_diagnosis(province1.getCumulative_diagnosis()-province2.getCumulative_diagnosis());
        increase_province.setAcute(province1.getAcute()-province2.getAcute());
        increase_province.setSuspected(province1.getSuspected()-province2.getSuspected());
        increase_province.setCured(province1.getCured()-province2.getCured());
        increase_province.setDead(province1.getDead()-province2.getDead());

        return JsonResult.ok(increase_province);

    }

}
