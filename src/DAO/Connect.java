/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MSI-VN
 */
public class Connect {
    protected Connection con=null;
    public Connect()
    {
        try
        {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          
            
        }
           catch(Exception ex)
            {
                ex.printStackTrace();
            }        
    }
}
