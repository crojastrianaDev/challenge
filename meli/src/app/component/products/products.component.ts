import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { ProductDto } from '../../domain/ProductDto';
import { ProductsService } from '../../services/products.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css',
})
export class ProductsComponent {
  services: ProductDto[] = [];
  maxItemsToShow = 2;

  @ViewChild('cardContainer') cardContainer: ElementRef | undefined;

  constructor(public service: ProductsService) {}

  ngOnInit(): void {
    this.loadAllProducts();
  }

  loadAllProducts(): void {
    this.service.getAllProducts().subscribe((data: ProductDto[]) => {
      this.services = data;
    });
  }
}
