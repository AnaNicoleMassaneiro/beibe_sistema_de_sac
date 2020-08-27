/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class ConnectionFactoryTest {
    
    public ConnectionFactoryTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            assertNotNull(connFactory.getConnection());
            
        } catch (DAOException ex) {
            Logger.getLogger(ConnectionFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ConnectionFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
}
