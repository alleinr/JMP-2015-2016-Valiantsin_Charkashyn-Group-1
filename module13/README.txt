Application used for this task is from previous module.

1. Install tomcat. Open server.xml. Uncomment AJP connector definition.

<Connector port="18009" protocol="AJP/1.3" redirectPort="8443" enableLookups="false" />

2. Download and unpack Apache. 

3. Download mod_jk from http://tomcat.apache.org/download-connectors.cgi. -> /pub/apache/tomcat/tomcat-connectors/jk/binaries/win32/. Unpack it to Apache's "modules" folder.

4. Open conf/httpd.conf and add following lines:

LoadModule jk_module modules/mod_jk.so

<IfModule jk_module>

    JkWorkersFile conf/workers.properties
    JkLogFile logs/mod_jk.log
    JkLogStampFormat "[%b %d %Y - %H:%M:%S] "
    JkRequestLogFormat "%w %V %T"
    JkLogLevel info

    JkOptions +ForwardKeySize +ForwardURICompat -ForwardDirectories

    Alias /ui "d:/nm_ws/newsmanagament/ui/"

    <Directory "d:/nm_ws/newsmanagament/ui/">
        AllowOverride None
        Allow from all
    </Directory>

    <Location /*/ui/*>
        deny from all
    </Location>
	#JkAutoAlias /usr/share/tomcat6-examples/
    JkMount /ui/* myworker
	JkMount /ui myworker
</IfModule>

5. Create workers.properties and insert there:

worker.list=myworker
worker.myworker.type=ajp13
worker.myworker.host=localhost
worker.myworker.port=18009

Save file to Apache conf folder.

6. Verify httpd. Run in cmd  from bin folder "httpd.exe -t". Install Apache by running "httpd.exe -k install". Run Apache by "httpd.exe -k start".

7. Start Tomcat and deploy application. 

8. Test if everything is okay.
Apache - http://localhost:81/ui/
Tomcat - http://localhost:8080/ui/

