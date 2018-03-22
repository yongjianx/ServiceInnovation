package com.example.skyworthclub.serviceinnovation.Project.model;



/**
 * Created by Awei on 2018/3/22.
 */

public class project {
    public String projectName;
    public String projectStatus;
    public project(){
        projectName=null;
        projectStatus=null;
    }
    public project(String projectName) {
        this.projectName = projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectName() {
        return projectName;

    }
    public String getProjectStatus() {
        return projectStatus;
    }

}
