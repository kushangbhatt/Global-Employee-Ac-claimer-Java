package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.leavemst_vo;
import VO.reg_vo;

public class reg_dao {
	public void insert(reg_vo rv){
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction tr = s.beginTransaction();
			s.save(rv);
			tr.commit();
	}

	public List search(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from reg_vo");
		List ls = q.list();
		return ls;
		
	}
	public List loadsrc(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from reg_vo where id='" + id + "'");
		List ls = q.list();
		return ls;

	}

	public void update(reg_vo rv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.saveOrUpdate(rv);
		tr.commit();
	}

	public void delete(reg_vo rv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.delete(rv);
		tr.commit();
	}
}
