package com.stackroute.controller;


import com.stackroute.domain.ServiceProvider;
import com.stackroute.dto.ServiceProviderDto;
import com.stackroute.exception.UserAlreadyFoundException;
import com.stackroute.service.ServiceProviderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
public class ServiceProviderController {

    private ServiceProviderService serviceProviderService;


    /**
     * Constructor based Dependency injection to inject TrackService into controller
     */
    @Autowired
    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;

    }

    /**
     * PostMapping Annotation for mapping HTTP POST requests onto specific handler methods.
     */
    @PostMapping("spdto")
    public ResponseEntity<?> saveTheUser(@RequestBody ServiceProviderDto provider) throws UserAlreadyFoundException {

        return new ResponseEntity<>(serviceProviderService.saveServiceProvider(provider), HttpStatus.CREATED);

    }

    /**
     * GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
     */

    @GetMapping("serviceprovider")
    public ResponseEntity<?> getTheUser() throws Exception{
        return new ResponseEntity<ServiceProvider>(serviceProviderService.getTheProfile(),HttpStatus.FOUND);

    }

    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     */
    @PutMapping("serviceprovider")
    public ResponseEntity<?> updateTheUser() throws Exception{
        return new ResponseEntity<ServiceProvider>(serviceProviderService.updateTheProfile(),HttpStatus.OK);
    }


}
