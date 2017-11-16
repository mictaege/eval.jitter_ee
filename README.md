# eval.jitter_ee

This repository contains an evaluation of the [jitter](https://github.com/mictaege/jitter-plugin) Gradle plugin and demonstrates how to build and distribute different flavours of a simple J2EE applpication from a single source base.

In this simple application the flavors are different types of space agencies: _ESA_, _NASA_ and _ROSKOSMOS_.

Because of the _jitter_ configuration in the _build.gradle_ file this project has three additional tasks: ```flavourESA```, ```flavourNASA``` and ```flavourROSKOSMOS```. This additional tasks are used to select the flavour which should be build or run.

## Examples

```Shell
gradle flavourESA clean build
```

Will build the application with the flavour _ESA_.

```Shell
gradle flavourESA clean war
```

Will create the war for the application with the flavour _ESA_.

**Note** If the application was build with another flavour before, the next build or run should always include a ```clean```.

To execute all test for all flavours omit the flavour selection:

```Shell
gradle clean test
```

Creating a war for the application requires the selection of one flavour.

## Deployment Setup

In order to deploy _eval.jitter_ee_ to an application server a Datasource with the JNDI name ```jdbc/eval-jitter-ee``` is required.

### Example

A possible application server setup using  _payara 4.1.1.163_  and it's bundled _Derby Database_ might look like this:

#### Payara

- Install _payara 4.1.1.163_ to ```<project-root>/payara```
- Create domain _eval_jitter_ee_
  ```Shell
    <project-root>/payara/bin/asadmin create-domain eval_jitter_ee
  ```
- Start domain _eval_jitter_ee_
  ```Shell
    <project-root>/payara/bin/asadmin start-domain eval_jitter_ee
  ```

#### Derby DB

- Create database _eval-jitter-ee-db_ with _ij_:
  ```Shell
    <project-root>/payara/bin/asadmin start-database --dbport 53100
  ```
  ```Shell
    <project-root>/payara/javadb/bin/ij
  ```
  ```Shell
    ij>connect 'jdbc:derby://localhost:53100/eval-jitter-ee-db;create=true;user=app;password=app';
  ```

#### Configure Connection-Pool and JDBC Resources

| Name                      | Value                                                                                   |
| :-------------            | :-------------                                                                          |
| Connection-Pool           | ```eval-jitter-ee-pool```                                                               |
|                           | - Resource Type: ```javax.sql.XADataSource```                                           |
|                           | - Datasource Classname: ```	org.apache.derby.jdbc.ClientXADataSource```               |
|                           | - User: ```app```                                                                       |
|                           | - DatabaseName: ```eval-jitter-ee-db```                                                 |
|                           | - Password: ```app```                                                                   |
|                           | - PortNumber: ```53100```                                                               |
|                           | - serverName: ```localhost```                                                           |
| JDBC Resources            | - JNDI-Name: ```jdbc/eval-jitter-ee```                                                  |
|                           | -  Connection Pool: ```eval-jitter-ee-pool```                                           |
