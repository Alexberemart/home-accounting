"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
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
var chart_component_1 = require("./chart.component");
var ChartMovementsComponent = (function (_super) {
    __extends(ChartMovementsComponent, _super);
    function ChartMovementsComponent() {
        _super.apply(this, arguments);
        this.lineChartData = [{ data: [], label: 'Movements' }];
        this.lineChartLabels = [];
        this.lineChartColors = [
            {
                backgroundColor: 'rgba(148,159,177,0.2)',
                borderColor: 'rgba(148,159,177,1)',
                pointBackgroundColor: 'rgba(148,159,177,1)',
                pointBorderColor: '#fff',
                pointHoverBackgroundColor: '#fff',
                pointHoverBorderColor: 'rgba(148,159,177,0.8)'
            }
        ];
        this.lineChartLegend = true;
        this.lineChartType = 'line';
    }
    ChartMovementsComponent.prototype.reloadData = function () {
        var self = this;
        console.log(this.accountingMovements);
        var values = [];
        if (!this.accountingMovements || this.accountingMovements.length == 0) {
            return [];
        }
        this.accountingMovements.forEach(function (heroe) {
            values.push(heroe.amount);
            self.lineChartLabels.push(heroe.date);
        });
        return values;
    };
    ChartMovementsComponent.prototype.ngOnChanges = function (changes) {
        this.lineChartData[0].data = this.reloadData();
        this.lineChartData = this.lineChartData.slice();
    };
    __decorate([
        core_1.Input(), 
        __metadata('design:type', Array)
    ], ChartMovementsComponent.prototype, "accountingMovements", void 0);
    ChartMovementsComponent = __decorate([
        core_1.Component({
            selector: 'chart-movements',
            templateUrl: 'app/chart.movement.component.html',
        }), 
        __metadata('design:paramtypes', [])
    ], ChartMovementsComponent);
    return ChartMovementsComponent;
}(chart_component_1.ChartComponent));
exports.ChartMovementsComponent = ChartMovementsComponent;
//# sourceMappingURL=chart.movement.component.js.map