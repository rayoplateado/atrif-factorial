#### Statement
We need a Frontend + Backend application that allows you to post and visualize metrics. Each metricEntity will have: Timestamp, name, and value. The metrics will be shown in a timeline and must show averages per minute/hour/day. The metrics will be persisted in the database.

- -----------------
## TODOs

 
- [x] Initial setup springboot initializer 
- [x] Add APIs (post and list all metrics + averages)
- [x] Use Timeseries Database (InfluxDB)
- [ ] Setup mocked data in the db
- [ ] Error management
- ------------------
## Potential improvements
- Caching (Redis)
- Message queue (Kafka)
- 
- -----------------