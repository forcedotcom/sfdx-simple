public with sharing class DemoController {
    public DemoController() {}
    public DemoController(ApexPages.StandardController controller) {
        // Get the last name from the url
        String lastName = ApexPages.currentPage().getParameters().get('lastName');

        // Query the object
        Contact theContact = [SELECT ID FROM Contact WHERE LastName = :lastName LIMIT 1];

        // this will set the Id, so now you can use the standard controller and just reference fields on the page
        ApexPages.currentPage().getParameters().put('id', theContact.Id);
    }

    public String getAppVersion() {
        return '1.0.0';
    }
}
