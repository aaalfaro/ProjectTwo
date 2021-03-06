import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-test-ng',
  templateUrl: './test-ng.component.html',
  styleUrls: ['./test-ng.component.css']
})
export class TestNgComponent implements OnInit {

  result: Object;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.getResults().subscribe(data=>this.result=data, err => console.log(err.error));
  }

  getResults(): Observable<string>{
    return this.http.get<string>("http://ec2-54-161-125-174.compute-1.amazonaws.com:8090/ProjectTwo/TestNGTest");

  }
}
