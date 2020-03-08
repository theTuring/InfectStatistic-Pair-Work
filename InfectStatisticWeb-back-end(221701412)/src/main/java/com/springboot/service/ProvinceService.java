package com.springboot.service;

import com.springboot.domain.Province;

import java.util.List;

/**
 * ProvinceService
 * TODO
 * @description 数据服务层 ProvinceService
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.8
 */
public interface ProvinceService {

    List<Province> getAllProvince();

    int insertProvince(Province province);
}
    