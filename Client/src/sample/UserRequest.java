package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UserRequest extends Request {
    private boolean registered=false;
    private final String name, phn, email, dob, state;
    private final String pop1, rap1, classical1, metal1, contemp1, folk1, romantic1, hiphop1, brostep1, regional1, band1, rock1;
    private final String eng1, hindi1, telugu1, harayanvi1, bihari1, punjabi1, french1, spanish1, tamil1, marathi1, guj1, raja1;

    UserRequest(String name, String phn, String email, String dob, String state, String pop1, String rap1, String classical1, String metal1, String folk1, String romantic1, String contemp1, String brostep1, String regional1, String hiphop1, String band1, String rock1, String eng1, String hindi1, String punjabi1, String harayanvi1, String bihari1, String telugu1, String marathi1, String guj1, String french1, String spanish1, String raja1, String tamil1) throws IOException {
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
        this.regional1=regional1;
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
        this.raja1=raja1;
        this.tamil1=tamil1;

        dis=new DataInputStream(s.getInputStream());
        dos=new DataOutputStream(s.getOutputStream());
    }


    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("DetailsUser");
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
        dos.writeUTF(regional1);
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
        dos.writeUTF(raja1);
        dos.writeUTF(tamil1);

        registered= dis.readBoolean();
        dis.close();
        dos.close();
    }

    public boolean isSuccessful()
    {
        return registered;
    }
}
