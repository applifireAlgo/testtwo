Ext.define('Testone.view.reportui.datachart.ChartPointView', {
	extend : 'Ext.panel.Panel',
	requires:['Testone.view.reportui.datachart.ChartPointController'],
	xtype : 'chart-point',
	controller : 'chartPointController',
	//bodyStyle : 'background:#D8D8D8',
	itemId:"chartpoint",
	
	//defualtHeight:100,
	layout : {
		type : 'hbox',
	}
});

