package com.springboot.serviceImpl;

import com.springboot.domain.Nation;
import com.springboot.mapper.NationMapper;
import com.springboot.service.NationService;
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
public class NationServiceImpl implements NationService {

    @Autowired
    private NationMapper nationMapper;

    @Override
    public List<Nation> getAllNation() {

        List<Nation> list = this.nationMapper.getAllNation();

        return list;

    }
}
    