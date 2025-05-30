import { AdditionalDetails } from './AdditionalDetails';
import { SellerInfo } from './SellerInfo';

export interface Product {
  id: string;
  title: string;
  description: string;
  price: number;
  currency: string;
  images: string[];
  sellerInfo: SellerInfo;
  paymentMethods: string[];
  stock: number;
  additionalDetails: AdditionalDetails;
}
