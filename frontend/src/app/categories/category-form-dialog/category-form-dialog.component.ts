import { Component, Inject, OnInit } from '@angular/core';
import { CategoryComponent } from '../category/category.component';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Category } from '../shared/category.model';
import { CategoryService } from '../shared/category.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';

@Component({
  selector: 'app-category-form-dialog',
  templateUrl: './category-form-dialog.component.html',
  styleUrls: ['./category-form-dialog.component.css']
})
export class CategoryFormDialogComponent implements OnInit {
  category: Category = { name: '' };

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<CategoryComponent>,
    private categoryService: CategoryService,
    private snackBar: SnackbarService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.category.name !== '') {
      this.categoryService.create(this.category).subscribe(() => {
        this.snackBar.showMessage('Categoria cadastrado com sucesso!', false);
        this.category = { name: '' };
        this.onNoClick();
      },
      () => this.snackBar.showMessage('Erro ao cadastrar a categoria!', true));
    }
  }

  onNoClick(event?: any): void {
    event?.preventDefault();
    this.dialogRef.close();
  }
}
