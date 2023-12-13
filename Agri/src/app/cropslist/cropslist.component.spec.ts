import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CropslistComponent } from './cropslist.component';

describe('CropslistComponent', () => {
  let component: CropslistComponent;
  let fixture: ComponentFixture<CropslistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CropslistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CropslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
