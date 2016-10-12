source heroku-config

heroku pipelines:destroy $pipelineName
heroku apps:destroy --app $stagingName --confirm $stagingName
heroku apps:destroy --app $prodName --confirm $prodName