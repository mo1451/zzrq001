package com.zzrq.lom.dto;

import javax.persistence.Table;
import java.util.Date;
/**
 * @author mo1451
 */
@Table(name = "alarm_history")
public class AlarmHistory {
    private Long  id;
    private Long  alarmId;
    private Date alarmDate;
    private Date alarmProcessingDate;
    private Integer alarmProcessingStatus;

    @Override
    public String toString() {
        return "AlarmHistory{" +
                "id=" + id +
                ", alarmId=" + alarmId +
                ", alarmDate=" + alarmDate +
                ", alarmProcessingDate=" + alarmProcessingDate +
                ", alarmProcessingStatus='" + alarmProcessingStatus + '\'' +
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

