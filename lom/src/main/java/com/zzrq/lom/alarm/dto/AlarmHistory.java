package com.zzrq.lom.alarm.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * @author mo1451
 */
@Table(name = "alarm_history")
public class AlarmHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long  id;
    private Long  alarmId;
    private Date alarmDate;
    private Date alarmProcessingDate;
    private Integer alarmProcessingStatus;
    @Transient
    private Integer count;
    @Transient
    private String groupName;
    @Transient
    private Integer groupDate;
    @Transient
    private Integer firstMonth;

    @Override
    public String toString() {
        return "AlarmHistory{" +
                "id=" + id +
                ", alarmId=" + alarmId +
                ", alarmDate=" + alarmDate +
                ", alarmProcessingDate=" + alarmProcessingDate +
                ", alarmProcessingStatus=" + alarmProcessingStatus +
                ", count=" + count +
                ", groupName='" + groupName + '\'' +
                ", groupDate=" + groupDate +
                ", firstMonth=" + firstMonth +
                '}';
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupDate() {
        return groupDate;
    }

    public void setGroupDate(Integer groupDate) {
        this.groupDate = groupDate;
    }

    public Integer getFirstMonth() {
        return firstMonth;
    }

    public void setFirstMonth(Integer firstMonth) {
        this.firstMonth = firstMonth;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public Date getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(Date alarmDate) {
        this.alarmDate = alarmDate;
    }

    public Date getAlarmProcessingDate() {
        return alarmProcessingDate;
    }

    public void setAlarmProcessingDate(Date alarmProcessingDate) {
        this.alarmProcessingDate = alarmProcessingDate;
    }

    public Integer getAlarmProcessingStatus() {
        return alarmProcessingStatus;
    }

    public void setAlarmProcessingStatus(Integer alarmProcessingStatus) {
        this.alarmProcessingStatus = alarmProcessingStatus;
    }
}

