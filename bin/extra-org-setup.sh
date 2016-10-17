#!/usr/bin/env bash

##
# Performs additional app setup on org.
#
# This script:
#   - Enables PermissionSet on configured workspace,
#   - Loads sample data.
##

# Debug, echo every command
#set -x

# Wrapper function to capture command return codes, detect failure,
# and, if error, log message
runCmd() {
    local cmnd="$*"
    local ret_code

    echo $cmnd
    eval $cmnd
    ret_code=$?
    if [ $ret_code != 0 ]; then
        printf "Error : [%d] when executing command: '$cmnd'" $ret_code
        exit $ret_code
    fi
}

# Set perms on apps and objects
echo ""
echo "Enabling PermissionSet for App and SObject visibility..."
# TODO
#runCmd "$HEROKU_CLIENT force:permset:assign --name [APP_NAME]"


if [ "$LOAD_DATA" = true ]; then
    # Load the app data into the org
    echo ""
    echo "Loading data..."
    # TODO
    #runCmd "$HEROKU_CLIENT force:data:import --plan [DATA_PLAN_FILE]"
fi

exit 0
