import { ref as a } from "vue";
import { computed as j } from "vue";
import { watch as U } from "vue";
import { provide as S } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as te } from "vue";
import { withDirectives as T } from "vue";
import { vShow as Q } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as l } from "vue";
import { unref as r } from "vue";
import { createBlock as q } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as h } from "vue";
import { withModifiers as ae } from "vue";
import { createTextVNode as oe } from "vue";
import { createCommentVNode as le } from "vue";
import { ElCascader as ne } from "element-plus";
import { ElDatePicker as se } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { ElProgress as ie } from "element-plus";
import { vLoading as ue } from "element-plus";
import { g as de } from "../../../../../../modules/project-overview-1b3937a7.js";
import { _ as ce, bo as w, o as pe, bZ as me, I as ve, G as fe, pH as ge } from "../../../../../../shared/runtime.js";
import { u as he } from "../../../../../../modules/use-product-lines-79a95221.js";
import we from "../process-detail/index.vue.js";
import "../../../../../../modules/production-line-select-f08e245b.js";
const _e = { class: "head-container" }, ye = { __name: "index", props: { processData: { type: Object, default: () => {
} } }, setup(B) {
  const G = a(), D = a([]), I = a(false), R = a(), m = a(), v = a(), f = a(), u = a(w.NET.V);
  a();
  const _ = a(), P = a([]), V = a(false), d = a([]), y = a(), b = a(), C = a([]), E = a(), n = B, { productLines: L } = he(), H = j(() => ({ startDate: y.value, endDate: b.value })), M = a([w.NET, w.GROSS]);
  U([() => {
    var o;
    return (o = n.processData) == null ? void 0 : o.id;
  }, () => m.value, () => v.value, () => _.value, () => f.value, () => u.value], () => {
    O();
  }), U(L, (o) => {
    A(L), console.log(L, "productLines");
  }, { immediate: true, deep: true }), S("monomerId", m), S("areaId", v), S("productionLineId", f);
  const W = j(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), { maxHeight: z } = pe({ extraBox: [".head-container"], paginate: true });
  async function O() {
    var o;
    if ((o = n.processData) != null && o.id) {
      D.value = [];
      try {
        I.value = true;
        const t = await de({ productType: R.value, monomerId: m.value, areaId: v.value, projectId: n.processData.id, workshopId: _.value, productionLineId: f.value, startDate: y.value, endDate: b.value });
        D.value = t;
      } catch (t) {
        console.log("获取项目下的工序清单", t);
      } finally {
        I.value = false;
      }
    }
  }
  function J(o) {
    V.value = true, P.value = o;
  }
  function $() {
    d.value && d.value.length > 1 ? (y.value = d.value[0], b.value = d.value[1]) : (y.value = void 0, b.value = void 0), O();
  }
  function A(o) {
    C.value = [];
    const t = [];
    try {
      o && (JSON.parse(JSON.stringify(o.value)).map((c) => {
        c.disabled = true, c.workshopList.map((g) => {
          g.children = g.productionLineList || [], t.push(g);
        }), c.children = c.workshopList || [];
      }), C.value = t);
    } catch (x) {
      console.log("获取工厂车间生产线树失败", x);
    }
  }
  function F(o) {
    o ? (_.value = o[0] || void 0, f.value = o[1] || void 0) : (_.value = void 0, f.value = void 0);
  }
  return (o, t) => {
    const x = k("common-radio-button"), c = ne, g = se, p = re, K = k("table-cell-tag"), Z = ie, X = k("common-button"), Y = k("common-table"), ee = ue;
    return N(), te("div", null, [T(s("div", null, t[6] || (t[6] = [s("div", { class: "my-code" }, "点击左边表项目行查看详情", -1)]), 512), [[Q, !n.processData.id]]), T(s("div", null, [s("div", _e, [l(x, { type: "enum", modelValue: u.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => u.value = e), options: M.value, class: "filter-item" }, null, 8, ["modelValue", "options"]), l(r(me), { monomerId: m.value, "onUpdate:monomerId": t[1] || (t[1] = (e) => m.value = e), areaId: v.value, "onUpdate:areaId": t[2] || (t[2] = (e) => v.value = e), needConvert: "", clearable: "", areaClearable: "", "project-id": n.processData.id }, null, 8, ["monomerId", "areaId", "project-id"]), l(c, { class: "filter-item", modelValue: E.value, "onUpdate:modelValue": t[3] || (t[3] = (e) => E.value = e), options: C.value, props: W.value, filterable: "", clearable: "", "show-all-levels": "", placeholder: "请选择车间/生产线", onChange: F, style: { width: "250px" } }, null, 8, ["modelValue", "options", "props"]), l(g, { modelValue: d.value, "onUpdate:modelValue": t[4] || (t[4] = (e) => d.value = e), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: r(ve), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: $ }, null, 8, ["modelValue", "shortcuts"])]), T((N(), q(Y, { ref_key: "tableRef", ref: G, data: D.value, "empty-text": "暂无数据", "max-height": r(z), "row-key": "id", style: { width: "100%" } }, { default: i(() => [l(p, { prop: "index", label: "序号", align: "center", width: "60px", type: "index" }), l(p, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "涉及工序", width: "100px" }, { default: i((e) => [l(K, { show: e.row.id === -1, color: "#e64242", name: "特殊" }, null, 8, ["show"]), s("span", null, h(e.row.name), 1)]), _: 1 }), l(p, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "需生产（件/kg）" }, { default: i((e) => [s("span", null, h(e.row.quantity) + "/" + h(u.value === r(w).NET.V ? e.row.totalNetWeight : e.row.totalGrossWeight), 1)]), _: 1 }), l(p, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成（件/kg）" }, { default: i((e) => [s("span", null, h(e.row.completeQuantity) + "/" + h(u.value === r(w).NET.V ? e.row.completeNetWeight : e.row.completeGrossWeight), 1)]), _: 1 }), l(p, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率", "min-width": "150px" }, { default: i((e) => [l(Z, { "text-inside": true, "stroke-width": 26, percentage: Number((e.row.completeQuantity / e.row.quantity * 100).toFixed(2)), status: "success" }, null, 8, ["percentage"])]), _: 1 }), r(fe)(r(ge).detail) ? (N(), q(p, { key: 0, align: "center", "show-overflow-tooltip": true, label: "操作" }, { default: i((e) => [l(X, { type: "primary", size: "default", onClick: ae((be) => J(e.row), ["stop"]) }, { default: i(() => t[7] || (t[7] = [oe("查看")])), _: 2, __: [7] }, 1032, ["onClick"])]), _: 1 })) : le("", true)]), _: 1 }, 8, ["data", "max-height"])), [[ee, I.value]]), l(we, { visible: V.value, "onUpdate:visible": t[5] || (t[5] = (e) => V.value = e), "project-id": n.processData.id, "detail-data": P.value, weightStatus: u.value, dateQuery: H.value }, null, 8, ["visible", "project-id", "detail-data", "weightStatus", "dateQuery"])], 512), [[Q, n.processData.id]])]);
  };
} }, Se = ce(ye, [["__scopeId", "data-v-080d4820"]]);
export {
  Se as default
};
