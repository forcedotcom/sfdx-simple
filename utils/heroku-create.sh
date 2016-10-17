source heroku-config

heroku apps:create $stagingName
heroku pipelines:create $pipelineName --app $stagingName --stage staging
heroku apps:create $prodName
heroku pipelines:add $pipelineName --app $prodName --stage production

heroku buildpacks:add https://github.com/heroku/salesforce-buildpack --app $stagingName
heroku buildpacks:add https://github.com/heroku/salesforce-buildpack --app $prodName

heroku addons:create salesforce:standard --app $stagingName
heroku addons:create salesforce:standard --app $prodName

heroku config:set HEROKU_APP_NAME=$stagingName --app $stagingName
heroku config:set HEROKU_APP_NAME=$prodName --app $prodName
