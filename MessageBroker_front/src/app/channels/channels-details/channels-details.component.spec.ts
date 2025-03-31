import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChannelsDetailsComponent } from './channels-details.component';

describe('ChannelsDetailsComponent', () => {
  let component: ChannelsDetailsComponent;
  let fixture: ComponentFixture<ChannelsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChannelsDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChannelsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
