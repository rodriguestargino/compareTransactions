import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResponseMessageDetails } from './transaction-compare/transaction-compare-form/responseTransactionCompareDetails';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TransactionsCompareService {

  constructor(private http: HttpClient) { }

  apiURlRecover: string = environment.apiUrl + "/matchfiles/api/csv/recover";

  apiURlUpload: string = environment.apiUrl + "/matchfiles/api/csv/upload/"

  getTransactions(){
    return this.http.get<ResponseMessageDetails[]>(`${this.apiURlRecover}`);
  }

  compareTransactions(formData : any) : Observable<any> {
      return this.http.post(`${this.apiURlUpload}`,formData,formData);
  }
}
