# This is a work in progress

Goals

- showcase the different subject name strategies
- showcase the different compatability modes
- showcase a custom built subject name strategy 
- showcase terraform managed schema creation
- showcase terraform managed scheam evolution
- showcase build automation
- showcase build backward-compatibility

# Steps

### Getting Jenkins online

1. docker compose up -d
1. Get the adminPassword
    docker exec -it jenkins cat /var/jenkins_home/secrets/initialAdminPassword
    > Ex
    > 6f70376da6d84747ab0a79c9c83ae7dd
2. Paste it into the console at http://localhost:8080
3. Select "install recommended/community plugins"
    > Wait a new minutes
4. Create your admin user, you can pretty much do whatever here. This is only local
5. Accept the base URL link, and then start

