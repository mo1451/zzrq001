package com.zzrq.lom.dto;

import javax.persistence.Table;

@Table(name = "alarm_detail")
public class AlarmDetail {
    private Long  id;
    private Long  alarmId;
    private Long nodeId;
    private Long gatewayId;
    private Long sensorNumber;
    private String nodeName;
    private String gatewayNeme;
    private String userName;
    private Long phoneNumber;
    private String address;

    @Override
    public String toString() {
        return "AlarmDetail{" +
                "id=" + id +
                ", alarmId=" + alarmId +
                ", nodeId=" + nodeId +
                ", gatewayId=" + gatewayId +
                ", sensorNumber=" + sensorNumber +
                ", nodeName='" + nodeName + '\'' +
                ", gatewayNeme='" + gatewayNeme + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Long gatewayId) {
        this.gatewayId = gatewayId;
    }

    public Long getSensorNumber() {
        return sensorNumber;
    }

    public void setSensorNumber(Long sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getGatewayNeme() {
        return gatewayNeme;
    }

    public void setGatewayNeme(String gatewayNeme) {
        this.gatewayNeme = gatewayNeme;
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
