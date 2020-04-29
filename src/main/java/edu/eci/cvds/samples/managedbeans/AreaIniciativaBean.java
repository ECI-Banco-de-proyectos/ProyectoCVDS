package edu.eci.cvds.samples.managedbeans;


import edu.eci.cvds.samples.entities.AreaIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoArea;
import edu.eci.cvds.servicios.IniciativasFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="areaIniBean")
@ApplicationScoped
public class AreaIniciativaBean {
    public int idIniciativa;
    public TipoArea areaConocimiento;
    ArrayList<TipoArea> areas;
    List<Iniciativa> lista;

    @PostConstruct
    public void init() {

        areas = new ArrayList<TipoArea>();
        areas.add(TipoArea.Artes);
        areas.add(TipoArea.Fisica);
        areas.add(TipoArea.Matematicas);
        areas.add(TipoArea.Gerencia);
        areas.add(TipoArea.Mecanica);
        areas.add(TipoArea.Robotica);
        areas.add(TipoArea.Sistemas);
    }

    public int getIdIniciativa() {
        return idIniciativa;
    }
    public void setIdIniciativa(int idIniciativa) {
        this.idIniciativa = idIniciativa;
    }
    public TipoArea getAreaConocimiento() {
        return areaConocimiento;
    }
    public void setAreaConocimiento(TipoArea areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }
    public ArrayList<TipoArea> getAreas() { return areas;  }
    public void setAreas(ArrayList<TipoArea> areas) { this.areas = areas; }


    public List<Iniciativa> agrupar() {

        List<Iniciativa> res= new ArrayList<Iniciativa>();

        lista = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();

        for(Iniciativa ini:lista){
            int temp=ini.getId();
            if(buscar(temp)){
                res.add(ini);
            }
        }
        return res;
    }

    public boolean buscar(int ini){
        List<AreaIniciativa> ser = IniciativasFactory.instancia().areaIniciativaPersistencia().selectAreaIniciativa();
        for(AreaIniciativa i: ser){
            if(i.getIdIniciativa()==ini && i.getAreaConocimiento().equals(areaConocimiento)){
                return true;
            }
        }
        return false;
    }


}
