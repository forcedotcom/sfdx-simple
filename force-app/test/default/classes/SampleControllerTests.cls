@isTest
private class SampleControllerTests {
    @isTest static void passingTest() {
        SampleController sc = new SampleController();
        System.assertEquals(sc.getAppVersion(), '1.0.0');
    }
}