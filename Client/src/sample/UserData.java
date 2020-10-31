package sample;

/**
 * Initializes username of user upon login
 */
public class UserData {

    private static String unamee;

    /**
     * @return to fetch username of the user currently logged in
     */
    static String getUname()
    {
        return unamee;
    }

    /**
     * @param uname to set the username of user upon login
     */
    static void setUname(String uname)
    {
        unamee=uname;
    }
}
