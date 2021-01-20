import { Component, OnInit } from '@angular/core';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from 'src/app/clientes/cliente';
import { ServicoPrestadoService } from 'src/app/servico-prestado.service';
import { ServicoPrestado } from '../servico-prestado';

@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrls: ['./servico-prestado-form.component.css']
})
export class ServicoPrestadoFormComponent implements OnInit {

  clientes: Cliente[] = [];
  servicoPrestado: ServicoPrestado = new ServicoPrestado();
  success: boolean = false;
  errors: string[];

  constructor(
    private clientesService: ClientesService,
    private service: ServicoPrestadoService
  ) { }

  ngOnInit(): void {
    this.clientesService
      .getClientes()
      .subscribe(response => this.clientes = response);
  }

  onSubmit(){
    this.service
      .salvar(this.servicoPrestado)
      .subscribe(response => {
        console.log(response);
        
        this.success = true;
        this.errors = null;
        this.servicoPrestado = new ServicoPrestado();

      }, errorResponse => {
        this.errors = errorResponse.error.errors;
        this.success = false;
      });
  }

}
