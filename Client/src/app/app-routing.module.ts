import { NgModule } from '@angular/core';
import {Routes , RouterModule} from '@angular/router';
import {RecommendComponent} from './recommend/recommend.component';
import {AddNewRuleComponent} from './add-new-rule/add-new-rule.component';

const routes: Routes = [
  {path : 'recommend', component: RecommendComponent},
  {path : 'newRule', component: AddNewRuleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
