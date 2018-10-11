package br.com.cielo.stb.entity;

public class PendenciasBandeira {

	private Integer codigoBandeira;
	private String indicadorApresentacaoBandeira = "";
	private Integer pendenciasBandeira = 0;
	private Integer pendenciasAccount = 0;
	private String nomeBandeira;

	public String getNomeBandeira() {
		return nomeBandeira;
	}

	public void setNomeBandeira(String nomeBandeira) {
		this.nomeBandeira = nomeBandeira;
	}

	public Integer getCodigoBandeira() {
		return codigoBandeira;
	}

	public void setCodigoBandeira(Integer codigoBandeira) {
		this.codigoBandeira = codigoBandeira;
	}

	public String getIndicadorApresentacaoBandeira() {
		return indicadorApresentacaoBandeira;
	}

	public void setIndicadorApresentacaoBandeira(String indicadorApresentacaoBandeira) {
		this.indicadorApresentacaoBandeira = indicadorApresentacaoBandeira;
	}

	public Integer getPendenciasBandeira() {
		return pendenciasBandeira;
	}

	public void setPendenciasBandeira(Integer pendenciasBandeira) {
		this.pendenciasBandeira = pendenciasBandeira;
	}

	public Integer getPendenciasAccount() {
		return pendenciasAccount;
	}

	public void setPendenciasAccount(Integer pendenciasAccount) {
		this.pendenciasAccount = pendenciasAccount;
	}

	public boolean isAgrupado() {

		return indicadorApresentacaoBandeira.equals("N") ? true : false;
	}

	public boolean hasNoPendencia() {

		return (pendenciasBandeira + pendenciasAccount) == 0 ? true : false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PendenciasBandeira [codigoBandeira=")
				.append(codigoBandeira)
				.append(", indicadorApresentacaoBandeira=")
				.append(indicadorApresentacaoBandeira)
				.append(", pendenciasBandeira=")
				.append(pendenciasBandeira)
				.append(", pendenciasAccount=")
				.append(pendenciasAccount)
				.append("]");
		return builder.toString();
	}

}
