import { l as e } from "../shared/runtime.js";
function i(t) {
  return e({ url: "/api/template/assembly/config/list", method: "get", params: t });
}
function r(t) {
  return e({ url: "/api/template/assembly/config/update", method: "put", data: t });
}
const o = { get: i, edit: r };
export {
  o as c,
  i as g
};
