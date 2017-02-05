import {Component, OnInit} from "@angular/core";
import {AccountingMovementService} from "./accountingMovement.service";
import {AccountingMovement} from "./accountingMovement";
import {AccountingMovementGroupByDate} from "./accountingMovementGroupByDate";
import {AccountingMovementGroupByMonth} from "./accountingMovementGroupByMonth";
import {BankAccount} from "./bankAccount";

@Component({
    selector: 'my-dashboard',
    templateUrl: 'app/dashboard.component.html',
})
export class DashboardComponent implements OnInit{

    accountingMovements : AccountingMovement[] = [];
    accountingMovementGroupByDate : AccountingMovementGroupByDate[] = [];
    accountingMovementGroupByMonth : AccountingMovementGroupByMonth[] = [];
    errorMessage : any;
    selectedBankAccount : BankAccount;

    ngOnInit(): void {
        this.accountingMovementService.getAll()
            .subscribe(
                accountingMovements => this.accountingMovements = accountingMovements,
                error => this.errorMessage = <any>error);
        this.accountingMovementService.getAmountGroupByDate()
            .subscribe(
                accountingMovementGroupByDate => this.accountingMovementGroupByDate = accountingMovementGroupByDate,
                error => this.errorMessage = <any>error);
        this.accountingMovementService.getAmountGroupByMonth()
            .subscribe(
                accountingMovementGroupByMonth => this.accountingMovementGroupByMonth = accountingMovementGroupByMonth,
                error => this.errorMessage = <any>error);
    }

    saveFile(name: string, selectedBankAccount : BankAccount) {
        if (!name) {
            return;
        }
        this.accountingMovementService.save(name, selectedBankAccount)
            .subscribe(
                accountingMovements => this.accountingMovements = accountingMovements,
                error => this.errorMessage = <any>error);
    }

    loadFile(event, selectedBankAccount : BankAccount) {
        let self = this;
        let files = event.srcElement.files;

        let myReader: FileReader = new FileReader();

        myReader.onloadend = function (e) {
            self.saveFile(myReader.result, selectedBankAccount);
        };

        myReader.readAsText(files[0]);
    }

    onNotifyBankAccountSelect(selectBankAccount:BankAccount):void {
        this.selectedBankAccount = selectBankAccount;
    }

    constructor(private accountingMovementService: AccountingMovementService) {
    }
}
