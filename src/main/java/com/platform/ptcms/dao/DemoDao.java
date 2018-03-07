package com.platform.ptcms.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.platform.ptcms.entity.WeUserRef;

@Component
public interface DemoDao extends 
JpaRepository<WeUserRef, String>,
JpaSpecificationExecutor<WeUserRef>,Serializable{
	
	  @Query("select w from WeUserRef w where w.weId = :id")
	  WeUserRef findByid(@Param("id") String id);
}
