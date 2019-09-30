package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.ActiveEntity;
import com.revature.datalayer.ActiveEntityDAO;

@Service
public class ActiveEntityService {

	private ActiveEntityDAO aed;
	
	public ActiveEntityService(ActiveEntityDAO aed) {
		this.aed = aed;
	}
	
	public List<ActiveEntity> returnAllActiveEntitesByCampaign(int id){
		return aed.getEntitiesByCampaign(id);
	}
	
	public void deleteActiveEntity(int id) {
		ActiveEntity temp = aed.getEntityById(id);
		aed.deleteEntity(temp);
	}
	
	public void storeActiveEntities(ActiveEntity ae /*activeEntityList*/) {
		//for(ActiveEntity ae : activeEntityList) {
			aed.createActiveEntity(ae);
		//}
	}
}
