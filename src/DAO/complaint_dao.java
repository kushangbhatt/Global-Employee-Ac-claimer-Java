package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import VO.complaint_vo;

public class complaint_dao {
	public void insert(complaint_vo cv1) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.save(cv1);
		tr.commit();
	}

	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from complaint_vo");
		List ls = q.list();
		return ls;
	}
}
