package br.edu.ifpb.application;

import br.edu.ifpb.domain.ClientDao;
import br.edu.ifpb.domain.model.Client;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
/**
 * @author Leanderson Coelho
 * @email leanderson.coelhoif@gmail.com
 */
@Stateless
public class ClientServiceJPA {

    @Inject
    private ClientDao userDao;

    public void save(Client user){
        userDao.save(user);
    }

    public void update(Client user){
        userDao.update(user);
    }

    public void delete(Client user){
        userDao.delete(user);
    }

    public List<Client> allClients(){
        return userDao.allClients();
    }

    public Client find(String email){
        return userDao.find(email);
    }

    public boolean login(Client c){
        Client trueClient = this.find(c.getEmail());
        if(trueClient != null && c.getPassword().equals(trueClient.getPassword())){
            return true;
        } return false;
    }

}
