import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { MatPaginatorIntl } from '@angular/material/paginator';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthModule } from './auth/auth.module';
import { BooksModule } from './books/books.module';
import { CategoriesModule } from './categories/categories.module';
import { EventsModule } from './events/events.module';
import { AuthGuard } from './guards/auth.guard';
import { LanguagesModule } from './languages/languages.module';
import { LibrariesModule } from './libraries/libraries.module';
import { LoansModule } from './loans/loans.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    BooksModule,
    LibrariesModule,
    CategoriesModule,
    AuthModule,
    LanguagesModule,
    LoansModule,
    EventsModule
  ],
  providers: [
    { provide: MatPaginatorIntl, useClass: AppComponent },
    { provide: MAT_DATE_LOCALE, useValue: 'pt-BR' },
    AuthGuard
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
