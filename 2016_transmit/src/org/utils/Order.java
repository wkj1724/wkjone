package org.utils;

public class Order {
	private String orderId ; // ����ID�����Ψһ��ʶ
	private String cityCode ; //������������
	private String cityName ; //��������
	private String company ;
	private String danhao ;
	private String cost ; 
	private String userPhone ; //�µ��˵���ϵ�绰
	private String userId ; //�û�ID
	private String userName ; //�û�����
	private String userAddress ; //�û���ַ
	private String actionDate ; //�µ�ʱ��
	private String orderName ; //�������� �磺��ݣ��ݳ�Ʊ
	private int status ;  //����״̬
	private String source = "0" ; //������Դ
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
			return "�Ϸ���";
		}
		if (!"".equals(cityCode) && cityCode.equals("wh")) {
			return "�ߺ���";
		}
		if (!"".equals(cityCode) && cityCode.equals("bb")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("hn")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("mas")) {
			return "��ɽ��";
		}
		if (!"".equals(cityCode) && cityCode.equals("hb")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("tl")) {
			return "ͭ����";
		}
		if (!"".equals(cityCode) && cityCode.equals("aq")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("hs")) {
			return "��ɽ��";
		}
		if (!"".equals(cityCode) && cityCode.equals("cz")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("fy")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("sz")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("la")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("bz")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("chiz")) {
			return "������";
		}
		if (!"".equals(cityCode) && cityCode.equals("xc")) {
			return "������";
		}
		 return "�Ϸ���";
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
			userPhone = userPhone.replace("��", "");
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
