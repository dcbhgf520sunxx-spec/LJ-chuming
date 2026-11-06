import { ref as N } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as s } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as R } from "element-plus";
import { l as d, x as B, pe as h, o as W, G as A, an as H } from "../../../../../shared/runtime.js";
import O from "./module/header.vue.js";
import P from "./module/form.vue.js";
function T(t) {
  return d({ module: "mes", url: "rivetWeld/artifact/type", method: "get", params: t });
}
function V(t) {
  return d({ module: "mes", url: "rivetWeld/artifact/type", method: "post", data: t });
}
function $(t) {
  return d({ module: "mes", url: "rivetWeld/artifact/type", method: "put", data: t });
}
function E(t) {
  return d({ module: "mes", url: "rivetWeld/artifact/type", method: "delete", data: t });
}
const M = { get: T, add: V, del: E, edit: $ }, U = { class: "app-container" }, j = { class: "head-container" }, z = { __name: "index", setup(t) {
  const v = { add: true, edit: false, del: false, download: false }, _ = N(), { crud: c, columns: y, CRUD: x } = B({ title: "构件种类配置", sort: [], permission: { ...h }, optShow: { ...v }, crudApi: { ...M }, hasPagination: false }, _), { maxHeight: w } = W();
  return x.HOOK.handleRefresh = (b, m) => {
    m.data.content = m.data.content.map((a) => {
      var r;
      return a.inventoryNamesStr = (r = a.inventoryNames) == null ? void 0 : r.map((p) => `【${p}】`).join(""), a;
    });
  }, (b, m) => {
    const a = D, r = k("common-table"), p = R;
    return n(), C("div", U, [u("div", j, [i(e(O))]), S((n(), s(r, { ref_key: "tableRef", ref: _, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(w), style: { width: "100%" } }, { default: l(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), e(y).visible("typeName") ? (n(), s(a, { key: 0, prop: "typeName", "show-overflow-tooltip": true, label: "种类", align: "center", width: "150px" }, { default: l(({ row: o }) => [u("span", null, g(o.typeName), 1)]), _: 1 })) : f("", true), e(y).visible("inventoryNamesStr") ? (n(), s(a, { key: 1, prop: "inventoryNamesStr", "show-overflow-tooltip": true, label: "包含构件编号", "min-width": "200px" }, { default: l(({ row: o }) => [u("span", null, g(o.inventoryNamesStr), 1)]), _: 1 })) : f("", true), e(A)([...e(h).edit, ...e(h).del]) ? (n(), s(a, { key: 2, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: l((o) => [i(e(H), { data: o.row }, null, 8, ["data"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[p, e(c).loading]]), i(e(P))]);
  };
} };
export {
  z as default
};
