package keepingMemory.interfaces;

import keepingMemory.domain.Mypage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MypageController {

    @PostMapping("/upload")
    public void saveImg(@RequestPart List<MultipartFile> multipartFiles){

    }

    @GetMapping("/getMypage")
    public List<Mypage> getFiles(@RequestBody Long id){
        return null;
    }
}
