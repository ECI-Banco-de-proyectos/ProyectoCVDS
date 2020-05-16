package edu.eci.cvds.samples.managedbeans;


import edu.eci.cvds.samples.entities.AreaIniciativa;
import edu.eci.cvds.samples.entities.EstadoIniciativa;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.TipoArea;
import edu.eci.cvds.servicios.IniciativasFactory;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;


@ManagedBean(name="chartView")
@ApplicationScoped
public class ChartView implements Serializable {


    private BarChartModel barModel;
    private BarChartModel barModelEstados;
    private int DireccionIplusi=0;
    private int Posgrados=0;
    private int VicerrectoriaAdministrativa=0;
    private int SecretariaGeneral=0;
    private int VicerrectoriaAcademica=0;
    private int maxi;
    
    private int enEsperaDeRevision=0;
    private int enRevision=0;
    private int proyecto=0;
    private int solucionado=0;
    private int maxi2;

    @PostConstruct
    public void init() {
        
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public BarChartModel getBarModel() {
        DireccionIplusi=0;
        Posgrados=0;
        VicerrectoriaAdministrativa=0;
        SecretariaGeneral=0;
        VicerrectoriaAcademica=0;
        maxi=0;
        createBarModels();
        return barModel;
    }
    
    public BarChartModel getBarModelEstados() {
        enEsperaDeRevision=0;
        enRevision=0;
        proyecto=0;
        solucionado=0;
        maxi2=0;
        createBarModelEstados();
        return barModelEstados;
    }


    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries mat = new ChartSeries();
        mat.setLabel("DireccionIplusi");
        mat.set("2020", DireccionIplusi);

        ChartSeries fis = new ChartSeries();
        fis.setLabel("Posgrados");
        fis.set("2020", Posgrados);

        ChartSeries sis = new ChartSeries();
        sis.setLabel("VicerrectoriaAdministrativa");
        sis.set("2020", VicerrectoriaAdministrativa);

        ChartSeries rob = new ChartSeries();
        rob.setLabel("SecretariaGeneral");
        rob.set("2020", SecretariaGeneral);

        ChartSeries art = new ChartSeries();
        art.setLabel("VicerrectoriaAcademica");
        art.set("2020", VicerrectoriaAcademica);



        model.addSeries(mat);
        model.addSeries(fis);
        model.addSeries(rob);
        model.addSeries(art);
        model.addSeries(sis);


        return model;
    }
    
    
    private BarChartModel initBarModelEstados() {
        BarChartModel model = new BarChartModel();

        ChartSeries solucionando = new ChartSeries();
        solucionando.setLabel("Solucionado");
        solucionando.set("2020", solucionado);

        ChartSeries enRevisiones = new ChartSeries();
        enRevisiones.setLabel("En revisión");
        enRevisiones.set("2020", enRevision);

        ChartSeries esperaRevision = new ChartSeries();
        esperaRevision.setLabel("En espera de revisión");
        esperaRevision.set("2020", enEsperaDeRevision);

        ChartSeries eProyecto = new ChartSeries();
        eProyecto.setLabel("Proyecto");
        eProyecto.set("2020", proyecto);


        model.addSeries(solucionando);
        model.addSeries(enRevisiones);
        model.addSeries(esperaRevision);
        model.addSeries(eProyecto);

        return model;
    }
    
    
    
    private void createBarModelEstados() {
        List<Iniciativa> ser = IniciativasFactory.instancia().serviciosIniciativas().consultarIniciativas();
        
        maxi2=0;
        for(Iniciativa i:ser ){
            if (i.getEstado().equals(EstadoIniciativa.Solucionado)) {
            	this.solucionado+=1;
            	maxi2=Math.max(maxi2,solucionado);
            }
            else if (i.getEstado().equals(EstadoIniciativa.Proyecto)) {
            	this.proyecto+=1;
            	maxi2=Math.max(maxi2,proyecto);
            }
            else if (i.getEstado().equals(EstadoIniciativa.En_Espera_De_Revision)) {
            	this.enEsperaDeRevision+=1;
            	maxi2=Math.max(maxi2,enEsperaDeRevision);
            }
            else if (i.getEstado().equals(EstadoIniciativa.En_Revision)) {
            	this.enRevision+=1;
            	maxi2=Math.max(maxi2,enRevision);
            }
        }
        
        
        createBarModelEstado();
    }
    
    
    
    
    

    private void createBarModels() {
        List<AreaIniciativa> ser = IniciativasFactory.instancia().serviciosIniciativas().selectAreaIniciativa();

        maxi=0;
        for(AreaIniciativa i:ser ){
            if(i.getAreaConocimiento().equals(TipoArea.DireccionIplusi)){
                this.DireccionIplusi+=1;
                maxi=Math.max(maxi,DireccionIplusi);
            }else if(i.getAreaConocimiento().equals(TipoArea.Posgrados)){
                this.Posgrados+=1;
                maxi=Math.max(maxi,Posgrados);
            }else if(i.getAreaConocimiento().equals(TipoArea.VicerrectoriaAdministrativa)){
                this.VicerrectoriaAdministrativa+=1;
                maxi=Math.max(maxi,VicerrectoriaAdministrativa);
            }else if(i.getAreaConocimiento().equals(TipoArea.SecretariaGeneral)){
                this.SecretariaGeneral+=1;
                maxi=Math.max(maxi,SecretariaGeneral);
            }else if(i.getAreaConocimiento().equals(TipoArea.VicerrectoriaAcademica)) {
                this.VicerrectoriaAcademica += 1;
                maxi = Math.max(maxi, VicerrectoriaAcademica);
            }
        }
        
        
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();


        barModel.setTitle("Cantidad de Iniciativas por Área");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Área");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(maxi+1);
    }
    
    private void createBarModelEstado() {
        barModelEstados = initBarModelEstados();


        barModelEstados.setTitle("Cantidad de Iniciativas por Estado");
        barModelEstados.setLegendPosition("ne");

        Axis xAxis = barModelEstados.getAxis(AxisType.X);
        xAxis.setLabel("Estado");

        Axis yAxis = barModelEstados.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(maxi2+1);
    }
    
    

}
