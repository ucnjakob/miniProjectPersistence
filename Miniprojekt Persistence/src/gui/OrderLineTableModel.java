/**
 * 
 */
package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.*;



/**
 * @author jakob
 *
 */
public class OrderLineTableModel extends AbstractTableModel {
	
	private List<Orderline> orderLines;
	
	
	public static final String[] COL_NAMES = 
		{"Navn", "Antal", "Stk Pris", "Subtotal"};
	
	
	public OrderLineTableModel()
	{
		this(new ArrayList<>());
	}
	
	public OrderLineTableModel(List<Orderline> orderLines)
	{
		super();
		if(orderLines != null)
		{
			this.orderLines = orderLines;
		}
		else
		{
			this.orderLines = new ArrayList<>();
		}
	}

	
	
	public String getColumnName(int col)
	{
		return COL_NAMES[col];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return orderLines.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Orderline ol = orderLines.get(rowIndex);
		String res = "";
		switch(columnIndex)
		{
		case 0: 
			res = ol.getProductName();
			break;
		case 1:
			res += ol.getQuantity();
			break;
		case 2:
			res += (ol.getProduct().getPrice() + " DKK");
			break;
		case 3:
			res += (ol.getTotalAmount() + " DKK");
			break;
		default:
			res = "Der skete en fejl!";
			
		}
		return res;
		
	}
	

}
