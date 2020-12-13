import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs'; // modulo reativo
import { environment } from 'src/environments/environment';
import { Cliente } from './clientes/cliente';
import { ClientesModule } from './clientes/clientes.module';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  apiURL : string = environment.apiURLBase + '/api/clients';

    constructor(private http : HttpClient) { }

  salvar(cliente: Cliente) : Observable<Cliente> {
    return this.http.post<Cliente>(`${this.apiURL}`, cliente);
  }

  atualizar(cliente: Cliente) : Observable<any> {
    return this.http.put<Cliente>(`${this.apiURL}/${cliente.id}`, cliente);
  }

  deletar(cliente: Cliente) : Observable<any> {
    return this.http.delete<any>(`${this.apiURL}/${cliente.id}`);
  }

  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.apiURL}`);
  }

  getClientePorId(id: number) : Observable<Cliente>{
    return this.http.get<Cliente>(`${this.apiURL}/${id}`);

  }
}
