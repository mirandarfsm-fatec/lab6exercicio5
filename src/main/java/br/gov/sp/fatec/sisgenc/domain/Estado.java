package br.gov.sp.fatec.sisgenc.domain;

public enum Estado {

	RECEBIDO("Recebido"),EM_ESTOQUE("Em Estoque"),ENTREGUE("Entregue");
	
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
