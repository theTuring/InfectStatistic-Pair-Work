package com.springboot.serviceImpl;

import com.springboot.domain.Nation;
import com.springboot.domain.Province;
import com.springboot.mapper.NationMapper;
import com.springboot.mapper.ProvinceMapper;
import com.springboot.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${PROJECT_NAME}
 * TODO
 * @description
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.8
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> getAllProvince() {

        List<Province> list = this.provinceMapper.getAllProvince();

        return list;

    }

    @Override
    public int insertProvince(Province province){

        int temp = this.provinceMapper.insertProvince(province);

        return temp;

    }

}
    