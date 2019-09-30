import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveEntityComponent } from './active-entity.component';

describe('ActiveEntityComponent', () => {
  let component: ActiveEntityComponent;
  let fixture: ComponentFixture<ActiveEntityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActiveEntityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiveEntityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
