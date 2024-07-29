package api.actions;

import objects.User;
import utils.FakerUtils;

public class DummyTest {

    public static void main(String[] args) {
       // System.out.println(new SignUpAPi().fetchRegisterNonceValueByJSoup());
       // System.out.println(new SignUpAPi().fetchRegisterNonceValueByGroovy());

        /*

        String username = "demouser"+ new FakerUtils().generateRandomNumber();
        User user = new User()
                        .setUsername(username)
                        .setPassword("user1234")
                        .setEmail(username+"@askomdch.com");

        SignUpAPi signUpAPi =new SignUpAPi();
        System.out.println(signUpAPi.registerUser(user));
        System.out.print(signUpAPi.getCookies());
        System.out.println("size "+signUpAPi.getCookies().size());
        System.out.println(signUpAPi.getCookies().asList());

         */

        /*
         //add Product to cart without login/register
        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215,1);
        System.out.println(cartApi.getCookies());
         */

     //add Product to cart after login or registered

        //first we need to register user
        String username = "demouser"+ new FakerUtils().generateRandomNumber();
        User user = new User()
                .setUsername(username)
                .setPassword("user1234")
                .setEmail(username+"@askomdch.com");

        SignUpAPi signUpAPi =new SignUpAPi();
        signUpAPi.registerUser(user);
        System.out.println("Register Cookies: "+signUpAPi.getCookies());

        CartApi cartApi = new CartApi(signUpAPi.getCookies()); //pass cookies from registered
        cartApi.addToCart(1215,1);
        System.out.println("Cart Cookies:  "+cartApi.getCookies());



    }
}
/* from response cb71cd9aec we need to use it
<input type="hidden" id="woocommerce-register-nonce"
name="woocommerce-register-nonce" value="cb71cd9aec"/>
 */