import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsumersComponent } from './consumers.component';

describe('ConsumersComponent', () => {
  let component: ConsumersComponent;
  let fixture: ComponentFixture<ConsumersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsumersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsumersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
