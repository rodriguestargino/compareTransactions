import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TransactionCompareRoutingModule } from './transaction-compare-routing.module';
import { TransactionCompareFormComponent } from './transaction-compare-form/transaction-compare-form.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    TransactionCompareFormComponent
  ],
  imports: [
    CommonModule,
    TransactionCompareRoutingModule,
    FormsModule
  ],
  exports: [
    TransactionCompareFormComponent
  ]
})
export class TransactionCompareModule { }
