import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ module: "contract", url: "visa/foreign", method: "get", params: t });
}
function r(t) {
  return e({ module: "contract", url: "visa/project/handle", method: "post", data: t });
}
function n(t) {
  return e({ module: "contract", url: "visa/project/handle", method: "put", data: t });
}
function l(t) {
  return e({ module: "contract", url: `visa/project/${t}`, method: "get" });
}
function c(t) {
  return e({ module: "contract", url: "visa", method: "post", data: t });
}
function u(t) {
  return e({ module: "contract", url: `visa/${t}`, method: "post" });
}
function a(t) {
  return e({ module: "contract", url: `visa/${t}/settlement/export`, method: "get", responseType: "blob" });
}
const i = { get: o, add: r, edit: n, detail: u, check: c, download: a };
export {
  c as a,
  i as c,
  a as d,
  l as g
};
