package edu.eci.cvds.samples.managedbeans;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.IniciativasAgrupadas;
import edu.eci.cvds.servicios.IniciativasFactory;
import org.apache.shiro.config.Ini;
import org.primefaces.event.UnselectEvent;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="cbox")
@ApplicationScoped
public class CheckboxView {

    private String[] selectedConsoles;
    private String[] selectedConsoles2;
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> cities;
    private List<SelectItem> cars;
    private String[] selectedCars;

    @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        List<Iniciativa> ini = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
        for(Iniciativa i: ini){
            cities.add(i.getNombre());
        }
    }

    public String[] getSelectedConsoles() {
        return selectedConsoles;
    }

    public void setSelectedConsoles(String[] selectedConsoles) {
        this.selectedConsoles = selectedConsoles;
    }

    public String[] getSelectedCities() {
        return selectedCities;
    }

    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }

    public String[] getSelectedCities2() {
        return selectedCities2;
    }

    public void setSelectedCities2(String[] selectedCities2) {
        this.selectedCities2 = selectedCities2;
    }

    public String[] getSelectedConsoles2() {
        return selectedConsoles2;
    }

    public void setSelectedConsoles2(String[] selectedConsoles2) {
        this.selectedConsoles2 = selectedConsoles2;
    }

    public List<String> getCities() {
        return cities;
    }

    public List<SelectItem> getCars() {
        return cars;
    }

    public void setCars(List<SelectItem> cars) {
        this.cars = cars;
    }

    public String[] getSelectedCars() {
        return selectedCars;
    }

    public void setSelectedCars(String[] selectedCars) {
        this.selectedCars = selectedCars;
    }

    public void onItemUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        context.addMessage(null, msg);
    }
    public void insertarIniciativasAgrupadas(){
        List<IniciativasAgrupadas> agu = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativasAgrupadas();
        int indexMax = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativasAgrupadas().size();
        int max = agu.get(indexMax-1).getIniciativaAgrupada();
        for (String i: selectedCities) {
            IniciativasFactory.instancia().serviciosIniciativas().insertarPorIniciativasAgrupadas(max+1, i);

        }

    }

}