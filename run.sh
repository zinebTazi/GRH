#!/bin/bash


mysql --user=root --password=$1 -e "CREATE USER 'GRH'@'localhost' IDENTIFIED BY 'pfe';"

retour=$?

if [ $retour -eq 0 ]; then 
mysql --user=root --password=$1 -e "GRANT ALL ON *.* TO 'GRH'@'localhost' WITH GRANT OPTION;"
retour1=$?
	if [ $retour1 -eq 0 ]; then
	mysql --user=root --password=$1 -e "FLUSH PRIVILEGES;"
	mysql --user=GRH --password=pfe -e "CREATE database GRH;"
	retour2=$?
		if [ $retour2 -eq 0 ]; then
		mysql --user=GRH --password=pfe GRH< ./PFE.sql
		fi
	fi
fi
