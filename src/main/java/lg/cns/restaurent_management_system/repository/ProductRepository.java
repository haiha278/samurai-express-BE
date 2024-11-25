package lg.cns.restaurent_management_system.repository;

import lg.cns.restaurent_management_system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategoryCategoryName(String categoryName);
}
