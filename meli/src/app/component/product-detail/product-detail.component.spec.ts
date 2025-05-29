import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ProductDetailComponent } from './product-detail.component';
import { ProductsService } from '../../services/products.service';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { Location } from '@angular/common';
import { CommonModule } from '@angular/common';
import { Product } from '../../domain/byId/Product';

describe('ProductDetailComponent', () => {
  let component: ProductDetailComponent;
  let fixture: ComponentFixture<ProductDetailComponent>;
  let productServiceMock: any;
  let locationMock: any;
  let activatedRouteMock: any;

  const mockProduct: Product = {
    id: '1',
    title: 'Test Product',
    description: 'A product for testing',
    price: 100,
    currency: 'USD',
    images: ['image1.jpg', 'image2.jpg'],
    sellerInfo: {
      name: '',
      rating: 0,
      reviews: 0,
    },
    paymentMethods: [],
    stock: 10,
    additionalDetails: {
      brand: '',
      model: '',
      storage: '',
      ram: '',
      color: '',
    },
  };

  beforeEach(async () => {
    productServiceMock = {
      getProductById: jasmine
        .createSpy('getProductById')
        .and.returnValue(of(mockProduct)),
    };

    locationMock = {
      back: jasmine.createSpy('back'),
    };

    activatedRouteMock = {
      snapshot: {
        paramMap: {
          get: jasmine.createSpy('get').and.returnValue('1'),
        },
      },
    };

    await TestBed.configureTestingModule({
      imports: [CommonModule],
      declarations: [ProductDetailComponent],
      providers: [
        { provide: ProductsService, useValue: productServiceMock },
        { provide: Location, useValue: locationMock },
        { provide: ActivatedRoute, useValue: activatedRouteMock },
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(ProductDetailComponent);
    component = fixture.componentInstance;
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should fetch product on init with the right id', () => {
    component.ngOnInit();

    expect(activatedRouteMock.snapshot.paramMap.get).toHaveBeenCalledWith('id');
    expect(productServiceMock.getProductById).toHaveBeenCalledWith('1');
    expect(component.product).toEqual(mockProduct);
  });

  it('should call location.back() on goBack()', () => {
    component.goBack();
    expect(locationMock.back).toHaveBeenCalled();
  });
});
