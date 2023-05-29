package com.softtek.java_jpa_23052023.controlador;

import com.softtek.java_jpa_23052023.controlador.servicio.ProductServiceImpl;
import com.softtek.java_jpa_23052023.dto.AverageCategoryDTO;
import com.softtek.java_jpa_23052023.dto.AverageSupplierDTO;
import com.softtek.java_jpa_23052023.dto.ProductDTO;
import com.softtek.java_jpa_23052023.dto.UnitsSupplierDTO;
import com.softtek.java_jpa_23052023.modelo.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping("/")
public class ServiceController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ModelMapper mapper;


    @GetMapping("/getAllProds")
    public ResponseEntity<List<ProductDTO>> getAllProds() throws Exception {
        List<Product> prods = productService.listar();
        List<ProductDTO> prodsDTO = prods.stream().map(x -> mapper.map(x, ProductDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(prodsDTO, HttpStatus.OK);
    }

//    Obtener el precio promedio por proveedor de la tabla de productos
    @GetMapping("/getAvgSupplier")
    public ResponseEntity<List<AverageSupplierDTO>> getAvgSupplier() throws Exception {
        List<Product> prods = productService.listar();
        Map<Short,Double> avgSupplier = prods.stream().collect(Collectors.groupingBy(Product::getSupplierId,Collectors.averagingDouble(Product::getUnitPrice)));
        List<AverageSupplierDTO> avgDTO = new ArrayList<>();
        avgSupplier.forEach((id,avg) -> avgDTO.add(new AverageSupplierDTO(id,avg)));
        return new ResponseEntity<>(avgDTO,HttpStatus.OK);
    }

//    Obtener la suma de inventario (UnitsInStock) por SupplierID De la tabla de productos (Products)
    @GetMapping("/getUnitsSupplier")
    public ResponseEntity<List<UnitsSupplierDTO>> getSumSupplier() throws Exception {
        List<Product> prods = productService.listar();
        Map<Short,Integer> sumSupplier = prods.stream().collect(Collectors.groupingBy(Product::getSupplierId, Collectors.summingInt(Product::getUnitsInStock)));
        List<UnitsSupplierDTO> unitsDTO = new ArrayList<>();
        sumSupplier.forEach((id,sum) -> unitsDTO.add(new UnitsSupplierDTO(id,sum)));
        return new ResponseEntity<>(unitsDTO,HttpStatus.OK);
    }

//    Obtener el precio promedio de los productos por categoria sin contar con los productos descontinuados (Discontinued)
    @GetMapping("/getAvgCategory")
    public ResponseEntity<List<AverageCategoryDTO>> getAvgCategory() throws Exception {
        List<Product> prods = productService.listar();
        Map<Short,Double> avgCategory = prods.stream().filter(p -> p.getDiscontinued() == 0).collect(Collectors.groupingBy(Product::getCategoryId,Collectors.averagingDouble(Product::getUnitPrice)));
        List<AverageCategoryDTO> categoryDTO = new ArrayList<>();
        avgCategory.forEach((id,avg) -> categoryDTO.add(new AverageCategoryDTO(id,avg)));
        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }
}
