package org.utils;

public class Order {
	private String orderId ; // 订单ID，必填，唯一标识
	private String cityCode ; //区域行政代码
	private String cityName ; //地市名称
	private String company ;
	private String danhao ;
	private String cost ; 
	private String userPhone ; //下单人的联系电话
	private String userId ; //用户ID
	private String userName ; //用户姓名
	private String userAddress ; //用户地址
	private String actionDate ; //下单时间
	private String orderName ; //订单类型 如：快递，演出票
	private int status ;  //订单状态
	private String source = "0" ; //订单来源
	private String kind = "";
	public String getKind() {
		if(kind!=null) kind = kind.trim();
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCityCode() {
		if (!"".equals(cityCode) && cityCode.equals("hf")) {
			return "340100";
		}
		if (!"".equals(cityCode) && cityCode.equals("wh")) {
			return "340200";
		}
		if (!"".equals(cityCode) && cityCode.equals("bb")) {
			return "340300";
		}
		if (!"".equals(cityCode) && cityCode.equals("hn")) {
			return "340400";
		}
		if (!"".equals(cityCode) && cityCode.equals("mas")) {
			return "340500";
		}
		if (!"".equals(cityCode) && cityCode.equals("hb")) {
			return "340600";
		}
		if (!"".equals(cityCode) && cityCode.equals("tl")) {
			return "340700";
		}
		if (!"".equals(cityCode) && cityCode.equals("aq")) {
			return "340800";
		}
		if (!"".equals(cityCode) && cityCode.equals("hs")) {
			return "341000";
		}
		if (!"".equals(cityCode) && cityCode.equals("cz")) {
			return "341100";
		}
		if (!"".equals(cityCode) && cityCode.equals("fy")) {
			return "341200";
		}
		if (!"".equals(cityCode) && cityCode.equals("sz")) {
			return "341300";
		}
		if (!"".equals(cityCode) && cityCode.equals("la")) {
			return "342400";
		}
		if (!"".equals(cityCode) && cityCode.equals("bz")) {
			return "341600";
		}
		if (!"".equals(cityCode) && cityCode.equals("chiz")) {
			return "342900";
		}
		if (!"".equals(cityCode) && cityCode.equals("xc")) {
			return "342500";
		}
		return "340100";
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		if (!"".equals(cityCode) && cityCode.equals("hf")) {
			return "合肥市";
		}
		if (!"".equals(cityCode) && cityCode.equals("wh")) {
			return "芜湖市";
		}
		if (!"".equals(cityCode) && cityCode.equals("bb")) {
			return "蚌埠市";
		}
		if (!"".equals(cityCode) && cityCode.equals("hn")) {
			return "淮南市";
		}
		if (!"".equals(cityCode) && cityCode.equals("mas")) {
			return "马鞍山市";
		}
		if (!"".equals(cityCode) && cityCode.equals("hb")) {
			return "淮北市";
		}
		if (!"".equals(cityCode) && cityCode.equals("tl")) {
			return "铜陵市";
		}
		if (!"".equals(cityCode) && cityCode.equals("aq")) {
			return "安庆市";
		}
		if (!"".equals(cityCode) && cityCode.equals("hs")) {
			return "黄山市";
		}
		if (!"".equals(cityCode) && cityCode.equals("cz")) {
			return "滁州市";
		}
		if (!"".equals(cityCode) && cityCode.equals("fy")) {
			return "阜阳市";
		}
		if (!"".equals(cityCode) && cityCode.equals("sz")) {
			return "宿州市";
		}
		if (!"".equals(cityCode) && cityCode.equals("la")) {
			return "六安市";
		}
		if (!"".equals(cityCode) && cityCode.equals("bz")) {
			return "亳州市";
		}
		if (!"".equals(cityCode) && cityCode.equals("chiz")) {
			return "池州市";
		}
		if (!"".equals(cityCode) && cityCode.equals("xc")) {
			return "宣城市";
		}
		 return "合肥市";
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getUserPhone() {
		if(userPhone==null||userPhone.equals("null"))
			userPhone="";
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		if(userPhone!=null){
			userPhone = userPhone.replace(" ", "");
			userPhone = userPhone.replace("　", "");
			if(userPhone.length()>15)
				userPhone = userPhone.substring(1,15);
		}
		this.userPhone = userPhone;
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		if(userAddress==null||userAddress.equals("null"))
			userAddress="";
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getActionDate() {
		return actionDate;
	}
	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int i) {
		this.status = i;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCompany() {
		if(company==null||company.equals("null"))
			company="";
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDanhao() {
		if (danhao == null||danhao.equals("null")) 
			danhao ="";
		danhao = danhao.trim();
		return danhao;
	}
	public void setDanhao(String danhao) {
		this.danhao = danhao;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public static void main(String[] args) {
		Order order = new Order();
		order.setUserPhone("114");
		
	}
}
