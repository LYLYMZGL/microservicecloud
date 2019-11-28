package com.lyl.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lyl.springcloud.entity.Dept;

//@FeignClient(value="MICROSERVICECLOUD-DEPT")
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	@GetMapping(value="/dept/get/{id}")
	public Dept get(@PathVariable("id") long id);
	
	@GetMapping(value="/dept/list")
	public List<Dept> list();
	
	@PostMapping(value="/dept/add")
	public boolean add(Dept dept);
}
