package com.app;

import com.api.dao.ModelDao;
import com.api.service.MakeService;
import com.model.Make;
import com.model.Model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class App {

    public static Long MAKE_ID = 1L;

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(App.class);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/com/storage/context-config.xml");
        MakeService makeService = (MakeService) ctx.getBean("makeService");

        Make make = makeService.retrieve(MAKE_ID);
        logger.info("MAKE: "+make.toString());
        for(Model model : make.getModels()){
            logger.info("  MODEL: " + model.toString());
        }
    }
}
