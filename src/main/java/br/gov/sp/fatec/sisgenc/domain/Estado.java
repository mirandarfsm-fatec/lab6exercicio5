package br.gov.sp.fatec.sisgenc.domain;

public enum Estado {

	EM_ESTOQUE("Em Estoque"), ENCAMINHADA("Encaminhada"), RECEBIDA("Recebida"), FINALIZADA(
			"Finalizada"), CANCELADA("Cancelada");

	private String label;

	private Estado(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
