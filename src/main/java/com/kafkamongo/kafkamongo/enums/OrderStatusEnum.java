package com.kafkamongo.kafkamongo.enums;

public enum OrderStatusEnum {
	AGUARDANDO_ENVIO("AGUARDANDO_ENVIO"),
	ENVIADO_TRANSPORTADORA("ENVIADO_TRANSPORTADORA");
	
	private String status;

	OrderStatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}	
}
