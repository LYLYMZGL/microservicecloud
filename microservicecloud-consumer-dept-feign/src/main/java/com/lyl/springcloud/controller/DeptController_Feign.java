package com.lyl.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyl.springcloud.entity.Dept;
import com.lyl.springcloud.service.DeptClientService;

@RestController
public class DeptController_Feign {
	@Autowired
	private DeptClientService deptClientService;
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.deptClientService.get(id);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return this.deptClientService.list();
	}
	
	@RequestMapping(value="/consumer/dept/add")
	public Object add(Dept dept) {
		return this.deptClientService.add(dept);
	}
}
