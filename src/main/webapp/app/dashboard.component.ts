import {Component, OnInit} from "@angular/core";
import {AccountingMovementService} from "./accountingMovement.service";
import {AccountingMovement} from "./accountingMovement";
import {AccountingMovementGroupByDate} from "./accountingMovementGroupByDate";

@Component({
    selector: 'my-dashboard',
    templateUrl: 'app/dashboard.component.html',
})
export class DashboardComponent implements OnInit{

    accountingMovements : AccountingMovement[] = [];
    accountingMovementGroupByDate : AccountingMovementGroupByDate[] = [];
    errorMessage : any;

    ngOnInit(): void {
        this.accountingMovementService.getAll()
            .subscribe(
                accountingMovements => this.accountingMovements = accountingMovements,
                error => this.errorMessage = <any>error);
        this.accountingMovementService.getAmountGroupByDate()
            .subscribe(
                accountingMovementGroupByDate => this.accountingMovementGroupByDate = accountingMovementGroupByDate,
                error => this.errorMessage = <any>error);
    }

    saveFile(name: string) {
        if (!name) {
            return;
        }
        this.accountingMovementService.save(name)
            .subscribe(
                accountingMovements => this.accountingMovements = accountingMovements,
                error => this.errorMessage = <any>error);
    }

    loadFile(event) {
        let self = this;
        let files = event.srcElement.files;

        let myReader: FileReader = new FileReader();

        myReader.onloadend = function (e) {
            self.saveFile(myReader.result);
        };

        myReader.readAsText(files[0]);
    }

    constructor(private accountingMovementService: AccountingMovementService) {
    }
}
