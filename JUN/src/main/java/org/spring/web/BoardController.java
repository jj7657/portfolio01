package org.spring.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.web.service.BoardService;
import org.spring.web.vo.BoardVO;
import org.spring.web.vo.Criteria;
import org.spring.web.vo.MemberVO;
import org.spring.web.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/board")
@SessionAttributes({"login","page"})
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService bservice;

	@RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
	public String boardlist(@PathVariable("page")Integer page, Model model) throws Exception {
		logger.info("list get ===============");
		model.addAttribute("page", page);
		
		// 현재시간
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		Date now = new Date();
		model.addAttribute("time", sdf.format(now));
		
		Criteria cri = new Criteria(page,10);
		System.out.println(bservice.listAll(cri));
		model.addAttribute("pagevo", bservice.listAll(cri));
		
		return "board/boardList";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String boardwriteGet() {
		logger.info("write get ===============");
		return "board/boardWrite";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String boardwritePost(BoardVO vo,@ModelAttribute("login") MemberVO login,@ModelAttribute("page")Integer page) throws Exception {
		logger.info("write post ===============" + vo);
		System.out.println("세션"+login);
		vo.setWriter(login.getUsername());
		bservice.create(vo);
		return "redirect:/board/list/"+page;
	}

	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String boardreadGet(BoardVO vo, Model model) throws Exception {
		logger.info("read get ===============" + vo);
		bservice.plusViewCnt(vo);
		model.addAttribute("read", bservice.read(vo));
		return "board/boardRead";
	}

	@RequestMapping(value = "/modify/{bno}", method = RequestMethod.GET)
	public String boardmodifyGet(BoardVO vo, Model model) throws Exception {
		logger.info("modify get ===============" + vo);
		logger.info("read result" + bservice.read(vo));
		model.addAttribute("read", bservice.read(vo));
		return "board/boardModify";
	}

	@RequestMapping(value = "/modify/{bno}", method = RequestMethod.POST)
	public String boardmodifyPost(BoardVO vo, Model model) throws Exception {
		logger.info("modify post ===============" + vo);
		bservice.update(vo);
		return "redirect:/board/read";
	}
	
	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.GET)
	public String delete(BoardVO vo,@ModelAttribute("page")Integer page) throws Exception {
		logger.info("delete get ===============" + vo);
		bservice.delete(vo);
		return "redirect:/board/list/"+page;
	}
	
	@RequestMapping(value = "/like/{bno}" , method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> likePost(BoardVO vo) throws Exception {
		logger.info("like post ===============" + vo);
		Integer a = bservice.plusLikeCnt(vo);
		System.out.println(a);
		return new  ResponseEntity<Integer>(a,HttpStatus.OK);
	}

}