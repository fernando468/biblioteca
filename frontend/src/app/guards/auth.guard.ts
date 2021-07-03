import { Injectable } from '@angular/core';
import { CanActivate, CanLoad, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { getToken } from '../shared/utils/token';

@Injectable()
export class AuthGuard implements CanActivate, CanLoad {
  constructor(
    private router: Router
  ) { }

  canActivate(): Observable<boolean> | boolean {
    return this.verificarAcesso();
  }

  private verificarAcesso(): boolean {
    if (getToken() != null) {
      return true;
    }
    this.router.navigate(['/']);
    return false;
  }

  canLoad(): Observable<boolean> | Promise<boolean> | boolean {
    return this.verificarAcesso();
  }

}
