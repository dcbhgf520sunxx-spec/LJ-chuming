import { ref as x } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as S } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as s } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as A } from "vue";
import { renderList as I } from "vue";
import { toDisplayString as B } from "vue";
import { ElTableColumn as E } from "element-plus";
import { vLoading as R } from "element-plus";
import { l as u, _ as D, x as M, al as y, o as P, am as F, G as H, an as V, P as O } from "../../../../../shared/runtime.js";
import T from "./module/header.vue.js";
import $ from "./module/form.vue.js";
function U(i) {
  return u({ url: "/api/bridge/auxiliary-class", method: "get", params: i });
}
function j(i) {
  return u({ url: "/api/bridge/auxiliary-class", method: "post", data: i });
}
function q(i) {
  return u({ url: "/api/bridge/auxiliary-class", method: "put", data: i });
}
function G(i) {
  return u({ url: `/api/bridge/auxiliary-class/delById/${i}`, method: "delete" });
}
const K = { get: U, add: j, edit: q, del: G };
const z = { class: "app-container" }, J = { class: "head-container" }, Q = { __name: "index", setup(i) {
  const g = { add: true, edit: false, del: false, download: false }, _ = x(), { CRUD: w, crud: c, columns: n } = M({ title: "桥梁-配套件特征定义", sort: [], permission: { ...y }, optShow: { ...g }, crudApi: { ...K }, hasPagination: true }, _), { maxHeight: C } = P({ wrapperBox: ".bridgeAuxiliaryMaterialConfig", paginate: true, extraHeight: 40 }), d = x([]);
  return w.HOOK.handleRefresh = (N, { data: b }) => {
    d.value = [], b.content.forEach((e) => {
      e.list = e.auxiliarySerialNumberList, e.classifyIds = e.boundFinalClassifyIds, e.classifyNames = e.classifyLinks.map((m) => m.classifyName).join("、"), e.basicClass = F.MATERIAL.V, d.value = d.value.concat(e.boundFinalClassifyIds);
    });
  }, (N, b) => {
    const e = E, m = k("common-table"), v = R;
    return t(), p("div", z, [S("div", J, [o(a(T))]), L((t(), s(m, { ref_key: "tableRef", ref: _, class: "upload-table", data: a(c).data, "empty-text": a(c).emptyText, "max-height": a(C), "return-source-data": "", showEmptySymbol: false, stripe: false, style: { width: "100%" } }, { default: f(() => [o(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(n).visible("name") ? (t(), s(e, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "类型名称", "min-width": "150" })) : r("", true), a(n).visible("classifyNames") ? (t(), s(e, { key: "classifyNames", prop: "classifyNames", "show-overflow-tooltip": true, label: "辅材科目", "min-width": "260" })) : r("", true), a(n).visible("auxiliarySerialNumberList") ? (t(), s(e, { key: "auxiliarySerialNumberList", prop: "auxiliarySerialNumberList", label: "编号", "show-overflow-tooltip": true, align: "center", "min-width": "260" }, { default: f((l) => [l.row.auxiliarySerialNumberList && l.row.auxiliarySerialNumberList.length > 0 ? (t(true), p(A, { key: 0 }, I(l.row.auxiliarySerialNumberList, (h) => (t(), p("span", { key: h.id }, B(`【${h.serialNumber}】`), 1))), 128)) : r("", true)]), _: 1 })) : r("", true), a(n).visible("sort") ? (t(), s(e, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", width: "80", align: "center" })) : r("", true), a(H)([...a(y).del, ...a(y).edit]) ? (t(), s(e, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: f((l) => [o(a(V), { data: l.row }, null, 8, ["data"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, a(c).loading]]), o(a(O)), o(a($), { boundAllClassifyIds: d.value }, null, 8, ["boundAllClassifyIds"])]);
  };
} }, ee = D(Q, [["__scopeId", "data-v-f17d702f"]]);
export {
  ee as default
};
