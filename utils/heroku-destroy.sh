stagingName=sfdx-simple-staging
prodName=sfdx-simple-prod
pipelineName=sfdx-simple-pipelines

heroku pipelines:destroy $pipelineName
heroku apps:destroy --app $stagingName --confirm $stagingName
heroku apps:destroy --app $prodName --confirm $prodName