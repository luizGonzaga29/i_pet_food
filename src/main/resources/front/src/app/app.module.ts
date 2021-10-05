import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { CadastroClienteComponent } from './views/cadastro-cliente/cadastro-cliente.component';
import { CadastroPetComponent } from './views/cadastro-pet/cadastro-pet.component';
import { CompraComponent } from './views/compra/compra.component';

import { ClienteService } from '../app/services/cliente.service'

@NgModule({
  declarations: [
    AppComponent,
    CadastroClienteComponent,
    CadastroPetComponent,
    CompraComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ClienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
