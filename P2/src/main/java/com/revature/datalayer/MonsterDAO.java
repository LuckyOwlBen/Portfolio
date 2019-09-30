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

import com.revature.beans.MonsterVault;

@Repository(value="monsterDAO")
@Transactional
public class MonsterDAO {
	
	private SessionFactory sf;

	@Autowired //constructor injection
	public MonsterDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	public List<MonsterVault> getAllMonsters() {
		Session s = sf.getCurrentSession();
		return s.createQuery("from MonsterVault").getResultList();
	}
	
	public MonsterVault getMonsterById(int id) {
		return sf.getCurrentSession().get(MonsterVault.class, id);
	}
	
	//SELECT * FROM MONSTER_VAULT WHERE NAME = ?
	public List<MonsterVault> getMonstersByName(String name){
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<MonsterVault> cq = cb.createQuery(MonsterVault.class);
		Root<MonsterVault> root = cq.from(MonsterVault.class);
		cq.select(root).where(cb.equal(root.get("name"), name));
		Query<MonsterVault> q = s.createQuery(cq);
		return q.getResultList();
	}
	
	public void addMonster(MonsterVault m) {
		sf.getCurrentSession().saveOrUpdate(m);
	}

}
