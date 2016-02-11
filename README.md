#WSO2 Message Broker Permission Update Client

Supported java version 1.7

This client can used as external java program to connecting to up and running WSO2 message broker and update queue or
topic permission passing necessary parameters. Please refer to Main class which has code snippet on how to do update
permission in queue.

 Things to modify in existing code before proceed.
 1. Modify host name in queueAdminServiceUrl and topicAdminServiceUrl variables in
 MessageBrokerPermissionUpdateClient class.
 2. Pass valid admin username and password to initialize MessageBrokerPermissionUpdateClient and authenticate admin
 service stubs.
 3. Provide correct queue name/topic name to update permission with correct role name.