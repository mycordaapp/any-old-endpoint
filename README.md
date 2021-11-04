# Any old Endpoint

[![Circle CI](https://circleci.com/gh/mycordaapp/any-old-endpoint.svg?style=shield)](https://circleci.com/gh/mycordaapp/any-old-endpoint)
[![Licence Status](https://img.shields.io/github/license/mycordaapp/any-old-endpoint)](https://github.com/mycordaapp/any-old-endpoint/blob/master/licence.txt)

## What it does

A simple server and optional client that provide a basic set of endpoints for testing deployments.

The basic use cases are problems like:

* I want to setup up a cloud service, and I need to test my https termination rules
* I want to deploy a clustered service like Kafka or Zookeeper, and I want to prove that I am publishing endpoints
  correctly to internal and external clients.

`Any old Endpoint` is simply a JAR/Container that can deployed instead of a real service. It can be configured to publish a
set of simple endpoints for common protocols (currently http, web sockets and vanilla TCP sockets) in place of the real
service. The name is taken from the expression "Any old thing will do" , i.e. we don't really care what we have, we just
need something. It is intended for early stage connectivity testing when all that is necessary are some basic endpoints
to test connectivity.

## Dependencies

As with everything in [myCorda dot App](https://mycorda.app), this library has minimal dependencies.

* Kotlin 1.4
* Java 11
* The [http4k](https://www.http4k.org/) toolkit

## Next Steps

More on starting, configuring and calling endpoints is  [here](./docs/any-old-endpoint.md)


