import { Library } from 'src/app/libraries/shared/library.model';

export interface Loan {
  id: string;
  dateStart: string;
  dateEnd: string;
  status: string;
  customer: Customer;
  book: Book;
  library: Library;
}

export interface Book {
  id: string;
  title: string;
  file: File;
}

export interface File {
  fileName: string;
  originalFileName: string;
  url: string;
}

export interface Customer {
  id: string;
  name: string;
}
