package com.revature.datalayer;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.ActiveEntity;
import com.revature.beans.Campaign;

@Repository(value="activeEntityDAO")
@Transactional
public class ActiveEntityDAO {

	private SessionFactory sf;

	@Autowired //constructor injection
	public ActiveEntityDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	public ActiveEntity getEntityById(int id) {
		return sf.getCurrentSession().get(ActiveEntity.class, id);
	}
	
	public List<ActiveEntity> getEntitiesByCampaign(int id){
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<ActiveEntity> cq = cb.createQuery(ActiveEntity.class);
		Root<ActiveEntity> root = cq.from(ActiveEntity.class);
		cq.select(root).where(cb.equal(root.get("campaignId"), id));
		Query<ActiveEntity> q = s.createQuery(cq);
		return q.getResultList();
	}
	
	public void deleteEntity(ActiveEntity ae) {
		sf.getCurrentSession().delete(ae);
	}
	
	public void deleteEntity(List<ActiveEntity> aeList) {
		Session s = sf.getCurrentSession();
		for(ActiveEntity ae : aeList) {
			s.delete(ae);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void deleteEntityByCampaign(Campaign c) {
		String hql = "delete from ActiveEntity where CAMPAIGN_ID := cid";
		Session s = sf.getCurrentSession();
		Query<ActiveEntity> q = s.createQuery(hql);
		q.setParameter("cid", c.getCampaignId());
		q.executeUpdate();
	}
	
	public void createActiveEntity(ActiveEntity ae) {
		sf.getCurrentSession().merge(ae);
	}
}
