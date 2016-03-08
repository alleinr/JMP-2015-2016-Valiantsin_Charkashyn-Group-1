Application used for this task is from previous module.

1. Install tomcat. Open server.xml. Uncomment AJP connector definition.

<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" enableLookups="false" />

2. Download and unpack Apache. 

3. Download mod_jk from http://tomcat.apache.org/download-connectors.cgi. -> /pub/apache/tomcat/tomcat-connectors/jk/binaries/win32/. Unpack it to Apache's modules folder.

4. Open conf/httpd.conf and add folowwing lines:

LoadModule jk_module modules/mod_jk.so

<IfModule jk_module>

    JkWorkersFile conf/workers.properties
    JkLogFile logs/mod_jk.log
    JkLogStampFormat "[%b %d %Y - %H:%M:%S] "
    JkRequestLogFormat "%w %V %T"
    JkLogLevel info

    JkOptions +ForwardKeySize +ForwardURICompat -ForwardDirectories

    Alias /newsmanagement "{address}"

    <Directory "{address}">
        AllowOverride None
        Allow from all
    </Directory>

    <Location /*/newsmanagement/*>
        deny from all
    </Location>

    JkMount /newsmanagement/* myworker

</IfModule>

5. Create workers.properties and insert there:

worker.list=myworker
worker.myworker.type=ajp13
worker.myworker.host=localhost
worker.myworker.port=8009

Save file to Apache conf folder.

6. Verify httpd. Run in cmd  from bin folder "httpd.exe -t". Run Apache.

7. Start Tomcat. Deploy application http://localhost:8080/manager/text/deploy?path=/{address}.

8. Test if everything is okay.


