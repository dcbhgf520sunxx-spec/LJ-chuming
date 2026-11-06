import { ref as N } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as d, x as R, b0 as h, o as W, G as H, an as O } from "../../../../../shared/runtime.js";
import P from "./module/header.vue.js";
import T from "./module/form.vue.js";
function V(t) {
  return d({ module: "bridge", url: "rivetWeld/box/type", method: "get", params: t });
}
function $(t) {
  return d({ module: "bridge", url: "rivetWeld/box/type", method: "post", data: t });
}
function A(t) {
  return d({ module: "bridge", url: "rivetWeld/box/type", method: "put", data: t });
}
function E(t) {
  return d({ module: "bridge", url: "rivetWeld/box/type", method: "delete", data: t });
}
const M = { get: V, add: $, del: E, edit: A }, U = { class: "app-container" }, j = { class: "head-container" }, z = { __name: "index", setup(t) {
  const g = { add: true, edit: false, del: false, download: false }, _ = N(), { crud: c, columns: y, CRUD: x } = R({ title: "分段种类配置", sort: [], permission: { ...h }, optShow: { ...g }, crudApi: { ...M }, hasPagination: false }, _), { maxHeight: v } = W();
  return x.HOOK.handleRefresh = (w, m) => {
    m.data.content = m.data.content.map((a) => {
      var r;
      return a.inventoryNamesStr = (r = a.inventoryNames) == null ? void 0 : r.map((p) => `【${p}】`).join(""), a;
    });
  }, (w, m) => {
    const a = B, r = k("common-table"), p = D;
    return n(), C("div", U, [u("div", j, [i(e(P))]), S((n(), l(r, { ref_key: "tableRef", ref: _, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(v), style: { width: "100%" } }, { default: s(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), e(y).visible("typeName") ? (n(), l(a, { key: 0, prop: "typeName", "show-overflow-tooltip": true, label: "种类", align: "center", width: "150px" }, { default: s(({ row: o }) => [u("span", null, b(o.typeName), 1)]), _: 1 })) : f("", true), e(y).visible("inventoryNamesStr") ? (n(), l(a, { key: 1, prop: "inventoryNamesStr", "show-overflow-tooltip": true, label: "包含分段编号", "min-width": "200px" }, { default: s(({ row: o }) => [u("span", null, b(o.inventoryNamesStr), 1)]), _: 1 })) : f("", true), e(H)([...e(h).edit, ...e(h).del]) ? (n(), l(a, { key: 2, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: s((o) => [i(e(O), { data: o.row }, null, 8, ["data"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[p, e(c).loading]]), i(e(T))]);
  };
} };
export {
  z as default
};
