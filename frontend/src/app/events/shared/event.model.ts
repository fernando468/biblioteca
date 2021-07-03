import { Library } from 'src/app/libraries/shared/library.model';

export interface Event {
  title: string;
  libraryId: string;
  hour: string;
  date: string;
}

export interface EventResponse {
  id: string;
  title: string;
  library: Library;
  hour: string;
  date: string;
  status: string;
}
