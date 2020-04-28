package com.occamsrazor.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController //url 처리하는 컨트롤러
@RequestMapping("/member") //요청하는 url
public class AdminController {
	@Autowired AdminService memberService; //spring container의 autowired가 bean을 자동으로 주입한다 
	
		@PostMapping("/join")
		public Messenger add(@RequestBody Admin member) { //controller는 무조건 응답(return)이 있어야 한다
			int current = memberService.count();
			memberService.add(member);
			return (memberService.count()==current+1)?Messenger.SUCCESS:Messenger.FAIL; //return타입은 객체로
		}

		@PostMapping("/login")
		public Messenger login(@RequestBody Admin member) {
			return memberService.login(member)?Messenger.SUCCESS:Messenger.FAIL;
		}
		

		
		@GetMapping("/count")
		public int count() {
			return memberService.count();
		}
		
	

}