# Deploy source to SALESFORCE_URL org.
release: bin/release

# Redirect all Heroku app domain requests to SALESFORCE_URL org.
# Defaults to /one/one.app, configurable via SALESFORCE_START_URL config var.
web: .salesforce/node/bin/node .salesforce/force.js redirect

