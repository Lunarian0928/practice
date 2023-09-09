package com.example.demo; // 클래스를 묶는 폴더명

import org.springframework.boot.SpringApplication; // 스프링 부트 기본 모듈
import org.springframework.boot.autoconfigure.SpringBootApplication; // 추가한 라이브러리를 자동적으로 설정하는 모듈

@SpringBootApplication
public class DemoApplication { 
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); // localhost:8080 웹 서버 오픈
	}	
}