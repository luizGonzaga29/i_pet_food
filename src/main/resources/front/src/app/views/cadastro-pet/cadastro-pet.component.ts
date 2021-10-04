import { Component, OnInit } from '@angular/core';
import { Pet } from '../../shared/pet'
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-cadastro-pet',
  templateUrl: './cadastro-pet.component.html',
  styleUrls: ['./cadastro-pet.component.css']
})
export class CadastroPetComponent implements OnInit {

  formPet!: FormGroup

  constructor() { }

  ngOnInit(): void {
    this.createForm(new Pet())
  }

  createForm(pet: Pet) {
    this.formPet = new FormGroup({
      especie: new FormControl(pet.especie),
      nome: new FormControl(pet.nome),
      apelido: new FormControl(pet.apelido),
      dtNascto: new FormControl(pet.dtNascto),
      raca: new FormControl(pet.raca),
      genero: new FormControl(pet.genero),
      peso: new FormControl(pet.peso),
      isCastrado: new FormControl(pet.isCastrado)
    })
  }

  onSubmit() {
    console.log(this.formPet.value);
  }

}
