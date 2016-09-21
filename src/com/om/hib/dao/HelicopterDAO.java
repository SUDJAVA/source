package com.om.hib.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.om.hib.dto.HelicopterDTO;
import com.om.hib.util.HibernateUtil;

public class HelicopterDAO {
	private SessionFactory factory = HibernateUtil.getSessionFactory();

	public HelicopterDAO() {
		System.out.println(this.getClass().getSimpleName() + "  created");
	}

	// SAVE METHOD................................
	public void save(HelicopterDTO dto) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();

	}

	// 1.FETCH BASED ON COUNTRYNAME
	public HelicopterDTO fetchByCountryName(String cname) {
		// prepare
		Session session = factory.openSession();
		String hql = "select hel from HelicopterDTO as hel where hCountryName='"
				+ cname + "'";
		Query query = session.createQuery(hql);
		// process
		HelicopterDTO fromQuery = (HelicopterDTO) query.uniqueResult();
		return fromQuery;
	}

	// 2.FETCH BASED ON NAME OR, PRICE
	public HelicopterDTO fetchBasedByNameOrPrice(String name, double price) {
		Session session = factory.openSession();
		String hql = "select hel from HelicopterDTO as hel where hName='"
				+ name + "' or hPrice=" + price;
		Query query = session.createQuery(hql);
		HelicopterDTO hdto = (HelicopterDTO) query.uniqueResult();
		return hdto;
	}

	// 3.FETCH ONLY NAME BASED ON PRICE
	public String fetchNameByPrice(double price) {
		Session session = factory.openSession();
		String hql = "select hName from HelicopterDTO where hPrice=" + price;
		Query query = session.createQuery(hql);
		String hdto = (String) query.uniqueResult();

		return hdto;
	}

	// 4.FETCH ONLY ID BASED ON NAME & COUNTRY NAME & PRICE
	public Integer fetchIdBYNameCnamePrice(String name, String cname,
			double price) {
		Session sesion = factory.openSession();
		String hql = "select hId from HelicopterDTO where hName='" + name
				+ "' and hCountryName='" + cname + "' and hPrice=" + price;
		Query query = sesion.createQuery(hql);
		Integer in = (Integer) query.uniqueResult();
		return in;
	}

	// 5.fetching multiple rows
	public List getHelicopterList() {
		Session session = factory.openSession();
		String hql = "from HelicopterDTO";
		Query query = session.createQuery(hql);
		List<HelicopterDTO> list = query.list();
		return list;
	}

	// 6.fetching 1row,multiple column
	public void fetchNameAndPrice(int pk) {
		Session session = factory.openSession();
		String hql = "select hName,hPrice from HelicopterDTO where hId=" + pk;
		Query query = session.createQuery(hql);
		Object obj = query.uniqueResult();
		System.out.println(obj);
		Object[] props = (Object[]) obj;
		System.out.print(props[0]);
		System.out.println(props[1]);

	}

	// 7.fetching multi row,multi column

	public List fetchNameAndPrice() {
		Session session = factory.openSession();
		String hql = "select hName,hPrice from HelicopterDTO";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
		/*
		  Object[] props=(Object[])list.get(0);
		  System.out.println(props[0]);
		  System.out.println(props[1]);*/
		 
	}
	
	public void fetchBYcountryName(String name){
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(HelicopterDTO.class).setProjection(Projections.avg("hId"));
		//criteria.add(Restrictions.like("hName","%hel%")).add(Restrictions.lt("hId", 14));
		//HelicopterDTO hdto=(HelicopterDTO)criteria.uniqueResult();
		List list=criteria.list();
		System.out.println(list);
		//System.out.println(list.get(0));
		//System.out.println(hdto.getHName());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
