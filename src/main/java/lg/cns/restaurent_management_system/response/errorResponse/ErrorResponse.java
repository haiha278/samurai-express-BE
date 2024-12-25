package lg.cns.restaurent_management_system.response.errorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime localDateTime;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
