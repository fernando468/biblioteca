import { Component, OnInit } from '@angular/core';
import { Library } from '../shared/library.model';
import { LibraryService } from '../shared/library.service';

@Component({
  selector: 'app-library-list',
  templateUrl: './library-list.component.html',
  styleUrls: ['./library-list.component.css']
})
export class LibraryListComponent implements OnInit {
  libraries: Library[] = [];
  showFiller = false;
  page = 0;
  size = 5;
  pageable = {
    totalElements: 0,
  };
  constructor(private service: LibraryService) { }

  ngOnInit(): void {
    this.service.getAll(this.page, this.size).subscribe((response: any) => {
      this.libraries = response.content;
      this.pageable.totalElements = response.totalElements;
    });
  }

  handlePage(event: any): void {
    this.page = event?.pageIndex;
    this.service.getAll(this.page, this.size).subscribe((libraries: any) => {
      this.libraries = libraries.content;
      this.pageable.totalElements = libraries.totalElements;
    });
  }

}
