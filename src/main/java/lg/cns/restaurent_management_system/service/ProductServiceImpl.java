package lg.cns.restaurent_management_system.service;

import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;
import lg.cns.restaurent_management_system.mapper.Mapper;
import lg.cns.restaurent_management_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private S3Client s3Client;
    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<GetAllProductByCategoryDTO> getAllProductByCategory(String categoryName) {
        List<GetAllProductByCategoryDTO> productList = productRepository.findAllByCategoryCategoryName(categoryName).stream().map(product -> {
            GetAllProductByCategoryDTO productDTO = Mapper.mapEntityToDto(product, GetAllProductByCategoryDTO.class);
            return productDTO;
        }).collect(Collectors.toList());
        return productList;
    }

    @Override
    public String uploadProductImage(MultipartFile multipartFile) throws IOException {
        String fileName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
        s3Client.putObject(PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(multipartFile.getContentType())
                .build(), RequestBody.fromBytes(multipartFile.getBytes()));
        return "https://" + bucketName + ".s3.amazonaws.com/" + fileName;
    }
}
