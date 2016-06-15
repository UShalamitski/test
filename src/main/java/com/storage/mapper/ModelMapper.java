package com.storage.mapper;

import com.model.Model;
import org.apache.ibatis.annotations.Param;

/**
 * The model {@link Model} mapper.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public interface ModelMapper {
    /**
     * Stores {@link Model} instance into database.
     *
     * @param model the model to store
     */
    void store(Model model);

    /**
     * Gets the {@link Model} instance from database.
     *
     * @param id the identifier of model to find
     * @return the found instance of {@link Model}
     */
    Model find(Long id);

    /**
     * Updates the {@link Model} instance in database.
     *
     * @param model the instance of model to update
     */
    void update(Model model);

    /**
     * Deletes the {@link Model} instance from database.
     *
     * @param id the identifier of make to delete
     */
    void delete(@Param("id") Long id);
}
