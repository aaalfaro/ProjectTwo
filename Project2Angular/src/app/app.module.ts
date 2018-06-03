import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppRoutes } from '../shared/app-routes';
import {HttpClientModule} from '@angular/common/http';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';


import { AppComponent } from './app.component';
import { ProtractorComponent } from './components/protractor/protractor.component';
import { TestNgComponent } from './components/test-ng/test-ng.component';
import { HomeComponent } from './components/home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    ProtractorComponent,
    TestNgComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(AppRoutes, {onSameUrlNavigation: 'reload'}),
    HttpClientModule,
    
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [HomeComponent],
  exports:[RouterModule]
})
export class AppModule { }
