package com.hashedin.deploymentTracker.controllers;

import com.hashedin.deploymentTracker.dao.ApplicationDetails;
import com.hashedin.deploymentTracker.services.DeploymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ServiceController {

    @Autowired
    private DeploymentServices deploymentServices;

    @PostMapping("/api/v1/service-details/")
    public  boolean createOrUpdate(@RequestBody ApplicationDetails applicationDetails)
    {
        return  deploymentServices.createOrUpdateApplicationDetail(applicationDetails);
    }

    @GetMapping("/api/v1/service-details/")
    public List<String> getAllServiceList()
    {
        return deploymentServices.getServiceDetails();
    }

    @GetMapping("/api/v1/service-details/{serviceId}")
    public List<ApplicationDetails> getServiceById(@PathVariable String serviceId,
                                                   @RequestParam(required = false) String env){

        if (env != null && !env.trim().isEmpty()) {
            return deploymentServices.getApplicationHistory(serviceId).stream().filter(applicationDetails -> {
                return applicationDetails.getEnv().equalsIgnoreCase(env);
            }).collect(Collectors.toList());
        }
        return deploymentServices.getApplicationHistory(serviceId);
    }

}
