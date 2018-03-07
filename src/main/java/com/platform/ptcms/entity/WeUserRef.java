package com.platform.ptcms.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class WeUserRef {
	
	@Id
	private String id;
	private String weId;
	private String userId;
	private Timestamp createTime;
	private String sign;
	
}
