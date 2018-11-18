package com.seesea.seeseauser.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_address.address_id
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    private String addressId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_address.address_user_id
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    private String addressUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_address.address_province
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    private String addressProvince;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_address.address_city
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    private String addressCity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_address.address_area
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    private String addressArea;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_address.address_detail
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    private String addressDetail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_address.address_remark
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    private String addressRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_address
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_address.address_id
     *
     * @return the value of tb_address.address_id
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_address.address_id
     *
     * @param addressId the value for tb_address.address_id
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_address.address_user_id
     *
     * @return the value of tb_address.address_user_id
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public String getAddressUserId() {
        return addressUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_address.address_user_id
     *
     * @param addressUserId the value for tb_address.address_user_id
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public void setAddressUserId(String addressUserId) {
        this.addressUserId = addressUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_address.address_province
     *
     * @return the value of tb_address.address_province
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public String getAddressProvince() {
        return addressProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_address.address_province
     *
     * @param addressProvince the value for tb_address.address_province
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_address.address_city
     *
     * @return the value of tb_address.address_city
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_address.address_city
     *
     * @param addressCity the value for tb_address.address_city
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_address.address_area
     *
     * @return the value of tb_address.address_area
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public String getAddressArea() {
        return addressArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_address.address_area
     *
     * @param addressArea the value for tb_address.address_area
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_address.address_detail
     *
     * @return the value of tb_address.address_detail
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_address.address_detail
     *
     * @param addressDetail the value for tb_address.address_detail
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_address.address_remark
     *
     * @return the value of tb_address.address_remark
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public String getAddressRemark() {
        return addressRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_address.address_remark
     *
     * @param addressRemark the value for tb_address.address_remark
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    public void setAddressRemark(String addressRemark) {
        this.addressRemark = addressRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Tue Oct 02 16:42:40 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addressId=").append(addressId);
        sb.append(", addressUserId=").append(addressUserId);
        sb.append(", addressProvince=").append(addressProvince);
        sb.append(", addressCity=").append(addressCity);
        sb.append(", addressArea=").append(addressArea);
        sb.append(", addressDetail=").append(addressDetail);
        sb.append(", addressRemark=").append(addressRemark);
        sb.append("]");
        return sb.toString();
    }
}