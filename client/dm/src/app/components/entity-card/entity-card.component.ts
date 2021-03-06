import {Component, Input, OnInit} from '@angular/core';
import {Entity} from '../../models/Entity';

@Component({
  selector: 'app-entity-card',
  templateUrl: './entity-card.component.html',
  styleUrls: ['./entity-card.component.css']
})
export class EntityCardComponent implements OnInit {
  @Input()
  entity: Entity;

  constructor() {}
  ngOnInit() {}
}
