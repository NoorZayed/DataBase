
import javafx.beans.property.SimpleStringProperty;

public class ServicesTable {
	private SimpleStringProperty repname ;
	private SimpleStringProperty custname;
	private SimpleStringProperty custid;
	private SimpleStringProperty serialnum;
	private SimpleStringProperty repid;
	private SimpleStringProperty model;
	
	
	
	 public ServicesTable(String repname, String custname, String custid, String serialnum, String repid,String model) {
	        this.repname = new SimpleStringProperty(repname);
	        this.custname = new SimpleStringProperty(custname);
	        this.custid = new SimpleStringProperty(custid);
	        this.serialnum = new SimpleStringProperty(serialnum);
	        this.repid = new SimpleStringProperty(repid);
	        this.model = new SimpleStringProperty(model);
	    }

	    // Getters
	    public String getRepname() {
	        return repname.get();
	    }

	    public String getCustname() {
	        return custname.get();
	    }

	    public String getCustid() {
	        return custid.get();
	    }

	    public String getSerialnum() {
	        return serialnum.get();
	    }

	    public String getRepid() {
	        return repid.get();
	    }
	    
	    public String getModel() {
	        return model.get();
	    }

	    // Setters
	    public void setRepname(String repname) {
	        this.repname.set(repname);
	    }
	    public void setModel(String r) {
	        this.model.set(r);
	    }

	    public void setCustname(String custname) {
	        this.custname.set(custname);
	    }

	    public void setCustid(String custid) {
	        this.custid.set(custid);
	    }

	    public void setSerialnum(String serialnum) {
	        this.serialnum.set(serialnum);
	    }

	    public void setRepid(String repid) {
	        this.repid.set(repid);
	    }
}
