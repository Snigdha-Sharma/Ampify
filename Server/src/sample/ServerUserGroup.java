package sample;

import Connectivity.ConnClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServerUserGroup {
    ArrayList<String> groups;
    String username, groupName;

    /**
     * @param members List of members in the group created
     * @param username  Username of the person creating the group
     * @param groupName Name of the new group
     */
    ServerUserGroup(List<String> members, String username, String groupName)
    {
        this.username=username;
        this.groupName=groupName;
        groups=new ArrayList<>();
        for (String x : members)
        {
            groups.add(x);
        }
        groups.add(username);
    }

    /**
     * @return checks if user-group creation is successful or not after adding data into database
     * @throws SQLException
     */
    boolean isCreateSuccessful() throws SQLException
    {
        boolean created;
        Connectivity.ConnClass connectionClass = new ConnClass();
        Connection connection = connectionClass.getConnection();
        Statement statement;
        String sql;
        ResultSet resultSet;

        //--------------------------------------------Checking for duplicate name from table--------------------

        sql="SELECT * FROM groupadmin WHERE USERID = '"+username+"' AND GroupName = '"+groupName+"'";
        statement = connection.createStatement();
        resultSet=statement.executeQuery(sql);
        if (resultSet.next())
        {
            return false;
        }

//        --------------------------------CREATING A NEW GROUP------------------------------------------
        sql = "INSERT INTO groupadmin(GroupName, USERID) VALUES ('"+groupName+"','"+username+"')";
        statement = connection.createStatement();
        try {
            statement.executeUpdate(sql);
            created = true;
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
            return created;
        }

//        ------------------------------FETCHING NEWLY CREATED GROUP ID----------------------------------
        String groupId="";
        sql = "SELECT GroupID FROM groupadmin WHERE USERID='"+username+"' AND GroupName='"+groupName+"'";
        statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                groupId = resultSet.getString(1);
            }
            else {
                created = false;
                return created;
            }
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
            return created;
        }

//        ------------------------------ADDING MEMBERS INTO GROUP-MEMBER TABLE----------------------------

        for(String str : groups)
        {
            sql = "INSERT INTO groupusers(GroupID, Members) VALUES ('"+groupId+"','"+str+"')";
            statement = connection.createStatement();
            try {
                statement.executeUpdate(sql);
                created = true;
            } catch (Exception e) {
                e.printStackTrace();
                created = false;
                return created;
            }
        }

        return created;
    }
}
