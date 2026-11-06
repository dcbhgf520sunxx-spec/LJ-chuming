import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ module: "plan", url: `planDetail/list/${t.projectId}`, method: "get", params: t });
}
function o(t, l) {
  return e({ module: "plan", url: `planDetail/updateList/${t}`, method: "put", data: l });
}
const u = { edit: o, get: n };
export {
  u as c
};
