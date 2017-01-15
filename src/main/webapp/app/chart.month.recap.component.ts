import {Component, Input, OnChanges, SimpleChange} from "@angular/core";
import {ChartComponent} from "./chart.component";
import {AccountingMovementGroupByDate} from "./accountingMovementGroupByDate";
import any = jasmine.any;
import {AccountingMovementGroupByMonth} from "./accountingMovementGroupByMonth";

@Component({
    selector: 'chart-month-recap',
    templateUrl: 'app/chart.recap.component.html',
})
export class ChartMonthRecapComponent extends ChartComponent implements OnChanges {

    @Input() accountingMovementGroupByMonth: AccountingMovementGroupByMonth[];

    public lineChartData: Array<any> = [{data: [], label: 'Movements'}];
    public lineChartLabels: Array<any> = [];
    public lineChartColors: Array<any> = [
        { // grey
            backgroundColor: 'rgba(148,159,177,0.2)',
            borderColor: 'rgba(148,159,177,1)',
            pointBackgroundColor: 'rgba(148,159,177,1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(148,159,177,0.8)'
        }
    ];
    public lineChartLegend: boolean = true;
    public lineChartType: string = 'line';

    reloadData() {
        let self = this;
        console.log(this.accountingMovementGroupByMonth);
        let values: Array<any> = [];

        if (!this.accountingMovementGroupByMonth || this.accountingMovementGroupByMonth.length == 0) {
            return [];
        }

        this.accountingMovementGroupByMonth.forEach(function (heroe) {
            values.push(heroe[0].amount);
            self.lineChartLabels.push(heroe[0].date);
        });
        return values;
    }

    ngOnChanges(changes: {[accountingMovementGroupByMonth: AccountingMovementGroupByMonth[]]: SimpleChange}): void {
        this.lineChartData[0].data = this.reloadData();
        this.lineChartData = this.lineChartData.slice();
    }

}
