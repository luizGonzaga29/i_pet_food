import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormArray, FormBuilder } from '@angular/forms'
import { Compra } from '../../shared/compra'

interface Racoes {
  id: number;
  nome: string;
  preco: number
}

@Component({
  selector: 'app-compra',
  templateUrl: './compra.component.html',
  styleUrls: ['./compra.component.css']
})
export class CompraComponent implements OnInit {

  formCompra!: FormGroup

  racoes: Racoes[] = [
    {
      id: 1,
      nome: "El Dorado",
      preco: 23.75
    },
    {
      id: 2,
      nome: "Pedigree",
      preco: 11.59
    }
  ];

  constructor() {
  }

  ngOnInit(): void {
    this.createForm(new Compra())
  }

  createForm(compra: Compra) {
    this.formCompra = new FormGroup({
      racoes: new FormArray(compra.racoes),
      quantidade: new FormControl(compra.quantidade),
      preco: new FormControl(compra.preco)
    })
  }

}
