package com.api.dao;

import com.model.Make;
import com.model.Model;

/**
 * The DAO for the {@link Make}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public interface MakeDao extends GenericDao<Long, Make>{

    /**
     * Links the {@link Make} and the {@link Model} by id.
     *
     * @param makeId the identifier of make
     * @param modelId the identifier of model
     */
    void linkMakeAndModel(Long makeId, Long modelId);

    /**
     * Delete links betwen the {@link Make} and the {@link Model} by make id.
     *
     * @param makeId the identifier of make
     */
    void deleteLinksMakeAndModel(Long makeId);
}
