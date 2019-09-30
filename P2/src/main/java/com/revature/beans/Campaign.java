package com.revature.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CAMPAIGN")
public class Campaign {

	public Campaign() {
		super();
	}

	public Campaign(String campaignName, int currentTurn, int currentRound) {
		super();
		this.campaignName = campaignName;
		this.currentTurn = currentTurn;
		this.currentRound = currentRound;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "campaignSequence")
	@SequenceGenerator(allocationSize = 1, name = "campaignSequence", sequenceName = "SQ_CAMPAIGN_PK")
	@Column(name = "CAMPAIGN_ID")
	private int campaignId;

	@Column(name = "CAMPAIGN_NAME")
	private String campaignName;

	@Column(name = "CURRENT_TURN")
	private int currentTurn;

	@Column(name = "CURRENT_ROUND")
	private int currentRound;
	
	@Column(name = "USER_ID")
	private int userId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name = "CAMPAIGN_ID")
	List<ActiveEntity> activeEntities;
	
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public int getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}

	public int getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<ActiveEntity> getActiveEntities() {
		return activeEntities;
	}

	public void setActiveEntities(List<ActiveEntity> activeEntities) {
		this.activeEntities = activeEntities;
	}

	@Override
	public String toString() {
		return "Campaign [ campaignId=" + campaignId + ", campaignName=" + campaignName + ", currentTurn=" + currentTurn
				+ ", currentRound=" + currentRound + "]";
	}

}
