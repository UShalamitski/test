package com.storage.mapper;

import com.model.Make;
import com.model.Model;
import org.apache.ibatis.annotations.Param;

/**
 * The make {@link Make} mapper.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public interface MakeMapper {

    /**
     * Stores {@link Make} instance into database.
     *
     * @param make the make to store
     */
    void store(Make make);

    /**
     * Gets the {@link Make} instance from database.
     *
     * @param id the identifier of make to find
     * @return the found instance of {@link Make}
     */
    Make find(Long id);

    /**
     * Updates the {@link Make} instance in database.
     *
     * @param make the instance of make to update
     */
    void update(Make make);

    /**
     * Deletes the {@link Make} instance from database.
     *
     * @param id the identifier of make to delete
     */
    void delete(@Param("id") Long id);

    /**
     * Links the {@link Make} and the {@link com.model.Model} by id.
     *
     * @param makeId the identifier of make
     * @param modelId the identifier of model
     */
    void linkMakeAndModel(@Param("makeId") Long makeId, @Param("modelId") Long modelId);

    /**
     * Delete Links between Make and Model
     *
     * @param makeId the identifier of make
     */
    void deleteLinksMakeAndModel(@Param("makeId") Long makeId);
}
