package com.service;

import com.api.dao.MakeDao;
import com.api.dao.ModelDao;
import com.api.service.MakeService;
import com.model.Make;
import com.model.Model;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Implements the contract of {@link MakeService}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public class MakeServiceImpl implements MakeService {

    @Resource
    private MakeDao makeDao;

    @Resource
    private ModelDao modelDao;

    public void setModelDao(ModelDao modelDao) {
        this.modelDao = modelDao;
    }

    public void setMakeDao(MakeDao makeDao) {
        this.makeDao = makeDao;
    }

    @Override
    public void save(Make make) {
        makeDao.insert(make);
        if(CollectionUtils.isNotEmpty(make.getModels())){
            for(Model model : make.getModels()){
                makeDao.linkMakeAndModel(make.getId(), model.getId());
            }
        }
    }

    @Override
    public void update(Make make) {
        makeDao.update(make);
        makeDao.deleteLinksMakeAndModel(make.getId());
        if(CollectionUtils.isNotEmpty(make.getModels())){
            for(Model model : make.getModels()){
                makeDao.linkMakeAndModel(make.getId(), model.getId());
            }
        }
    }

    @Override
    public Make delete(Long id) {
        Make make = retrieve(id);
        if(null != make) {
            makeDao.delete(make);
        }
        return make;
    }

    @Override
    public Make retrieve(Long id) {
        return makeDao.find(id);
    }
}
