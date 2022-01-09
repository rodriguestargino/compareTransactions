import { ResponseMessageDetails } from './responseTransactionCompareDetails';
import { ResponseMessage } from './responseTransactionCompare';
import { Component, OnInit } from '@angular/core';
import { TransactionsCompareService } from 'src/app/transactions-compare.service';

@Component({
  selector: 'app-transaction-compare-form',
  templateUrl: './transaction-compare-form.component.html',
  styleUrls: ['./transaction-compare-form.component.css']
})
export class TransactionCompareFormComponent implements OnInit {

  formData = new FormData();

  responseMessage!: ResponseMessage;

  responseMessageDetails : ResponseMessageDetails[] = [];

  errors:String[]= []

  constructor(private service : TransactionsCompareService) {
  }

  ngOnInit(): void {
  }

  inputFileChange1(event : any){
    if(event.target.files && event.target.files[0]){
      const file = event.target.files[0];
      this.formData.append("file1", file); 
    }
  }

  inputFileChange2(event : any){
    if(event.target.files && event.target.files[0]){
      const file = event.target.files[0];
      this.formData.append("file2", file); 
    }
  }

  onSubmit(){
    this.service.compareTransactions(this.formData).subscribe(response => {
      this.responseMessage = response;
    } , errorResponse => {
        this.errors=[];
        this.errors.push(errorResponse.error.errors);
      }
    );
  }

  showRecords(){
    this.service.getTransactions().subscribe(response => {
        this.responseMessageDetails = response;
    });
  }

}
