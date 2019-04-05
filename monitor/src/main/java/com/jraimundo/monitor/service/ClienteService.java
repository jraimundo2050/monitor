package com.jraimundo.monitor.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.jraimundo.monitor.entity.ClienteEntity;
import com.jraimundo.monitor.model.Cliente;
import com.jraimundo.monitor.utils.JPAUtil;

public class ClienteService {

	private ClienteEntity cliEntity; 
	private Cliente	cliente;
	EntityManager em = JPAUtil.getEntityManager();
	
	public ClienteEntity salvar(Cliente cli) {
		
		try {
				cliEntity = new ClienteEntity(cli);
				em.getTransaction().begin();
				em.persist(cliEntity);
				em.getTransaction().commit();
		} catch (Exception e) {
			if(em.isOpen()) {
				em.getTransaction().rollback();
			}			
		} finally {
			if(em.isOpen()){
				em.close();
			}
		}				
				
		return cliEntity;
	}
	
	public Cliente findId(Long id) {
		cliente = new Cliente();
		em.getTransaction().begin();
		cliEntity =  em.find(ClienteEntity.class, id);
		cliente = entityToModelCli();
		em.close();		
		return cliente;
	}
	
	public Cliente entityToModelCli() {
		cliente = new Cliente();
		cliente.setIdCliente(cliEntity.getId());
		cliente.setNome(cliEntity.getNome());
		cliente.setTelefone(cliEntity.getTelefone());
		cliente.setCelular(cliEntity.getCelular());
		cliente.setEmail(cliEntity.getEmail());
		cliente.setDocumento(cliEntity.getDocumento());
		cliente.setContato(cliEntity.getContato());
		cliente.setData(cliEntity.getData());
		return cliente;
	}
	
	
	public Cliente entityToModelCli(ClienteEntity clienteEntity) {
		cliente = new Cliente();
		cliente.setIdCliente(clienteEntity.getId());
		cliente.setNome(clienteEntity.getNome());
		cliente.setTelefone(clienteEntity.getTelefone());
		cliente.setCelular(clienteEntity.getCelular());
		cliente.setEmail(clienteEntity.getEmail());
		cliente.setDocumento(clienteEntity.getDocumento());
		cliente.setContato(clienteEntity.getContato());
		cliente.setData(clienteEntity.getData());
		return cliente;
	}
	
	public Cliente findByDocumento(String documento) {
		
		cliente = new Cliente();
		
		try {
			
			String jpql = "select c from ClienteEntity c where c.documento = :pDocumento";
			Query query = em.createQuery(jpql);
			query.setParameter("pDocumento", documento);
			cliEntity =  (ClienteEntity) query.getSingleResult();
			cliente = entityToModelCli(); 
			em.close();
		} catch (NoResultException e) {
		      cliente.setIdCliente(0L); 
		} catch (RuntimeException e) {
		      e.printStackTrace();
		}			
		return cliente;
	}
	
	public boolean delete(Long id) {
		try {
				em.getTransaction().begin();
				cliEntity =  (ClienteEntity) em.find(ClienteEntity.class, id);
				em.remove(cliEntity);
				em.getTransaction().commit();
				em.close();		
				return true;
		} catch (RuntimeException e) {
		      e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<ClienteEntity> listAll() {
		try {
				String jpql = "select c from ClienteEntity c";
				Query query = em.createQuery(jpql);
				List<ClienteEntity> resultados = null;
				resultados = query.getResultList();
				 return (List<ClienteEntity>) resultados ;
		} catch (NoResultException e) {
		      return null; 
		} catch (RuntimeException e) {
		      e.printStackTrace();
		}			
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<ClienteEntity> listByName(String nome) {
		
		try {
				String jpql = "select c from ClienteEntity c where ( upper(c.nome) like :pnome or upper(c.contato) like :pnome  ) ";
				Query query = em.createQuery(jpql);
				query.setParameter("pnome", "%" + nome.toUpperCase() + "%");
				List<ClienteEntity> resultados = null;
				resultados = query.getResultList();
				 return (List<ClienteEntity>) resultados ;
		} catch (NoResultException e) {
		      return null; 
		} catch (RuntimeException e) {
		      e.printStackTrace();
		}			
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ClienteEntity> listByTelefone(String numero) {
		
		try {
				String jpql = "select c from ClienteEntity c where ( upper(c.telefone) like :pnumero or upper(c.celular) like :pnumero ) ";
				Query query = em.createQuery(jpql);
				query.setParameter("pnumero", "%" + numero.toUpperCase() + "%");
				List<ClienteEntity> resultados = null;
				resultados = query.getResultList();
				 return (List<ClienteEntity>) resultados ;
		} catch (NoResultException e) {
		      return null; 
		} catch (RuntimeException e) {
		      e.printStackTrace();
		}			
		return null;
	}	
}
