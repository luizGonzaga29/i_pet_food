import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { CadastroClienteComponent } from './views/cadastro-cliente/cadastro-cliente.component';
import { CadastroPetComponent } from './views/cadastro-pet/cadastro-pet.component';
import { CompraComponent } from './views/compra/compra.component';

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
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
