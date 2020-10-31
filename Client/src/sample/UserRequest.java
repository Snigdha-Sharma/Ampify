package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Sends request to server to fill user details into database
 */
public class UserRequest extends Request {
    private boolean registered=false;
    private final String name, phn, username, email, dob, state;
    private final String pop1, rap1, classical1, metal1, contemp1, folk1, romantic1, hiphop1, brostep1, band1, rock1;
    private final String eng1, hindi1, telugu1, harayanvi1, bihari1, punjabi1, french1, spanish1, marathi1, guj1;
    private final String a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14;

    UserRequest(String username, String name, String phn, String email, String dob, String state, String pop1, String rap1, String classical1, String metal1, String folk1, String romantic1, String contemp1, String brostep1, String hiphop1, String band1, String rock1, String eng1, String hindi1, String punjabi1, String harayanvi1, String bihari1, String telugu1, String marathi1, String guj1, String french1, String spanish1, String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8, String a9, String a10, String a11, String a12, String a13, String a14) throws IOException {
        this.username=username;
        this.name=name;
        this.phn=phn;
        this.email=email;
        this.dob=dob;
        this.state=state;
        this.pop1=pop1;
        this.rap1=rap1;
        this.classical1=classical1;
        this.metal1=metal1;
        this.folk1=folk1;
        this.romantic1=romantic1;
        this.contemp1=contemp1;
        this.brostep1=brostep1;
        this.hiphop1=hiphop1;
        this.band1=band1;
        this.rock1=rock1;
        this.eng1=eng1;
        this.hindi1=hindi1;
        this.punjabi1=punjabi1;
        this.harayanvi1=harayanvi1;
        this.bihari1=bihari1;
        this.telugu1=telugu1;
        this.marathi1=marathi1;
        this.guj1=guj1;
        this.french1=french1;
        this.spanish1=spanish1;

        this.a1=a1;
        this.a2=a2;
        this.a3=a3;
        this.a4=a4;
        this.a5=a5;
        this.a6=a6;
        this.a7=a7;
        this.a8=a8;
        this.a9=a9;
        this.a10=a10;
        this.a11=a11;
        this.a12=a12;
        this.a13=a13;
        this.a14=a14;

        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }

    /**
     * @throws IOException sends request to server
     */
    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("UserRequest");
        dos.writeUTF(username);
        dos.writeUTF(name);
        dos.writeUTF(phn);
        dos.writeUTF(email);
        dos.writeUTF(dob);
        dos.writeUTF(state);

        dos.writeUTF(pop1);
        dos.writeUTF(rap1);
        dos.writeUTF(classical1);
        dos.writeUTF(metal1);
        dos.writeUTF(folk1);
        dos.writeUTF(romantic1);
        dos.writeUTF(contemp1);
        dos.writeUTF(brostep1);
        dos.writeUTF(hiphop1);
        dos.writeUTF(band1);
        dos.writeUTF(rock1);

        dos.writeUTF(eng1);
        dos.writeUTF(hindi1);
        dos.writeUTF(punjabi1);
        dos.writeUTF(harayanvi1);
        dos.writeUTF(bihari1);
        dos.writeUTF(telugu1);
        dos.writeUTF(marathi1);
        dos.writeUTF(guj1);
        dos.writeUTF(french1);
        dos.writeUTF(spanish1);

        dos.writeUTF(a1);
        dos.writeUTF(a2);
        dos.writeUTF(a3);
        dos.writeUTF(a4);
        dos.writeUTF(a5);
        dos.writeUTF(a6);
        dos.writeUTF(a7);
        dos.writeUTF(a8);
        dos.writeUTF(a9);
        dos.writeUTF(a10);
        dos.writeUTF(a11);
        dos.writeUTF(a12);
        dos.writeUTF(a13);
        dos.writeUTF(a14);

        registered= dis.readBoolean();
        dis.close();
        dos.close();
    }

    /**
     * @return if user data is successfully filled into database
     */
    public boolean isSuccessful()
    {
        return registered;
    }
}
