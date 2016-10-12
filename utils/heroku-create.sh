source heroku-config

heroku apps:create $stagingName
heroku pipelines:create $pipelineName --app $stagingName --stage staging
heroku apps:create $prodName
heroku pipelines:add $pipelineName --app $prodName --stage production

heroku buildpacks:add https://github.com/heroku/salesforce-buildpack --app $stagingName
heroku buildpacks:add https://github.com/heroku/salesforce-buildpack --app $prodName

heroku addons:create salesforce:byoo --app $stagingName
heroku addons:create salesforce:byoo --app $prodName

heroku config:set HEROKU_APP_NAME=$stagingName --app $stagingName
heroku config:set HEROKU_APP_NAME=$prodName --app $prodName

heroku config:set SALESFORCE_BYOO=true --app $stagingName
heroku config:set SALESFORCE_BYOO=true --app $prodName