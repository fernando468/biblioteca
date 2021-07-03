export interface BookResponse {
  id?: string;
  title: string;
  isbn: string;
  yearOfPublication: string;
  edition: string;
  synopsis: string;
  totalPages: number;
  authors: Author[];
  category: string;
  language: string;
  file: File;
  libraries: Library[];
  publishingCompany: string;
}

export interface BookForm {
  title: string;
  isbn: string;
  yearOfPublication: string;
  edition: string;
  synopsis: string;
  totalPages: number;
  authors: Author[];
  genreId: string;
  languageId: string;
  file: File;
  libraries: Library[];
  publishingCompany: string;
}

export interface Category {
  id?: string;
  name: string;
}

export interface Language {
  id?: string;
  name: string;
}

export interface Author {
  id?: string;
  name: string;
}

export interface File {
  fileName: string;
  originalFileName: string;
  url: string;
}

export interface Library {
  id?: string;
  cep: string;
  address: string;
  city: string;
  number: string;
  name: string;
  bairro: string;
}
