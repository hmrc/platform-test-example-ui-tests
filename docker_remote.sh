#!/usr/bin/env sh

#
# This script starts the local instance of an ARM64 Apple Silicone Chrome Docker container that you have
# already setup.
#
# The instructions to setup the local docker image are here:
# https://docs.google.com/document/d/1xmFUvaj4yFZVMg0OKgry92dvZiCuvt-E0nwzceYXbvk/edit?pli=1
#
###  Execute Test scenarios locally using docker
#    Note: you have to run all services locally, what runs in docker is chrome, therefore running the acceptante tests
#    does not interfiere with your work.
#    If using Docker Desktop, make sure how much memory and cpus is using and make sure you do not allocate a lot (check
#    setting icon on the upper right, and then resources, allocate one cpu and 2GB ram max.
#    otherwise your machine will struggle
#    1. Make sure you are on VPN
#    2. Start mongod
#    3. Start FSET_FASTSTREAM_ALL in service manager, that will use the latest from main:
#        sm --start FSET_FASTSTREAM_ALL -r
#       You can choose to stop some of the services, and run your own updated copy of the service
#    4. Start docker studio and wait a few seconds/ minutes
#    5. From the candidate acceptance parent project, run ./setup-docker.sh remote-chrome
#    5.1. If there is an existing container running, you may want to remove it using docker studio.
#    6. To run the test themselves, use this command:
#    ./jenkins_run_integration_local.sh

# If a command line argument for the browser driver to use is specified use it, otherwise use the default
#browserValue=$(commandLineArgOrDefault $1)
#
#echo "Going to supply the following command line arguments to sbt: sbt -Dbrowser=$browserValue"
#set -x
#sbt clean -Dbrowser=$browserValue 'testOnly uk.gov.hmrc.integration.cucumber.RunTestSuite' testReport

PORTS=$(lsof -i -P | grep LISTEN | grep :$PORT | grep java | awk '{ print $9"->"$9 }' | sed 's/\*://g' | paste -sd "," -)

if [ "EMPTY$PORTS" = "EMPTY" ]; then
  echo "NO PORTS FOUND. EXITING"
  exit 1
fi

PORT_MAPPINGS="$PORTS,11000->11000, 6010->6010"

echo PORT_MAPPINGS: $PORT_MAPPINGS

docker run \
       -d \
       --rm \
       --name "remote-chrome-arm" \
       --shm-size=2g \
       -p 4444:4444 \
       -p 5900:5900 \
       -e PORT_MAPPINGS="$PORT_MAPPINGS" \
       -e TARGET_IP='host.docker.internal' \
       remote-chrome-arm