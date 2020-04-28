package edu.eci.cvds.samples.managedbeans;


import edu.eci.cvds.samples.entities.TipoArea;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="areaIniBean")
@ApplicationScoped
public class AreaIniciativaBean {
    public int idIniciativa;
    public TipoArea areaConocimiento;

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


}
