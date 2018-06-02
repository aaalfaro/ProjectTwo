import { Routes } from '@angular/router';
import { TestNgComponent } from '../app/components/test-ng/test-ng.component';
import { HomeComponent } from '../app/components/home/home.component';
import { ProtractorComponent } from '../app/components/protractor/protractor.component';

export const AppRoutes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'TestNG', component: TestNgComponent},
    { path: 'Protractor', component: ProtractorComponent}
]