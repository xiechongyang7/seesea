package com.seesea.seeseagateway.entity;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/9/15 上午 1:01
 * @Author xiechongyang
 */
public class ServiceEntity {

    private String serviceId;

    private String serviceName;

    private String serviceRemark;

    private String serviceUrl;

    private boolean isCheck;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceRemark() {
        return serviceRemark;
    }

    public void setServiceRemark(String serviceRemark) {
        this.serviceRemark = serviceRemark;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }
}
