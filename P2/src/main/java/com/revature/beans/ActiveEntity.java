package com.revature.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVE_ENTITY") // stores monsters and players while
public class ActiveEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "activeEntitySequence")
	@SequenceGenerator(allocationSize = 1, name = "activeEntitySequence", sequenceName = "SQ_ACTIVE_ENTITY_PK")
	@Column(name = "ACT_ENTITY_ID")
	private int id;
	@Column(name="CAMPAIGN_ID")
	private int campaignId;
	@Column(name = "ACT_ENTITY_NAME")
	private String name;
	@Column(name = "ACT_HIT_POINTS")
	private int hp;
	@Column(name = "ACT_CURRENT_HIT_POINTS")
	private int currentHp;
	@Column(name = "ACT_ARMOR_CLASS")
	private int armorClass;
	@Column(name = "ACT_INITIATIVE_MOD")
	private int initiativeMod;
	@Column(name = "ACT_INITIATIVE_TOTAL")
	private int initiativeTotal;
	@Column(name = "ACT_TYPE") // will be either player or monster
	private String entityType;
	@Column(name="ACT_CONDITIONS")
	private ArrayList<Conditions> conditions;

	public ActiveEntity() {
		super();
	}
	public ActiveEntity(Campaign containingCampaign,int campaignId, String name, int hp, int currentHp, int armorClass,
			int initiativeMod, int initiativeTotal, String type) {
		super();
		this.campaignId = campaignId;
		this.name = name;
		this.hp = hp;
		this.currentHp = currentHp;
		this.armorClass = armorClass;
		this.initiativeMod = initiativeMod;
		this.initiativeTotal = initiativeTotal;
		this.entityType = type;
	}

	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getInitiativeMod() {
		return initiativeMod;
	}

	public void setInitiativeMod(int initiativeMod) {
		this.initiativeMod = initiativeMod;
	}

	public int getInitiativeTotal() {
		return initiativeTotal;
	}

	public void setInitiativeTotal(int initiativeTotal) {
		this.initiativeTotal = initiativeTotal;
	}
	
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public ArrayList<Conditions> getConditions() {
		return conditions;
	}
	public void setConditions(ArrayList<Conditions> conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		return "ActiveEntity{" +
				"id=" + id +
				", campaignId=" + campaignId +
				", name='" + name + '\'' +
				", hp=" + hp +
				", currentHp=" + currentHp +
				", armorClass=" + armorClass +
				", initiativeMod=" + initiativeMod +
				", initiativeTotal=" + initiativeTotal +
				", entityType='" + entityType + '\'' +
				", conditions=" + conditions +
				'}';
	}
}
