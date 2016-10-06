package prova_3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSACOP2 {

	private static final String MATRICULA_REF = "123AB";
	private static final String TIPO_LABORATORIO = "Laboratorio";
	private static final String TIPO_MINILABORATORIO = "Minilaboratorio";
	private static final String ATIVIDADE_1 = "Classes";
	private static final String ATIVIDADE_2 = "Interfaces";
	private static final String ATIVIDADE_3 = "Heranca";
	private static final String ATIVIDADE_4 = "Strategy";
	private static final String ATIVIDADE_IMPORTADA = "Arquivos";
	SistemaAutomaticoDeCorrecaoOtimizadaPDoisIf sacoP2;

	@Before
	@Test
	public void setup() throws Exception {
		this.sacoP2 = new SistemaAutomaticoDeCorrecaoOtimizadaPDois();
		testePasso1();
		testePasso2();
		testePasso3();
		testePasso4();
		testePasso5();
		/*testePasso6();
		testePasso7();
		testExceptions();*/
	}

	public void testePasso1() throws Exception {
		this.sacoP2.cadastraAluno("Pedro Pedreiro", MATRICULA_REF, false);
		this.sacoP2.cadastraAluno("Maria Mariana", "124AB", true);
		this.sacoP2.cadastraAluno("Gustavo Gustaffson", "0123455", false);
		this.sacoP2.cadastraAluno("Roberto Roeu Rego", "007", true);
		this.sacoP2.cadastraAluno("Criatividade Crescendo", "XPTO", false);
		this.sacoP2.cadastraAluno("Yhoovhaanny Yhovanisson", "999", false);

		Assert.assertEquals("Pedro Pedreiro - 123AB", this.sacoP2.consultaAluno(MATRICULA_REF));
		Assert.assertEquals("Maria Mariana (R) - 124AB", this.sacoP2.consultaAluno("124AB"));
		Assert.assertEquals("Gustavo Gustaffson - 0123455", this.sacoP2.consultaAluno("0123455"));
		Assert.assertEquals("Roberto Roeu Rego (R) - 007", this.sacoP2.consultaAluno("007"));
		Assert.assertEquals("Criatividade Crescendo - XPTO", this.sacoP2.consultaAluno("XPTO"));
		Assert.assertEquals("Yhoovhaanny Yhovanisson - 999", this.sacoP2.consultaAluno("999"));
	}

	public void testePasso2() throws Exception {
		this.sacoP2.cadastraAtividade(ATIVIDADE_1, TIPO_MINILABORATORIO);
		Assert.assertEquals(TIPO_MINILABORATORIO, this.sacoP2.consultaAtividade(ATIVIDADE_1));
		this.sacoP2.cadastraAtividade(ATIVIDADE_2, TIPO_MINILABORATORIO);
		Assert.assertEquals(TIPO_MINILABORATORIO, this.sacoP2.consultaAtividade(ATIVIDADE_2));
		this.sacoP2.cadastraAtividade(ATIVIDADE_3, TIPO_LABORATORIO);
		Assert.assertEquals(TIPO_LABORATORIO, this.sacoP2.consultaAtividade(ATIVIDADE_3));
		this.sacoP2.cadastraAtividade(ATIVIDADE_4, TIPO_LABORATORIO);
	}
	
	public void testePasso3() throws Exception {
		this.sacoP2.adicionaAvaliacao(MATRICULA_REF, ATIVIDADE_1, 100,
				new String[] { "perfeito", "continue assim" });
		this.sacoP2.adicionaAvaliacao(MATRICULA_REF, ATIVIDADE_2, 91,
				new String[] { "show", "sucesso", "mto bom" });
		this.sacoP2.adicionaAvaliacao(MATRICULA_REF, ATIVIDADE_3, 78,
				new String[] { "pode melhorar", "quede javadoc", "o codigo tah com xeiro de aluno de p2" });
		this.sacoP2.adicionaAvaliacao(MATRICULA_REF, ATIVIDADE_4, 30, new String[] { "desastre" });
	}

	public void testePasso4() throws Exception {
		Assert.assertEquals("perfeito, continue assim", this.sacoP2.getComentarios(MATRICULA_REF, ATIVIDADE_1));
		Assert.assertEquals("show, sucesso", this.sacoP2.getComentarios(MATRICULA_REF, ATIVIDADE_2));
		Assert.assertEquals("pode melhorar, quede javadoc, o codigo tah com xeiro de aluno de p2",
				this.sacoP2.getComentarios(MATRICULA_REF, ATIVIDADE_3));
	}

	public void testePasso5() throws Exception {
		this.sacoP2.trocarTipoAtividade(ATIVIDADE_1, TIPO_MINILABORATORIO);
		this.sacoP2.trocarTipoAtividade(ATIVIDADE_2, TIPO_LABORATORIO);
		this.sacoP2.trocarTipoAtividade(ATIVIDADE_3, TIPO_MINILABORATORIO);
		Assert.assertEquals("perfeito, continue assim", this.sacoP2.getComentarios(MATRICULA_REF, ATIVIDADE_1));
		Assert.assertEquals("show, sucesso, mto bom", this.sacoP2.getComentarios(MATRICULA_REF, ATIVIDADE_2));
		Assert.assertEquals("pode melhorar, quede javadoc", this.sacoP2.getComentarios(MATRICULA_REF, ATIVIDADE_3));
	}

	public void testePasso6() throws Exception {
		Assert.assertEquals(10, this.sacoP2.getNotaFinal(MATRICULA_REF, ATIVIDADE_1));
		Assert.assertEquals(91, this.sacoP2.getNotaFinal(MATRICULA_REF, ATIVIDADE_2));
		Assert.assertEquals(7, this.sacoP2.getNotaFinal(MATRICULA_REF, ATIVIDADE_3));
		Assert.assertEquals(30, this.sacoP2.getNotaFinal(MATRICULA_REF, ATIVIDADE_4));
		// (91 + 30)/2 = 60 (10 + 7)/2 = 8. Final = 68
		Assert.assertEquals(68, this.sacoP2.getNotaFinal(MATRICULA_REF));
	}

	/*public void testePasso7() throws Exception {
		this.sacoP2.importaAtividades("atividade_especial.csv");
		Assert.assertEquals(68, this.sacoP2.getNotaFinal(MATRICULA_REF));
		Assert.assertEquals(30, this.sacoP2.getNotaFinal(MATRICULA_REF, ATIVIDADE_4));
		Assert.assertEquals("<importado>", this.sacoP2.getComentarios(MATRICULA_REF, ATIVIDADE_IMPORTADA));
	}

	public void testExceptions() {
		try {
			this.sacoP2.cadastraAluno("Pedro Pedrosa", MATRICULA_REF, false);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Matricula ja cadastrada.", e.getMessage());
		}

		try {
			this.sacoP2.consultaAluno("XXX");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Aluno nao cadastrado.", e.getMessage());
		}

		try {
			this.sacoP2.cadastraAtividade("   ", TIPO_MINILABORATORIO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome da atividade invalido.", e.getMessage());
		}

		try {
			this.sacoP2.cadastraAtividade("Exemplo", "");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Tipo de atividade invalido.", e.getMessage());
		}

		try {
			this.sacoP2.cadastraAtividade("Exemplo_1", "Teste");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Tipo de atividade invalido.", e.getMessage());
		}

		try {
			this.sacoP2.trocarTipoAtividade("Exemplo_1", TIPO_MINILABORATORIO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Atividade nao cadastrada.", e.getMessage());
		}

		try {
			this.sacoP2.trocarTipoAtividade(ATIVIDADE_1, "Teste");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Tipo de atividade invalido.", e.getMessage());
		}

		try {
			this.sacoP2.adicionaAvaliacao("XPTOs", ATIVIDADE_1, 50, new String[] { "sem comentarios" });
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Aluno nao cadastrado.", e.getMessage());
		}

		try {
			this.sacoP2.adicionaAvaliacao(MATRICULA_REF, ATIVIDADE_1, -1, new String[] { "sem comentarios" });
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nota invalida.", e.getMessage());
		}

		try {
			this.sacoP2.getNotaFinal("XPTOs", ATIVIDADE_1);
		} catch (Exception e) {
			Assert.assertEquals("Aluno nao cadastrado.", e.getMessage());
		}

		try {
			this.sacoP2.getNotaFinal(MATRICULA_REF, "Teste");
		} catch (Exception e) {
			Assert.assertEquals("Atividade nao cadastrada.", e.getMessage());
		}

	}*/
}