import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Library } from 'src/app/libraries/shared/library.model';
import { LibraryService } from 'src/app/libraries/shared/library.service';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';
import { Event } from '../shared/event.model';
import { EventService } from '../shared/event.service';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent implements OnInit {
  event: Event;
  dateSelected = '';
  libraries: Library[] = [];
  minDate: any;
  constructor(
    private eventService: EventService,
    private libraryService: LibraryService,
    private snackBar: SnackbarService,
    private router: Router
  ) {
    this.event = {
      date: '',
      hour: '',
      libraryId: '',
      title: ''
    };
    const year = new Date().getFullYear();
    const month = new Date().getMonth();
    const day = new Date().getDay();
    this.minDate = new Date(year, month, day);
  }

  ngOnInit(): void {
    this.libraryService.getAll(0, 10).subscribe((response: any) => {
      this.libraries = response.content;
    });
  }


  onSubmit(): void {
    const date = new Date(this.dateSelected);
    this.event.date = date.toLocaleDateString();
    this.eventService.create(this.event).subscribe(() => {
      this.snackBar.showMessage('Evento cadastrado com sucesso!', false);
      this.router.navigate(['/biblioteca/evento/lista']);
    }, () => {
      this.snackBar.showMessage('Erro ao cadastrar evento!', true);
    });
  }

}
