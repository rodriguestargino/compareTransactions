import { TestBed } from '@angular/core/testing';

import { TransactionsCompareService } from './transactions-compare.service';

describe('TransactionsCompareService', () => {
  let service: TransactionsCompareService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransactionsCompareService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
