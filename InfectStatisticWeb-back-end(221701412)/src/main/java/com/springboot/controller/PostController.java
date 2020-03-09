package com.springboot.controller;

import com.springboot.domain.Nation;
import com.springboot.domain.Province;
import com.springboot.service.NationService;
import com.springboot.service.ProvinceService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * PostController
 * TODO
 * @description 所有的post请求的接口
 * 1./api/province/insert 添加新省份用接口
 * 2./api/nation/insert 添加新国家记录用接口
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since
 */


@RestController
@CrossOrigin
@RequestMapping("/api")
public class PostController {

    @Autowired
    private NationService nationService;

    @Autowired
    private ProvinceService provinceService;

    //添加省份统计
    @RequestMapping(value = "province/insert", method = RequestMethod.POST)
    public JsonResult insertProvince(@RequestBody Province province) {


        int temp = provinceService.insertProvince(province);

        if(temp==0){

            return JsonResult.errorMsg("defeat");

        }

        return JsonResult.build(200,"success",province);
    }

    //添加国家统计
    @RequestMapping(value = "nation/insert", method = RequestMethod.POST)
    public JsonResult insertNation(@RequestBody Nation nation) {


        int temp = nationService.insertNation(nation);

        if(temp==0){

            return JsonResult.errorMsg("defeat");

        }

        return JsonResult.build(200,"success",nation);
    }

}
