package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.EnderecoDAO;
import model.Conta;
import model.Endereco;
import model.util.JpaUtil;

public class EnderecoDAOImpl implements EnderecoDAO{
	
	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void salvar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(endereco);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transacao - endereco");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void alterar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(endereco);
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transacao");

		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void remover(int id_endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Endereco.class, id_endereco));
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transacao");

		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Endereco pesquisar(int id_endereco) {
		Endereco endereco = new Endereco();
		try {
			this.em = JpaUtil.getEntityManager();
			endereco = em.find(Endereco.class, id_endereco);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transacao");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

		return endereco;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Endereco e");
		List<Endereco> listaEndereco = query.getResultList();
		em.close();
		return listaEndereco;
	}

}
