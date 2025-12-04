package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.RentareaEntity;

public interface RentareaRepository {
//	RentareaEntity findValue(Long id);
	List<RentareaEntity> findValue(Long id);
}
