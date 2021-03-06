package com.zzrq.lom.alarm.dto;

import javax.persistence.*;
import java.util.Date;


/**
 * @author mo1451
 */
@Table(name = "alarm_detail")
public class AlarmDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long  id;
    private String  alarmId;
    private String nodeId;
    private String gatewayId;
    /**
     * 传感器
     */
    private String sensorNumber;
    /**
     * 控制器
     */
    private String nodeName;
    /**
     * 设备
     */
    private String gatewayName;
    private String userName;
    private Long phoneNumber;
    private String address;
    private Double longitude;
    private Double latitude;
    @Transient
    private Integer alarmProcessingStatus;
    @Transient
    private Date alarmDate;
    @Transient
    private Date alarmProcessingDate;

    @Override
    public String toString() {
        return "AlarmDetail{" +
                "id=" + id +
                ", alarmId=" + alarmId +
                ", nodeId=" + nodeId +
                ", gatewayId=" + gatewayId +
                ", sensorNumber='" + sensorNumber + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", gatewayName='" + gatewayName + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", alarmProcessingStatus=" + alarmProcessingStatus +
                ", alarmDate=" + alarmDate +
                ", alarmProcessingDate=" + alarmProcessingDate +
                '}';
    }

    public Date getAlarmProcessingDate() {
        return alarmProcessingDate;
    }

    public void setAlarmProcessingDate(Date alarmProcessingDate) {
        this.alarmProcessingDate = alarmProcessingDate;
    }

    public Date getAlarmDate() {

        return alarmDate;
    }

    public void setAlarmDate(Date alarmDate) {
        this.alarmDate = alarmDate;
    }

    public Integer getAlarmProcessingStatus() {
        return alarmProcessingStatus;
    }

    public void setAlarmProcessingStatus(Integer alarmProcessingStatus) {
        this.alarmProcessingStatus = alarmProcessingStatus;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getSensorNumber() {
        return sensorNumber;
    }

    public void setSensorNumber(String sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
