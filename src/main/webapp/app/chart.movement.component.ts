import {Component, Input, SimpleChange, OnChanges} from "@angular/core";
import {AccountingMovement} from "./accountingMovement";
import {ChartComponent} from "./chart.component";
import any = jasmine.any;

@Component({
    selector: 'chart-movements',
    templateUrl: 'app/chart.movement.component.html',
})
export class ChartMovementsComponent extends ChartComponent implements OnChanges {
    @Input() accountingMovements: AccountingMovement[];

    public lineChartData: Array<any> = [{data: [], label: 'Movements'}];
    public lineChartLabels: Array<any> = [];
    public lineChartOptions: any = {
        responsive: true,
        scales: {
            yAxes: [
                {
                    ticks: {
                        callback: function(label, index, labels) {
                            return label/1000+'k';
                        }
                    },
                    scaleLabel: {
                        display: true,
                        labelString: '1k = 1000'
                    }
                }
            ]
        }
    };
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
        console.log(this.accountingMovements);
        let values: Array<any> = [];

        if (!this.accountingMovements || this.accountingMovements.length == 0) {
            return [];
        }

        this.accountingMovements.forEach(function (heroe) {
            values.push(heroe.amount);
            self.lineChartLabels.push(heroe.date);
        });
        return values;
    }

    ngOnChanges(changes: {[accountingMovements: AccountingMovement[]]: SimpleChange}) {
        this.lineChartData[0].data = this.reloadData();
        this.lineChartData = this.lineChartData.slice();
    }

}
