package com.zzrq.lom.sys.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: mo1451
 * @Date: 2019/04/06 18:13
 */
@Table(name = "sys_config")
public class SysConfig {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long  id;
    private String name;
    private String value;
    private Date creationDate;
    private Date lastupdateDate;

    @Override
    public String toString() {
        return "SysConfig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
