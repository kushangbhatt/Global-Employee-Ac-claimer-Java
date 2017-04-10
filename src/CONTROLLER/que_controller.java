package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.que_dao;
import DAO.reg_dao;
import DAO.subcat_dao;
import VO.que_vo;
import VO.subcat_vo;

/**
 * Servlet implementation class que_controller
 */
@WebServlet("/que_controller")
public class que_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public que_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		que_vo qv = new que_vo();
		
		if(f!=null && f.equals("load")){
			load(request, response);
		}
		
		if (f!=null && f.equals("loadsrc")){
			int id = Integer.parseInt(request.getParameter("id"));
			loadsrc(request, response, id);
			
		}
		
		if (f!=null && f.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			
			qv.setId(id);
			delete(request, response, qv);
		}
		if (f!=null && f.equals("loadsub")){
			loadsub(request, response);
		}
	}

	private void loadsub(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		subcat_dao sd = new subcat_dao();
		List ls= sd.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		response.sendRedirect("Admin/form_question.jsp");
		
	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response, int id) throws IOException{
		// TODO Auto-generated method stub
		que_dao qd = new que_dao();
		List ls = qd.loadsrc(id);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);
		response.sendRedirect("Admin/update_question_form.jsp");
	}

	private void delete(HttpServletRequest request,
			HttpServletResponse response, que_vo qv) throws IOException{
		// TODO Auto-generated method stub
		que_dao qd = new que_dao();
		qd.delete(qv);
		
		response.sendRedirect("que_controller?flag=load");
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		que_dao qd = new que_dao();
		List ls = qd.search();
		HttpSession session = request.getSession();
		session.setAttribute("list", ls);
		response.sendRedirect("Admin/search_question.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 = request.getParameter("q");
		String s2 = request.getParameter("o1");
		String s3 = request.getParameter("o2");
		String s4 = request.getParameter("o3");
		String s5 = request.getParameter("o4");
		String s6 = request.getParameter("ra");
		int s8 = Integer.parseInt(request.getParameter("subcat"));
		int s7 = Integer.parseInt(request.getParameter("m"));
		
		subcat_vo sv = new subcat_vo();
		sv.setId(s8);
		
		que_vo qv = new que_vo();
		qv.setQue(s1);
		qv.setO1(s2);
		qv.setO2(s3);
		qv.setO3(s4);
		qv.setO4(s5);
		qv.setRa(s6);
		qv.setM(s7);
		qv.setSubv(sv);
		
		String f = request.getParameter("flag");
		
		if(f!=null && f.equals("insert")){
			insert (request, response, qv);
		}
		
		if (f!=null && f.equals("update")){
			int id = Integer.parseInt(request.getParameter("id"));
			qv.setId(id);
			update(request, response, qv);
		}
		
	}


	private void update(HttpServletRequest request,
			HttpServletResponse response, que_vo qv) throws IOException{
		// TODO Auto-generated method stub
		que_dao qd = new que_dao();
		qd.update(qv);
		response.sendRedirect("que_controller?flag=load");
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, que_vo qv) throws IOException {
		// TODO Auto-generated method stub
		que_dao qd = new que_dao();
		qd.insert(qv);
		response.sendRedirect("Admin/form_question.jsp");

	}

}
