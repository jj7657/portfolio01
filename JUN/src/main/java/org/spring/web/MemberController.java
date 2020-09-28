package org.spring.web;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.web.service.MemberService;
import org.spring.web.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/member")
@SessionAttributes("login")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService mservice;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void loginGet() {
		logger.info("login get ==========");
	}
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public String loginPost(MemberVO vo ,Model model,RedirectAttributes ra) throws Exception{
		logger.info("login post ==========");
		logger.info("vo = "+vo);
		
		MemberVO userVO =  mservice.login(vo);
		logger.info("userVO = "+userVO);
		if (userVO == null) {
			ra.addFlashAttribute("msg", "로그인실패");
			return "redirect:/web/member/login";
		}
		model.addAttribute("login", userVO);
		return "redirect:/";
	}
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public void joinGet() {
		logger.info("join get ==========");
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String joinPost(MemberVO vo,RedirectAttributes ra) throws Exception {
		logger.info("join post ==========\n");
		System.out.println(vo);
		mservice.createMember(vo);
		ra.addFlashAttribute("msg", "가입성공");
		return "redirect:/";
	}
	@RequestMapping(value="/logout")
	public String logout (SessionStatus sessionStatus) {
		logger.info("logout ============");
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGet(@SessionAttribute("login")MemberVO login, Model model) throws Exception {
		logger.info("modify get ============\n");
		System.out.println("login"+login);
		model.addAttribute("memberVO", mservice.memberRead(login));
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPost(@ModelAttribute("login") MemberVO vo ,@Param("pw")String pw,RedirectAttributes ra,SessionStatus sessionStatus) throws Exception {
		logger.info("modify post ============\n");
		System.out.println(vo);
		if(mservice.login(vo)!=null) {
			vo.setUserpw(pw);
			System.out.println("변경한vo"+vo);
			mservice.updateMember(vo);
			sessionStatus.setComplete();
			ra.addFlashAttribute("msg", "회원정보가 수정되었습니다");
			return "redirect:/";
		}else {
			ra.addFlashAttribute("msg", "회원정보수정실패 ");
			return "redirect:/member/modify";
		}
	}
	
	@RequestMapping(value="/delete")
	public String delete (SessionStatus sessionStatus) {
		logger.info("logout ============");
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
}
