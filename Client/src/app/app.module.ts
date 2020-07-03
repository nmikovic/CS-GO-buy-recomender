import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RecommendComponent } from './recommend/recommend.component';
import { AddNewRuleComponent } from './add-new-rule/add-new-rule.component';
import { AppRoutingModule} from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    RecommendComponent,
    AddNewRuleComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
