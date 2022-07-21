import  {NFTStorage,File } from "nft.storage";

import fs from "fs";

const apiKey="bafkreihe3pi22hkxzos7oguobupvdbe47se2of53lsqcrtjcl6nuia2yn4"

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