package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.cat_vo;
import VO.leavedtl_vo;
import VO.leavemst_vo;

public class leavemst_dao {
	public void insert(leavemst_vo lv) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(lv);
		tr.commit();
	}

	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from leavemst_vo");
		List ls = q.list();
		return ls;
	}

	public List loadsrc(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from leavemst_vo where id='" + id + "'");
		List ls = q.list();
		return ls;

	}

	public void update(leavemst_vo lv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.saveOrUpdate(lv);
		tr.commit();
	}

	public void delete(leavemst_vo lv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.delete(lv);
		tr.commit();
	}

	public void insertE(leavedtl_vo lv1) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(lv1);
		tr.commit();
	}

	public List searchE() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from leavedtl_vo");
		List ls = q.list();
		return ls;
}


}
