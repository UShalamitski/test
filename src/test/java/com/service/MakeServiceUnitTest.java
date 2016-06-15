package com.service;

import com.api.dao.MakeDao;
import com.api.service.MakeService;
import com.model.Make;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

/**
 * Tests {@link MakeService}.
 * Date: 06/14/2016
 *
 * @author Uladzislau_Shalamitski
 */
public class MakeServiceUnitTest {

    private static Long MAKE_ID = 1L;
    private static Long MAKE_ID_NULL = 100L;

    private MakeServiceImpl makeService;
    private MakeDao makeDao;

    @Before
    public void setUp() {
        makeService = new MakeServiceImpl();
        makeDao = createMock(MakeDao.class);
        makeService.setMakeDao(makeDao);
    }

    @Test
    public void testRetrieve() {
        Make make = new Make();
        make.setId(MAKE_ID);
        expect(makeDao.find(make.getId())).andReturn(make);
        replay(makeDao);

        Make m = makeService.retrieve(make.getId());
        assertEquals(m.getId(), make.getId());
        verify(makeDao);
    }

    @Test
    public void testRetrieveNull() {
        expect(makeDao.find(MAKE_ID_NULL)).andReturn(null);
        replay(makeDao);

        Make m = makeService.retrieve(MAKE_ID_NULL);
        assertNull(m);
        verify(makeDao);
    }

    @Test
    public void testInsert() {
        Make make = new Make();
        make.setId(MAKE_ID);
        makeDao.insert(make);
        replay(makeDao);

        makeService.save(make);
        verify(makeDao);
    }

    @Test
    public void testDelete() {
        Make make = new Make();
        make.setId(MAKE_ID);
        expect(makeDao.find(MAKE_ID)).andReturn(make);
        makeDao.delete(make);
        replay(makeDao);

        Make m = makeService.delete(MAKE_ID);
        assertNotNull(m);
        verify(makeDao);
    }

    @Test
    public void testDeleteNull() {
        Make make = new Make();
        make.setId(MAKE_ID_NULL);
        expect(makeDao.find(MAKE_ID_NULL)).andReturn(null);
        makeDao.delete(make);
        replay(makeDao);

        Make m = makeService.delete(MAKE_ID_NULL);
        assertNull(m);
    }
}
