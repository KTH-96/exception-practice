package test.exception.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import test.exception.domain.Member;
import test.exception.service.MemberService;

@RequiredArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/member/{name}")
	public Member findMember (@PathVariable String name) {
		return memberService.findMember(name);
	}

}
