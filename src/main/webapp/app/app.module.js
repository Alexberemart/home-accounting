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
var core_1 = require('@angular/core');
var platform_browser_1 = require('@angular/platform-browser');
var forms_1 = require('@angular/forms');
var http_1 = require('@angular/http');
var app_component_1 = require('./app.component');
var dashboard_component_1 = require('./dashboard.component');
var accountingMovement_service_1 = require('./accountingMovement.service');
var app_routing_1 = require('./app.routing');
var ng2_charts_1 = require('ng2-charts');
var chart_movement_component_1 = require("./chart.movement.component");
var chart_recap_component_1 = require("./chart.recap.component");
var chart_month_recap_component_1 = require("./chart.month.recap.component");
var bank_account_select_component_1 = require("./bank.account.select.component");
var bank_account_service_1 = require("./bank.account.service");
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [
                platform_browser_1.BrowserModule,
                forms_1.FormsModule,
                http_1.HttpModule,
                app_routing_1.routing,
                ng2_charts_1.ChartsModule
            ],
            declarations: [
                app_component_1.AppComponent,
                dashboard_component_1.DashboardComponent,
                chart_movement_component_1.ChartMovementsComponent,
                chart_recap_component_1.ChartRecapComponent,
                chart_month_recap_component_1.ChartMonthRecapComponent,
                bank_account_select_component_1.BankAccountSelectComponent
            ],
            bootstrap: [
                app_component_1.AppComponent
            ],
            providers: [
                accountingMovement_service_1.AccountingMovementService,
                bank_account_service_1.BankAccountService
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map