package com.stackroute.service;

import com.stackroute.domain.ServiceProvider;
import com.stackroute.dto.ServiceProviderDto;
import com.stackroute.exception.GlobalException;
import com.stackroute.repository.ServiceProviderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{

    private ServiceProviderRepository serviceProviderRepository;
    private RabbitTemplate amqpTemplate;

    /**
     * Constructor based Dependency injection to inject TrackRepository here
     */
    @Autowired
    public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository, RabbitTemplate amqpTemplate) {
        this.serviceProviderRepository = serviceProviderRepository;
        this.amqpTemplate = amqpTemplate;
    }


    @Value("${sp.rabbitmq.exchange}")
    public String exchange;

    @Value("${sp.rabbitmq.routingkey}")
    public String routingkey;

    @Override
    public ServiceProvider saveServiceProvider(ServiceProviderDto provider)  {

        amqpTemplate.convertAndSend(exchange, routingkey, provider);

        ServiceProvider sp = new ServiceProvider();
        sp.setName(provider.getUserName());
        sp.setEmail(provider.getEmail());

        return serviceProviderRepository.save(sp);
    }

    @Override
    public ServiceProvider getTheProfile() {

        return null;
    }

    @Override
    public ServiceProvider updateTheProfile() {
        return null;
    }
}
