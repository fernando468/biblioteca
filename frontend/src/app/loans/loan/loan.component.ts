import { Component, OnInit } from '@angular/core';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';
import { Loan } from '../shared/loan.model';
import { LoanService } from '../shared/loan.service';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {
  loans: Loan[] = [];
  panelOpenState = false;
  statusList: any[] = [];
  statusSelected = '';
  user = {
    cpf: '12345678910'
  };

  constructor(private loanService: LoanService, private snackBar: SnackbarService) { }

  ngOnInit(): void {
    this.loanService.getStatusList().subscribe(response => {
      this.statusList = response;
    });
  }

  onSubmit(): void {
    if (this.user.cpf) {
      this.getLoans();
    }
  }

  getLoans(): void {
    this.loanService.getAllLoansByUserId(this.user.cpf, this.statusSelected).subscribe(response => {
      this.loans = response;
    });
  }

  onAccept(id: string): void {
    this.loanService.changeStatus(id, 'PENDENTE').subscribe(() => {
      this.snackBar.showMessage('Empréstimo aceito com sucesso!', false);
      this.getLoans();
    }, () => this.snackBar.showMessage('Ocorreu um erro ao aceitar o emprestimo!', true));
  }

  onFinish(id: string): void {
    this.loanService.changeStatus(id, 'FINALIZADO').subscribe(() => {
      this.snackBar.showMessage('Empréstimo finalizado com sucesso!', false);
      this.getLoans();
    }, () => this.snackBar.showMessage('Ocorreu um erro ao finalizar o emprestimo!', true));
  }

}
