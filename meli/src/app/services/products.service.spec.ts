import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';

import { ProductDto } from '../domain/ProductDto';
import { Product } from '../domain/byId/Product';

import { SellerInfo } from '../domain/byId/SellerInfo';
import { AdditionalDetails } from '../domain/byId/AdditionalDetails';
import { ProductsService } from './products.service';

describe('ProductsService', () => {
  let service: ProductsService;
  let httpMock: HttpTestingController;
  const baseUrl = 'http://localhost:8080/api/v1';

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ProductsService],
    });

    service = TestBed.inject(ProductsService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    // Verifica que no haya solicitudes pendientes
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('getAllProducts() should return an Observable<ProductDto[]>', () => {
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

    service.getAllProducts().subscribe((products) => {
      expect(products.length).toBe(2);
      expect(products).toEqual(dummyProducts);
    });

    const req = httpMock.expectOne(`${baseUrl}/products`);
    expect(req.request.method).toBe('GET');

    // Responde la petición con datos dummy
    req.flush(dummyProducts);
  });

  it('getProductById() should return an Observable<Product>', () => {
    const dummySellerInfo: SellerInfo = {
      name: '',
      rating: 0,
      reviews: 0,
    };
    const dummyAdditionalDetails: AdditionalDetails = {
      brand: '',
      model: '',
      storage: '',
      ram: '',
      color: '',
    };
    const dummyProduct: Product = {
      id: '1',
      title: 'Product 1',
      price: 10,
      currency: 'USD',
      description: 'Some description',
      images: ['image1.jpg', 'image2.jpg'],
      sellerInfo: dummySellerInfo,
      paymentMethods: [],
      stock: 0,
      additionalDetails: dummyAdditionalDetails,
    };

    service.getProductById('1').subscribe((product) => {
      expect(product).toEqual(dummyProduct);
    });

    const req = httpMock.expectOne(`${baseUrl}/products/1`);
    expect(req.request.method).toBe('GET');

    req.flush(dummyProduct);
  });
});
