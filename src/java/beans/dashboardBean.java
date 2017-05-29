/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import dao.AchatDao;
import dao.ClientDao;
import dao.ProduitsDao;
import dao.ProviderDao;
import dao.VentesDao;
import entity.Achats;
import entity.Ventes;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
/**
 *
 * @author benrh
 */
@Named
@ViewScoped
public class dashboardBean implements Serializable{
    private int nbrproduit;
    private int nbrprovider;
    private int nbrclient;
    private int totalearning;
    private BarChartModel barModel;
    private LineChartModel lineModel;
    Map<String, Integer> hashMap;
    
    @PostConstruct
    public void init() {
        nbrproduit = ProduitsDao.getNbrProduit();
        nbrprovider = ProviderDao.getNbrProvider();
        nbrclient = ClientDao.getNbrClient();
        totalearning = VentesDao.getPrice()-AchatDao.getPrice();
        createBarModels();
        
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel1(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
   
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        List<Ventes> v = VentesDao.getAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -6);
        hashMap = new LinkedHashMap<>();
        Map<String, Integer> tot = new LinkedHashMap<>();
        // loop adding one day in each iteration
        for(int i = 0; i< 6; i++){
            cal.add(Calendar.MONTH, 1);
            hashMap.put(sdf.format(cal.getTime()), 0);
            tot.put(sdf.format(cal.getTime()), 0);
        }
        
        for(int i = 0;i<v.size();i++){
           String[] l = v.get(i).getDateVente().toString().split("-");
           String key = l[0]+"-"+l[1];
           if(hashMap.get(key) != null){
               hashMap.put(key, hashMap.get(key) + v.get(i).getPrixVente().intValue() * Integer.parseInt(v.get(i).getQteVendue()));
               tot.put(key, tot.get(key) + v.get(i).getPrixVente().intValue() * Integer.parseInt(v.get(i).getQteVendue()));
           }
        }
        ChartSeries data = new ChartSeries();
        data.setLabel("Orders");
        
        for(int i =0;i<6;i++){
            data.set((hashMap.keySet().toArray())[ i ], hashMap.get( (hashMap.keySet().toArray())[ i ] ));
            hashMap.put( (hashMap.keySet().toArray())[ i ].toString() ,0);
        }
        List<Achats> a = AchatDao.getAll();
        
        for(int i = 0;i<a.size();i++){
           String[] l = a.get(i).getDateAchat().toString().split("-");
           String key = l[0]+"-"+l[1];
           if(hashMap.get(key) != null){
               hashMap.put(key, hashMap.get(key) + a.get(i).getPrixAchat().intValue() * Integer.parseInt(a.get(i).getQteAchete()));
           }
        }
        ChartSeries dataStat = new ChartSeries();
        ChartSeries dataStatCat = new ChartSeries();
        dataStat.setLabel("Sales");
        for(int i =0;i<6;i++){
            dataStat.set((hashMap.keySet().toArray())[ i ], hashMap.get( (hashMap.keySet().toArray())[ i ] ));
            dataStatCat.set((hashMap.keySet().toArray())[ i ].toString(),hashMap.get( (hashMap.keySet().toArray())[ i ] )- tot.get( (hashMap.keySet().toArray())[ i ] ));
    
        }
        lineModel = new LineChartModel();
        lineModel.addSeries(dataStatCat);
        lineModel.setTitle("Category Chart");
        lineModel.setLegendPosition("e");
        lineModel.setShowPointLabels(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(150000);
        model.addSeries(data);
        model.addSeries(dataStat);
        return model;
    }
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         barModel.setSeriesColors("01c0c8,00c292");
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(2500000);
    }
     
   
    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    
 
    
    public String goUrl(){
        return "produit";
    }
    public String logout(){
        return "login";
    }

    public int getNbrproduit() {
        return nbrproduit;
    }

    public void setNbrproduit(int nbrproduit) {
        this.nbrproduit = nbrproduit;
    }

    public int getNbrprovider() {
        return nbrprovider;
    }

    public void setNbrprovider(int nbrprovider) {
        this.nbrprovider = nbrprovider;
    }

    public int getNbrclient() {
        return nbrclient;
    }

    public void setNbrclient(int nbrclient) {
        this.nbrclient = nbrclient;
    }

    public int getTotalearning() {
        return totalearning;
    }

    public void setTotalearning(int totalearning) {
        this.totalearning = totalearning;
    }
    
}
