package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import org.controlsfx.control.CheckListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserGroupController implements Initializable
{
    public JFXButton back;
    public JFXButton done;
    public CheckListView<String> allUsers;
    public JFXTextField grpName;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<String> observeAllUsers= FXCollections.observableArrayList(MiddlePageController.allUserList);
        allUsers.setItems(observeAllUsers);
    }

    public void goBack() throws IOException
    {
        MiddlePageController.allUserList=null;
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene second=new Scene(root1);
        Main.window.setScene(second);
        Main.window.show();
    }

    public void makeUserGroup() throws IOException
    {
        String groupName=grpName.getText();
        System.out.println(groupName);
        List<String> selectedUsers=allUsers.getCheckModel().getCheckedItems();
        NewUserGroupRequest o=new NewUserGroupRequest(groupName,selectedUsers);
        o.myRequest();
        goBack();
    }
}
