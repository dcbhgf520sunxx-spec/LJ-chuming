import { ref as k } from "vue";
import { provide as N } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as W } from "vue";
import { createBlock as l } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as p } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as C } from "element-plus";
import { l as L, t as P, o as B, x as D, po as g, z as Q, fj as V, P as E, ba as M } from "../../../../shared/runtime.js";
import R from "./module/header.vue.js";
function A(d) {
  return L({ module: "mes", url: "price/stud/sleeve/page", method: "get", params: d });
}
const H = { get: A }, q = { class: "app-container" }, z = { class: "head-container" }, G = { __name: "index", setup(d) {
  const { decimalPrecision: y } = P(), w = k(), { maxHeight: h } = B({ extraBox: [".head-container"], paginate: true }), b = { add: false, edit: false, del: false, download: false }, { crud: c, columns: n } = D({ title: "栓钉套筒统计", sort: [], optShow: { ...b }, crudApi: { ...H }, permission: { ...g }, hasPagination: true }, w);
  N("permission", g);
  function v(f) {
    return M(f, { props: ["auxiliaryQuantity", ["wages", y.value.mes]] });
  }
  return (f, F) => {
    const o = j, _ = S("common-table"), x = C;
    return a(), T("div", q, [i("div", z, [m(t(R))]), W((a(), l(_, { ref_key: "tableRef", ref: w, data: t(c).data, "empty-text": t(c).emptyText, "max-height": t(h), "show-summary": "", "summary-method": v, "row-key": "projectId", style: { width: "100%" } }, { default: r(() => [m(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(n).visible("project") ? (a(), l(o, { "header-align": "center", key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "140" }, { default: r((e) => [i("span", null, s(t(Q)(e.row.project)), 1)]), _: 1 })) : p("", true), t(n).visible("monomer.name") ? (a(), l(o, { align: "center", key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: r((e) => {
      var u;
      return [i("span", null, s((u = e.row.monomer) == null ? void 0 : u.name), 1)];
    }), _: 1 })) : p("", true), t(n).visible("area.name") ? (a(), l(o, { align: "center", key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: "区域" }, { default: r((e) => {
      var u;
      return [i("span", null, s((u = e.row.area) == null ? void 0 : u.name), 1)];
    }), _: 1 })) : p("", true), t(n).visible("serialNumber") ? (a(), l(o, { align: "center", key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }, { default: r((e) => [i("span", null, s(e.row.serialNumber), 1)]), _: 1 })) : p("", true), t(n).visible("specification") ? (a(), l(o, { align: "center", key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140" }, { default: r((e) => [i("span", null, s(e.row.specification), 1)]), _: 1 })) : p("", true), t(n).visible("netWeight") ? (a(), l(o, { align: "center", key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单净重（kg）" }, { default: r((e) => [i("span", null, s(e.row.netWeight), 1)]), _: 1 })) : p("", true), t(n).visible("grossWeight") ? (a(), l(o, { align: "center", key: "grossWeight", prop: "grossWeight", "show-overflow-tooltip": true, label: "单毛重（kg）" }, { default: r((e) => [i("span", null, s(e.row.grossWeight), 1)]), _: 1 })) : p("", true), t(n).visible("productionLine.name") ? (a(), l(o, { align: "center", key: "productionLine.name", prop: "productionLine.name", "show-overflow-tooltip": true, label: "产线" }, { default: r((e) => {
      var u;
      return [i("span", null, s((u = e.row.productionLine) == null ? void 0 : u.name), 1)];
    }), _: 1 })) : p("", true), t(n).visible("completeTime") ? (a(), l(o, { align: "center", key: "completeTime", prop: "completeTime", "show-overflow-tooltip": true, label: "生产日期", "min-width": "100" }, { default: r((e) => [i("span", null, s(e.row.completeTime), 1)]), _: 1 })) : p("", true), t(n).visible("auxiliaryTypeName") ? (a(), l(o, { align: "center", key: "auxiliaryTypeName", prop: "auxiliaryTypeName", "show-overflow-tooltip": true, label: "类型" }, { default: r((e) => [i("span", null, s(t(V).VL[e.row.auxiliaryTypeName]), 1)]), _: 1 })) : p("", true), t(n).visible("auxiliarySpecification") ? (a(), l(o, { align: "center", key: "auxiliarySpecification", prop: "auxiliarySpecification", "show-overflow-tooltip": true, label: "规格", "min-width": "80" }, { default: r((e) => [i("span", null, s(e.row.auxiliarySpecification), 1)]), _: 1 })) : p("", true), t(n).visible("auxiliaryQuantity") ? (a(), l(o, { align: "center", key: "auxiliaryQuantity", prop: "auxiliaryQuantity", "show-overflow-tooltip": true, label: "数量" }, { default: r((e) => [i("span", null, s(e.row.auxiliaryQuantity), 1)]), _: 1 })) : p("", true), t(n).visible("price") ? (a(), l(o, { align: "center", key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价" }, { default: r((e) => [i("span", null, s(e.row.price), 1)]), _: 1 })) : p("", true), t(n).visible("wages") ? (a(), l(o, { align: "center", key: "wages", prop: "wages", "show-overflow-tooltip": true, label: "总价" }, { default: r((e) => [i("span", null, s(e.row.wages), 1)]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[x, t(c).loading]]), m(t(E))]);
  };
} };
export {
  G as default
};
