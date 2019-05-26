package ConnectionTest;

import com.secaidastudio.e04_mvc.utils.CustomConnection;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author oscar
 */
public class CustomConnectionTest {

    @Test
    public void testConnection() {
        Connection conn = null;
        try {
            conn = CustomConnection.getInstance().getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        Assert.assertNotNull(conn);
    }

}
