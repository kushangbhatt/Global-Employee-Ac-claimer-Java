package DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.emp_dtl_vo;
import VO.login_vo;
import VO.reg_vo;

public class emp_dtl_dao {
	public void insert(emp_dtl_vo ev){
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction tr = s.beginTransaction();
			
			s.save(ev);
			tr.commit();
	}
	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from emp_dtl_vo");
		List ls = q.list();
		return ls;
	}
	public List AJAXSearch(emp_dtl_vo ev) {
		// TODO Auto-generated method stub
		System.out.println("in dao");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from login_vo a, emp_dtl_vo b WHERE a.utype='"+ev.getLogin().getUtype()+"' AND a.u_id = b.login");
		List ls = q.list();
		return ls;
	}
	public void delete(emp_dtl_vo ev) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		s.delete(ev);
		tr.commit();
	}
	public void update(emp_dtl_vo ev) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		s.update(ev);
		tr.commit();
	}
	public List loadsrc(emp_dtl_vo ev) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from emp_dtl_vo where U_Id='"+ev.getId()+"'");
		List ls = q.list();
		return ls;
	}
	public List loadname(login_vo lgv) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from emp_dtl_vo where U_Id='"+lgv.getU_id()+"'");
		List ls = q.list();
		return ls;
	}
}
