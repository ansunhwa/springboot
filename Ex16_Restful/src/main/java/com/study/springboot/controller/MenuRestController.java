package com.study.springboot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Menu;
import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;
import com.study.springboot.service.MenuService;

@RestController
@RequestMapping("/menu")     //어떠한 매핑이 들어오든 menu밑에 html
public class MenuRestController {
	
	@Autowired
	MenuService menuService;
	
	@GetMapping
	public List<Menu> menuAllList() {
		return menuService.menuAllList();		
	}
	
	// /menu/type/${e.target.value} 여기 Path로 받아옴
	// /menu/type/KR  /menu/type/CH  /menu/type/JP
	// {변수명} : URL의 변수로서 클라이언트가 요청할 때 경로에 포함된 값을 파라미터로 전달
	@GetMapping("/type/{type}")   //type/kr, ch, jp가 들어옴
	public List<Menu> findByType(@PathVariable(name="type") Type type) { //내가 만들어둔 타입
		return menuService.findByType(type);
	}
	
	// /menu/type/${type}/taste/${taste}
	@GetMapping("/type/{type}/taste/{taste}")
	public List<Menu> findByTypeAndTaste(@PathVariable(name="type") Type type ,
										@PathVariable(name="taste") Taste taste) {  //각각 내가 넣은 조건(Mapping)에 맞는 값 가져오기
		return menuService.findByTypeAndTaste(type, taste);
	}
	
/*	
	@GetMapping("/{id}")
	public String idSelect(@PathVariable(name="id") Long id, Model model) {
		Optional<Menu> result = menuService.idSelect(id);
		if(result.isPresent()) {
			model.addAttribute("idSelect",result.get());
		} else {
			model.addAttribute("idSelect", null);
		}
		return menuService.findById(id).get();
	}
	*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Menu> findById(@PathVariable(name="id") Long id) {
		Optional<Menu> menu = menuService.findById(id);
		
		if(menu.isPresent()) {  // 200번 ok
			return ResponseEntity.ok().body(menu.get());
		} else {	// 404처리
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping()
	public ResponseEntity<?> insertMenu(@RequestBody Menu menu) {
		Menu reMenu = menuService.insertMenu(menu);
		return ResponseEntity.created(URI.create("/menu/" + reMenu.getId())).build();
	}
	
	@PutMapping()
	public ResponseEntity<?> updateMenu(@RequestBody Menu menu) {
		Menu reMenu = menuService.insertMenu(menu);    //save()는 삭제 수정 같이 해주니 새로 만들지 말고 같이 써도 된다
		return ResponseEntity.ok(reMenu);
	}
	
	
	
	/*
	 * // 없는 id를 넣어서 오류가 났을 때 500(서버측오류) 가 뜸
		// 사용자의 잘못인 것(400번대 오류가 나야함)
		 * 
	 * ResponseEntity : 결과 데이터와 HTTP상태코드와 오류코드까지 직접 제어할 수 있는 클래스
	 * 					(HttpRequest에 대한 응답 데이터가 포함되어 있음)
	 *   - status : 응답에 대한 status코드
	 *   - header : header값 (요청/대응)에 대한 요구사항
	 *   - body : 메세지 body에 작성될 내용(요구사항의 내용)
	 * 
	 * ResponseEntity 사용법
	 *   - status와 body를 이용
	 *     ResponseEntity.status(상태코드).body(객체)
	 *     
	 *     + 상태코드는 HttpStatus에 정의된 값 이용
	 *     
	 *     + 상태코드 OK 와 body를 한번에 사용
	 *     	 ResponseEntity.ok.body(menu)
	 *     
	 *     + body가 없을 때, build() 사용
	 *     	 ResponseEntity.status(HttpStatus.Not_FOUND).build()
	 *     
	 *     + notFound() : 404
	 *     
	 */
	

}
