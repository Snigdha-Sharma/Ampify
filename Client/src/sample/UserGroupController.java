package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.controlsfx.control.CheckListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for Usergroup creation page
 */
public class UserGroupController implements Initializable
{
    public JFXButton back;
    public JFXButton done;
    public CheckListView<String> allUsers;
    public JFXTextField grpName;
    public Label warning;

    /**
     * Initializes observable list of users
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<String> observeAllUsers= FXCollections.observableArrayList(MiddlePageController.allUserList);
        for (String s:observeAllUsers)
        {
            if(s.equals(UserData.getUname())) {
                int i=observeAllUsers.indexOf(s);
                observeAllUsers.remove(i);
                break;
            }
        }
        System.out.println(observeAllUsers);
        allUsers.setItems(observeAllUsers);
    }

    /**
     * @throws IOException goes back to home page
     */
    public void goBack() throws IOException
    {
        MiddlePageController.allUserList=null;
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene second=new Scene(root1);
        second.getStylesheets().add("resources/css/middle.css");
        Main.window.setX(40);
        Main.window.setY(25);
        Main.window.setScene(second);
        Main.window.show();

    }

    /**
     * @throws IOException sends a request to create user group
     */
    public void makeUserGroup() throws IOException
    {
        String groupName=grpName.getText();
        if(groupName.isEmpty())
        {
            warning.setText("Group Name can't be empty!");
            return;
        }
        System.out.println(groupName);
        List<String> selectedUsers=allUsers.getCheckModel().getCheckedItems();
        if(selectedUsers.isEmpty())
        {
            warning.setText("Select atleast 1 member for creating a group");
            return;
        }
        NewUserGroupRequest o=new NewUserGroupRequest(groupName,selectedUsers);
        o.myRequest();
        if(!o.isSuccessfullyCreation())
        {
            warning.setText("Group name should not match with previously created groups!");
            return;
        }
        goBack();
    }
}
