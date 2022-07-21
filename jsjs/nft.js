import  {NFTStorage,File } from "nft.storage";

import fs from "fs";

const apiKey="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJkaWQ6ZXRocjoweDA1Qzg1ZTQzMTBjNTVGOWU0YWNiQmIwNjA3N0RBOWI1NTdBNjI3NzMiLCJpc3MiOiJuZnQtc3RvcmFnZSIsImlhdCI6MTY1ODM4NTg3MDM4MiwibmFtZSI6InN1bmdqZXNzdGVzdCJ9.g9ii71qV0n9BoStzPW9DGX_ml7tbtA0U69rbyBA6Tl4"

const client = new NFTStorage({token:apiKey});

const metadata = await client.store({
    name: "myFirst",
    description :"myFirst is so cute",
    image : new File([fs.readFileSync("./myFirst.png")],"myFirst",
    {type: "image/png"}),
    attributes:[
        {
            trait_type : "skin",
            value: "blue",
        },
        {
            trait_type : "face",
            value: "smile",
        },
    ] ,
});
console.log(metadata.url);