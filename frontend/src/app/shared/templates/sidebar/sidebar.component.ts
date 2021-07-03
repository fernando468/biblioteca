import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  @ViewChild('sidenav') sidenav!: MatSidenav;
  @Input() showSubMenuLibrary = false;
  @Input() showSubmenuBook = false;
  isExpanded = true;
  isShowing = false;

  constructor() { }

  ngOnInit(): void {
  }

}
