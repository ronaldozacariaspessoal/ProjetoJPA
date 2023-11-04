package controller;

import java.util.ArrayList;
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
import model.Telefone;


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
		
		Conta cc  = new Conta();
		ContaDAO contaDao = new ContaDAOImpl();
		Endereco e = new Endereco();
		EnderecoDAO enderecoDao = new EnderecoDAOImpl();
		Pessoa p = new Pessoa();
		PessoaDAO pessoaDao = new PessoaDAOImpl();
	
		
		p.setCpf("65092331429");
		p.setIdade(35);
		p.setNome("Katarina da Silva");
		p.setSexo("F");
		
		cc.setNumero(1007);
		cc.setLimite(600d);
		cc.setSaldo(900d);
		
		
		
		//int end = pessoaDao.pesquisar(pessoa.getCpf()).getEndereco().getId_endereco();
		//endereco.setId_endereco(end);
		e.setRua("Rua oito");
		e.setNumero(55);
		e.setComplemento("Apt");
		
		p.setConta(cc);
		p.setEndereco(e);
		
//		int end = pessoaDao.pesquisar(p.getCpf()).getEndereco().getId_endereco();
//		e.setId_endereco(end);
		
		Telefone tel1 = new Telefone("81", "978877661", p);
		Telefone tel2 = new Telefone("81", "978877662", p);
		Telefone tel3 = new Telefone("81", "978877663", p);
		Telefone tel4 = new Telefone("81", "978877664", p);
		List<Telefone> lista = new ArrayList<>();
		lista.add(tel1);
		lista.add(tel2);
		lista.add(tel3);
		lista.add(tel4);
		
		p.setTelefones(lista);
		
		
		pessoaDao.salvar(p);
//		pessoaDao.remover(pessoa.getCpf());
//		pessoaDao.alterar(pessoa);
				
		
		
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
		System.out.println("-----Listagem Geral de Pessoas-------------------------------");
		System.out.println("CPF			 	NOME	SALDO	ENDERECO					 ");
		listaPessoa.forEach(c -> System.out.println(c.getCpf() +"\t" +c.getNome()+"\t" +c.getConta().getSaldo()+"\t" +c.getEndereco().getRua()));
		
		
		System.out.println("-------------------------------------------------------------");
		listaPessoa.forEach(c -> System.out.println(c.toString()));
	}

}
