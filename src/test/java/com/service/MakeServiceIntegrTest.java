package com.service;

import com.api.service.MakeService;
import com.model.Make;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Tests {@link MakeService}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/storage/context-config.xml"})
@Transactional
public class MakeServiceIntegrTest {

    private static Long MAKE_RETRIEVE_ID = 2L;

    @Resource
    private MakeService makeService;

    @Test
    public void testRetrieve() {
        Make expect = makeService.retrieve(MAKE_RETRIEVE_ID);
        assertEquals(MAKE_RETRIEVE_ID, expect.getId());
    }

    @Test
    public void testSave() {
        Make make = new Make();
        make.setName("name");
        makeService.save(make);
        Make expect = makeService.retrieve(make.getId());
        assertNotNull(expect);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSaveWrong() {
        Make make = new Make();
        makeService.save(make);
    }

    @Test
    public void testDelete() {
        makeService.delete(MAKE_RETRIEVE_ID);
        Make expect = makeService.retrieve(MAKE_RETRIEVE_ID);
        assertNull(expect);
    }

    @Test
    public void testUpdate() {
        Make make = makeService.retrieve(MAKE_RETRIEVE_ID);
        make.setName("test");
        makeService.update(make);
        make = makeService.retrieve(MAKE_RETRIEVE_ID);
        assertEquals("test", make.getName());
    }
}
