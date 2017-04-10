package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.complaint_dao;
import DAO.emp_dtl_dao;
import DAO.login_dao;
import VO.complaint_vo;
import VO.emp_dtl_vo;
import VO.login_vo;

/**
 * Servlet implementation class complaint_controller
 */
@WebServlet("/complaint_controller")
public class complaint_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public complaint_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		if(f!=null && f.equals("loadname"))
		{
			loadname(request, response);
		}
		
		if(f!=null && f.equals("load"))
		{
			load(request, response);
		}
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		complaint_dao cd = new complaint_dao();
		List ls = cd.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		
		response.sendRedirect("Employee/search_complaint.jsp");
	}

	private void loadname(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String s1 = request.getParameter("type");
		System.out.println("id="+s1);
		login_vo lgv = new login_vo();
		lgv.setUtype(s1);
		
		emp_dtl_vo ev = new emp_dtl_vo();
		ev.setLogin(lgv);
		
		emp_dtl_dao ed = new emp_dtl_dao();
		List ls = ed.AJAXSearch(ev);
		System.out.println("out dao");
		HttpSession hs = request.getSession();
		hs.setAttribute("employee_details", ls);
		response.sendRedirect("Employee/json_employee.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String f= request.getParameter("flag");
		
		if(f!=null && f.equals("insert")){
			insert(request, response);
			response.sendRedirect("Employee/form_complaint.jsp");
		}

	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		complaint_vo cv = new complaint_vo();
		cv.setType(request.getParameter("type"));
		cv.setSub(request.getParameter("sub"));
		cv.setDesc(request.getParameter("desc"));
		
		/*login_vo lgv = new login_vo();
		lgv.setUtype(request.getParameter("type"));*/
		
		emp_dtl_vo emp = new emp_dtl_vo();
		emp.setId(Integer.parseInt(request.getParameter("to")));;
		
		cv.setEmp(emp);
		
		complaint_dao cd = new complaint_dao();
		cd.insert(cv);
	}

}
