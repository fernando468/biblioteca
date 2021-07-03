import { Component, OnInit } from '@angular/core';
import {
  MatDialog
} from '@angular/material/dialog';
import { CategoryFormDialogComponent } from '../category-form-dialog/category-form-dialog.component';
import { Category } from '../shared/category.model';
import { CategoryService } from '../shared/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  genres: Category[] = [];
  dialogOpened = false;

  constructor(
    private categoryService: CategoryService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.listCategories();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CategoryFormDialogComponent);
    dialogRef.afterClosed().subscribe(() => {
      this.listCategories();
    });
  }

  listCategories(): void {
    this.categoryService.getAll().subscribe(response => {
      this.genres = response;
    });
  }

}
