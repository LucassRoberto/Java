package f_exerciseEntitiesContribution;

public class PessoaJuridica extends Contribuinte {
	
	private int numeroFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	@Override
	public double imposto() {
		if (getNumeroFuncionarios() <= 10) {
			return getRendaAnual() * 0.16; 
		}
		else {
			return getRendaAnual() * 0.14; 
		}
	}
	

}
