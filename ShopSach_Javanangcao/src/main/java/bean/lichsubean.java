package bean;

import java.util.Date;

public class lichsubean {
   private String makh;
   private String tensach;
   private int soluongmua;
   private int gia;
   private int thanhtien;
   private Date ngaymua;
   private int damua;
public lichsubean() {
	super();
	// TODO Auto-generated constructor stub
}
public lichsubean(String makh, String tensach,int soluongmua, int gia, int thanhtien, Date ngaymua,
		int damua) {
	super();
	this.makh = makh;
	this.tensach = tensach;
	this.soluongmua = soluongmua;
	this.gia = gia;
	this.thanhtien = thanhtien;	
	this.ngaymua = ngaymua;
	this.damua = damua;
}
public String getMakh() {
	return makh;
}
public void setMakh(String makh) {
	this.makh = makh;
}
public String getTensach() {
	return tensach;
}
public void setTensach(String tensach) {
	this.tensach = tensach;
}
public int getSoluongmua() {
	return soluongmua;
}
public void setSoluongmua(int soluongmua) {
	this.soluongmua = soluongmua;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}
public int getThanhtien() {
	return thanhtien;
}
public void setThanhtien(int thanhtien) {
	this.thanhtien = thanhtien;
}
public Date getNgaymua() {
	return ngaymua;
}
public void setNgaymua(Date ngaymua) {
	this.ngaymua = ngaymua;
}
public int isDamua() {
	return damua;
}
public void setDamua(int damua) {
	this.damua = damua;
}

}
