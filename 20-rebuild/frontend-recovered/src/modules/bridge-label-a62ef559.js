import { bp as E } from "../shared/runtime.js";
const r = { ARTIFACT_TASK: "/s/s/a", ENCLOSURE_TASK: "/s/s/e", AUXILIARY_MATERIAL: "/s/s/m", BRIDGE_BOX_TASK: "/s/b/b", BRIDGE_SINGLE_ELEMENT_TASK: "/s/b/s", BRIDGE_AUXILIARY_MATERIAL: "/s/b/m" };
function t(A, _) {
  let s = E(A, _);
  if (s.length > 271) {
    const e = JSON.parse(JSON.stringify(_));
    delete e.mn, s = E(A, e);
  }
  return s;
}
export {
  r as Q,
  t as s
};
