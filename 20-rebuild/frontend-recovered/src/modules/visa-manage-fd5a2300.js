import { l as o } from "../shared/runtime.js";
function e(t) {
  return o({ module: "contract", url: "visa/foreign", method: "get", params: t });
}
function r(t) {
  return o({ module: "contract", url: "visa/foreign", method: "post", data: t });
}
function n(t) {
  return o({ module: "contract", url: "visa/foreign", method: "put", data: t });
}
function i(t) {
  return o({ module: "contract", url: `visa/project/${t}`, method: "get" });
}
function u(t) {
  return o({ module: "contract", url: "visa", method: "post", data: t });
}
function c(t) {
  return o({ module: "contract", url: `visa/${t}`, method: "post" });
}
function a(t) {
  return o({ module: "contract", url: `visa/${t}/export`, method: "get", responseType: "blob" });
}
const s = { get: e, add: r, edit: n, detail: c, check: u, download: a };
export {
  u as a,
  s as c,
  a as d,
  i as g
};
