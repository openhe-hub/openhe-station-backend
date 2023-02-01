# Openhe Station Backend Project
![](https://img.shields.io/badge/lang-Java-lightgreen.svg?style=flat)
![](https://img.shields.io/badge/build-Maven-8678fe.svg?style=flat)
![](https://img.shields.io/badge/framework-Springboot-cyan.svg?style=flat)
![](https://img.shields.io/badge/database-Mysql-yellow.svg?style=flat)
![](https://img.shields.io/badge/plugin-MybatisPlus-red.svg?style=flat)

## Introduction
This project is the back-end section for [openhe-station](http://www.openhe-station.com/)
, a personal website.
* Tech Stack: Springboot+Spring+SpringMVC+MybatisPlus
* Function: blog, resource download, project view, data management, chat
* Visiting URL: http://www.openhe-station.com/
* View Frontend Project: https://github.com/openhe-hub/openhe-station-frontend.git
## Run & Deploy
* Run Jar
    ```bash
    git clone https://github.com/openhe-hub/openhe-station-backend.git
    cd ./openhe-station-backend/target
    java -jar backend-0.0.1-SNAPSHOT.jar
    ```
* Nginx Settings
  ```
   server {
    listen       80;
    server_name  <ip or domain>;

    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   /usr/share/nginx/html;
    }


    location / {
        root <frontend dist>;
        index index.html index.htm;
        try_files $uri $uri/ /index.html;
    }

    location /api {
        proxy_pass http://<ip or domain>:8080/api;
    }
  }
  ```       
## Version
### v-0.1
* finish note module & whole structure
## TO DO/TO FIX
- [ ] note add/delete
- [ ] user auth control
- [ ] add static resource files & projects
## Contributor
[openhe](https://github.com/openhe-hub)