package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.login_vo;

public class login_dao {

	public boolean insert(login_vo lg){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Query q = s.createQuery("from login_vo where U_Name='"+lg.getUname()+"'");
		List ls = q.list();
		if(ls.isEmpty()){
			s.save(lg);
			tr.commit();
			return true;
		}
		else {
			
			return false;
		}
}
	
	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from login_vo");
		List ls = q.list();
		return ls;
	}
	
	public List authentication(login_vo lg) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		Query q = s.createQuery("from login_vo where U_Name='"+lg.getUname()+"' and U_Password='"+lg.getPass()+"'");
		List ls = q.list();
		return ls;
	}
	public List searchE() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from login_vo group by U_Type");
		List ls = q.list();
		return ls;
	}

}
