@isTest
private class DemoControllerTests {
    @isTest static void passingTest() {
        DemoController sc = new DemoController();
        System.assertEquals(sc.getAppVersion(), '1.0.0');
    }
}
