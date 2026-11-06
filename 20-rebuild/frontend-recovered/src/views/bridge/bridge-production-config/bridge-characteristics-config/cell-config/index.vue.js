import { ref as S } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as m } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as s } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as l } from "vue";
import { Fragment as B } from "vue";
import { renderList as P } from "vue";
import { toDisplayString as D } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as E } from "element-plus";
import { l as i, _ as H, x as N, ar as u, o as O, G as V, an as $, P as A } from "../../../../../shared/runtime.js";
import F from "./module/header.vue.js";
import I from "./module/form.vue.js";
function M(t) {
  return i({ module: "contract", url: "bridge/element-class", method: "get", params: t });
}
function T(t) {
  return i({ module: "contract", url: "bridge/element-class", method: "post", data: t });
}
function U(t) {
  return i({ module: "contract", url: "bridge/element-class", method: "put", data: t });
}
function q(t) {
  return i({ module: "contract", url: `bridge/element-class/delById/${t}`, method: "delete" });
}
const G = { get: M, add: T, edit: U, del: q };
const K = { class: "app-container" }, j = { class: "head-container" }, z = { __name: "index", setup(t) {
  const g = { add: true, edit: false, del: false, download: false }, _ = S(), { CRUD: b, crud: c, columns: d } = N({ title: "单元特征定义", sort: [], permission: { ...u }, optShow: { ...g }, crudApi: { ...G }, hasPagination: true }, _), { maxHeight: w } = O({ wrapperBox: ".cellConfig", paginate: true, extraHeight: 40 });
  return b.HOOK.handleRefresh = (x, { data: f }) => {
    f.content.forEach((a) => {
      a.list = a.elementSpecList;
    });
  }, (x, f) => {
    const a = R, y = k("common-table"), v = E;
    return o(), m("div", K, [C("div", j, [r(e(F))]), L((o(), s(y, { ref_key: "tableRef", ref: _, class: "upload-table", data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(w), "return-source-data": "", showEmptySymbol: false, stripe: false, style: { width: "100%" } }, { default: p(() => [r(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(d).visible("name") ? (o(), s(a, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "名称", "min-width": "150" })) : l("", true), e(d).visible("elementSpecList") ? (o(), s(a, { key: "elementSpecList", prop: "elementSpecList", label: "规格前缀", "show-overflow-tooltip": true, align: "center", "min-width": "260" }, { default: p((n) => [n.row.elementSpecList && n.row.elementSpecList.length > 0 ? (o(true), m(B, { key: 0 }, P(n.row.elementSpecList, (h) => (o(), m("span", { key: h.id }, D(`【${h.specPrefix}】`), 1))), 128)) : l("", true)]), _: 1 })) : l("", true), e(d).visible("sort") ? (o(), s(a, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", width: "80", align: "center" })) : l("", true), e(V)([...e(u).del, ...e(u).edit]) ? (o(), s(a, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: p((n) => [r(e($), { data: n.row }, null, 8, ["data"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, e(c).loading]]), r(e(A)), r(e(I))]);
  };
} }, Y = H(z, [["__scopeId", "data-v-257e4fb2"]]);
export {
  Y as default
};
