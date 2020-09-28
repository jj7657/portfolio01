package org.spring.web;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.web.service.ReplyService;
import org.spring.web.vo.Criteria;
import org.spring.web.vo.MemberVO;
import org.spring.web.vo.PageVO;
import org.spring.web.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequestMapping(value="/reply")
@SessionAttributes("login")
public class ReplyController {

	private final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService rservice;
	
	@RequestMapping(value="/read/{bno}/{page}" , method=RequestMethod.GET)
	public ResponseEntity<PageVO> replyRead(@PathVariable("bno") Integer bno,@PathVariable("page") int page) throws Exception {
		logger.info("read =========== "+bno);
		//페이지당 10개 불러오기
		Criteria cri = new Criteria(page,10);
		System.out.println(cri);
		return new ResponseEntity<PageVO>(rservice.list(bno,cri),HttpStatus.OK);
	}
	@RequestMapping(value="/create/{bno}" , method=RequestMethod.POST)
	public ResponseEntity<String> replyCreate(@PathVariable("bno") int bno,@ModelAttribute("login") MemberVO login,@RequestBody ReplyVO vo) throws Exception {
		logger.info("reply create =========== "+bno+" / "+login.getUsername());
		System.out.println(vo);
		ResponseEntity<String> entity = null;
		if(login.getUsername()!=null) {
			vo.setReplyer(login.getUsername());
			rservice.create(vo);
			logger.info("reply create success");
			entity= new ResponseEntity<String>("success",HttpStatus.OK);
			return entity;
		}
		return new ResponseEntity<String>("fail",HttpStatus.OK);
	}

	
}
