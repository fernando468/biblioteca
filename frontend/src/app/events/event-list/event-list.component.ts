import { Component, OnInit } from '@angular/core';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';
import { EventResponse } from '../shared/event.model';
import { EventService } from '../shared/event.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  events: EventResponse[] = [];
  page = 0;
  size = 5;
  pageable = {
    totalElements: 0,
  };

  constructor(private eventService: EventService, private snackBar: SnackbarService) { }

  ngOnInit(): void {
    this.getAllEvents(this.page, this.size);
  }

  handlePage(event: any): void {
    this.page = event?.pageIndex;
    this.getAllEvents(this.page, this.size);
  }

  getAllEvents(page: number, size: number): void {
    this.eventService.getAll(page, size).subscribe((libraries: any) => {
      this.events = libraries.content;
      this.pageable.totalElements = libraries.totalElements;
    });
  }

  changeStatus(event: EventResponse): void {
    this.eventService.update(event.id, 'FINALIZADO').subscribe(() => {
      this.snackBar.showMessage('Evento finalizado com sucesso!', false);
      this.getAllEvents(this.page, this.size);
    }, () => {
      this.snackBar.showMessage('Erro ao finalizar evento!', true);
    });
  }

}
