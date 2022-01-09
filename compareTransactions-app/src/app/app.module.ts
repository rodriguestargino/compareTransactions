import { TransactionsCompareService } from './transactions-compare.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component'
import { TransactionCompareModule } from './transaction-compare/transaction-compare.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, 
    AppRoutingModule,
    TemplateModule,
    TransactionCompareModule
  ],
  providers: [
    TransactionsCompareService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
