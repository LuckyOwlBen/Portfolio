import { Component, OnInit, Input } from '@angular/core';
import { StatusService } from '../../services/status.service';
import { Entity } from 'src/app/models/Entity';


@Component({
  selector: 'app-status-card',
  templateUrl: './status-card.component.html',
  styleUrls: ['./status-card.component.css']
})
export class StatusCardComponent implements OnInit {

  @Input()
  entity: Entity;

  conditions: string[] = [];


  constructor(private statusService: StatusService) {
  }

 ngOnInit() {
   this.getConditions();
   if (!this.entity.conditions) {
    this.entity.conditions = [];
   }
 }


 getConditions() {
  this.statusService.getConditions().subscribe(conditions => {
    this.conditions = conditions; });
}

  toggleCondition(condition, entity) {
    // if (entity.conditions.includes(condition)) {
    //   entity.conditions.splice(entity.conditions.indexOf(condition), 1);
    // } else {
    if (!entity.conditions.includes(condition)) {
      entity.conditions.push(condition);
    }
    console.log(entity);
  }

}
