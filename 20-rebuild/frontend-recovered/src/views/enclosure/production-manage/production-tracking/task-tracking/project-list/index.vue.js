import { ref as s } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as B } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as M } from "vue";
import { ElTableColumn as O } from "element-plus";
import { ElTag as A } from "element-plus";
import { vLoading as H } from "element-plus";
import { l as i, mD as g, x as P, o as V } from "../../../../../../shared/runtime.js";
import { d as z } from "../../../../../../modules/enclosure-365a2177.js";
import K from "./module/header.vue.js";
function L(e) {
  return i({ module: "enclosure", url: "produce/project", method: "get", params: e });
}
function N(e) {
  return i({ module: "enclosure", url: "produce/order/list", method: "get", params: e });
}
function U(e) {
  return i({ module: "enclosure", url: "produce/order/detail", method: "get", params: { id: e } });
}
const Q = { get: N, detail: U }, q = { class: "app-container" }, F = { __name: "index", emits: ["project-change"], setup(e, { emit: f }) {
  const x = f, j = { add: false, edit: false, del: false, download: false }, d = s(), u = s({}), b = s([["project", "parse-project"], ["status", ["parse-enum", g]]]), { crud: n, CRUD: y } = P({ title: "任务跟踪-项目列表", sort: [], permission: { ...z }, optShow: { ...j }, crudApi: { get: L }, hasPagination: false }, d), { maxHeight: v } = V({ extraBox: ".project-head-container" });
  function C(a) {
    u.value = (a == null ? void 0 : a.project) || {}, x("project-change", u.value);
  }
  return y.HOOK.handleRefresh = async (a, { data: r }) => {
    r.content = r;
  }, (a, r) => {
    const c = O, k = A, T = S("common-table"), R = H;
    return h(), w("div", q, [o(t(K), { class: "head-container project-head-container" }), D((h(), B(T, { ref_key: "tableRef", ref: d, "data-format": b.value, data: t(n).data, "highlight-current-row": "", "empty-text": t(n).emptyText, "max-height": t(v), onCurrentChange: C }, { default: l(() => [o(c, { label: "序号", type: "index", align: "center", width: "55" }), o(c, { key: "project", prop: "project", label: "项目列表", "min-width": "100", align: "center" }), o(c, { key: "status", prop: "status", label: "状态", width: "92", align: "center" }, { default: l(({ row: p }) => {
      var m, _;
      return [o(k, { size: "large", type: (_ = (m = t(g).V) == null ? void 0 : m[p.sourceRow.status]) == null ? void 0 : _.TAG }, { default: l(() => [E(M(p.status), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })]), _: 1 }, 8, ["data-format", "data", "empty-text", "max-height"])), [[R, t(n).loading]])]);
  };
} }, W = Object.freeze(Object.defineProperty({ __proto__: null, default: F }, Symbol.toStringTag, { value: "Module" }));
export {
  F as _,
  Q as c,
  W as i
};
