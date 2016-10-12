heroku apps:create sfdx-simple-staging
heroku pipelines:create sfdx-simple-pipelines --app sfdx-simple-staging --stage staging
heroku apps:create sfdx-simple-prod
heroku pipelines:add sfdx-simple-pipelines --app sfdx-simple-prod --stage production

heroku buildpacks:add https://github.com/heroku/salesforce-buildpack --app sfdx-simple-staging
heroku buildpacks:add https://github.com/heroku/salesforce-buildpack --app sfdx-simple-prod

heroku addons:create salesforce:byoo --app sfdx-simple-staging
heroku addons:create salesforce:byoo --app sfdx-simple-prod

heroku config:set HEROKU_APP_NAME=sfdx-simple-staging --app sfdx-simple-staging
heroku config:set HEROKU_APP_NAME=sfdx-simple-prod --app sfdx-simple-prod

#heroku config:set SALESFORCE_BYOO=true --app sfdx-simple-staging
#heroku config:set SALESFORCE_BYOO=true --app sfdx-simple-prod



# heroku config:set HEROKU_APP_NAME=dreamhouse-devkeynote-sdx --app dreamhouse-dev-sdx
# heroku config:set SALESFORCE_BUILDPACK_VERBOSE=true --app dreamhouse-dev-sdx
# heroku config:set SALESFORCE_BYOO=true --app dreamhouse-dev-sdx
# heroku config:set SALESFORCE_HUB_URL=force://3MVG9SemV5D80oBfPBCgboxuJ9df3F8MrzZxhqU5qeUb5MoRs.vuBNHRhhdMh2WDeh5cFiAXcv9z2PnZ7CScu:7278165525231799669:5Aep8614XGwzVzzTO6qBJOvmrMfeAZ4Sc3uO0RDrLGdXsjdUptJNEncPW1UWhP9ETgwIKtxUjgG4cFovYohFrnr@adcxgs0hub.my.salesforce.com --app dreamhouse-dev-sdx
# heroku config:set HEROKU_APP_NAME=dreamhouse-devkeynote-sdx-staging --app dreamhouse-dev-sdx-staging
# heroku config:set SALESFORCE_BUILDPACK_VERBOSE=true --app dreamhouse-dev-sdx-staging
# heroku config:set SALESFORCE_BYOO=true --app dreamhouse-dev-sdx-staging
# heroku config:set SALESFORCE_HUB_URL=force://3MVG9SemV5D80oBfPBCgboxuJ9df3F8MrzZxhqU5qeUb5MoRs.vuBNHRhhdMh2WDeh5cFiAXcv9z2PnZ7CScu:7278165525231799669:5Aep8614XGwzVzzTO6qBJOvmrMfeAZ4Sc3uO0RDrLGdXsjdUptJNEncPW1UWhP9ETgwIKtxUjgG4cFovYohFrnr@adcxgs0hub.my.salesforce.com --app dreamhouse-dev-sdx-staging