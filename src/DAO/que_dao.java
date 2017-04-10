package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.cat_vo;
import VO.exam_vo;
import VO.que_vo;

public class que_dao {
	public void insert(que_vo qv){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(qv);
		tr.commit();
	}
	public List search(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from que_vo");
		List ls = q.list();
		return ls;
		
	}
	public List loadsrc(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from que_vo where id='"+id+"'");
		List ls = q.list();
		return ls;

	}

	public void update(que_vo qv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.saveOrUpdate(qv);
		tr.commit();
	}

	public void delete(que_vo qv) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		s.delete(qv);
		tr.commit();
	}
	public List generate(exam_vo ev) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from que_vo where Subcat='"+ev.getE_subcat()+"' order by rand() limit 0,'"+ev.getNo_q()+"'");
		List ls = q.list();
		return ls;
	}
}
