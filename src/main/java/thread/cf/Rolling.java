package thread.cf;

import java.util.UUID;

public class Rolling {

    public static final String USER_ID = UUID.randomUUID().toString();
    public static final String CART_ID = UUID.randomUUID().toString();
    public static void main(String[] args) {
        EComCheckOut checkOut = new EComCheckOut( new MicroserviceClients());
        checkOut.getCheckoutSummary(USER_ID, CART_ID);
    }


}
