package com.practica.models.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="activos")
public class Activo implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idserial;
	
	private int depreciacionCompra;
	private String descripcion;
	private String equipo_name;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_compra")
	private Date fecha_compra;
	private double valor_compra;
	
	public Long getIdserial() {
		return idserial;
	}
	public void setIdserial(Long idserial) {
		this.idserial = idserial;
	}
	public int getDepreciacionCompra() {
		return depreciacionCompra;
	}
	public void setDepreciacionCompra(int depreciacionCompra) {
		this.depreciacionCompra = depreciacionCompra;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEquipo_name() {
		return equipo_name;
	}
	public void setEquipo_name(String equipo_name) {
		this.equipo_name = equipo_name;
	}
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public double getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Activo [idserial=" + idserial + ", depreciacionCompra=" + depreciacionCompra + ", descripcion="
				+ descripcion + ", equipo_name=" + equipo_name + ", fecha_compra=" + fecha_compra + ", valor_compra="
				+ valor_compra + "]";
	}
	
	
	
}
