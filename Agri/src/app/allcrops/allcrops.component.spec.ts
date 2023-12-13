import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllcropsComponent } from './allcrops.component';

describe('AllcropsComponent', () => {
  let component: AllcropsComponent;
  let fixture: ComponentFixture<AllcropsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllcropsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllcropsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
