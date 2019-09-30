import {Component, Input, OnInit} from '@angular/core';
import {Entity} from 'src/app/models/Entity';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Campaign} from 'src/app/models/Campaign';
import {CampaignService} from 'src/app/services/campaign.service';
import {Router} from '@angular/router';
import { EntityService } from 'src/app/services/entity.service';

@Component({
  selector: 'app-encounter',
  templateUrl: './encounter.component.html',
  styleUrls: ['./encounter.component.css']
})
export class EncounterComponent implements OnInit {

  @Input()
  entity: Entity;

  constructor(
    private modalService: NgbModal,
    private campaignService: CampaignService,
    private router: Router,
    private entityService: EntityService
  ) {  }

  entities = this.campaignService.currentCampaign.activeEntities;
  monsters: Entity[] = [];
  selectedEntity: Entity;
  activeEntity: Entity;
  roundNumber = 1;
  turnNumber = 1;

  setActiveEntity(turnNumber: number): void {
    this.activeEntity = this.entities[turnNumber];
  }

  sortByInitiative(entities): void {
    entities.sort((a, b) => a.initiativeTotal > b.initiativeTotal ? -1 : a.initiativeTotal < b.initiativeTotal ? 1 : 0);
  }

  openEntityModal(entityModal) {
    this.modalService.open(entityModal);
  }

  openMonsterModal(addMonsterModal) {
    this.modalService.open(addMonsterModal);
  }

  openConditionModal(conditionModal) {
    this.modalService.open(conditionModal);
  }

  onSelect(entity: Entity): void {
  this.selectedEntity = entity;
}

  updateEntity(value: number): void {
    this.selectedEntity.currentHp = value;
  }

  getMonsters(): any {
    this.entities.forEach(entity => {
      if (entity.entityType === "monster") {
        this.monsters.push(entity);
      }
    });
    console.log(this.monsters);
  }

  addMonster(monster): void {
    let newMonster = new Entity();
    newMonster = {id: this.getRandomInt(1000, 1000000000), campaignId: monster.campaignId,
      name: monster.name, entityType: monster.entityType,
      hp: monster.hp, currentHp: monster.hp, armorClass: monster.armorClass,
      conditions: [], initiativeMod: monster.initiativeMod, initiativeTotal: monster.initiativeMod + this.getRandomInt(1,20)};
    if (this.turnNumber === 1) {
      this.entities.push(newMonster);
      const json = JSON.stringify(newMonster);
      this.entityService.saveEntity(json);
    }
      this.sortByInitiative(this.entities);
  }

  getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min; //The maximum is exclusive and the minimum is inclusive
  }

  checkConditions(entity, conditionModal): void {
    if (entity.conditions === []) {
      this.passTurn();
    }
    if (entity.conditions) {
      this.openConditionModal(conditionModal);
    } else {
      this.passTurn();
    }
  }

  removeCondition(condition, entity) {
    entity.conditions.splice(condition, 1);
  }

  passTurn(): void {
    if (this.turnNumber === this.entities.length) {
      this.roundNumber += 1;
      this.turnNumber = 1;
      const json = JSON.stringify(this.campaignService.currentCampaign);
      console.log(json);
      this.campaignService.updateCampaign(json).subscribe(res => {
      if (res === 'Added Campaign: ' + this.campaignService.currentCampaign) {
        console.log("Save Success");
      }
    });
      this.setActiveEntity(this.turnNumber - 1);
    } else {
      this.turnNumber += 1;
      const json = JSON.stringify(this.campaignService.currentCampaign);
      console.log(json);
      this.campaignService.updateCampaign(json).subscribe(res => {
      if (res === 'Added Campaign: ' + this.campaignService.currentCampaign) {
        console.log("Save Success");
      }
    });
      this.setActiveEntity(this.turnNumber - 1);
    }
  }

  endEncounter(): void {
    this.entities.forEach(entity => {
      const json = JSON.stringify(entity);
      this.entityService.saveEntity(json);
    });
    this.router.navigate(['/campaign']);
  }

  getCurrentCampaign(): Campaign {
    return this.campaignService.currentCampaign;
  }

  saveCampaign() {
    const json = JSON.stringify(this.campaignService.currentCampaign);
    console.log(json);
    this.campaignService.updateCampaign(json).subscribe(res => {
      if (res === 'Added Campaign: ' + this.campaignService.currentCampaign) {
        console.log("Save Success");
      }
    });
    this.router.navigate(['/campaign']);
  }

  ngOnInit() {
    if (sessionStorage.getItem('currentUser')) {
      this.sortByInitiative(this.entities);
      this.setActiveEntity(this.turnNumber - 1);
      this.getCurrentCampaign();
    } else {
      this.router.navigate(['/login']);
    }

  }

}
