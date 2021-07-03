import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';
import { Cep } from '../shared/cep.model';
import { Library } from '../shared/library.model';
import { LibraryService } from '../shared/library.service';

@Component({
  selector: 'app-library-form',
  templateUrl: './library-form.component.html',
  styleUrls: ['./library-form.component.css']
})
export class LibraryFormComponent implements OnInit {
  cep = '';
  library: Library;

  constructor(
    private http: HttpClient,
    private service: LibraryService,
    private snackBar: SnackbarService,
    private router: Router
  ) {
    this.library = {
      address: '',
      neighborhood: '',
      cep: '',
      city: '',
      name: '',
      number: ''
    };
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.service.create(this.library).subscribe(() => {
      this.snackBar.showMessage('Biblioteca cadastrada com sucesso!', false);
      this.router.navigate(['/biblioteca/lista']);
    }, () => this.snackBar.showMessage('Erro ao cadastrar biblioteca!', true));
  }

  searchCep(): Observable<Cep> {
    return this.http.get<Cep>(`https://viacep.com.br/ws/${this.cep}/json/`);
  }

  changeCep(cep: string): void {
    if (cep.length === 8) {
      this.cep = cep.replace('-', '');
      this.searchCep().subscribe(data => {
        this.library = {
          city: data.localidade,
          cep: data.cep.replace('-', ''),
          neighborhood: data.bairro,
          address: data.logradouro,
          name: this.library.name,
          number: this.library.number
        };
      });
    }
  }

}
