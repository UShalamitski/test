package com.storage.dao;

import com.api.dao.MakeDao;
import com.model.Make;
import com.storage.mapper.MakeMapper;

import javax.annotation.Resource;

/**
 * The implementation of the {@link MakeDao}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public class MakeDaoImpl implements MakeDao {

    @Resource
    private MakeMapper makeMapper;

    @Override
    public Make find(Long id) {
        return makeMapper.find(id);
    }

    @Override
    public void insert(Make make) {
        makeMapper.store(make);
    }

    @Override
    public void update(Make make) {
        makeMapper.update(make);
    }

    @Override
    public void delete(Make make) {
        makeMapper.delete(make.getId());
    }

    @Override
    public void linkMakeAndModel(Long makeId, Long modelId) {
        makeMapper.linkMakeAndModel(makeId, modelId);
    }

    @Override
    public void deleteLinksMakeAndModel(Long makeId) {
        makeMapper.deleteLinksMakeAndModel(makeId);
    }
}
