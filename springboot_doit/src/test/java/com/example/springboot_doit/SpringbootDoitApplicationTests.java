package com.example.springboot_doit;

import com.example.springboot_doit.question.Question;
import com.example.springboot_doit.question.QuestionRepository;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDoitApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

//	@Transactional
	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("스프링 부트 모델 질문입니다.");
		q2.setContent("id는 자동 생성이 되나요?");
		q2.setCreateDate(LocalTime.now());
		questionRepository.save(q2);
	}

}
