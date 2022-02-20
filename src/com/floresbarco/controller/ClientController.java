package com.floresbarco.controller;

import com.floresbarco.DataStructure.CircularDoubleLinkedList;
import com.floresbarco.DataStructure.LinkedList;
import com.floresbarco.DataStructure.Node;
import com.floresbarco.model.Client;

public class ClientController {
    private static ClientController instance;
    // LISTA
    private  LinkedList<Client> list;
    // COLA DE RECEPCION DE CLIENTES
    private LinkedList<Client> receptionQueue;
    // LISTA SIMPLE DE CLIENTES ATENDIDOS
    private LinkedList<Client> clientsServed;
    // LISTA DE LISTA DE CLIENTES DE ESPERA
    private CircularDoubleLinkedList<Client> clientWaiting;

    // CONSTRUCTOR
    public ClientController() {
        instance = null;
        list = new LinkedList<Client>();
        receptionQueue = new LinkedList<Client>();
        clientsServed = new LinkedList<Client>();
        clientWaiting = new CircularDoubleLinkedList<Client>();
    }

    // SINGLETON
    public static synchronized ClientController getInstance() {
        if(instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    // GET
    public LinkedList<Client> getList() {
        return list;
    }

    public LinkedList<Client> getReceptionQueue() {
        return receptionQueue;
    }

    public LinkedList<Client> getClientsServed() {
        return clientsServed;
    }

    public CircularDoubleLinkedList getClientWaiting() {
        return clientWaiting;
    }

    // ADD
    public void add(Client client) {
        list.add(client);
    }

    public void addReceptionQueue(Client client) {
        receptionQueue.add(client);
    }

    public void addClientsServed(Client client) {
        clientsServed.add(client);
    }

    public void addClientWaiting(Client client) {
        clientWaiting.add(client);
    }

    // DEQUEUE
    public Client dequeueReceptionQueue() {
        return receptionQueue.dequeue();
    }

    public Client dequeueClientsServed() {
        return clientsServed.dequeue();
    }

    public Client deleteClientWaiting(Integer id) {
        return clientWaiting.delete(id);
    }

    // FIND
    public Client findClientWaiting(Integer id) {
        Node<Client> current = clientWaiting.get();
        if(current != null) {
            if(current.getElement().getId() == id) {
                return current.getElement();
            } else {
                do {
                    if(current.getElement().getId() == id) {
                        return current.getElement();
                    }
                } while (current != clientWaiting.get());
            }
        }
        return null;
    }

    public Client findClientNameWaiting(String name) {
        Node<Client> current = clientWaiting.get();
        if(current != null) {
            if(current.getElement().getName().equals(name)) {
                return current.getElement();
            } else {
                do {
                    if(current.getElement().getName().equals(name)) {
                        return current.getElement();
                    }
                } while (current != clientWaiting.get());
            }
        }
        return null;
    }

}
