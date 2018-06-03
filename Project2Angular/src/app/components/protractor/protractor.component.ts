import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-protractor',
  templateUrl: './protractor.component.html',
  styleUrls: ['./protractor.component.css']
})
export class ProtractorComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit() {
  }
  getResults(): Observable<String>{
    return this.http.get<String>("http://localhost:8080/ProjectTwo/Protractor");

  }
}
