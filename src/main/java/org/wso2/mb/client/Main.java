package org.wso2.mb.client;

import org.wso2.carbon.andes.stub.AndesAdminServiceBrokerManagerAdminException;
import org.wso2.carbon.andes.stub.admin.types.QueueRolePermission;

import java.rmi.RemoteException;

/**
 * Main class does permission update
 */
public class Main {

    /**
     * Main method
     *
     * @param args arguments
     */
    public static void main(String[] args) throws RemoteException, AndesAdminServiceBrokerManagerAdminException {
        //initialize permission update client
        MessageBrokerPermissionUpdateClient client = new MessageBrokerPermissionUpdateClient("admin", "admin");
        //setting up queue permission to set
        QueueRolePermission[] permissions = new QueueRolePermission[1];
        QueueRolePermission role1Permission = new QueueRolePermission();
        role1Permission.setRoleName("role1");
        role1Permission.setAllowedToConsume(false);
        role1Permission.setAllowedToPublish(false);
        permissions[0] = role1Permission;
        //updating queue permission
        client.updateQueuePermission("myQueue", permissions);
    }
}
