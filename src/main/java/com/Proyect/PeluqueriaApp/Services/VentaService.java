package com.Proyect.PeluqueriaApp.Services;

import com.Proyect.PeluqueriaApp.Entities.VentaEntity;
import com.Proyect.PeluqueriaApp.Repositories.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

	@Autowired
	private IVentaRepository ventaRepository;
	
	// Listar Todos
	public List<VentaEntity> listarVentas(){
		return (List<VentaEntity>) ventaRepository.findAll();
	}
	
	// recuperar una Venta por Id
	public Optional<VentaEntity> VentaById(Long Id){
		return ventaRepository.findById(Id);
	}
	
	// Crear Venta
	public VentaEntity crearVenta(VentaEntity venta) {
		return ventaRepository.save(venta);
	}
	
	// Modificar Venta
	public VentaEntity modificarVenta(VentaEntity venta) {
		return ventaRepository.save(venta);
	}
		
	/*
	// Eliminar Venta
	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);
	}
	*/
	
	// Eliminar/Ocultar Venta
	//public void eliminarOcultarVentaById(Long id) {
	//	ventaRepository.eliminarOcultarVentaById(id);
	//}

	// Obtener todas las ventas con detalles
	public List<VentaEntity> getAllVentasConDetalles() {
		return ventaRepository.getAllVentasConDetalles();
	}

	/*
	public List<VentaEntity> getVentaConProductosPorCliente(Long clienteId,Long ventaId) {
		return (List<VentaEntity>) (List<VentaEntity>) ventaRepository.getVentaConProductosPorCliente(clienteId, ventaId);
	}
	*/
}