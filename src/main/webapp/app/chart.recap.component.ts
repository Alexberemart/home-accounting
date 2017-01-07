import {Component, Input, OnChanges, SimpleChange} from "@angular/core";
import {ChartComponent} from "./chart.component";
import {AccountingMovementGroupByDate} from "./accountingMovementGroupByDate";
import any = jasmine.any;

@Component({
    selector: 'chart-recap',
    templateUrl: 'app/chart.recap.component.html',
})
export class ChartRecapComponent extends ChartComponent implements OnChanges {

    @Input() accountingMovementGroupByDate: AccountingMovementGroupByDate[];

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
        console.log(this.accountingMovementGroupByDate);
        let values: Array<any> = [];

        if (!this.accountingMovementGroupByDate || this.accountingMovementGroupByDate.length == 0) {
            return [];
        }

        this.accountingMovementGroupByDate.forEach(function (heroe) {
            values.push(heroe.amount);
            self.lineChartLabels.push(heroe.date);
        });
        return values;
    }

    ngOnChanges(changes: {[accountingMovementGroupByDate: AccountingMovementGroupByDate[]]: SimpleChange}): void {
        this.lineChartData[0].data = this.reloadData();
        this.lineChartData = this.lineChartData.slice();
    }

}
