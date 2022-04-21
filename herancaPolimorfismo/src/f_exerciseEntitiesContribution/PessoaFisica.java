package f_exerciseEntitiesContribution;

public class PessoaFisica extends Contribuinte{
	
	private double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double imposto() {
		if (getRendaAnual() < 20000.00) {
			return getRendaAnual() * 0.15 - getGastosSaude() * 0.5; 
		}
		else {
			return getRendaAnual() * 0.25 - getGastosSaude() * 0.5; 
		}
	}

}
