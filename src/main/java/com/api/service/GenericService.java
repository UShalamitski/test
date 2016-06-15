package com.api.service;

import com.model.Make;

/**
 * Base Service class.
 * Date: 06/14/2016
 *
 * @param <T>  The type of objects
 * @author Uladzislau_Shalamitski
 */
public interface GenericService<ID, T> {

    /**
     * Saves object into storage
     *
     * @param object Object to be insert
     */
    void save(T object);

    /**
     * Update object in storage
     *
     * @param object the objects to update
     */
    void update(T object);

    /**
     * Delete object from storage
     *
     * @param id the object identifier to delete
     * @return the removed object
     */
    T delete(ID id);

    /**
     * Retrieves object from storage by identifier
     *
     * @param id the identifier to look for
     * @return the object
     */
    T retrieve(ID id);
}
