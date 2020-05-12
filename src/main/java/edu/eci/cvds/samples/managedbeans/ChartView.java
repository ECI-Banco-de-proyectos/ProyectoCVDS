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
    private int matematicas=0;
    private int fisica=0;
    private int robotica=0;
    private int artes=0;
    private int gerencia=0;
    private int sistemas=0;
    private int mecanica=0;
    private int maxi;
    
    private int enEsperaDeRevision=0;
    private int enRevision=0;
    private int proyecto=0;
    private int solucionado=0;
    private int maxi2;

    @PostConstruct
    public void init() {
        createBarModels();
        createBarModelEstados();
        
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }
    
    public BarChartModel getBarModelEstados() {
        return barModelEstados;
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries mat = new ChartSeries();
        mat.setLabel("Matematicas");
        mat.set("2020", matematicas);

        ChartSeries fis = new ChartSeries();
        fis.setLabel("Fisica");
        fis.set("2020", fisica);

        ChartSeries sis = new ChartSeries();
        sis.setLabel("Sistemas");
        sis.set("2020", sistemas);

        ChartSeries rob = new ChartSeries();
        rob.setLabel("Robotica");
        rob.set("2020", robotica);

        ChartSeries art = new ChartSeries();
        art.setLabel("Artes");
        art.set("2020", artes);

        ChartSeries ger = new ChartSeries();
        ger.setLabel("Gerencia");
        ger.set("2020", gerencia);

        ChartSeries mec = new ChartSeries();
        mec.setLabel("Mecanica");
        mec.set("2020", mecanica);

        model.addSeries(mat);
        model.addSeries(fis);
        model.addSeries(sis);
        model.addSeries(rob);
        model.addSeries(mec);
        model.addSeries(ger);
        model.addSeries(art);

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
            if(i.getAreaConocimiento().equals(TipoArea.Matematicas)){
                this.matematicas+=1;
                maxi=Math.max(maxi,matematicas);
            }else if(i.getAreaConocimiento().equals(TipoArea.Fisica)){
                this.fisica+=1;
                maxi=Math.max(maxi,fisica);
            }else if(i.getAreaConocimiento().equals(TipoArea.Robotica)){
                this.robotica+=1;
                maxi=Math.max(maxi,robotica);
            }else if(i.getAreaConocimiento().equals(TipoArea.Artes)){
                this.artes+=1;
                maxi=Math.max(maxi,artes);
            }else if(i.getAreaConocimiento().equals(TipoArea.Gerencia)){
                this.gerencia+=1;
                maxi=Math.max(maxi,gerencia);
            }else if(i.getAreaConocimiento().equals(TipoArea.Sistemas)){
                this.sistemas+=1;
                maxi=Math.max(maxi,sistemas);
            }else if(i.getAreaConocimiento().equals(TipoArea.Mecanica)){
                this.mecanica+=1;
                maxi=Math.max(maxi,mecanica);
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
