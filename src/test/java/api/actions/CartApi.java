package api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import objects.User;
import utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CartApi {

    private Cookies cookies;

    public CartApi(){}
    //if user don't login/register we pass empty cookie while creating the object of this class

    public CartApi(Cookies cookies){ // we will get the cookie from when user loggedIn/Registered
        this.cookies = cookies; //pass this cookie
    }

    public Cookies getCookies(){
        return cookies;
    }

    public Response addToCart(int productId, int quantity){

        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);

        HashMap<String,Object> addProduct = new HashMap<>();
        addProduct.put("product_sku","");
        addProduct.put("product_id",productId);
        addProduct.put("quantity",quantity);

        if(cookies == null){
            cookies = new Cookies(); //create empty cookies
            //if user don't login/register we pass empty cookie while creating the object of this class
        }

        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseUrl())
                .headers(headers)
                // .body(createUser) this is not working, need to use formParams
                .formParams(addProduct)
                .cookies(cookies)
                .log().all().
            when().
                post("/?wc-ajax=add_to_cart").
            then().
                log().all()
                .extract()
                .response();
        if(response.getStatusCode() !=200){
            throw new RuntimeException(("Failed to add Product "+productId+ "to the cart"+
                    "HTTP Status Code: " + response.getStatusCode()));
        }
        this.cookies = response.getDetailedCookies(); // we can use response cookie whenever required
        return response;

    }

}
