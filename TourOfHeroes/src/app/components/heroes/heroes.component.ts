import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Hero } from'../../models/hero'
import { HEROES } from'../../models/mock-heroes';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {
  selectedHero:Hero;
  onSelect(hero: Hero): void{
    this.selectedHero = hero;
  }
  heroes = HEROES;
  hero: Hero = {
    id:1,
    name:'Windstorm'
  };
  constructor() { }

  ngOnInit() {
  }

}
