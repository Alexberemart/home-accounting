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
var accountingMovement_service_1 = require("./accountingMovement.service");
var DashboardComponent = (function () {
    function DashboardComponent(accountingMovementService) {
        this.accountingMovementService = accountingMovementService;
        this.accountingMovements = [];
        this.accountingMovementGroupByDate = [];
        this.accountingMovementGroupByMonth = [];
    }
    DashboardComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.accountingMovementService.getAll()
            .subscribe(function (accountingMovements) { return _this.accountingMovements = accountingMovements; }, function (error) { return _this.errorMessage = error; });
        this.accountingMovementService.getAmountGroupByDate()
            .subscribe(function (accountingMovementGroupByDate) { return _this.accountingMovementGroupByDate = accountingMovementGroupByDate; }, function (error) { return _this.errorMessage = error; });
        this.accountingMovementService.getAmountGroupByMonth()
            .subscribe(function (accountingMovementGroupByMonth) { return _this.accountingMovementGroupByMonth = accountingMovementGroupByMonth; }, function (error) { return _this.errorMessage = error; });
    };
    DashboardComponent.prototype.saveFile = function (name) {
        var _this = this;
        if (!name) {
            return;
        }
        this.accountingMovementService.save(name)
            .subscribe(function (accountingMovements) { return _this.accountingMovements = accountingMovements; }, function (error) { return _this.errorMessage = error; });
    };
    DashboardComponent.prototype.loadFile = function (event) {
        var self = this;
        var files = event.srcElement.files;
        var myReader = new FileReader();
        myReader.onloadend = function (e) {
            self.saveFile(myReader.result);
        };
        myReader.readAsText(files[0]);
    };
    DashboardComponent = __decorate([
        core_1.Component({
            selector: 'my-dashboard',
            templateUrl: 'app/dashboard.component.html',
        }), 
        __metadata('design:paramtypes', [accountingMovement_service_1.AccountingMovementService])
    ], DashboardComponent);
    return DashboardComponent;
}());
exports.DashboardComponent = DashboardComponent;
//# sourceMappingURL=dashboard.component.js.map