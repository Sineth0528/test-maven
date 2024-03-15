package com.kushan.abclab.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kushan.abclab.service.DropDownService;
import com.kushan.abclab.model.AppointmentInfo;
import com.kushan.abclab.model.DropDownModel;
import java.util.List;

public class RequestAppointment extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DropDownService dropDownService;

    public RequestAppointment() {
        this.dropDownService = new DropDownService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        	
        String aptype = request.getParameter("aptype");
            
        if(aptype != null) {
            try {
                AppointmentInfo appinfo =  dropDownService.getAvilableDateSer(aptype);
                String maxdate = appinfo.getDate();
                String price = appinfo.getPrice();
                LocalDate today = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                if (maxdate == null || LocalDate.parse(maxdate, formatter).isBefore(today)) {
                    maxdate = today.format(formatter);
                }
     
                String responseString = maxdate + "," + price;
                response.getWriter().write(maxdate); 
                return; 
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }   
        }
        
        try {
            // Call the service layer to fetch the data
            List<DropDownModel> dropDownData = dropDownService.GetTypeName();
            
            // Set the data as an attribute in the request
            request.setAttribute("dropDownData", dropDownData);
            
            // Forward the request to the JSP
            request.getRequestDispatcher("request_appointment.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace(); // Or log the exception
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error occurred");
        }      
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}