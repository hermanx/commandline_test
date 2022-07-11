
set SCRIPT_DIR=%~dp0%
set INPUT_FILE=%SCRIPT_DIR%..\snmp.yaml

java -cp %SCRIPT_DIR%..\lib\*;%SCRIPT_DIR%..\lib\thirdparty\* com.bouff.oids.OidAppLauncher %INPUT_FILE%