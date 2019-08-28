package br.edu.ifpb.domain;


import br.edu.ifpb.domain.model.Client;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;
/**
 * @author Leanderson Coelho
 * @email leanderson.coelhoif@gmail.com
 */
@Stateless
public class ClientDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Client user){
        em.persist(user);
    }

    public void update(Client user){
        em.merge(user);
    }

    public void delete(Client user){
        em.remove(
                em.merge(user)
        );
    }

    public List<Client> allClients(){
        return em.createQuery("SELECT u FROM Client u", Client.class).getResultList();
    }

    public Client find(String email){
        try {
            TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.email = :email", Client.class);
            query.setParameter("email", email);
            Client c = query.getSingleResult();
            return c;
        }catch (NoResultException e){
            //código somente de teste, melhorias não necessárias para essa atividade
            return null;
            //pode ser melhorado
        }
    }
}
