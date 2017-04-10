package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.exam_vo;
import VO.leavemst_vo;

public class exam_dao {
	public void insert(exam_vo exv){
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction tr = s.beginTransaction();
			
			s.save(exv);
			tr.commit();
	}

	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from exam_vo");
		List ls = q.list();
		return ls;
	}
	public List loadsrc(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from exam_vo where id='" + id + "'");
		List ls = q.list();
		return ls;

	}

	public void update(exam_vo ev) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.saveOrUpdate(ev);
		tr.commit();
	}

	public void delete(exam_vo ev) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.delete(ev);
		tr.commit();
	}

}
