package sample;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller class for user details filling page
 */
public class UserControl implements Initializable
{
    static Stage window;

    public Button submit;

    public Label lname;
    public Label lphn;
    public Label lstate;
    public Label lemail;
    public Label ldob;
    public Label llang;
    public Label lgen;
    public Label lart;

    public TextField name;
    public TextField email;
    public TextField phn;
    public ChoiceBox state;
    public DatePicker dob;

    public CheckBox pop;
    public CheckBox rap;
    public CheckBox contemp;
    public CheckBox metal;
    public CheckBox folk;
    public CheckBox romantic;
    public CheckBox hiphop;
    public CheckBox brostep;
    public CheckBox band;
    public CheckBox rock;
    public CheckBox classical;

    public CheckBox english;
    public CheckBox hindi;
    public CheckBox telugu;
    public CheckBox harayanvi;
    public CheckBox bihari;
    public CheckBox punjabi;
    public CheckBox french;
    public CheckBox spanish;
    public CheckBox marathi;
    public CheckBox gujarati;

    public CheckBox e1;
    public CheckBox e2;
    public CheckBox e3;
    public CheckBox e4;
    public CheckBox e5;
    public CheckBox e6;
    public CheckBox e7;
    public CheckBox e8;
    public CheckBox e9;
    public CheckBox e10;
    public CheckBox e11;
    public CheckBox e12;
    public CheckBox e13;
    public CheckBox e14;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        String states[]={"Madhya Pradesh", "Uttar Pradesh", "Bihar", "Punjab", "Harayana",
                "Chhattisgarh", "Gujarat", "Maharashtra", "Jammu & Kashmir", "Andhra Pradesh",
        "Telangana", "Uttar Pradesh", "Uttarakhand", "North-Eastern States", "Kerela", "Karnataka",
        "Tamil Nadu", "Odisha", "West Bengal"};
        lname.setText("");
        lstate.setText("");
        lphn.setText("");
        ldob.setText("");
        lgen.setText("");
        llang.setText("");
        lemail.setText("");
        state.setItems(FXCollections.observableArrayList(states));
    }

    private void setEmpty()
    {
        lname.setText("");
        lstate.setText("");
        lphn.setText("");
        ldob.setText("");
        lgen.setText("");
        llang.setText("");
        lemail.setText("");
    }


    public void submitAct(ActionEvent event)
    {
        setEmpty();
        try {
            String username;
            String name1 = name.getText();
            String phn1 = phn.getText();
            String email1 = email.getText();
            String state1 = (String)state.getValue();
            String dob1 = String.valueOf(dob.getValue());
            String pop1="", rap1="", classical1="", metal1="", contemp1="", folk1="", romantic1="", hiphop1="", brostep1="", band1="", rock1="";
            String eng1="", hindi1="", telugu1="", harayanvi1="", bihari1="", punjabi1="", french1="", spanish1="", marathi1="", guj1="";
            String a1="", a2="", a3="", a4="", a5="", a6="", a7="", a8="", a9="", a10="", a11="", a12="", a13="", a14="";

            //            -----------------------------------GENRES---------------------------------------\
            boolean gen=false;
            if(pop.isSelected())
            {
                pop1="Pop";
                gen=true;
            }
            if(classical.isSelected())
            {
                classical1="Classical";
                gen=true;
            }
            if(metal.isSelected())
            {
                metal1="Metal";
                gen=true;
            }
            if(folk.isSelected())
            {
                folk1="Folk";
                gen=true;
            }
            if(romantic.isSelected())
            {
                romantic1="Romantic";
                gen=true;
            }
            if(contemp.isSelected())
            {
                contemp1="Contemporary";
                gen=true;
            }
            if(rap.isSelected())
            {
                rap1="Rap";
                gen=true;
            }
            if(brostep.isSelected())
            {
                brostep1="Brostep";
                gen=true;
            }
            if(hiphop.isSelected())
            {
                hiphop1="Hiphop";
                gen=true;
            }
            if(band.isSelected())
            {
                band1="Band";
                gen=true;
            }
            if(rock.isSelected())
            {
                rock1="Rock";
                gen=true;
            }
//            --------------------------------LANGUAGES---------------------------------------\
            boolean lingo=false;
            if(english.isSelected())
            {
                eng1="English";
                lingo=true;
            }if(hindi.isSelected())
            {
                hindi1="Hindi";
                lingo=true;
            }if(punjabi.isSelected())
            {
                punjabi1="Punjabi";
                lingo=true;
            }if(harayanvi.isSelected())
            {
                harayanvi1="Harayanvi";
                lingo=true;
            }if(bihari.isSelected())
            {
                bihari1="Bihari";
                lingo=true;
            }if(telugu.isSelected())
            {
                telugu1="Telugu";
                lingo=true;
            }if(marathi.isSelected())
            {
                marathi1="Marathi";
                lingo=true;
            }if(gujarati.isSelected())
            {
                guj1="Gujarati";
                lingo=true;
            }if(french.isSelected())
            {
                french1="French";
                lingo=true;
            }if(spanish.isSelected())
            {
                spanish1="Spanish";
                lingo=true;
            }

            //            --------------------------------ARTISTS---------------------------------------\

            boolean art=false;
            if(e1.isSelected())
            {
                a1="Ed Sheeran";
                art=true;
            }
            if(e2.isSelected())
            {
                a2="Shawn Mendes";
                art=true;
            }
            if(e3.isSelected())
            {
                a3="Eminem";
                art=true;
            }
            if(e4.isSelected())
            {
                a4="Harry Styles";
                art=true;
            }
            if(e5.isSelected())
            {
                a5="Marshmallow";
                art=true;
            }
            if(e6.isSelected())
            {
                a6="Alec Benjamin";
                art=true;
            }
            if(e7.isSelected())
            {
                a7="The Chainsmokers";
                art=true;
            }
            if(e8.isSelected())
            {
                a8="Queen";
                art=true;
            }
            if(e9.isSelected())
            {
                a9="Billie Eilish";
                art=true;
            }
            if(e10.isSelected())
            {
                a10="Lil Nas X";
                art=true;
            }
            if(e11.isSelected())
            {
                a11="Post Malone";
                art=true;
            }
            if(e12.isSelected())
            {
                a12="Panic! And the Disco";
                art=true;
            }
            if(e13.isSelected())
            {
                a13="Tones and I";
                art=true;
            }
            if(e14.isSelected())
            {
                a14="Maroon 5";
                art=true;
            }

            //            --------------------------------CHECKING CONTRAINTS---------------------------------------\
            username = UserData.getUname();
            System.out.println(username);
            boolean isVal=true;
            if(!lingo)
            {
                llang.setText("Please choose atleast 1 language preference!");
                isVal=false;
            }
            if(!gen)
            {
                lgen.setText("Please choose atleast 1 genre preference!");
                isVal=false;
            }
            if(!art)
            {
                lart.setText("Please choose atleast 1 artist preference");
                isVal=false;
            }
            if(!isValidEmail(email1))
            {
                lemail.setText("Please enter a valid email address");
                isVal=false;
            }
            if(name1.isEmpty())
            {
                lname.setText("Please enter a valid name!");
                isVal=false;
            }
            if(!isValidPhone(phn1))
            {
                lphn.setText("Please enter a valid phone number!");
                isVal=false;
            }
            String year = dob1.substring(0, 4);
            int yy=Integer.parseInt(year);
            if(yy<1900)
            {
                ldob.setText("Please enter a valid date of birth");
                isVal=false;
            }
            if(yy>2005)
            {
                ldob.setText("This app should not be used by children less than 15 years.");
                isVal=false;
            }
            if(!isVal)
                return;

            UserRequest ob=new UserRequest(username, name1, phn1, email1, dob1, state1, pop1, rap1, classical1, metal1, contemp1, folk1, romantic1, hiphop1, brostep1, band1, rock1, eng1, hindi1, telugu1, harayanvi1, bihari1, punjabi1, french1, spanish1, marathi1, guj1, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
            ob.myRequest();
            if(ob.isSuccessful())
            {
//                setUname(u1);
                OpenPlayerHome(event, username);
            }
            else
            {
                System.out.println("False");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private boolean isValidPhone(String phn)
    {
        String regex = "(0/91)?[6-9][0-9]{9}";
        Pattern pat = Pattern.compile(regex);
        if (phn == null)
            return false;
        return pat.matcher(phn).matches();
    }

    private boolean isValidEmail(String e)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (e == null)
            return false;
        return pat.matcher(e).matches();
    }

//    public void GoToLogin(ActionEvent event) throws IOException
//    {
//        Parent root1 = FXMLLoader.load(getClass().getResource("loginscene.fxml"));
//        Scene second=new Scene(root1);
//        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(second);
//        window.show();
//    }
    public void OpenPlayerHome(ActionEvent event,String u1) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene second=new Scene(root1);
        window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(second);
        window.show();
        window.setOnCloseRequest(e->closePlayer());
    }
    public static void closePlayer()
    {
        Controller.closePlayer();
        Main.window.close();
    }
}
