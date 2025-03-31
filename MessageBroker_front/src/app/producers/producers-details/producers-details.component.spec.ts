import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProducersDetailsComponent } from './producers-details.component';

describe('ProducersDetailsComponent', () => {
  let component: ProducersDetailsComponent;
  let fixture: ComponentFixture<ProducersDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProducersDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProducersDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
