package CONTROLLER;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import DAO.emp_dtl_dao;
import DAO.loanmst_dao;
import DAO.reg_dao;
import VO.emp_dtl_vo;
import VO.leavemst_vo;
import VO.loandtl_vo;
import VO.loanmst_vo;
import VO.login_vo;

/**
 * Servlet implementation class loan_controller
 */
@WebServlet("/loan_controller")
public class loan_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loan_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		if(f!=null && f.equals("load")){
			load(request, response);
			response.sendRedirect("Admin/search_loan.jsp");
		}
		if (f!=null && f.equals("loadsrc")){
			int id = Integer.parseInt(request.getParameter("id"));
			loadsrc(request, response, id);
			response.sendRedirect("Admin/update_loandtl_form.jsp");
		}
		if (f!=null && f.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			loanmst_vo lv = new loanmst_vo();
			lv.setId(id);
			delete(request, response, lv);
		}
		if(f!=null && f.equals("loadtype")){
			load(request, response);
			response.sendRedirect("Employee/form_loandtl.jsp");
		}
		if(f!=null && f.equals("loadrate")){
			int id = Integer.parseInt(request.getParameter("loan_id"));
			System.out.println("id"+id);
			loadsrc(request, response, id);
			response.sendRedirect("Employee/json_loandtl.jsp");
		}
		if (f!=null && f.equals("loansrc")){
			loansrc(request, response);
			response.sendRedirect("Employee/search_loandtl.jsp");
		}
	}

	private void loansrc(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		loanmst_dao ld = new loanmst_dao();
		List ls = ld.loansrc();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);		
	}

	private void delete(HttpServletRequest request,
			HttpServletResponse response, loanmst_vo lv) throws IOException {
		// TODO Auto-generated method stub
		loanmst_dao ld = new loanmst_dao();
		ld.delete(lv);
		response.sendRedirect("loan_controller?flag=load");
	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response, int id) throws IOException {
		// TODO Auto-generated method stub
		loanmst_dao ld = new loanmst_dao();
		List ls = ld.loadsrc(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("ulist", ls);
		
		
		
	}

	private void load(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		loanmst_dao l1 = new loanmst_dao();
		List ls = l1.search();
		HttpSession session = request.getSession();
		session.setAttribute("loan_list", ls);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int s2 = Integer.parseInt(request.getParameter("amount"));
		String s4 = request.getParameter("ld");
		
		
		loanmst_vo lov = new loanmst_vo();
		lov.setAmount(s2);
		lov.setLoan_desc(s4);
	
		
		String f = request.getParameter("flag");
		if (f!=null && f.equals("insert")){
			String s1 = request.getParameter("lt");
			int s3 = Integer.parseInt(request.getParameter("rate"));
			lov.setRate(s3);
			lov.setLoan_type(s1);

			insert(request, response, lov);
			response.sendRedirect("Admin/form_loandtl.jsp");
		}
		
		if (f!=null && f.equals("update")){
			String s1 = request.getParameter("lt");
			int id = Integer.parseInt(request.getParameter("id"));
			lov.setId(id);
			lov.setLoan_type(s1);

			int s3 = Integer.parseInt(request.getParameter("rate"));
			lov.setRate(s3);
			update(request, response, lov);
		}
		
		if (f!=null && f.equals("insertE")){
		lov.setId(Integer.parseInt(request.getParameter("lt")));
		System.out.println(Integer.parseInt(request.getParameter("lt")));
		loandtl_vo ldv = new loandtl_vo();
		ldv.setLv(lov);
		ldv.setAmount(s2);
		ldv.setDesc(s4);
		login_vo lgv = new login_vo();
		HttpSession hs = request.getSession();
		lgv.setU_id((Integer)hs.getAttribute("userID"));
		emp_dtl_vo ev1 = new emp_dtl_vo();

		emp_dtl_dao ed = new emp_dtl_dao();
		List ls = ed.loadname(lgv);
		Iterator itr = ls.iterator();
		while (itr.hasNext()){
			emp_dtl_vo ev = (emp_dtl_vo)itr.next();
			int y = (Integer)ev.getId();
			ev1.setId(y);
		}
		
		ldv.setEv(ev1);
		insertE(request, response, ldv);
		}
	}

	private void insertE(HttpServletRequest request,
			HttpServletResponse response, loandtl_vo lv) throws IOException {
		// TODO Auto-generated method stub
		loanmst_dao l1 = new loanmst_dao();
		l1.insertE(lv);
		response.sendRedirect("Employee/form_loandtl.jsp");
	}

	private void update(HttpServletRequest request,
			HttpServletResponse response, loanmst_vo lov) throws IOException {
		// TODO Auto-generated method stub
		loanmst_dao ld = new loanmst_dao();
		ld.update(lov);
		
		response.sendRedirect("loan_controller?flag=load");
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, loanmst_vo lov) throws IOException {
		// TODO Auto-generated method stub
		loanmst_dao l1 = new loanmst_dao();
		l1.insert(lov);
		
	}


}
