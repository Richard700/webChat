package com.chat.webservice.businesslayer;

import com.chat.dao.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vlad
 * Date: 03.06.15_14:48
 */
public class ServiceFactory implements ServiceFactoryI {

    @Autowired
    private RepositoryFactory repositoryFactory;

}
