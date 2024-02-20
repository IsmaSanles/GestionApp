package com.Proyect.PeluqueriaApp.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Ventas")
public class VentaEntity {
	
	@Id
	@Column(name="ventaId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ventaId;
	
	@Column(name="fechaVenta", nullable = false)
	private Date fechaVenta;
	
	@NotNull
	@Column(name="udsVendidas", nullable = false)
	private int udsVendidas;

	
// ------------------------------------------------------- RELACIONES --------------------------------------------------------------		
	/* cada Venta tendrá un solo Cliente */
	@ManyToOne
	@NotNull// utilizamos NotNull para valores numéricos
	@JsonIgnoreProperties({"ventas"}) // Evitar bucle infinito al serializar ClienteEntity
    @JoinColumn(name = "clienteId", nullable = false)
	private ClienteEntity clienteId;
	
	/* cada Venta tendrá un solo Producto */
	/*@ManyToOne
	@NotNull// utilizamos NotNull para valores numéricos
	@JsonIgnoreProperties({"ventas"}) // Evitar bucle infinito al serializar ProductoEntity
    @JoinColumn(name = "productoId", nullable = false)
	private ProductoEntity productoId;*/


	@ManyToMany
	@JsonIgnoreProperties({"listaVentas"}) // Evitar bucle infinito al serializar ProductoEntity
	@JoinTable(name = "venta_producto",
			joinColumns = @JoinColumn(name = "ventaId"),
			inverseJoinColumns = @JoinColumn(name = "productoId"))
	private List<ProductoEntity> listaProductos;

// ------------------------------------------------------- GETTERS/SETTERS --------------------------------------------------------------	
	public Long getVentaId() {
		return ventaId;
	}

	public void setVentaId(Long ventaId) {
		this.ventaId = ventaId;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getUdsVendidas() {
		return udsVendidas;
	}

	public void setUdsVendidas(int udsVendidas) {
		this.udsVendidas = udsVendidas;
	}

	public ClienteEntity getClienteId() {
		return clienteId;
	}

	public void setClienteId(ClienteEntity clienteId) {
		this.clienteId = clienteId;
	}

	public List<ProductoEntity> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoEntity> listaProductos) {
		this.listaProductos = listaProductos;
	}
}