package sample;

import java.io.IOException;

public class UserRequest extends Request {
    private String name, phn, email, dob;
    private boolean registered=false;

    @Override
    public void myRequest() throws IOException
    {
        dos.writeUTF("DetailsUser");
        dos.writeUTF(name);
        dos.writeUTF(phn);
        dos.writeUTF(email);
        dos.writeUTF(dob);
        registered= dis.readBoolean();
        dis.close();
        dos.close();
    }

    public boolean isSuccessfullyRegistered()
    {
        return registered;
    }
}
