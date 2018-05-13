package com.example.skyworthclub.serviceinnovation.Project.model;



/**
 * Created by Awei on 2018/3/22.
 */

public class project {
    public String projectName;
    public boolean projectStatus;
    public project(){
        projectName=null;
        projectStatus=false;
    }
    public project(String projectName) {
        this.projectName = projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectStatus(boolean projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectName() {
        return projectName;

    }
    public boolean getProjectStatus() {
        return projectStatus;
    }

}
