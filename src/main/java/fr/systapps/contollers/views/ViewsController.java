package fr.systapps.contollers.views;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;

import java.util.Map;

@Controller("/")
class ViewsController {

    private static final String APP_NAME = "My Awesome Application";
    private static final String APP_VERSION = "v0.1";
    private static final String APP_COPYRIGHT = "©systapps.fr 2019-2022";

    public static final String KEY_PAGE = "page";
    public static final String KEY_APPNAME = "appname";
    public static final String KEY_APPVERSION = "appversion";
    public static final String KEY_APPCOPY = "appcopy";

    @View("home")
    @Get(uris = {"/", "/home"})
    public ModelAndView<Map<String, Object>> indexPage() {
        return new ModelAndView<>("home", Map.of(
                KEY_PAGE, "home",
                KEY_APPNAME, APP_NAME,
                KEY_APPVERSION, APP_VERSION,
                KEY_APPCOPY, APP_COPYRIGHT
        ));
    }

    @View("page1")
    @Get(value = "/page1")
    public ModelAndView<Map<String, Object>> pageOne() {
        return new ModelAndView<>("page1", Map.of(
                KEY_PAGE, "page1",
                KEY_APPNAME, APP_NAME,
                KEY_APPVERSION, APP_VERSION,
                KEY_APPCOPY, APP_COPYRIGHT
        ));
    }

    @View("page2")
    @Get(value = "/page2")
    public ModelAndView<Map<String, Object>> pageTwo() {
        return new ModelAndView<>("page2", Map.of(
                KEY_PAGE, "page2",
                KEY_APPNAME, APP_NAME,
                KEY_APPVERSION, APP_VERSION,
                KEY_APPCOPY, APP_COPYRIGHT
        ));
    }

}