export abstract class ChartComponent {

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
            ],
            xAxes: [
                {
                    ticks: {
                        callback: function(label, index, labels) {
                            var date = new Date(label);
                            return date.getUTCDate() + '-' + (date.getUTCMonth() + 1) + '-' + date.getUTCFullYear();
                        }
                    }
                }
            ]
        }
    };

    abstract reloadData();

}
