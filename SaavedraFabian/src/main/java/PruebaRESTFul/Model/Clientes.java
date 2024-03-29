package PruebaRESTFul.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")


public class Clientes {
	
	//********CONSTRUCTORES*********
	public Clientes() {}
	public Clientes(String rut, String nombres, String apellidos, String email, String celular) {
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.celular = celular;
	}



	@Id
	private String rut;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="email")
	private String email;
	@Column(name="celular")
	private String celular;
	
	
	
//********GETTERS AND SETTERS*********
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
//Para ver lo que retornan los metodos. 
	@Override
	public String toString() {
		return "Clientes [rut=" + rut + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", celular=" + celular + "]";
	}
	
	
	public boolean equals(Clientes a) {
		if(this.nombres.equalsIgnoreCase(a.nombres) && this.rut.equalsIgnoreCase(a.rut)) {
			if(this.apellidos.equalsIgnoreCase(a.apellidos) && this.email.equalsIgnoreCase(a.email)) {
				if(this.celular.equalsIgnoreCase(a.celular)) {
					return true;
				}else return false;
			}else return false;
		}else return false;
	}
	
}
