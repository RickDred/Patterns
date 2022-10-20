public class Application {
    static Application app = null;

    private Application() {}

    public static synchronized Application getApp() {
        if(app == null) app = new Application();
        return app;
    }
}
