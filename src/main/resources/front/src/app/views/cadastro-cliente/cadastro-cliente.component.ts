import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../shared/cliente'
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-cadastro-cliente',
  templateUrl: './cadastro-cliente.component.html',
  styleUrls: ['./cadastro-cliente.component.css']
})
export class CadastroClienteComponent implements OnInit {

  formCliente!: FormGroup;

  constructor() { }

  ngOnInit(): void {
    this.createForm(new Cliente());
  }

  createForm(cliente: Cliente) {
    this.formCliente = new FormGroup({
      nome: new FormControl(cliente.nome),
      cPF: new FormControl(cliente.cPF),
      diaMesNascto: new FormControl(cliente.diaMesNascto),
      email: new FormControl(cliente.email)
    })
  }

  onSubmit() {
    console.log(this.formCliente.value);
  }

}
