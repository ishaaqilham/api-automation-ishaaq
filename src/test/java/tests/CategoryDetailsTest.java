package tests;

import common.Constants;
import common.ResponseCodes;
import data.CategoryDetailsData;
import io.restassured.http.ContentType;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.ResponseValidationUtil;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CategoryDetailsTest {
    SoftAssert softAssert;
    ResponseValidationUtil responseValidationUtil;

    @Test(description = "Verify retrieval of category details", alwaysRun = true, priority = 1,
            groups = {"CategoryDetails"})
    public void testGetValidCategoryDetails() throws IOException, ParseException {
        softAssert = new SoftAssert();
        responseValidationUtil = new ResponseValidationUtil();

        CategoryDetailsData categoryDetailsData =
                new CategoryDetailsData(Constants.DETAILS_CATALOGUE_FALSE_DATA);

        String response =
                given()
                        .baseUri(Constants.BASE_URL)
                        .basePath(String.format("/%s/Categories/6327/Details.json", Constants.API_VERSION))
                        .contentType(ContentType.JSON)
                        .queryParam("catalogue", categoryDetailsData.getCatalogue())
                        .log().all()
                .when()
                        .get()
                .then()
                        .log().all()
                        .statusCode(ResponseCodes.RESPONSE_CODE_200)
                        .extract().asString();

        softAssert.assertEquals(responseValidationUtil.getValueForKey(response, "Name"),
                "Carbon credits", "Name mismatch");
        softAssert.assertTrue(Boolean.parseBoolean(responseValidationUtil.getValueForKey(response, "CanRelist")),
                "The value for CanRelist is not true");
        softAssert.assertEquals(responseValidationUtil.getValueForJSONObjectFromArray(response,
                        "Promotions", 1, "Description"), "Good position in category",
                "Description for Gallery promotions is not correct");

        softAssert.assertAll();
    }

}
