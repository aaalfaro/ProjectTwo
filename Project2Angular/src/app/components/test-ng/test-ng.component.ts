import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-test-ng',
  templateUrl: './test-ng.component.html',
  styleUrls: ['./test-ng.component.css']
})
export class TestNgComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit() {
  }

  getResults(): Observable<String>{
    return this.http.get<String>("http://ec2-54-161-125-174.compute-1.amazonaws.com:8090/ProjectTwo/TestNG");
  }

}
