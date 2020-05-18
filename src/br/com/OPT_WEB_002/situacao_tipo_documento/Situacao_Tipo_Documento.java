package br.com.OPT_WEB_002.situacao_tipo_documento;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.tipo_documento.Tipo_Documento;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;

@Entity(name = "situacao_tipo_documento")
public class Situacao_Tipo_Documento implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	private String cod_campo;

	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;

	@ManyToOne
	@JoinColumn(name = "cod_filial")
	private Filial cod_filial;

	@ManyToOne
	@JoinColumn(name = "cod_unidade")
	private Unidade_Negocio cod_unidade;

	@ManyToOne
	@JoinColumn(name = "id_tipo_doc")
	private Tipo_Documento id_tipo_doc;

	private String cor_situacao;


	public Situacao_Tipo_Documento() {

		
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		Tipo_Documento tipo_Documento = new Tipo_Documento();

		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		this.id_tipo_doc = tipo_Documento;

	}

	public String getCod_campo() {
		return cod_campo;
	}

	public void setCod_campo(String cod_campo) {
		this.cod_campo = cod_campo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Empresa getCod_empresa() {
		return cod_empresa;
	}

	public void setCod_empresa(Empresa cod_empresa) {
		this.cod_empresa = cod_empresa;
	}

	public Filial getCod_filial() {
		return cod_filial;
	}

	public void setCod_filial(Filial cod_filial) {
		this.cod_filial = cod_filial;
	}

	public Unidade_Negocio getCod_unidade() {
		return cod_unidade;
	}

	public void setCod_unidade(Unidade_Negocio cod_unidade) {
		this.cod_unidade = cod_unidade;
	}

	public Tipo_Documento getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(Tipo_Documento id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}
	public String getCor_situacao() {
		return cor_situacao;
	}

	public void setCor_situacao(String cor_situacao) {
		this.cor_situacao = cor_situacao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_campo == null) ? 0 : cod_campo.hashCode());
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((cor_situacao == null) ? 0 : cor_situacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id_tipo_doc == null) ? 0 : id_tipo_doc.hashCode());		
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
		Situacao_Tipo_Documento other = (Situacao_Tipo_Documento) obj;
		if (cod_campo == null) {
			if (other.cod_campo != null)
				return false;
		} else if (!cod_campo.equals(other.cod_campo))
			return false;
		if (cod_empresa == null) {
			if (other.cod_empresa != null)
				return false;
		} else if (!cod_empresa.equals(other.cod_empresa))
			return false;
		if (cod_filial == null) {
			if (other.cod_filial != null)
				return false;
		} else if (!cod_filial.equals(other.cod_filial))
			return false;
		if (cod_unidade == null) {
			if (other.cod_unidade != null)
				return false;
		} else if (!cod_unidade.equals(other.cod_unidade))
			return false;
		if (cor_situacao == null) {
			if (other.cor_situacao != null)
				return false;
		} else if (!cor_situacao.equals(other.cor_situacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_tipo_doc == null) {
			if (other.id_tipo_doc != null)
				return false;
		} else if (!id_tipo_doc.equals(other.id_tipo_doc))
			return false;
		
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
