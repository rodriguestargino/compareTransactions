import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransactionCompareFormComponent } from './transaction-compare-form/transaction-compare-form.component';

const routes: Routes = [
  {path: 'transactioncompare-form', component:TransactionCompareFormComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TransactionCompareRoutingModule { }
