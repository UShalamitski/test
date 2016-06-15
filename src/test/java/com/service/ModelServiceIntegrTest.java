package com.service;

import com.api.service.ModelService;
import com.model.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Tests {@link ModelService}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/storage/context-config.xml"})
@Transactional
public class ModelServiceIntegrTest {

    private static Long MAKE_RETRIEVE_ID = 2L;

    @Resource
    private ModelService modelService;

    @Test
    public void testRetrieve() {
        Model expect = modelService.retrieve(MAKE_RETRIEVE_ID);
        assertEquals(MAKE_RETRIEVE_ID, expect.getId());
    }

    @Test
    public void testSave() {
        Model model = new Model();
        model.setName("name");
        model.setStartDate(new Date());
        modelService.save(model);
        Model expect = modelService.retrieve(model.getId());
        assertNotNull(expect);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSaveWrong() {
        Model model = new Model();
        modelService.save(model);
    }

    @Test
    public void testDelete() {
        modelService.delete(MAKE_RETRIEVE_ID);
        Model expect = modelService.retrieve(MAKE_RETRIEVE_ID);
        assertNull(expect);
    }

    @Test
    public void testUpdate() {
        Model model = modelService.retrieve(MAKE_RETRIEVE_ID);
        model.setName("test");
        modelService.update(model);
        model = modelService.retrieve(MAKE_RETRIEVE_ID);
        assertEquals("test", model.getName());
    }
}
