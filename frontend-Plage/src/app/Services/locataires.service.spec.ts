import { TestBed } from '@angular/core/testing';

import { LocatairesService } from './locataires.service';

describe('LocatairesService', () => {
  let service: LocatairesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LocatairesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
