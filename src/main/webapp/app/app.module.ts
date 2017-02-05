import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpModule }     from '@angular/http';

import { AppComponent }        from './app.component';
import { DashboardComponent }        from './dashboard.component';
import { AccountingMovementService } from './accountingMovement.service';
import { routing } from './app.routing';
import { ChartsModule } from 'ng2-charts';
import {ChartMovementsComponent} from "./chart.movement.component";
import {ChartRecapComponent} from "./chart.recap.component";
import {ChartMonthRecapComponent} from "./chart.month.recap.component";
import {BankAccountSelectComponent} from "./bank.account.select.component";
import {BankAccountService} from "./bank.account.service";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        routing,
        ChartsModule
    ],
    declarations: [
        AppComponent,
        DashboardComponent,
        ChartMovementsComponent,
        ChartRecapComponent,
        ChartMonthRecapComponent,
        BankAccountSelectComponent
    ],
    bootstrap:    [
        AppComponent
    ],
    providers: [
        AccountingMovementService,
        BankAccountService
    ]
})
export class AppModule { }
