package controller;

import java.util.List;

import dao.ContaDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import dao.impl.ContaDAOImpl;
import dao.impl.EnderecoDAOImpl;
import dao.impl.PessoaDAOImpl;
import model.Conta;
import model.Endereco;
import model.Pessoa;


public class Principal {

	public static void main(String[] args) {
//			
//		EntityManager em = JpaUtil.getEntityManager();
//		EntityTransaction et = em.getTransaction();
//		et.begin();
//		em.close();
		
//		Conta conta  = new Conta();
//		conta.setNumero(9010);
//		conta.setSaldo(50800d);
//		conta.setLimite(89000d);
		
//		ContaDAO contaDao = new ContaDAOImpl();
//		contaDao.salvar(conta);
//		
//		conta.setSaldo(9900d);
//		conta.setLimite(96000d);
//		contaDao.alterar(conta);
		
		//contaDao.remover(9002);
		
		
//		Endereco endereco = new Endereco();
//		endereco.setRua("Rua D");
//		endereco.setNumero(12);
//		endereco.setComplemento("Casa");
		
//		EnderecoDAO enderecoDao = new EnderecoDAOImpl();
//		enderecoDao.salvar(endereco);
//		
//		endereco.setRua("Rua W");
//		endereco.setNumero(19);
//		endereco.setComplemento("Casa");
//		enderecoDao.alterar(endereco);
//		//enderecoDao.remover(endereco.getId_endereco());
//		enderecoDao.remover(8);
		
//-------------------------------------------------------
		
		Conta conta  = new Conta();
		ContaDAO contaDao = new ContaDAOImpl();
		Endereco endereco = new Endereco();
		EnderecoDAO enderecoDao = new EnderecoDAOImpl();
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDao = new PessoaDAOImpl();
	
		
		pessoa.setCpf("02092331410");
		pessoa.setIdade(35);
		pessoa.setNome("Maria da Silva");
		pessoa.setSexo("F");
		
		conta.setNumero(1002);
		conta.setLimite(300d);
		conta.setSaldo(800d);
		
		
		
		int end = pessoaDao.pesquisar(pessoa.getCpf()).getEndereco().getId_endereco();
		endereco.setId_endereco(end);
		endereco.setRua("Rua 159");
		endereco.setNumero(40);
		endereco.setComplemento("Casa");
		pessoa.setConta(conta);
		pessoa.setEndereco(endereco);
		
		
//		pessoaDao.salvar(pessoa);
		pessoaDao.alterar(pessoa);
				
		
		
//		ContaDAO contaDAO = new ContaDAOImpl();
//		
//		System.out.println("----------------retorno de pesquisa conta e endereco-------------------------");
//		Conta conta1 = contaDAO.pesquisar(9001);
//		System.out.println(conta1.toString());
//		
//		Endereco endereco1 = enderecoDao.pesquisar(3);
//		System.out.println(endereco1.toString());
//		
//		System.out.println("----------------Lista todos---------------------------------");
//		List<Conta> listaConta = contaDAO.listarTodos();
//		List<Endereco> listaEndereco = enderecoDao.listarTodos();
//		for (Conta c : listaConta) {
//			System.out.println(c.toString());
//		}
//		System.out.println("-------------------------------------------------");
//		for (Endereco c : listaEndereco) {
//			System.out.println(c.toString());
//		}
//		
//		
//		System.out.println("----------------Lista todos alternativos -------------------");
//		
//		listaConta.forEach(System.out::println);
//		
//		System.out.println("-------------------------------------------------");
//		listaConta.forEach(c -> System.out.println(c));
//		System.out.println("-------------------------------------------------------------");
		
		List<Pessoa> listaPessoa = pessoaDao.listarTodos();
		System.out.println("-------------------------------------------------");
		listaPessoa.forEach(c -> System.out.println(c));
		System.out.println("-------------------------------------------------------------");
		
	}

}
