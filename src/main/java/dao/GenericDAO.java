package dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

public abstract class GenericDAO {

	@Resource(name = "sessionFactory")
	static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	final static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	static Session session = threadLocal.get();

	public <T> void save(final T o) {

		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}

	}

	public void delete(final Object object) {

		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}

	}

	public <T> T get(final Class<T> type, final Long id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	public <T> T merge(final T o) {
		return (T) sessionFactory.getCurrentSession().merge(o);
	}

	public <T> void saveOrUpdate(final T o) {

		session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			session.update(o);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}


	}

	public <T> List<T> getAll(final Class<T> type) {
		session = sessionFactory.openSession();
		final Criteria crit = session.createCriteria(type);
		return crit.list();
	}

	public <T> List<T> getListByDistinctbyProject(String project, int year, final Class type) {
		List tempList = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		tempList = session.createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.setProjection(Projections.projectionList())
				.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("p_id"))
						.add(Projections.property("p_commit")).add(Projections.property("v_file"))
						.add(Projections.property("v_id")).add(Projections.property("cveid"))))
				.list();

		for (Iterator<Object[]> iterator = tempList.iterator(); iterator.hasNext();) {
			Object[] value = iterator.next();
			if (!value[0].toString().contains(project) || !value[4].toString().contains(year + "")) {
				iterator.remove();
			}
		}

		try {
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}
		session.close();
		return tempList;

	}



	public  Object[] getListByDistinctbyClassification( String nameFunc ) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "SELECT func,commit, timestamp, COUNT(*) FROM Classification E WHERE E.vulnerability=1 and E.typeOfStructure=3 and E.typeofChange='-' and E.func='"+nameFunc+"' GROUP BY func,timestamp,commit  ORDER BY E.timestamp";


		Query query = session.createQuery(hql);
		Object[] results = query.list().toArray();

		try {
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}
		session.close();
		return results;

	}

	public synchronized <T> List<T> getListByDistinctbyFile(final Class type) {
		List tempList = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		tempList = session.createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.setProjection(Projections.projectionList())
				.setProjection(Projections.distinct(
						Projections.projectionList().add(Projections.property("id")).add(Projections.property("files"))
								.add(Projections.property("bug_id")).add(Projections.property("commit")).add(Projections.property("version"))))
				.list();

		session.close();

		try {
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}

		return tempList;

	}

	public <T> List<T> getListByDistinctbyProject(String project, final Class type) {
		List tempList = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		tempList = session.createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.setProjection(Projections.projectionList())
				.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("p_id"))
						.add(Projections.property("p_commit")).add(Projections.property("v_file"))
						.add(Projections.property("v_id")).add(Projections.property("cveid"))))
				.list();

		for (Iterator<Object[]> iterator = tempList.iterator(); iterator.hasNext();) {
			Object[] value = iterator.next();
			if (!value[0].toString().contains(project)) {
				iterator.remove();
			}
		}

		session.close();

		try {
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}

		return tempList;

	}

}