import { a$ as R, b as y, rM as b, i as w } from "../shared/runtime.js";
import { cloneDeep as v } from "lodash";
import { ElMessage as k } from "element-plus";
function x({ rules: e = {}, ditto: a = /* @__PURE__ */ new Map(), errorMsg: t = "请修正表格中标红的信息" }) {
  return { tableValidate: (n) => M(n, e, a, t), wrongCellMask: (n) => E(n, e), cleanUpData: (n) => V(n, a) };
}
function M(e, a, t, n) {
  let f = true, l = "请填写数据";
  const s = v(e), u = [];
  if ((e == null ? void 0 : e.length) > 0) {
    let g = true;
    for (const d in e) {
      const i = e[d];
      delete i.verify;
      const r = v(i);
      if (delete r.uid, t.forEach((o, c) => {
        r[c] === o && delete r[c];
      }), R(r).every((o) => y(o))) {
        u.push(d);
        continue;
      }
      g && (t.forEach((o, c) => {
        i[c] === o && delete i[c];
      }), g = false);
      const p = $(a, i, d);
      i.verify = {};
      for (const o in p) {
        const c = h(o, p[o], i);
        i.verify[o] = c, c || (f = false);
      }
    }
    f || (l = n), u.length === s.length && (f = false);
  } else f = false;
  return f || k({ message: l, type: "error" }), { dealList: e, validResult: f };
}
function $(e, a, t) {
  let n = e;
  return typeof (e == null ? void 0 : e.value) < "u" && (n = e.value), typeof n == "function" ? n(a, t) || {} : n || {};
}
function E({ row: e, column: a }, t) {
  if (!e || !a) return "";
  const f = $(t, e)[a.property];
  if (!f) return "";
  const l = h(a.property, f, e);
  return e.verify && (e.verify[a.property] = l), l ? "" : "mask-td";
}
function h(e, a, t = {}) {
  const n = b(t, e);
  if (!(a != null && a.length)) return true;
  for (let f = 0; f < a.length; f++) {
    const { pattern: l, validator: s, required: u, type: g, min: d, max: i, message: r } = a[f];
    if (l && !l.test(n ?? "")) return console.warn(`校验失败 [${e}]: ${r}`), false;
    if (typeof s == "function" && !s(n, t)) return console.warn(`校验失败 [${e}]: ${r}`), false;
    if (u && y(n)) return console.warn(`校验失败 [${e}]: ${r}`), false;
    if (g && typeof n !== g) return console.warn(`校验失败 [${e}]: ${r}`), false;
    if (typeof n == "string") {
      if (d && n.length < d) return console.warn(`校验失败 [${e}]: ${r}`), false;
      if (i && n.length > i) return console.warn(`校验失败 [${e}]: ${r}`), false;
    }
  }
  return true;
}
function V(e, a = /* @__PURE__ */ new Map()) {
  return v(e).filter((t) => (a.forEach((n, f) => {
    t[f] === n && delete t[f];
  }), Object.values(t).some((n) => w(n)))).map((t, n, f) => (a.forEach((l, s) => {
    var u;
    t[s] = t[s] ?? ((u = f[n - 1]) == null ? void 0 : u[s]);
  }), delete t.uid, delete t.verify, t));
}
export {
  x as u
};
