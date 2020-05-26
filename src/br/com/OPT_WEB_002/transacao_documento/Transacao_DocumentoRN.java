package br.com.OPT_WEB_002.transacao_documento;

import java.math.BigInteger;
import java.util.*;

import br.com.OPT_WEB_002.campo_adicional.Campo_Adicional;
import br.com.OPT_WEB_002.campo_adicional.Campo_AdicionalRN;
import br.com.OPT_WEB_002.util.*;
import br.com.OPT_WEB_002.val_campos_trans_doc.*;

public class Transacao_DocumentoRN {

	private Transacao_DocumentoDAO transacaoDocumentoDAO;
	private BigInteger totalTransDoc;

	public Transacao_DocumentoRN() {
       
		this.transacaoDocumentoDAO = DAOFactory.criarTransacaoDocumentoDAO();		
	}

	public void salvar(Transacao_Documento transacao_documento) throws DAOException {
		
		Campo_AdicionalRN campo_AdicionalRN = new Campo_AdicionalRN();
		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
		Val_Campos_Trans_Doc val_Campos_Trans_Doc = new Val_Campos_Trans_Doc();
	
		 transacao_documento.setEstado("Nao Iniciado");
		 transacaoDocumentoDAO.salvar(transacao_documento);
	
		for(Campo_Adicional campo_adic : campo_AdicionalRN.listarPorIdTransCodEmCodFiCodUni(transacao_documento.getId_transacao().getId_transacao())) {
			
			val_Campos_Trans_Doc = new  Val_Campos_Trans_Doc();
			
			val_Campos_Trans_Doc.getId_trans_doc().setId_transacao_doc(transacao_documento.getId_transacao_doc());							
			val_Campos_Trans_Doc.getCod_empresa().setCod_empresa(campo_adic.getCod_empresa().getCod_empresa());
			val_Campos_Trans_Doc.getCod_filial().setCod_filial(campo_adic.getCod_filial().getCod_filial());
			val_Campos_Trans_Doc.getCod_unidade().setCod_unidade(campo_adic.getCod_unidade().getCod_unidade());
			val_Campos_Trans_Doc.getId_camp_adic().setId_camp_adic(campo_adic.getId_camp_adic());
					
			val_Campos_Trans_DocRN.salvar(val_Campos_Trans_Doc);	
		}
		
	}

	public void cadastrarTransacaoDocumentoWebService(Transacao_Documento transacao_documento) {
		
		  try{	  
			  
			  transacaoDocumentoDAO.cadastrarTransacaoDocumentoWebService(transacao_documento);
		  
		  }catch(Exception e){
			  
			  e.printStackTrace();
		  }
		  
		  
	}

	public void excluir(Transacao_Documento transacao_documento) throws DAOException {

		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
			
		for(Val_Campos_Trans_Doc val_Campos_Trans_Doc : val_Campos_Trans_DocRN.listarPorIdTransDoc(transacao_documento.getId_transacao_doc(),transacao_documento.getCod_empresa().getCod_empresa(),transacao_documento.getCod_filial().getCod_filial(),transacao_documento.getCod_unidade().getCod_unidade())){
			
			val_Campos_Trans_DocRN.excluir(val_Campos_Trans_Doc);
		}
		
		this.transacaoDocumentoDAO.excluir(transacao_documento);
	}

	public void alterar(Transacao_Documento transacao_documento) {
		
		System.out.println(transacao_documento.getEstado());
		this.transacaoDocumentoDAO.alterar(transacao_documento);
	}

	public List<Transacao_Documento> listar() {
		
		return transacaoDocumentoDAO.listar();
	}
	
	public List<Transacao_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {

		return this.transacaoDocumentoDAO.listarPorCodEmCodFiCodUni(cod_empresa,cod_filial,cod_unidade);
	}
	
	public Transacao_Documento carregar(BigInteger id_transacao){
		
		return this.transacaoDocumentoDAO.carregar(id_transacao);
	}

	public Transacao_Documento carregarPorIdTransDocCodEmpCodFiCodUni(BigInteger id_transacao_doc,Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
		
		return this.transacaoDocumentoDAO.carregarPorIdTransDocCodEmpCodFiCodUni(id_transacao_doc, cod_empresa, cod_filial, cod_unidade);
	}
	
	public List<Transacao_Documento> listarPorIdDoc(BigInteger id_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return this.transacaoDocumentoDAO.listarPorIdDoc(id_doc, cod_empresa, cod_filial, cod_unidade);
	}
	
	public List<Transacao_Documento> listarPorIdTrans(BigInteger id_transacao_doc){
		
		return transacaoDocumentoDAO.listarPorIdTrans(id_transacao_doc);
	}
			
	public Transacao_Documento listarUltimoId(){
		
		return this.transacaoDocumentoDAO.listarUltimoId();
	}
	
	public Transacao_Documento consultaWebService(BigInteger id_transacao_doc){
		
		return transacaoDocumentoDAO.consultaWebService(id_transacao_doc);
	}
	
	public Transacao_DocumentoDAO getTransacaoEtiquetaDAO() {
		return transacaoDocumentoDAO;
	}

	public void setTransacaoEtiquetaDAO(Transacao_DocumentoDAO transacaoEtiquetaDAO) {
		this.transacaoDocumentoDAO = transacaoEtiquetaDAO;
	}

	public Transacao_DocumentoDAO getTransacaoDocumentoDAO() {
		return transacaoDocumentoDAO;
	}

	public void setTransacaoDocumentoDAO(Transacao_DocumentoDAO transacaoDocumentoDAO) {
		this.transacaoDocumentoDAO = transacaoDocumentoDAO;
	}

	public BigInteger getTotalTransDoc() {
		return totalTransDoc;
	}

	public void setTotalTransDoc(BigInteger totalTransDoc) {
		this.totalTransDoc = totalTransDoc;
	}

}