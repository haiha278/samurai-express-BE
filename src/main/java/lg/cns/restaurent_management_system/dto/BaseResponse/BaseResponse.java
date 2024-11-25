package lg.cns.restaurent_management_system.dto.BaseResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BaseResponse<T> {
    private String message;
    private int code;
    private T data;

    public BaseResponse(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
