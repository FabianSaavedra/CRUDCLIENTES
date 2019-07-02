package PruebaRESTFul.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import PruebaRESTFul.Model.Clientes;
import PruebaRESTFul.Model.Repository.ClientesRepositorio;

@RestController
public class Controlador {
	
	@Autowired
	ClientesRepositorio clienteDAO;
	
	
//**********READ
	@GetMapping("/clientes")
	public List<Clientes> ReadCientes(){
		return this.clienteDAO.findAll();
	}
//**********READ
	@GetMapping("/clientes/{rut}")
	public Clientes ReadCliente(@PathVariable String rut) {
		System.out.println("rut: " + rut);
		return this.clienteDAO.findById(rut).orElse(new Clientes());
	}
	
//**********CREATE
	@PostMapping("/clientes/nuevo")
	public boolean CreateCliente(@RequestBody Clientes nuevoCliente) {
		if(!this.clienteDAO.existsById(nuevoCliente.getRut())) {
			this.clienteDAO.save(nuevoCliente);
			return true;
		}else return false;
		
	}

//**********UPDATE
	@PutMapping("/cliente/modificar")
	public boolean UpdateCliente(@RequestBody Clientes clienteModi) {
		if(this.clienteDAO.existsById(clienteModi.getRut())) {	
			this.clienteDAO.save(clienteModi);
			return true;}else 
		return false;
	}
	
//**********DELETE
	@DeleteMapping("/cliente/eliminar/{rut}")
	public boolean deleteCliente(@PathVariable String rut) {
		
		if(rut.equalsIgnoreCase("99999999-9")) {
			this.clienteDAO.deleteAll();
			return true;
		}else if(!rut.equalsIgnoreCase("99999999-9") && this.clienteDAO.existsById(rut)){
			this.clienteDAO.deleteById(rut);
			return true;
		}else if(!this.clienteDAO.existsById(rut)) {
			return false;
		}
	
		return false;	
	
	}
}
