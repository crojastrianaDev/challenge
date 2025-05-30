import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsComponent } from './products.component';
import { ProductsService } from '../../services/products.service';
import { of } from 'rxjs';
import { RouterTestingModule } from '@angular/router/testing';
import { CommonModule } from '@angular/common';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { ProductDto } from '../../domain/ProductDto';

describe('ProductsComponent', () => {
  let component: ProductsComponent;
  let fixture: ComponentFixture<ProductsComponent>;
  let productsServiceMock: any;

  const dummyProducts: ProductDto[] = [
    {
      id: '1',
      title: 'Product 1',
      price: 10,
      currency: 'USD',
      image: '',
    },
    {
      id: '2',
      title: 'Product 2',
      price: 20,
      currency: 'USD',
      image: '',
    },
  ];

  beforeEach(async () => {
    productsServiceMock = {
      getAllProducts: jasmine
        .createSpy('getAllProducts')
        .and.returnValue(of(dummyProducts)),
    };

    await TestBed.configureTestingModule({
      imports: [CommonModule, RouterTestingModule],
      declarations: [ProductsComponent],
      providers: [{ provide: ProductsService, useValue: productsServiceMock }],
    }).compileComponents();

    fixture = TestBed.createComponent(ProductsComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call loadAllProducts on ngOnInit and set services', () => {
    component.ngOnInit();
    expect(productsServiceMock.getAllProducts).toHaveBeenCalled();
    expect(component.services.length).toBe(2);
    expect(component.services).toEqual(dummyProducts);
  });

  it('should render product titles and prices', () => {
    component.services = dummyProducts;
    fixture.detectChanges();

    const cards: DebugElement[] = fixture.debugElement.queryAll(
      By.css('.card')
    );
    expect(cards.length).toBe(2);

    expect(cards[0].nativeElement.textContent).toContain('Product 1');
    expect(cards[0].nativeElement.textContent).toContain('10');

    expect(cards[1].nativeElement.textContent).toContain('Product 2');
    expect(cards[1].nativeElement.textContent).toContain('20');
  });

  it('should have routerLink on detail button', () => {
    component.services = dummyProducts;
    fixture.detectChanges();

    const buttons: DebugElement[] = fixture.debugElement.queryAll(
      By.css('.detail-button')
    );
    expect(buttons.length).toBe(2);

    expect(buttons[0].attributes['ng-reflect-router-link']).toBe('/product,1');
    expect(buttons[1].attributes['ng-reflect-router-link']).toBe('/product,2');
  });
});
