package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Campaign;
import com.revature.beans.User;
import com.revature.datalayer.CampaignDAO;

@Service
public class CampaignService {
	
	private CampaignDAO cDAO;
	
	@Autowired
	public CampaignService(CampaignDAO cDAO) {
		this.cDAO = cDAO;
	}
	
	public Campaign getCampaignById(int id) {
		return cDAO.getCampaignById(id);
	}
	
	public List<Campaign> getAllCampaigns(){
		return cDAO.getAllCampaigns();
	}
	
	public List<Campaign> getCampaignsByUser(User u){
		return cDAO.getCampaignsByUser(u);
	}
	
	public List<Campaign> getCampaignsByUserId(int id){
		return cDAO.getCampaignsByUserId(id);
	}
	
	//Pass in a User's List of campaign ids to get those respective campaigns
	public List<Campaign> getCampaignsByIntegerList(List<Integer> cList){
		List<Campaign> listToReturn = new ArrayList<>();
		for(int i : cList) {
			listToReturn.add(cDAO.getCampaignById(i));
		}
		return listToReturn;
	}
	
	public List<Integer> getCampaignIdsByUser(User u){
		return cDAO.getCampaignIdsByUser(u);
	}
	
	//Can also set UserId instead of type: User
	public void addCampaign(String cName, int round, int turn, int userId) {
		Campaign cToAdd = new Campaign(cName, round, turn);
		cToAdd.setUserId(userId);
		cDAO.addCampaign(cToAdd);
	}
	
	public void updateCampaign(Campaign c) {
		cDAO.updateCampaign(c);
	}
	
	public void deleteCampaignById(int id) {
		cDAO.deleteCampaignById(id);
	}

}
