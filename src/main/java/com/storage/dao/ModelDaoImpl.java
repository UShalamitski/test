package com.storage.dao;

import com.api.dao.MakeDao;
import com.api.dao.ModelDao;
import com.model.Model;
import com.storage.mapper.ModelMapper;

import javax.annotation.Resource;

/**
 * The implementation of the {@link ModelDao}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public class ModelDaoImpl implements ModelDao {

    @Resource
    private ModelMapper modelMapper;

    @Override
    public Model find(Long id) {
        return modelMapper.find(id);
    }

    @Override
    public void insert(Model make) {
        modelMapper.store(make);
    }

    @Override
    public void update(Model make) {
        modelMapper.update(make);
    }

    @Override
    public void delete(Model make) {
        modelMapper.delete(make.getId());
    }

}
