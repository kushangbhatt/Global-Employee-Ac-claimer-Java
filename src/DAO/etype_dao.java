package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.cat_vo;
import VO.examtype_vo;

public class etype_dao {

	public void insert(examtype_vo ev) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.save(ev);
		tr.commit();
	}

	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from examtype_vo");
		List ls = q.list();
		return ls;
		}

	public List loadsrc(examtype_vo ev) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from examtype_vo where id='" + ev.getId() + "'");
		List ls = q.list();
		return ls;
	}

	public void update(examtype_vo ev) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.saveOrUpdate(ev);
		tr.commit();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		examtype_vo ev = new examtype_vo();
		ev.setId(id);
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.delete(ev);
		tr.commit();
	}

}
