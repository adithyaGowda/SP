package com.stackroute.service;

import com.stackroute.domain.ServiceProvider;
import com.stackroute.dto.ServiceProviderDto;

public interface ServiceProviderService {


    /**
     * AbstractMethod to save  ServiceProvider
     */
    ServiceProvider saveServiceProvider(ServiceProviderDto provider);

    /**
     * AbstractMethod to get  ServiceProvider
     */
    ServiceProvider getTheProfile();

    /**
     * AbstractMethod to update  ServiceProvider
     */
    ServiceProvider updateTheProfile();
}
