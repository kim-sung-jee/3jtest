package eternal.flame;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestIpfs {

    private final FileStore fileStore;
    private final FileUploadService fileUploadService;

    @Value("${file.dir}")
    private String fileDir;


    @PostMapping("upload")
    public String adding(ImageForm imageForm,Model model) throws IOException {


        FileDto fileDto = fileStore.storeFile(imageForm.getAttachFile());
        fileUploadService.save(fileDto);
        String src=fileDto.getStoreFileName();
        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
        System.out.println(src);
        ipfs.refs.local();
        NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(
                new File(fileDir+src)
        );
        MerkleNode addResult = ipfs.add(file).get(0);
        System.out.println(addResult.hash);
        System.out.println(addResult.size);
        model.addAttribute("hash","https://dweb.link/ipfs/"+addResult.hash);
//        ipfs.refs.local();
//        NamedStreamable.FileWrapper savefile = new NamedStreamable.FileWrapper(new File(
//                "hello.txt"
//        ));
//        MerkleNode result = ipfs.add(savefile).get(0);
//        System.out.println(result.toJSONString());// hash，  hash
//        System.out.println(result.hash);
        return "/listfiles";
    }



    @GetMapping("/files")
    public String lide(Model model){

        List<String> list=new ArrayList<>();


        File dir=new File(fileDir);
        String[] names=dir.list();

        for (String name:names){
            list.add(name);
        }
        model.addAttribute("filenames",list);

        return "listfiles";

    }

}
