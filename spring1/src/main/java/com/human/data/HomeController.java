package com.human.data;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.lang.model.element.ModuleElement;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	  @RequestMapping("/list") public String doList(Model model) { iEmployee emp
	  =sqlSession.getMapper(iEmployee.class); ArrayList<empDTO>
	  emplist=emp.listEmpLoyees();
	  System.out.println("empList count="+emplist.size());
	  model.addAttribute("list",emplist);
	  
	  return "list"; }
	  
	  @RequestMapping("/menulist") public String doMenulist(Model model) 
	  {
	  imenu menu =sqlSession.getMapper(imenu.class); ArrayList<menuDTO>
	  menulist=menu.listmenu(); model.addAttribute("menulist",menulist); 
	  return "menulist"; 
	  }

	@RequestMapping("/find/{eid}")
	public String doMenulist(@PathVariable int eid,Model model) {
		iEmployee emp=sqlSession.getMapper(iEmployee.class);
		EmpDAO minfo =new EmpDAO(emp);
		Memberinfo mi =minfo.getMemberinfo(eid);
		model.addAttribute("mi", mi);
		return "find";
	}
	@RequestMapping("/addnew")
	public String doAddNew(Model model) {
		imenu menu =sqlSession.getMapper(imenu.class); ArrayList<menuDTO>
		 menulist=menu.listmenu(); model.addAttribute("menulist",menulist); 
		return "addnew";
	}
	@RequestMapping(value="/addMenu",method=RequestMethod.POST)
	public String doAddMenu(@RequestParam String mname,@RequestParam int price,Model model) {
		imenu im=sqlSession.getMapper(imenu.class);
		im.insert(mname,price);
		System.out.println("현재"+mname);
		System.out.println(price);
		return "redirect:/addnew";
	}
	@RequestMapping("delete")
	public String doDeleteMenu(HttpServletRequest req) {
		imenu im=sqlSession.getMapper(imenu.class);
		
		im.delete(Integer.parseInt(req.getParameter("seqno")));
		return "redirect:/addnew";
	}
	@RequestMapping("/view")
	public String doView(@RequestParam int seqno,Model model) {
		imenu im=sqlSession.getMapper(imenu.class);
		menuDTO mdto =im.viewMenu(seqno);
		model.addAttribute("mdto",mdto);
		return "view";
	}
	@RequestMapping("/update")
	public String doUpdate(HttpServletRequest req,Model model) {
		String name=req.getParameter("name");
		int price=Integer.parseInt(req.getParameter("price"));
		int seqno=Integer.parseInt(req.getParameter("seqno"));
		imenu im=sqlSession.getMapper(imenu.class);
		im.update(name,price,seqno);
		return "redirect:/addnew";
	}
	
	@RequestMapping("/tmember")
	public String dotmember(Model model) {
		itmember tmember =sqlSession.getMapper(itmember.class);
		ArrayList<TmemberDTO> memberlist=tmember.listmember(); 
		model.addAttribute("memberlist",memberlist);
		System.out.println("응애");
		return "tmember";
	}
	@RequestMapping(value="/addMember",method=RequestMethod.POST)
	public String doAddMember(@RequestParam String tid,@RequestParam int tpwd1,@RequestParam String tname,@RequestParam int tmobile,Model model) {
		itmember tmember =sqlSession.getMapper(itmember.class);
		tmember.insert(tid,tpwd1,tname,tmobile);
		return "redirect:/tmember";
	}
}
