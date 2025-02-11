package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public  BigDecimal valorTotalVendido() {
		String jpql = "select sum(p.valorTotal) from Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

	public List<Object[]> relatorioDeVendas(){
		String jpql = "select produto.nome, "
				+ "sum(item.quantidade), "
				+ "max(pedido.data) "
				+ "from Pedido pedido "
				+ "inner join pedido.itens item "
				+ "inner join item.produto produto "
				+ "group by produto.nome "
				+ "order by item.quantidade desc";

		return em.createQuery(jpql, Object[].class).getResultList();

	}

	public List<RelatorioDeVendasVo> relatorioDeVendas2(){
		String jpql = "select new br.com.alura.loja.vo.RelatorioDeVendasVo("
				+ "produto.nome, "
				+ "sum(item.quantidade), "
				+ "max(pedido.data)) "
				+ "from Pedido pedido "
				+ "inner join pedido.itens item "
				+ "inner join item.produto produto "
				+ "group by produto.nome "
				+ "order by item.quantidade desc";

		return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();

	}

	public Pedido buscarPedidoComCliente(Long id) {
		return em.createQuery("select p from Pedido p join fetch p.cliente where p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}

}
