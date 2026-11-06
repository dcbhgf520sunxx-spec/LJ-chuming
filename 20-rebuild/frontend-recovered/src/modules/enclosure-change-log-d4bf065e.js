import { l as c } from "../shared/runtime.js";
function n(e) {
  return c({ url: "/api/plan/enclosure-change", method: "get", params: e });
}
function t(e) {
  return c({ url: "/api/plan/enclosure-change/check", method: "post", data: e });
}
const o = { get: n };
export {
  t as a,
  o as c
};
