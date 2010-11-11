package edu.wustl.keggproject.client;

import com.smartgwt.client.data.XJSONDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class WorkPanel{
	
	private static HorizontalSplitPanel instance;
	private static final String baseurl = "http://128.252.160.238:8000/";
	
	final Anchor titlePanel_welcome = new Anchor("Welcome", "#");
	final Anchor titlePanel_genome = new Anchor("Genomic Information", "#");
	final Anchor titlePanel_pathway = new Anchor("Metabolic Pathways", "#");
	final Anchor titlePanel_optimization = new Anchor("Optimization", "#");
	final Anchor titlePanel_result = new Anchor("Result", "#");
	VerticalPanel titlePanel; 
	private String id = "det";
	private int uid = 0;
	
	public WorkPanel(){
		if (instance == null){
			instance = new HorizontalSplitPanel();
		}
	}
	
	public HorizontalSplitPanel getPanel()
	{
		return instance;
	}
	
	public void initialize(){
		instance.setSize("100%", "100%");
		instance.setSplitPosition("20%");
		initializeLeft();
		changeToWelcome();
	}
	
	public void changeToPathway() {
		clearRight();
		
		final ListGrid pathwayModule = new ListGrid();
		pathwayModule.setWidth(400);
		pathwayModule.setHeight(500);
		pathwayModule.setShowAllRecords(true);
		pathwayModule.setDataSource(JSONDS.getInstance());
		
		ListGridField ko = new ListGridField("ko");
		ListGridField arrow = new ListGridField("arrow");
		ListGridField reactants = new ListGridField("reactants");
		ListGridField products = new ListGridField("products");
		ListGridField pathway = new ListGridField("pathway");
		pathway.setHidden(true);
		pathwayModule.setFields(ko, reactants, arrow, products, pathway);
		
		pathwayModule.setAutoFetchData(true);
		pathwayModule.setGroupByField("pathway");
		
		final VerticalPanel pathwayPanel=new VerticalPanel();
		
		final DynamicForm form = new DynamicForm();  
		
		// form.setIsGroup(true);  
		form.setNumCols(4);  
		
		form.setDataSource(JSONDS.getInstance());
		
		pathwayModule.addRecordClickHandler(new RecordClickHandler() {  

			@Override
			public void onRecordClick(RecordClickEvent event) {
				// TODO Auto-generated method stub
				 form.reset();
	             form.editSelectedData(pathwayModule);  
			}  
		});  
		
		final Button buttonSave = new Button();
		buttonSave.setText("Save");
		
		final Button buttonAdd = new Button();
		buttonAdd.setText("Add");

		buttonAdd.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				ListGridRecord r = new ListGridRecord();
				r.setAttribute("ko", false);
				r.setAttribute("reactants", "");
				r.setAttribute("products", "");
				r.setAttribute("pathway", "Customer Defined");
				r.setAttribute("arrow", 0);
				pathwayModule.addData(r);
				// pathwayModule.startEditingNew();
			}
		});
		
		
		buttonSave.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				form.saveData();
			}
		});
        
		final HorizontalPanel buttonPanel=new HorizontalPanel();
		buttonPanel.add(buttonAdd);
		buttonPanel.add(buttonSave);
		
		
		pathwayPanel.add(pathwayModule);
		pathwayPanel.add(form);
		pathwayPanel.add(buttonPanel);
		
		instance.setRightWidget(pathwayPanel);

	}
	
	public void changeToWelcome(){
		clearRight();
		final TabSet topTabSet = new TabSet();  
		topTabSet.setTabBarPosition(Side.TOP);  
		topTabSet.setTabBarAlign(Side.LEFT);  
		topTabSet.setWidth(400);  
		topTabSet.setHeight(200); 
		
		topTabSet.setSize("550px", "400px");		
		final Tab introductionTab = new Tab("Introduction");  
		final Tab functionTab = new Tab("Functions");
		final Tab flowchartTab = new Tab("Flowchart");
		final Tab demoTab = new Tab("Demo");
		final Tab helpTab = new Tab("Help");
		//Tab module		
		String introductionContent="Here is what we will input in the Introduciton tab";
		String functionContent="Here is what we will input in the Function tab";
		String flowchartContent="Here is what we will input in the Flowchart tab";
		String demoContent="Here is what we will input in the Demo tab";
		String helpContent="Here is what we will input in the Help tab";
		
		Label introductionForm=new Label(introductionContent);
		Label functionForm=new Label(functionContent);
		Label flowchartForm=new Label(flowchartContent);
		Label demoForm=new Label(demoContent);
		Label helpForm=new Label(helpContent);
				
		introductionTab.setPane(introductionForm);
		functionTab.setPane(functionForm);
		flowchartTab.setPane(flowchartForm);
		demoTab.setPane(demoForm);
		helpTab.setPane(helpForm);
		
		topTabSet.addTab(introductionTab);
		topTabSet.addTab(functionTab);
		topTabSet.addTab(flowchartTab);
		topTabSet.addTab(demoTab);
		topTabSet.addTab(helpTab);
		instance.setRightWidget(topTabSet);
		
	}
	
	public void sendGenomicInformation(String id){
		this.id = id;
	}
	
	public void changeToGenome()
	{
		clearRight();
		ListGrid l = new ListGrid();
		XJSONDataSource stat = new XJSONDataSource();
		stat.setDataURL(baseurl + "stat/?name="+id);

		DataSourceTextField itemField = new DataSourceTextField("name", "Item");  
		DataSourceTextField valueField = new DataSourceTextField("value", "Value");  

		stat.setFields(itemField, valueField);  

		l.setShowAllRecords(true);  
		l.setDataSource(stat);  
		l.fetchData();
		l.setSize("200", "500");	
		instance.setRightWidget(l);		
	}
	
	public void clearRight(){
		instance.setRightWidget(null);
	}
	
	public void clearStyle(){
		//default display
		titlePanel_welcome.removeStyleName("Link-selected");
		titlePanel_genome.removeStyleName("Link-selected");
		titlePanel_pathway.removeStyleName("Link-selected");
		titlePanel_optimization.removeStyleName("Link-selected");
		titlePanel_result.removeStyleName("Link-selected");
		titlePanel_welcome.addStyleName("Link-selected");	
	}
	
	
	public void initializeLeft(){
		
		titlePanel = new VerticalPanel();
		titlePanel.add(titlePanel_welcome);
		
		titlePanel_welcome.addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				clearStyle();
				changeToWelcome();
			}
		});
		
		titlePanel.add(titlePanel_genome);	
		titlePanel_genome.addClickHandler(new ClickHandler() {
				public void onClick(final ClickEvent event) {
					changeToGenome();
				}
			}
		);
			
		
		titlePanel.add(titlePanel_pathway);
		
		titlePanel_pathway.addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				changeToPathway();
			}
		}
		);
		
		titlePanel.add(titlePanel_optimization);
		
		titlePanel_optimization.addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				changeToOptimization();
			}
		}
		);
		
		titlePanel.add(titlePanel_result);
		titlePanel_result.addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				changeToResult();
			}
		}
		);
		
		instance.setLeftWidget(titlePanel);
		clearStyle();
	}
	
	protected void changeToResult() {
		// TODO Auto-generated method stub
		
	}
	protected void changeToOptimization() {
		// TODO Auto-generated method stub
		
	}
}


