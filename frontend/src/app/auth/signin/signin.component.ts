import { Component, OnInit } from '@angular/core';
import { Auth } from '../shared/auth.model';
import { AuthService } from '../shared/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { setToken } from 'src/app/shared/utils/token';
import { Token } from '../shared/token.model';
import { Router } from '@angular/router';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  auth: Auth;

  constructor(private service: AuthService, private snackBar: SnackbarService, private router: Router) {
    this.auth = {
      email: 'admin1@email.com',
      password: '1234'
    };
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.service.signIn(this.auth).subscribe(response => {
      this.snackBar.showMessage('Login efetuado com sucesso!', false);
      setToken(response.token);
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate(['livro/lista']);
      });
    }, () => this.snackBar.showMessage('Ocorreu um erro ao realizar o login!', true)
    );
  }

}
