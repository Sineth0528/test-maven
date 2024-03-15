// DropDownService.java
package com.kushan.abclab.service;

import java.sql.SQLException;
import java.util.List;
import com.kushan.abclab.dao.DropDownDao;
import com.kushan.abclab.model.AppointmentInfo;
import com.kushan.abclab.model.DropDownModel;

public class DropDownService {
    
    private DropDownDao dropDownDao;
    
    public DropDownService() {
        this.dropDownDao = new DropDownDao(); 
    }
    
    public List<DropDownModel> GetTypeName() throws SQLException, ClassNotFoundException {
        return dropDownDao.getAllAppointName(); 
    }
    
    public AppointmentInfo getAvilableDateSer(String appointmentId) throws SQLException, ClassNotFoundException  {
    	return dropDownDao.CheckAvilabaleDate(appointmentId);
	}
    
}
