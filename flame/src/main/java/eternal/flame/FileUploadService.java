package eternal.flame;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FileUploadService {
    private final FileRepository fileRepository;

    @Transactional
    public String save(FileDto fileDto){
        return fileRepository.save(fileDto.toEntity()).getAllFileName();
    }
}

