package com.service;

import com.api.dao.MakeDao;
import com.api.dao.ModelDao;
import com.api.service.MakeService;
import com.api.service.ModelService;
import com.model.Make;
import com.model.Model;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;

/**
 * Implements the contract of {@link ModelService}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public class ModelServiceImpl implements ModelService {

    @Resource
    private ModelDao modelDao;

    public void setModelDao(ModelDao modelDao) {
        this.modelDao = modelDao;
    }

    @Override
    public void save(Model model) {
        modelDao.insert(model);
    }

    @Override
    public void update(Model model) {
        modelDao.update(model);
    }

    @Override
    public Model delete(Long id) {
        Model model = modelDao.find(id);
        if (null != model) {
            modelDao.delete(model);
        }
        return model;
    }

    @Override
    public Model retrieve(Long id) {
        return modelDao.find(id);
    }
}
