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
var bank_account_service_1 = require("./bank.account.service");
var BankAccountSelectComponent = (function () {
    function BankAccountSelectComponent(bankAccountService) {
        this.bankAccountService = bankAccountService;
        this.notify = new core_1.EventEmitter();
        this.bankAccounts = [];
    }
    BankAccountSelectComponent.prototype.onClick2 = function (selectedBankAccount) {
        onclick(JSON.parse(selectedBankAccount));
    };
    BankAccountSelectComponent.prototype.onClick = function (selectedBankAccount) {
        this.selectedBankAccount = selectedBankAccount;
        this.notify.emit(this.selectedBankAccount);
    };
    BankAccountSelectComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.bankAccountService.getAll()
            .subscribe(function (bankAccounts) { return _this.afterFindAll(bankAccounts); }, function (error) { return _this.errorMessage = error; });
    };
    BankAccountSelectComponent.prototype.afterFindAll = function (bankAccounts) {
        this.bankAccounts = bankAccounts;
        this.onClick(bankAccounts[0]);
    };
    __decorate([
        core_1.Output(), 
        __metadata('design:type', core_1.EventEmitter)
    ], BankAccountSelectComponent.prototype, "notify", void 0);
    BankAccountSelectComponent = __decorate([
        core_1.Component({
            selector: 'bank-account-selector',
            templateUrl: 'app/bank.account.select.component.html',
        }), 
        __metadata('design:paramtypes', [bank_account_service_1.BankAccountService])
    ], BankAccountSelectComponent);
    return BankAccountSelectComponent;
}());
exports.BankAccountSelectComponent = BankAccountSelectComponent;
//# sourceMappingURL=bank.account.select.component.js.map