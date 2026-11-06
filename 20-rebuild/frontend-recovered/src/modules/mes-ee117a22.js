import { a3 as _, kA as e } from "../shared/runtime.js";
const t = [["length", ["to-fixed-ck", "MES_ARTIFACT_L__MM"]], ["netWeight", ["to-fixed-ck", "COM_WT__KG"]], ["grossWeight", ["to-fixed-ck", "COM_WT__KG"]], ["totalNetWeight", ["to-fixed-ck", "COM_WT__KG"]], ["totalGrossWeight", ["to-fixed-ck", "COM_WT__KG"]], ["surfaceArea", ["to-fixed-ck", "COM_AREA__M2"]]], o = [["width", ["to-fixed-ck", "MES_ENCLOSURE_W__MM"]], ["thickness", ["to-fixed-ck", "MES_ENCLOSURE_T__MM"]], ["length", ["to-fixed-ck", "MES_ENCLOSURE_L__MM"]], ["totalArea", ["to-fixed-ck", "COM_AREA__M2"]], ["totalLength", ["to-fixed-ck", "MES_ENCLOSURE_L__M"]], ["weight", ["to-fixed-ck", "COM_WT__KG"]]], E = { [_.MACHINE_PART.V]: t, [_.ASSEMBLE.V]: t, [_.ARTIFACT.V]: t, [_.ENCLOSURE.V]: o }, c = [["category", ["parse-enum", e]]];
export {
  c as e,
  E as p
};
