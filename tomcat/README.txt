1) Install Tomcat and Apache (I used apache-tomcat-7.0.29.exe and apache_2.2.14-win32-x86-no_ssl.msi for installation; tomcat port: 8080, apache port:8008)

2) Add the following line in "path/to/tomcat/conf/tomcat-users.xml" to create a new user with manager-script role.

	<user username="tomcat" password="tomcat" roles="manager-script"/>

3) Configure the Tomcat and Apache integration with mod_jk.so module

	3.1) Download mod_jk.so (I used mod_jk-1.2.31-httpd-2.2.3.so)

	3.2) Copy mod_jk.so in "path/to/apache/modules" folder

	3.3) Add the following lines in "path/to/apache/conf/httpd.conf"

		LoadModule jk_module modules/mod_jk.so
		Include conf/extra/mod_jk.conf

	3.4) Create mod_jk.conf in "path/to/apache/conf/extra" folder

		#mod_jk config

		<IfModule mod_jk.c>
			JkworkersFile conf/extra/workers.properties
		</IfModule>

		<VirtualHost *:8008>
    			ServerName localhost
		
			Alias /tomcat /tomcat7/webapps/tomcat

			<Directory "/tomcat7/webapps/tomcat">
         			Order allow,deny
         			Allow from all
        		</Directory>

			JkMount /* ajp13

			JkUnMount /*.html ajp13
  			JkUnMount /*.jpg  ajp13
  			JkUnMount /*.css  ajp13
		</VirtualHost>

	3.5) Create workers.properties in "path/to/apache/conf/extra" folder

		worker.list=ajp13
		worker.ajp13.port=8009
		worker.ajp13.host=localhost
		worker.ajp13.type=ajp13

4) Start Apache and Tomcat

5) Built application with maven

6) Use the following URL to deploy with tomcat manager application (text/script mode)

	http://localhost:8008/manager/text/deploy?path=/tomcat&war=file:absolute/path/to/war/tomcat.war

	username/password: tomcat/tomcat

	Sample: http://localhost:8008/manager/text/deploy?path=/tomcat&war=file:D:/mentoring/tasks/tomcat/target/tomcat.war

7) Check application

	http://localhost:8008/tomcat/index.jsp
	http://localhost:8008/tomcat/lazy.jsp

	http://localhost:8008/tomcat/static/css/style.css
	http://localhost:8008/tomcat/static/image/cat.jpg
	http://localhost:8008/tomcat/static/html/lazy.html
