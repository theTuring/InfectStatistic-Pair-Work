package com.springboot.controller;

import com.springboot.constant.ProvinceConstant;
import com.springboot.domain.Nation;
import com.springboot.domain.Province;
import com.springboot.service.NationService;
import com.springboot.service.ProvinceService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * GetController
 * TODO
 * @description 所有的get请求的接口
 * 1./api/query/nation/all 查询全部的国家统计信息
 * 2./api/query/province/all 查询全部的国家省份统计信息
 * 3./api/init/province/all 初始化所有的省份状态(后端测试用非前端使用)
 * 将所有省份置为"date":"1970-1-1","current_diagnosis":0,"cumulative_diagnosis":0,"suspected":0,"cured":0,"acute":0,"dead":0
 * 4.
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


}
