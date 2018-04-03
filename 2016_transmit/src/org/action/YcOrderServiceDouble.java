package org.action;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.utils.JdbcUtil;
import org.utils.Order;
import org.utils.TimeCost;
import org.utils.gettime;




public class YcOrderServiceDouble {
	private String begin ;
	private String end;
	
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	//查询数据库反馈Enterprise 对象
	public List<Order> getOrders(int num ){
		List<Order> list = new ArrayList<Order>();
		Order order = null;
		Connection con = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//正式类
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);                                                                                                                                     
			String sql = "update t_car_workorder_his set column2 = 'sending' where    create_time<date'"+end+"'and create_time>=date'"+begin+"' and (column2 is null or column2='-1') and  rownum<"+(num+1);
			stmt.executeUpdate(sql);
			con.commit();
			sql = "select city,       id,             nvl( caller,''),      nvl( replace(replace(address,'-',''),'+',''),''), " 
				+"  nvl( replace(phone,'-',''),''),  order_handler , to_char(create_time,'yyyy-mm-dd hh24:mi:ss'),  '便民服务' , nvl(caller,'') , '挪车服务' ,'0','汽车服务' from t_car_workorder_his t " 
				+ " where  create_time<date'"+end+"'and create_time>=date'"+begin+"'  and column2 = 'sending'";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				order = new Order (); 				
				order.setCityCode(rs.getString(1));
				order.setOrderId(rs.getString(2));
				order.setUserName(rs.getString(3));
				order.setUserAddress(rs.getString(4));
				order.setUserPhone(rs.getString(5));
				order.setUserId(rs.getString(6));
				order.setActionDate(rs.getString(7));
				order.setOrderName(rs.getString(8));
				order.setCompany(rs.getString(9));
				order.setDanhao(rs.getString(10));
				order.setCost(rs.getString(11));
				order.setKind(rs.getString(12));
				order.setStatus(1);
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			JdbcUtil.close(rs, stmt,ps, con) ;
		}		
		return list;
	}
	public void writeOrders(List<Order> list){		
		Connection con = null; 
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try{
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			sql = "update t_car_workorder_his t set t.column2 = ? where id = ?";
			ps = con.prepareStatement(sql);
			for(Order order:list){
				ps.setString( 1, (order.getStatus()+"") );
				ps.setString( 2, order.getOrderId() );
				ps.addBatch();
			}
			ps.executeBatch();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{			
			JdbcUtil.close(rs, stmt,ps, con) ;
		}	
		
	}
	
	public static void transmit() {
		long begin = System.currentTimeMillis();
		YcOrderServiceDouble service = new YcOrderServiceDouble();
		List<Order> list = new ArrayList<Order>();
		service.setBegin(gettime.getbg());
		service.setEnd(gettime.getend());
		ExpressDelivery delivery  = new ExpressDelivery(); 
		int num = 400 ;
		int count = 0 ;
		try{
		    list = service.getOrders(num) ;
		}catch (Exception e) {
			e.printStackTrace();
		}
		int i =1 ; int j= 1 ;
		while(list.size()>0){
			System.out.println("************"+ new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()) +"   循环"+i+"次 BEGIN      *************");
			for(Order order:list){
				System.out.print(".");
				try{
					delivery.send(order);
					j++;
					count++;
					if(count%50==0) System.out.println("---已成功发送"+count+"条记录！---样本日期："+order.getActionDate()); 
				}catch (Exception e) {
					order.setStatus(-1);
					e.printStackTrace();
				}
			}
			service.writeOrders(list);
			j=1;
			System.out.println("************   循环"+i+"次 END      *************");
			i++ ; 
			try{
			    list = service.getOrders(num) ;
			}catch (Exception e) {
				e.printStackTrace();
				list = service.getOrders(num) ;
			}
		}
		long cost = (System.currentTimeMillis()-begin)/1000 ;
		System.out.println("合计发送"+count+"条数据!耗时："+TimeCost.showCost(cost));

	}
	 
	public static void main(String[] args){
		
	}
}
