import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../shared/cliente'
import { ClienteService } from '../../services/cliente.service'
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-cadastro-cliente',
  templateUrl: './cadastro-cliente.component.html',
  styleUrls: ['./cadastro-cliente.component.css']
})
export class CadastroClienteComponent implements OnInit {

  formCliente!: FormGroup;

  constructor(private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.createForm(new Cliente());
  }

  createForm(cliente: Cliente) {
    this.formCliente = new FormGroup({
      nome: new FormControl(cliente.nome),
      cPF: new FormControl(cliente.cPF),
      diaMesNascto: new FormControl(cliente.diaMesNascto),
      email: new FormControl(cliente.email),
      dDD: new FormControl(cliente.dDD),
      celular: new FormControl(cliente.celular),
      bairro: new FormControl(cliente.bairro)
    })
  }

  onSubmit() {
    const data = {
      nome: this.formCliente.controls.nome.value,
      cpf: this.formCliente.controls.cPF.value,
      dataNascimento: this.formCliente.controls.diaMesNascto.value,
      email: this.formCliente.controls.email.value,
      ddd: this.formCliente.controls.dDD.value,
      numCelular: this.formCliente.controls.celular.value,
      bairro: this.formCliente.controls.bairro.value
    }

    this.clienteService.create(data).subscribe(res => console.log(res), error => console.log(error))
  }

}
