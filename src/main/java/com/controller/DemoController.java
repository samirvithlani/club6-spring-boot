package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.DemoBean;

//component
//service
//repository
//controller --> RestController

@RestController
public class DemoController {

	public static List<DemoBean> demos;

	@GetMapping("/test")
	public String test() {

		return "Hello world";
	}

	@GetMapping("/json")
	public ResponseEntity<?> getJsonData() {
		DemoBean demoBean = new DemoBean(101, "kunal");
		demoBean.setId(101);
		demoBean.setName("ram");

		return new ResponseEntity<DemoBean>(demoBean, HttpStatus.OK);
	}

	@GetMapping("/jsonarray")
	public ResponseEntity<List<DemoBean>> jsonArraay() {

		demos = new ArrayList<>();
		demos.add(new DemoBean(101, "ram"));
		demos.add(new DemoBean(102, "parth"));
		demos.add(new DemoBean(103, "kunal"));

		return new ResponseEntity<List<DemoBean>>(demos, HttpStatus.OK);

	}

	@PostMapping("/adddemo")
	public ResponseEntity<?> addDemo(@RequestBody DemoBean demoBean) {

		demos.add(demoBean); //4

		return new ResponseEntity<List<DemoBean>>(demos, HttpStatus.OK); //4

	}

}
