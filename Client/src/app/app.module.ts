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
import { CodeViewerComponent } from './add-new-rule/code-viewer/code-viewer.component';
import {HIGHLIGHT_OPTIONS, HighlightModule} from 'ngx-highlightjs';
import { FactsListComponent } from './add-new-rule/facts-list/facts-list.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {UrlInterceptor} from './interceptors/url.interceptor';
import {MatListModule} from '@angular/material/list';
import {MatSelectModule} from '@angular/material/select';
import { TextEditorComponent } from './add-new-rule/text-editor/text-editor.component';
import {MatInputModule} from '@angular/material/input';
import {MatStepperModule} from '@angular/material/stepper';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MAT_SNACK_BAR_DEFAULT_OPTIONS, MatSnackBarModule} from '@angular/material/snack-bar';
import { MatCardModule } from '@angular/material/card';

export function getHighlightLanguages() {
  return {
    java: () => import('highlight.js/lib/languages/java'),
  };
}

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    RecommendComponent,
    AddNewRuleComponent,
    CodeViewerComponent,
    FactsListComponent,
    TextEditorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatButtonModule,
    HighlightModule,
    HttpClientModule,
    MatListModule,
    MatSelectModule,
    MatInputModule,
    MatStepperModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    FormsModule,
    MatSnackBarModule,
    MatCardModule
  ],
  providers: [
    {
      provide: HIGHLIGHT_OPTIONS,
      useValue: {
        languages: getHighlightLanguages()
      }
    },
    {provide: HTTP_INTERCEPTORS, useClass: UrlInterceptor, multi: true},
    {provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: {duration: 3000}}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
