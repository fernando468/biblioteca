import jwtDecode from 'jwt-decode';

export function setToken(token: string): void {
  localStorage.setItem('token', token);
}

export function getToken() {
  return localStorage.getItem('token');
}

export function getDecodedToken(token: string) {
  return jwtDecode(token);
}

export function removeToken(): void {
  localStorage.removeItem('token');
}
