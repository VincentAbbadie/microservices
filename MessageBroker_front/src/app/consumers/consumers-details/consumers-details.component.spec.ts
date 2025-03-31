import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsumersDetailsComponent } from './consumers-details.component';

describe('ConsumersDetailsComponent', () => {
  let component: ConsumersDetailsComponent;
  let fixture: ComponentFixture<ConsumersDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsumersDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsumersDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
