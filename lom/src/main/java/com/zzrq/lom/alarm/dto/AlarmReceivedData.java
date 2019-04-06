package com.zzrq.lom.alarm.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: mo1451
 * @Date: 2019/04/06 18:06
 */
@Table(name = "alarm_received_data")
public class AlarmReceivedData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long  id;
    private String productKey;
    private String deviceName;
    private String propBool;
    private String propControl;
    private String propSensor;
    private Date creationDate;
    private Date lastupdateDate;

    @Override
    public String toString() {
        return "AlarmReceivedData{" +
                "id=" + id +
                ", productKey='" + productKey + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", propBool='" + propBool + '\'' +
                ", propControl='" + propControl + '\'' +
                ", propSensor='" + propSensor + '\'' +
                ", creationDate=" + creationDate +
                ", lastupdateDate=" + lastupdateDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getPropBool() {
        return propBool;
    }

    public void setPropBool(String propBool) {
        this.propBool = propBool;
    }

    public String getPropControl() {
        return propControl;
    }

    public void setPropControl(String propControl) {
        this.propControl = propControl;
    }

    public String getPropSensor() {
        return propSensor;
    }

    public void setPropSensor(String propSensor) {
        this.propSensor = propSensor;
    }

    public String getDeviceName() {

        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastupdateDate() {
        return lastupdateDate;
    }

    public void setLastupdateDate(Date lastupdateDate) {
        this.lastupdateDate = lastupdateDate;
    }
}
