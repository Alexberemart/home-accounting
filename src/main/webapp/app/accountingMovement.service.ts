import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {AccountingMovement} from "./accountingMovement";
import {AccountingMovementGroupByDate} from "./accountingMovementGroupByDate";

@Injectable()
export class AccountingMovementService {

    constructor(private http: Http) {
    }

    save(name: string): Observable<AccountingMovement[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.post("/api/accountingMovement", name, options)
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

    private extractData(res: Response) {
        let body = res.json();
        return body || [];
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