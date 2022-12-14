package bean;

public class dangnhapadminbean {
	private String tendangnhap;
	private String matkhau;
	private int quyen;
	public dangnhapadminbean(String tendn, String matkhau, int quyen) {
		super();
		this.tendangnhap = tendn;
		this.matkhau = matkhau;
		this.quyen = quyen;
	}
	public dangnhapadminbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

}
