import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { getDecodedToken, getToken, removeToken } from '../../utils/token';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  name: any;
  constructor(private router: Router) { }

  ngOnInit(): void {
    const token: any = getToken() || '';
    const tokenDecoded: any = getDecodedToken(token);
    this.name = tokenDecoded.name;
  }

  signOut(): void {
    removeToken();
    this.router.navigate(['/']);
  }

}
