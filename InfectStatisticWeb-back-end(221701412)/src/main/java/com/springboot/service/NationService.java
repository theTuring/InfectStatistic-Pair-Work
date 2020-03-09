package com.springboot.service;

import com.springboot.domain.Nation;

import java.util.List;

/**
 * NationService
 * TODO
 * @description 数据服务层 NationService
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.8
 */
public interface NationService {

    List<Nation> getAllNation();

    Nation queryNationByDate(String date);

}
    