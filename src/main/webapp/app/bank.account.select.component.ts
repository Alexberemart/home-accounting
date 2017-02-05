import {Component, OnInit, Output, EventEmitter} from "@angular/core";
import {BankAccountService} from "./bank.account.service";
import {BankAccount} from "./bankAccount";

@Component({
    selector: 'bank-account-selector',
    templateUrl: 'app/bank.account.select.component.html',
})
export class BankAccountSelectComponent implements OnInit{

    @Output() notify: EventEmitter<BankAccount> = new EventEmitter<BankAccount>();
    bankAccounts: BankAccount[] = [];
    errorMessage: any;
    selectedBankAccount : BankAccount;

    onClick2(selectedBankAccount : string) {
        onclick(JSON.parse(selectedBankAccount));
    }

    onClick(selectedBankAccount : BankAccount) {
        this.selectedBankAccount = selectedBankAccount;
        this.notify.emit(this.selectedBankAccount);
    }

    ngOnInit(): void {
        this.bankAccountService.getAll()
            .subscribe(
                bankAccounts => this.afterFindAll(bankAccounts),
                error => this.errorMessage = <any>error);
    }

    afterFindAll(bankAccounts) {
        this.bankAccounts = bankAccounts;
        this.onClick(bankAccounts[0]);
    }

    constructor(private bankAccountService: BankAccountService) {
    }
}
