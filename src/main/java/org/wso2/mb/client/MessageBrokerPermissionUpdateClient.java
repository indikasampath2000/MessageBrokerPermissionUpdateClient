package org.wso2.mb.client;

import org.apache.axis2.AxisFault;
import org.wso2.carbon.andes.event.stub.core.TopicRolePermission;
import org.wso2.carbon.andes.event.stub.service.AndesEventAdminServiceEventAdminException;
import org.wso2.carbon.andes.event.stub.service.AndesEventAdminServiceStub;
import org.wso2.carbon.andes.stub.AndesAdminServiceBrokerManagerAdminException;
import org.wso2.carbon.andes.stub.AndesAdminServiceStub;
import org.wso2.carbon.andes.stub.admin.types.QueueRolePermission;

import java.rmi.RemoteException;

/**
 * This class does admin service call and update queue/topic permission
 */
public class MessageBrokerPermissionUpdateClient {

    private String queueAdminServiceUrl = "https://localhost:9443/services/AndesAdminService?wsdl";
    private String topicAdminServiceUrl = "https://localhost:9443/services/AndesEventAdminService?wsdl";
    private AndesAdminServiceStub queueStub = null;
    private AndesEventAdminServiceStub topicStub = null;

    /**
     * MessageBrokerPermissionUpdateClient constructor
     *
     * @param username username of valid user to invoke admin service
     * @param password password of valid user to invoke admin service
     * @throws AxisFault
     */
    public MessageBrokerPermissionUpdateClient(String username, String password) throws AxisFault {
        //initialize and authenticate queue stub
        queueStub = new AndesAdminServiceStub(this.queueAdminServiceUrl);
        AuthenticateStubUtil.authenticateStub(username, password, queueStub);
        //initialize and authenticate topic stub
        topicStub = new AndesEventAdminServiceStub(this.topicAdminServiceUrl);
        AuthenticateStubUtil.authenticateStub(username, password, topicStub);
    }

    /**
     * Update queue permissions
     *
     * @param queueName            queue name to set permission
     * @param queueRolePermissions permissions array which contain necessary information
     * @throws RemoteException
     * @throws AndesAdminServiceBrokerManagerAdminException
     */
    public void updateQueuePermission(String queueName, QueueRolePermission[] queueRolePermissions)
            throws RemoteException, AndesAdminServiceBrokerManagerAdminException {
        queueStub.updatePermission(queueName, queueRolePermissions);
        System.out.println("Queue permission update successfully!");

    }

    /**
     * Update topic permission
     *
     * @param topicName            topic name to set permission
     * @param topicRolePermissions permissions array which contain necessary information
     * @throws RemoteException
     * @throws AndesEventAdminServiceEventAdminException
     */
    public void updateTopicPermission(String topicName, TopicRolePermission[] topicRolePermissions)
            throws RemoteException, AndesEventAdminServiceEventAdminException {
        topicStub.updatePermission(topicName, topicRolePermissions);
        System.out.println("Topic permission update successfully!");
    }
}
