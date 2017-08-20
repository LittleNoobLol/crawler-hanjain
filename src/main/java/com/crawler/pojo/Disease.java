package com.crawler.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Disease {

	@Id
	@GeneratedValue
	private Long dId;
	
	@Column(length=500)
	private String categoryid;
	@Column(length=500)
	private String code;
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="COMP_ID")
	private List<Diseases> diseases;
	@Column(length=500)
	private String dtotal;
	@Column(length=500)
	private String ecategory;
	@Column(length=500)
	private String edef;
	@Column(length=500)
	private String ename;
	@Column(length=500)
	private String error;
	@Column(length=500)
	private List<Genes> genes;
	@Column(length=500)
	private String gtotal;
	@Column(length=500)
	private String id;
	@Column(length=500)
	private String name;
	@ManyToOne
	private List<Parents> parents;
	//private Sons sons;
	@Column(length=500)
	private String xref;
	@Column(length=500)
	private String zhcategory;
	@Column(length=500)
	private String zhdef;

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDtotal() {
		return dtotal;
	}

	public void setDtotal(String dtotal) {
		this.dtotal = dtotal;
	}

	public String getEcategory() {
		return ecategory;
	}

	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	public String getEdef() {
		return edef;
	}

	public void setEdef(String edef) {
		this.edef = edef;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getdId() {
		return dId;
	}

	public void setdId(Long dId) {
		this.dId = dId;
	}

	public List<Genes> getGenes() {
		return genes;
	}

	public void setGenes(List<Genes> genes) {
		this.genes = genes;
	}

	public String getGtotal() {
		return gtotal;
	}

	public void setGtotal(String gtotal) {
		this.gtotal = gtotal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getXref() {
		return xref;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}

	public String getZhcategory() {
		return zhcategory;
	}

	public void setZhcategory(String zhcategory) {
		this.zhcategory = zhcategory;
	}

	public String getZhdef() {
		return zhdef;
	}

	public void setZhdef(String zhdef) {
		this.zhdef = zhdef;
	}

	public List<Diseases> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Diseases> diseases) {
		this.diseases = diseases;
	}


	public List<Parents> getParents() {
		return parents;
	}

	public void setParents(List<Parents> parents) {
		this.parents = parents;
	}

	@Override
	public String toString() {
		return "Disease [categoryid=" + categoryid + ", code=" + code + ", dtotal=" + dtotal + ", ecategory="
				+ ecategory + ", edef=" + edef + ", ename=" + ename + ", error=" + error + ", genes=" + genes
				+ ", gtotal=" + gtotal + ", id=" + id + ", name=" + name + ", xref=" + xref + ", zhcategory="
				+ zhcategory + ", zhdef=" + zhdef + "]";
	}

	

}
