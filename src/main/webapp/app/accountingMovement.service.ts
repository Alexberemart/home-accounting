import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {AccountingMovement} from "./accountingMovement";
import {AccountingMovementGroupByDate} from "./accountingMovementGroupByDate";
import {AccountingMovementGroupByMonth} from "./accountingMovementGroupByMonth";
import {BankAccount} from "./bankAccount";

@Injectable()
export class AccountingMovementService {

    constructor(private http: Http) {
    }

    save(name: string, selectedBankAccount : BankAccount): Observable<AccountingMovement[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.post("/api/accountingMovement/" + selectedBankAccount.id, name, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getAll(): Observable<AccountingMovement[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.get("/api/accountingMovement/findAllOrderByDate", options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getAmountGroupByDate(): Observable<AccountingMovementGroupByDate[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.get("/api/accountingMovement/getAmountAccumulatedByDate", options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getAmountGroupByMonth(): Observable<AccountingMovementGroupByMonth[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.get("/api/accountingMovement/getAmountAccumulatedByDate", options)
            .map(this.extractData2)
            .catch(this.handleError);
    }

    private extractData(res: Response) {
        let body = res.json();
        return body || [];
    }

    private extractData2(res: Response) {
        let body = res.json();
        var groups = {};
        body.forEach(function(element){
            var d = new Date(element.date);
            var group = (d.getFullYear() * 100) + d.getMonth() + 1;
            groups[group] = groups[group] || [];
            groups[group].push(element);
        });
        return Object.keys(groups).map( function( group )
        {
            return groups[group];
        })
    }

    private handleError(error: Response | any) {
        // In a real world app, we might use a remote logging infrastructure
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return null;
    }
}