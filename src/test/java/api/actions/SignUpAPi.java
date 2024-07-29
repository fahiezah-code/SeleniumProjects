package api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import objects.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
public class SignUpAPi {
    private Cookies cookies; // make sure this is from RestAssured

    public Cookies getCookies(){
        return cookies;
    }
    private String fetchRegisterNonceValueByGroovy(){
        Response response = getAccount();
        return response.htmlPath().getString("**.findAll {it.@name == 'woocommerce-register-nonce' }.@value");
        //fetch this value cb71cd9aec

        /* fetch below name  and value From response
<input type="hidden" id="woocommerce-register-nonce"
name="woocommerce-register-nonce" value="cb71cd9aec"/> */
    }
    private String fetchRegisterNonceValueByJSoup(){
        Response response = getAccount();
        Document doc = Jsoup.parse(response.body().prettyPrint());
        Element element = doc.selectFirst("#woocommerce-register-nonce");
        //above we can use Elements for multiple elements
        return element.attr("value");
    }
    private Response getAccount(){
    Cookies cookies = new Cookies();
    Response response = given().
                                baseUri(ConfigLoader.getInstance()
                                .getBaseUrl())
                                .cookies(cookies)
                                .log().all().
                        when().
                                get("/account").
                        then().
                                log().all()
                                .extract()
                                .response();
                        if(response.getStatusCode() !=200){
                            throw new RuntimeException(("Failed to fetch the account, " + response.getStatusCode()));
                        }
                        return response;

    }

    public Response registerUser(User user){
        Cookies cookies = new Cookies();
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);

        HashMap<String,String> createUser = new HashMap<>();
        createUser.put("username",user.getUsername());
        createUser.put("email",user.getEmail());
        createUser.put("password",user.getPassword());
        createUser.put("woocommerce-register-nonce",fetchRegisterNonceValueByJSoup());
        createUser.put("register","Register");

        Response response = given().
                                    baseUri(ConfigLoader.getInstance().getBaseUrl())
                                    .headers(headers)
                                   // .body(createUser) this is not working, need to use formParams
                                    .formParams(createUser)
                                    .cookies(cookies)
                                    .log().all().
                            when().
                                    post("/account").
                            then().
                                    log().all()
                                    .extract()
                                    .response();
        if(response.getStatusCode() !=302){
            throw new RuntimeException(("Failed to register user, " + response.getStatusCode()));
        }
        this.cookies = response.getDetailedCookies();
        return response;

    }

}
