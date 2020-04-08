package edu.eci.cvds.samples.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.servicios.IniciativasFactory;
import edu.eci.cvds.servicios.ServiciosIniciativas;

@FacesValidator(value="check_If_pass_is_valid")
public class Validacion implements Validator{
	static ArrayList<String> usuarios=new ArrayList<String>();
	@Override
    public void validate(FacesContext facescontext, UIComponent uicomponent,Object obj) throws ValidatorException {
         String obj1=(String) obj;
         String nombre;
         String pass;
         usuarios.add(obj1);
         System.out.println(usuarios.size());
            if(usuarios.size()==2){
            	nombre=usuarios.get(0);
            	pass=usuarios.get(1);
            	usuarios=new ArrayList<String>();
            	
                if (validar(nombre,pass)) {
                	
                }
                else{
                    throw new ValidatorException(new FacesMessage("Contraseña no valida"));
              }
               
            }
     }

	public boolean validar(String usuario,String contrasena) {
		ServiciosIniciativas ser = IniciativasFactory.instancia().serviciosIniciativas();
		boolean in = false;
		for(Usuario s: ser.consultarUsuarios()) {
			boolean res = s.getNombre().equals(usuario) && (contrasena!="" && s.getContraseña().equals(contrasena));
			if(res) {
				in = true;
			}
		}

		return in;
	}
	
}


