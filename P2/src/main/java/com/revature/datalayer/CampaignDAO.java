package com.revature.datalayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Campaign;
import com.revature.beans.User;

@Repository(value="campaignDAO")
@Transactional
public class CampaignDAO {
	
	private SessionFactory sf;

	@Autowired //constructor injection
	public CampaignDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Campaign> getAllCampaigns(){
		return sf.getCurrentSession().createQuery("from Campaign").getResultList();
	}
	
	public Campaign getCampaignById(int id) {
		return sf.getCurrentSession().get(Campaign.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Campaign> getCampaignsByUserId(int id){
		Query<Campaign> query = sf.getCurrentSession().createQuery("from Campaign where USER_ID = :id ");
		query.setParameter("id", id);
		return query.list();
	}

	public List<Campaign> getCampaignsByUser(User u){
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Campaign> cq = cb.createQuery(Campaign.class);
		Root<Campaign> root = cq.from(Campaign.class);
		cq.select(root).where(cb.equal(root.get("user"), u));
		Query<Campaign> q = s.createQuery(cq);
		return q.getResultList();
	}
	
	//Change to get ids only, time permitting
	public List<Integer> getCampaignIdsByUser(User u){
		List<Campaign> temp = getCampaignsByUser(u);
		List<Integer> campIds = new ArrayList<>();
		for(Campaign c: temp) {
			campIds.add(c.getCampaignId());
		}
		return campIds;
	}
	
	//This, and the Active Entities DAO, will assume that the respective 
	//ManyToOnes will have been set before being passed in
	public void addCampaign(Campaign c) {
		sf.getCurrentSession().persist(c);
	}
	
	public void updateCampaign(Campaign c) {
		sf.getCurrentSession().saveOrUpdate(c);
	}
	
	public void deleteCampaignById(int id) {
		Session s = sf.getCurrentSession();
		s.delete(s.get(Campaign.class, id));
	}
	
}
