import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  
  mensagemSucesso: string;
  erros: string[];

  cadastrando: boolean = false;

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(){

    this.authService
      .tentarLogar(this.username, this.password)
      .subscribe(response => {
        const access_token = JSON.stringify(response);
        localStorage.setItem('access_token', access_token);
        this.router.navigate(['home']);
      }, errorResponse => {
        this.erros = ['Usuário e/ou senha incorreto(s)'];
      })

  }

  preparaCadastrar(event){
    event.preventDefault();
    this.cadastrando = true;
  }

  cancelaCadastro(){
     this.cadastrando = false;
  }

  cadastrar(){
    const usuario: Usuario = new Usuario();
    usuario.username = this.username;
    usuario.password = this.password;
    this.authService
      .salvar(usuario)
      .subscribe(response => {
        this.mensagemSucesso = "Cadastro realizado com sucesso! Efetue o login."
        this.erros = null;
        this.cadastrando = false;
        this.username = '';
        this.password = '';
      }, errorResponse => {
        this.mensagemSucesso = null;
        this.erros = errorResponse.error.errors;
      });
  }
}
