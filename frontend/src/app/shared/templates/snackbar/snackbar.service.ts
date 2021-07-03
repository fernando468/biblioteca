import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {
  constructor(private snackBar: MatSnackBar) { }

  showMessage(message: string, isError: boolean = false): void {
    this.snackBar.open(message, '', {
      duration: 4000,
      horizontalPosition: 'left',
      verticalPosition: 'top',
      panelClass: isError ? ['warn'] : ['success']
    })
  }

}
