"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
require('rxjs/add/operator/map');
require('rxjs/add/operator/catch');
var AccountingMovementService = (function () {
    function AccountingMovementService(http) {
        this.http = http;
    }
    AccountingMovementService.prototype.save = function (name, selectedBankAccount) {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.post("/api/accountingMovement/" + selectedBankAccount.id, name, options)
            .map(this.extractData)
            .catch(this.handleError);
    };
    AccountingMovementService.prototype.getAll = function () {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.get("/api/accountingMovement/findAllOrderByDate", options)
            .map(this.extractData)
            .catch(this.handleError);
    };
    AccountingMovementService.prototype.getAmountGroupByDate = function () {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.get("/api/accountingMovement/getAmountAccumulatedByDate", options)
            .map(this.extractData)
            .catch(this.handleError);
    };
    AccountingMovementService.prototype.getAmountGroupByMonth = function () {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.get("/api/accountingMovement/getAmountAccumulatedByDate", options)
            .map(this.extractData2)
            .catch(this.handleError);
    };
    AccountingMovementService.prototype.extractData = function (res) {
        var body = res.json();
        return body || [];
    };
    AccountingMovementService.prototype.extractData2 = function (res) {
        var body = res.json();
        var groups = {};
        body.forEach(function (element) {
            var d = new Date(element.date);
            var group = (d.getFullYear() * 100) + d.getMonth() + 1;
            groups[group] = groups[group] || [];
            groups[group].push(element);
        });
        return Object.keys(groups).map(function (group) {
            return groups[group];
        });
    };
    AccountingMovementService.prototype.handleError = function (error) {
        // In a real world app, we might use a remote logging infrastructure
        var errMsg;
        if (error instanceof http_1.Response) {
            var body = error.json() || '';
            var err = body.error || JSON.stringify(body);
            errMsg = error.status + " - " + (error.statusText || '') + " " + err;
        }
        else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return null;
    };
    AccountingMovementService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], AccountingMovementService);
    return AccountingMovementService;
}());
exports.AccountingMovementService = AccountingMovementService;
//# sourceMappingURL=accountingMovement.service.js.map