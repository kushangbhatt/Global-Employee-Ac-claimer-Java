package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.cat_vo;
import VO.subcat_vo;

public class subcat_dao {
	
	public void insert(subcat_vo sv){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		s.save(sv);
		tr.commit();
	}

	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from subcat_vo");
		List ls = q.list();
		return ls;
	}
	
	public List loadsrc(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from subcat_vo where id='"+id+"'");
		List ls = q.list();
		return ls;
		
	}
	
	public void update(subcat_vo sv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		s.saveOrUpdate(sv);
		tr.commit();
	}
	
	public void delete(subcat_vo sv2) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		s.delete(sv2);
		tr.commit();
	}

	public List AJAXSearch(subcat_vo sv) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sf = new Configuration().configure()
		
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from subcat_vo where cat_id='"+sv.getC().getId()+"'");
		List ls = q.list();
		return ls;
	}catch(Exception e){e.printStackTrace();}
		return null;
	}
}
