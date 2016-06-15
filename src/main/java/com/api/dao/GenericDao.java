package com.api.dao;

/**
 * Base DAO class.
 * Date: 06/14/2016
 *
 * @param <T>  The type of objects
 * @author Uladzislau_Shalamitski
 */
public interface GenericDao<ID, T> {

    /**
     * Inserts object.
     *
     * @param object Object to be insert.
     */
    void insert(T object);

    /**
     * Returns object by id.
     *
     * @param id Id of object
     * @return The object
     */
    T find(ID id);

    /**
     * Updates the object.
     *
     * @param object Object to be update.
     */
    void update(T object);

    /**
     * Deletes the object.
     *
     * @param object object to be deleted,
     */
    void delete(T object);
}
