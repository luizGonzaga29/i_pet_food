import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroClienteComponent } from '../app/views/cadastro-cliente/cadastro-cliente.component'
import { CadastroPetComponent } from '../app/views/cadastro-pet/cadastro-pet.component'
import { CompraComponent } from '../app/views/compra/compra.component'

const routes: Routes = [
  {
    path: '',
    component: CadastroClienteComponent
  },
  {
    path: "cadastro-pet",
    component: CadastroPetComponent
  },
  {
    path: "comprar",
    component: CompraComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
