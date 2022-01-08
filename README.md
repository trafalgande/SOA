# SOA-3

##### haproxy.cfg
```
defaults
    timeout connect 5000ms
    timeout server 50000ms
    timeout client 50000ms
    timeout check 50000ms

frontend yo
    mode http
    bind *:88
    use_backend service-a
    use_backend service-b


backend service-a
    mode http
    option ssl-hello-chk
    balance roundrobin
    server instance_1 127.0.0.1:8080 check
    server instance_2 127.0.0.1:8081 check

backend service-b
    mode http
    option ssl-hello-chk
    balance roundrobin
    server instance_1 127.0.0.1:10362 check
    server instance-2 127.0.0.1:10363 check

listen stats
    bind 127.0.0.1:1111
    mode http
    stats uri /
    stats auth yo:yo
```
