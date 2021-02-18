package com.hashedin.deploymentTracker.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ApplicationDetails {

    private String applicationId;

    private String name;

    private String env;

    private Timestamp tmpStamp;

    private String technology;

    private String userName;

    private String version;

    private String gitBranch;

    public ApplicationDetails clone() {
        return new ApplicationDetails(this.applicationId, this.name, this.env, this.tmpStamp, this.technology,
                this.userName, this.version, this.gitBranch);
    }

}
