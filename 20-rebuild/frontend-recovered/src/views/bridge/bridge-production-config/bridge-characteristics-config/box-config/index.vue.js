import { ref as S } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as n } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as B } from "vue";
import { renderList as P } from "vue";
import { toDisplayString as D } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as E } from "element-plus";
import { l, _ as H, x as N, aq as m, o as O, G as V, an as $, P as q } from "../../../../../shared/runtime.js";
import A from "./module/header.vue.js";
import F from "./module/form.vue.js";
function I(t) {
  return l({ module: "contract", url: "bridge/box-class", method: "get", params: t });
}
function M(t) {
  return l({ module: "contract", url: "bridge/box-class", method: "post", data: t });
}
function T(t) {
  return l({ module: "contract", url: "bridge/box-class", method: "put", data: t });
}
function U(t) {
  return l({ module: "contract", url: `bridge/box-class/delById/${t}`, method: "delete" });
}
const G = { get: I, add: M, edit: T, del: U };
const K = { class: "app-container" }, j = { class: "head-container" }, z = { __name: "index", setup(t) {
  const h = { add: true, edit: false, del: false, download: false }, _ = S(), { CRUD: x, crud: c, columns: d } = N({ title: "分段特征定义", sort: [], permission: { ...m }, optShow: { ...h }, crudApi: { ...G }, hasPagination: true }, _), { maxHeight: g } = O({ wrapperBox: ".boxConfig", paginate: true, extraHeight: 40 });
  return x.HOOK.handleRefresh = (w, { data: f }) => {
    f.content.forEach((o) => {
      o.list = o.boxSpecList;
    });
  }, (w, f) => {
    const o = R, y = k("common-table"), v = E;
    return a(), p("div", K, [C("div", j, [s(e(A))]), L((a(), n(y, { ref_key: "tableRef", ref: _, class: "upload-table", data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(g), "return-source-data": "", showEmptySymbol: false, stripe: false, style: { width: "100%" } }, { default: u(() => [s(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(d).visible("name") ? (a(), n(o, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "名称", "min-width": "150" })) : i("", true), e(d).visible("boxSpecList") ? (a(), n(o, { key: "boxSpecList", prop: "boxSpecList", label: "规格前缀", "show-overflow-tooltip": true, align: "center", "min-width": "260" }, { default: u((r) => [r.row.boxSpecList && r.row.boxSpecList.length > 0 ? (a(true), p(B, { key: 0 }, P(r.row.boxSpecList, (b) => (a(), p("span", { key: b.id }, D(`【${b.specPrefix}】`), 1))), 128)) : i("", true)]), _: 1 })) : i("", true), e(d).visible("sort") ? (a(), n(o, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", width: "80", align: "center" })) : i("", true), e(V)([...e(m).del, ...e(m).edit]) ? (a(), n(o, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((r) => [s(e($), { data: r.row }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, e(c).loading]]), s(e(q)), s(e(F))]);
  };
} }, Y = H(z, [["__scopeId", "data-v-f5f335b4"]]);
export {
  Y as default
};
