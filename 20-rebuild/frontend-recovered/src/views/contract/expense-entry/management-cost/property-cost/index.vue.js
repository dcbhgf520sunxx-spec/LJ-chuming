import { ref as k } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as R } from "vue";
import { unref as e } from "vue";
import { createBlock as p } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as g } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as q } from "element-plus";
import { l, t as P, x as T, o as V, bV as H, an as N, ba as O } from "../../../../../shared/runtime.js";
import { r as x } from "../../../../../modules/contract-9b18cc88.js";
import E from "./module/header.vue.js";
import M from "./module/form.vue.js";
function U(t) {
  return l({ module: "", url: "/api/contract/property-fee", method: "get", params: t });
}
function $(t) {
  return l({ module: "", url: "/api/contract/property-fee", method: "post", data: [t] });
}
function F(t) {
  return l({ module: "", url: "/api/contract/property-fee", method: "post", data: [t] });
}
function K(t) {
  return l({ module: "", url: "/api/contract/property-fee", method: "delete", data: t });
}
const L = { get: U, add: $, edit: F, del: K }, j = { class: "app-container" }, z = { class: "head-container" }, X = { __name: "index", setup(t) {
  const f = k(), { decimalPrecision: h } = P(), b = { add: true, edit: false, del: false, download: false }, { crud: n, CRUD: w, columns: _ } = T({ title: "物业费", sort: [], optShow: { ...b }, permission: { ...x }, crudApi: { ...L }, hasPagination: false }, f);
  function v(c) {
    return O(c, { props: [["feeAmount", h.value.contract]], toThousandFields: ["feeAmount"] });
  }
  w.HOOK.handleRefresh = (c, m) => {
    var a;
    m.data.content = (a = m.data.content) == null ? void 0 : a.map((d) => d);
  };
  const { maxHeight: A } = V({ extraBox: [".head-container"], paginate: true });
  return (c, m) => {
    const a = S, d = D("common-table"), C = q;
    return r(), B("div", j, [u("div", z, [s(E)]), R((r(), p(d, { ref_key: "tableRef", ref: f, data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(A), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": v }, { default: i(() => [e(_).visible("month") ? (r(), p(a, { key: 0, prop: "month", label: "月份", align: "center", width: "140px" }, { default: i(({ row: o }) => [u("span", null, y(o.month) + "月", 1)]), _: 1 })) : g("", true), e(_).visible("feeAmount") ? (r(), p(a, { align: "center", key: "feeAmount", prop: "feeAmount", "show-overflow-tooltip": true, label: "费用" }, { default: i(({ row: o }) => [u("span", null, y(e(H)(o.feeAmount, e(h).contract)), 1)]), _: 1 })) : g("", true), s(a, { align: "center", label: "操作", width: "300px" }, { default: i((o) => [s(e(N), { data: o.row }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[C, e(n).loading]]), s(M, { query: e(n).query, permission: e(x) }, null, 8, ["query", "permission"])]);
  };
} };
export {
  X as default
};
