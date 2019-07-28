import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

/* Angular Material */
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatDialogModule,
  MatIconModule,
  MatInputModule,
  MatMenuModule,
  MatProgressSpinnerModule,
  MatSelectModule,
  MatTableModule,
  MatToolbarModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatExpansionModule,
  MatDividerModule,
  MatPaginatorModule,
  MatSortModule,
  MatSidenavModule,
  MatProgressBarModule,
  MatBadgeModule,
  MatChipsModule,
  MatSlideToggleModule,
  MatRadioModule,
  MatSnackBarModule
} from '@angular/material';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { MatTooltipModule } from '@angular/material/tooltip';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ChannelDetailComponent } from './components/channel-detail/channel-detail.component';
import { CustomerDetailComponent } from './components/customer-detail/customer-detail.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { ChannelsListComponent } from './components/channels-list/channels-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ChannelDetailComponent,
    CustomerDetailComponent,
    NavBarComponent,
    ChannelsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,

    /* Material imports */
    MatAutocompleteModule,
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatDialogModule,
    MatIconModule,
    MatInputModule,
    MatMenuModule,
    MatProgressSpinnerModule,
    MatSelectModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatToolbarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatGridListModule,
    MatFormFieldModule,
    ScrollingModule,
    MatExpansionModule,
    MatDividerModule,
    MatListModule,
    MatTooltipModule,
    MatSidenavModule,
    MatProgressBarModule,
    MatBadgeModule,
    MatChipsModule,
    MatSlideToggleModule,
    MatRadioModule,
    MatChipsModule,
    MatSnackBarModule
    /***/
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
