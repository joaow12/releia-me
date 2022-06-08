import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/model/Cliente';
import { ClienteLogin } from 'src/app/model/ClienteLogin';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  cliente: Cliente = new Cliente
  clienteLogin: ClienteLogin = new ClienteLogin

  constructor(
    private authService:AuthService
  ) { }

  ngOnInit() {
    window.scroll(0,0)
  }
  cadastrar() {
    this.authService.cadastrar(this.cliente).subscribe((resp: Cliente)=>{
      this.cliente = resp
      alert('Cliente cadastrado com sucesso!!!')
    })
  }

}
