package test.exception.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.exception.domain.Member;
import test.exception.domain.MemberRepository;
import test.exception.exception.ErrorMessage;
import test.exception.exception.custom.CustomException;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

	private final MemberRepository repository;


	public Member findMember(String name) {
		return repository.findByName(name)
			.orElseThrow(() -> new CustomException(ErrorMessage.MEMBER_NOT_FOUND));
	}

}
