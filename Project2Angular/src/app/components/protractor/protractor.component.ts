import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-protractor',
  templateUrl: './protractor.component.html',
  styleUrls: ['./protractor.component.css']
})
export class ProtractorComponent implements OnInit {

  result: Object;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.getResults().subscribe(data=>this.result=data, err => console.log(err.error));
  }
  getResults(): Observable<string>{
    return this.http.get<string>("http://localhost:8080/ProjectTwo/Protractor");

  }
}
