import { Component, OnInit } from '@angular/core';
import { Pet } from '../../shared/pet'
import { PetService } from '../../services/pet.service'
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-cadastro-pet',
  templateUrl: './cadastro-pet.component.html',
  styleUrls: ['./cadastro-pet.component.css']
})
export class CadastroPetComponent implements OnInit {

  formPet!: FormGroup

  constructor(private petService: PetService) { }

  ngOnInit(): void {
    this.createForm(new Pet())
  }

  createForm(pet: Pet) {
    this.formPet = new FormGroup({
      clienteCPF: new FormControl(pet.clienteCPF),
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
    const data = {
      especie: this.formPet.controls.especie.value,
      nome: this.formPet.controls.nome.value,
      apelido: this.formPet.controls.apelido.value,
      dataNascimento: this.formPet.controls.dtNascto.value,
      raca: this.formPet.controls.raca.value,
      genero: this.formPet.controls.genero.value,
      peso: this.formPet.controls.peso.value,
    }

    this.petService.create(data).subscribe(res => console.log(res), error => console.log(error));
  }

}
