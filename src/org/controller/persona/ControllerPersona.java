package org.controller.persona;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dao.persona.DaoPersona;
import org.modelo.persona.Persona;

@ManagedBean
@ViewScoped
public class ControllerPersona implements Serializable{

	private static final long serialVersionUID = 1L;
	private Persona persona=null;
	private List<Persona> listaPersonas=null;
	//constructor
	public ControllerPersona() {
		super();
		persona=new Persona();
		// TODO Auto-generated constructor stub
	}
	//GETTERS
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	//modificado
	public List<Persona> getListaPersonas() {
		DaoPersona daoPersona=new DaoPersona();
		listaPersonas = daoPersona.selectPersona();
		return listaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	//methods crud
	public void limpiarPersona() {
		persona=new Persona();
	}
	public String agregarPersona() {
		DaoPersona dao= new DaoPersona();
		dao.addPersona(persona);
		return "/index.html?faces-redirect=true";
	}
	public String modificarPersona() {
		DaoPersona dao= new DaoPersona();
		dao.updatePersona(persona);
		return "/index.html?faces-redirect=true";
	}
	public String eliminarPersona() {
		DaoPersona dao= new DaoPersona();
		dao.deletePersona(persona);
		return "/index.html?faces-redirect=true";
	}
}
