package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.city_vo;

public class city_dao {
	public void insert(city_vo cv){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		s.save(cv);
		tr.commit();
	}
	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from city_vo");
		List ls = q.list();
		return ls;
	}
	public List AJAXSearch(city_vo cv) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from city_vo where state_id='"+cv.getSv().getId()+"'");
		List ls = q.list();
		return ls;
	}
}
