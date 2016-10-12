const express = require('express');
const force = require('salesforce-alm-buildpack-dev');

const startUrl = process.env.SALESFORCE_START_URL || '/one/one.app';
const org = process.env.SALESFORCE_ORG || 'org@salesforce.com';
const app = express.createServer(express.logger());

app.get('*', function(request, response) {
    const openCmd = new force.open();
    openCmd.validate({ targetname: org, path: startUrl, urlonly: true })
        .bind(openCmd)
        .then(openCmd.execute)
        .then((result) => {
            console.log(`Redirecting to org '${org}', URL ${result.url}...`);
            response.redirect(result.url);
        });
});

const port = process.env.PORT || 5000;
app.listen(port, function() {
    console.log("Redirect-to-Salesforce listening on " + port);
});