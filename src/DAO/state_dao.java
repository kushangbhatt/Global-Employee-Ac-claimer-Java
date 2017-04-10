package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.leavemst_vo;
import VO.state_vo;

public class state_dao {
	public void insert(state_vo sv) {

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.save(sv);
		tr.commit();
	}

	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from state_vo");
		List ls = q.list();
		return ls;
	}

	public List loadsrc(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from state_vo where id='" + id + "'");
		List ls = q.list();
		return ls;

	}

	public void update(state_vo sv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.saveOrUpdate(sv);
		tr.commit();
	}

	public void delete(state_vo sv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.delete(sv);
		tr.commit();
	}

	public List AJAXsearch(state_vo sv) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sf = new Configuration().configure()
		
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from state_vo where Country_id='"+sv.getCv().getId()+"'");
		List ls = q.list();
		return ls;
	}catch(Exception e){e.printStackTrace();}
		return null;
	}
}
