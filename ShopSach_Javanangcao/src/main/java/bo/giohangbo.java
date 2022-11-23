package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
    public ArrayList<giohangbean> ds
     		= new ArrayList<giohangbean>();
    public void Them(String masach, String tensach, long gia, long soluong) {
    	for(giohangbean h: ds)
    		if(h.getMasach().equals(masach)) {
    			h.setSoluong(h.getSoluong()+soluong);
    			return;
    		}
    	ds.add(new giohangbean(masach, tensach, gia, soluong));
    }

    
    public void xoa(String masach) {
    	
		for(giohangbean h:ds)
    		
    			if (h.getMasach().equals(masach)) {
    				ds.remove(h);
    				return;
    			}
    }
    
    
    public void capnhatsoluong(String masach, long soluong   ) {
    	for (giohangbean gh:ds) {
    		if (gh.getMasach().equals(masach)) {
				gh.setSoluong(soluong);
				return;
			}
    	}
    }
    
    
    
public void xoachon(String masach) {
    	
		for(giohangbean h:ds)
    		
    		 {
    				ds.remove(h);
    				return;
    			}
    }
   
}