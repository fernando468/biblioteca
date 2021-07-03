import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './auth/signin/signin.component';
import { BookDetailComponent } from './books/book-detail/book-detail.component';
import { BookFormComponent } from './books/book-form/book-form.component';
import { BookListComponent } from './books/book-list/book-list.component';
import { CategoryComponent } from './categories/category/category.component';
import { EventFormComponent } from './events/event-form/event-form.component';
import { EventListComponent } from './events/event-list/event-list.component';
import { AuthGuard } from './guards/auth.guard';
import { LanguageComponent } from './languages/language/language.component';
import { AddBookComponent } from './libraries/add-book/add-book.component';
import { LibraryFormComponent } from './libraries/library-form/library-form.component';
import { LibraryListComponent } from './libraries/library-list/library-list.component';
import { LoanComponent } from './loans/loan/loan.component';

const routes: Routes = [{
  path: 'login',
  component: SigninComponent,
}, {
  path: '',
  redirectTo: 'login',
  pathMatch: 'full'
}, {
  path: 'livro/lista',
  component: BookListComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'livro/form',
  component: BookFormComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'livro/lista/:id',
  component: BookDetailComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'biblioteca/form',
  component: LibraryFormComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'biblioteca/lista',
  component: LibraryListComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'biblioteca/adicionar-livro',
  component: AddBookComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'biblioteca/evento/form',
  component: EventFormComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'biblioteca/evento/lista',
  component: EventListComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'categoria',
  component: CategoryComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'idioma',
  component: LanguageComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}, {
  path: 'emprestimo',
  component: LoanComponent,
  canActivate: [AuthGuard],
  canLoad: [AuthGuard]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
