# SFDX Simple App

> **Important:** Salesforce DX is available as a developer preview. Salesforce DX isn’t generally available unless or until Salesforce announces its general availability in documentation or in press releases or public statements. All commands, parameters, and other features are subject to change or deprecation at any time, with or without notice. Don't implement functionality developed with these commands or tools.

The Salesforce Developer Experience (SFDX) starts with source code living in your version control system.

## Set Up the Developer Workspace

Our first goal is to set up a developer workspace for us to use to modify our application. It starts by cloning the repository. Use the command ...

    git clone https://github.com/forcedotcom/sfdx-simple.git

… or ...

    git clone git@github.com:forcedotcom/sfdx-simple.git

… to clone the repository. Then, open the directory.

    cd sfdx-simple
    
## Resources

For details on using sfdx-simple, please review the [Salesforce DX Developer Guide](https://goo.gl/rG43Cz).

## Description of Files and Directories

The sfdx-simple sample repo shows how you can set up your own repo for use with Salesforce DX.  The repo includes a number of configuration files; some are specific to Salesforce DX while others are used by related applications such as Heroku Pipelines and CI, Eclipse, Git, or Selenium.  

The following list briefly describes each configuration file, the application that uses it, and whether it is required, optional, or is simply a sample file that shows a best practice or additional examples.  See the [Salesforce DX Developer Guide](https://goo.gl/rG43Cz) for additional information.

* **workspace-config.json**: Required by Salesforce DX. Configures your workspace.  Use this file to specify the parameters that affect your Salesforce development project.
* **app.json**: Required by Heroku Pipelines. Configures the Salesforce buildpack and add-on for Heroku review apps.
* **app-ci.json**: Optional Heroku CI file.  Configures the Salesforce buildpack, add-on, and tests for the Heroku app that automatically spins up as part of CI test run.   Because the Salesforce configuration for test runs is different from the configuration for Heroku review apps, this sample app uses the optional **app-ci.json** file for configuring Heroku CI instead of **app.json**.
* **app-ci-test-runner.json**: Sample file that shows how to use the Test Runner within the context of Heroku CI.  To use, rename the file **app-ci.json**.
* **app-ci-apex-only.json**: Sample file that shows how to run Apex tests within the context of Heroku CI. To use, rename the file **app-ci.json**.
* **Procfile**: Optional Heroku Pipelines file.  Specifies the commands that are run by the Heroku app's dynos.  If you do not explicitly create a Procfile when using Salesforce DX with Heroku Pipelines, a default one is used.
* **.forceignore**:  Optional Salesforce DX file.   Lists the directories and files that you want force:src:push/pull to ignore.
* **.project**:  Required by the Eclipse IDE.  Describes the Eclipse project. 
* **.gitignore**:  Optional Git file. Specifies intentionally untracked files that you want Git (or in this case GitHub) to ignore.
* **bin/extra-org-setup.sh**: Sample shell script that performs additional setup on a Salesforce scratch org.  Called by **bin/release**.
* **bin/release**: Sample script file that describes the commands that are run during the release phase of a Heroku app deployment.  Called by the Heroku **Procfile**.
* **config/workspace-scratch-def.json**: Sample file that shows how to define the shape of a scratch org.  You can reference this file when you create your workspace scratch org with the force:org:create command.   In the sfdx-simple sample, this file is also called by the **test/test-runner-config.json** file.
* **test/pom.xml**: Sample Maven POM file that shows how to configure the Selenium tests.  Called by the **test/test-runner-config.json** file. 
* **test/test-data.json**: Sample file that loads data into a scratch org.   Called by **test/test-runner-config.json**.
* **test/test-runner-config.json**: Required by Test Runner, although you can name the file anything you want.  Configures all aspects of the Test Runner, such as its profiles, the tests to run, the orgs to create, the data to load, and so on.
* **test/test.sh**: Sample script that shows how to use the Test Runner in the context of Heroku CI.  Called by the sample **app-ci-test-runner.json** Heroku file.

The following two directories contain source code:

* **force-app**: The source for the sample Force.com app and tests.  The name of this directory corresponds to the value of the DefaultArtifact parameter of your **workspace-config.json** file.  
* **test/integration**: The Java source for the Selenium tests.

Finally, the **utils** directory contains sample scripts for quickly creating and configuring Heroku apps and pipelines.

## Issues

Please log issues related to this repository [here](https://github.com/forcedotcom/sfdx-simple/issues).
