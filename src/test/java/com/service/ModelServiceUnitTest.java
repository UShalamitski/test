package com.service;

import com.api.dao.ModelDao;
import com.api.service.ModelService;
import com.model.Model;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * Tests {@link ModelService}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public class ModelServiceUnitTest {

    private static Long MODEL_ID = 1L;
    private static Long MODEL_ID_NULL = 100L;

    private ModelServiceImpl modelService;
    private ModelDao modelDao;

    @Before
    public void setUp() {
        modelService = new ModelServiceImpl();
        modelDao = createMock(ModelDao.class);
        modelService.setModelDao(modelDao);
    }

    @Test
    public void testRetrieve() {
        Model model = new Model();
        model.setId(MODEL_ID);
        expect(modelDao.find(model.getId())).andReturn(model);
        replay(modelDao);

        Model m = modelService.retrieve(model.getId());
        assertEquals(m.getId(), model.getId());
        verify(modelDao);
    }

    @Test
    public void testRetrieveNull() {
        expect(modelDao.find(MODEL_ID_NULL)).andReturn(null);
        replay(modelDao);

        Model m = modelService.retrieve(MODEL_ID_NULL);
        assertNull(m);
        verify(modelDao);
    }

    @Test
    public void testUpdate() {
        Model model = new Model();
        model.setId(MODEL_ID);
        modelDao.update(model);
        replay(modelDao);

        modelService.update(model);
        verify(modelDao);
    }

    @Test
    public void testInsert() {
        Model model = new Model();
        model.setId(MODEL_ID);
        modelDao.insert(model);
        replay(modelDao);

        modelService.save(model);
        verify(modelDao);
    }

    @Test
    public void testDelete() {
        Model model = new Model();
        model.setId(MODEL_ID);
        expect(modelDao.find(MODEL_ID)).andReturn(model);
        modelDao.delete(model);
        replay(modelDao);

        Model m = modelService.delete(MODEL_ID);
        assertNotNull(m);
        verify(modelDao);
    }

    @Test
    public void testDeleteNull() {
        Model model = new Model();
        model.setId(MODEL_ID_NULL);
        expect(modelDao.find(MODEL_ID_NULL)).andReturn(null);
        modelDao.delete(model);
        replay(modelDao);

        Model m = modelService.delete(MODEL_ID_NULL);
        assertNull(m);
    }
}
