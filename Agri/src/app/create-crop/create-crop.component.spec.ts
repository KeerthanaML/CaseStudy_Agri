import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCropComponent } from './create-crop.component';

describe('CreateCropComponent', () => {
  let component: CreateCropComponent;
  let fixture: ComponentFixture<CreateCropComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateCropComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateCropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
