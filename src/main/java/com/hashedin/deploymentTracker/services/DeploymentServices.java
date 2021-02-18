package com.hashedin.deploymentTracker.services;

import com.hashedin.deploymentTracker.dao.ApplicationDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeploymentServices {
    Map<String, List<ApplicationDetails>> applicationsDeployedMap;

    DeploymentServices() {
        applicationsDeployedMap = new HashMap<>();
    }

    public boolean createOrUpdateApplicationDetail(ApplicationDetails applicationDetails) {
        if(!applicationsDeployedMap.containsKey(applicationDetails.getApplicationId())) {
            applicationsDeployedMap.put(applicationDetails.getApplicationId(), new ArrayList<>());
        }
        applicationsDeployedMap.get(applicationDetails.getApplicationId()).add(applicationDetails.clone());
        return true;
    }

    public List<String> getServiceDetails() {
        List<String> serviceDetails = new ArrayList<>();

        for(Map.Entry<String, List<ApplicationDetails>> entry: applicationsDeployedMap.entrySet()) {
            serviceDetails.add(this.getCurrentEntry(entry.getKey()).getName());
        }

        Collections.sort(serviceDetails);
        return serviceDetails;
    }

    public List<ApplicationDetails> getApplicationHistory(String applicationId) {
        if (applicationsDeployedMap.containsKey(applicationId)) {
            return this.applicationsDeployedMap.get(applicationId);
        }
        return new ArrayList<>();
    }

    private ApplicationDetails getCurrentEntry(String applicationId) {
        if (applicationsDeployedMap.containsKey(applicationId)) {
            List<ApplicationDetails> applicationDetails = applicationsDeployedMap.get(applicationId);
            return applicationDetails.get(applicationDetails.size() - 1);
        }
        return null;
    }
}
