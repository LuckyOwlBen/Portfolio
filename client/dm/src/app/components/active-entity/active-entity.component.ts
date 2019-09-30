import { Component, OnInit, Input } from '@angular/core';
import { Entity } from 'src/app/models/Entity';

@Component({
  selector: 'app-active-entity',
  templateUrl: './active-entity.component.html',
  styleUrls: ['./active-entity.component.css']
})
export class ActiveEntityComponent implements OnInit {

  @Input()
  entity: Entity;

  updateEntity(value: number): void {
    this.entity.currentHp = value;
    console.log(this.entity);
  }

  constructor() { }

  ngOnInit() {
  }

}
