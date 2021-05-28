package br.com.fiap.tds.exercicio.entity;

import java.io.Serializable;
import java.util.Calendar;

public class AgendamentoPK implements Serializable {
	
	private int servico;
	
	private int animal;
	
	private Calendar data;

	public AgendamentoPK() {}
	
	public AgendamentoPK(int servico, int animal, Calendar data) {
		this.servico = servico;
		this.animal = animal;
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + animal;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + servico;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendamentoPK other = (AgendamentoPK) obj;
		if (animal != other.animal)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (servico != other.servico)
			return false;
		return true;
	}

	public int getServico() {
		return servico;
	}

	public void setServico(int servico) {
		this.servico = servico;
	}

	public int getAnimal() {
		return animal;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
}
