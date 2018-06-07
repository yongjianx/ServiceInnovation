package com.example.skyworthclub.serviceinnovation.Project.model;



/**
 * Created by Awei on 2018/3/22.
 */

public class project {
    public String projectName;
    public boolean projectStatus;
    public int proId;
    public int proMony;
    public String pubTime;
    public String proDescription;
    public int proCycle;
    public project(){
        projectName=null;
        projectStatus=false;
        proId = 0;
        proMony = 0;
        pubTime = null;
        proDescription = null;
        proCycle = 0;
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

    public void setProId(int proId) {
        this.proId = proId;
    }
    public int getProId() {
        return proId;
    }

    public void setProMony(int proMony) {
        this.proMony = proMony;
    }

    public int getProMony() {
        return proMony;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProCycle(int proCycle) {
        this.proCycle = proCycle;
    }

    public int getProCycle() {
        return proCycle;
    }
}
