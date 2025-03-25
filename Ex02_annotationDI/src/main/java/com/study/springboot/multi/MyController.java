package com.study.springboot.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @Controller : bean으로 등록
 * 				 어떠한 기능을 수행하는 경우에 붙여줌
 * 			* 주입되어 사용되는 경우 @Component
 */
@Controller
public class MyController {
	/*
	@RequestMapping("/")  //get, post의 method를 모두 받음 /루트
	public @ResponseBody String root() {  //@ResponseBody : html이 아닌 일반 문자를 반환할 때
		return "Annotation 사용하기";  
	}
	*/
	
	@Autowired  //객체생성된 것의 주소가 들어옴 지금 / 생성된거 person, A, B
	Person Person1;  // Person Person1 = new Person() 한거임
	
	@Autowired
	@Qualifier("printerB")
	Printer printer;
	
	@Autowired
	Person Person2; 
	
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		Person1.printer();
		
		Person1.setPrinter(printer);
		
		if(Person1 == Person2) {
			System.out.println("동일한객체");
		} else {
			System.out.println("다른 객체");
		}
		return "Annotation사용하기";
	}
	
}
