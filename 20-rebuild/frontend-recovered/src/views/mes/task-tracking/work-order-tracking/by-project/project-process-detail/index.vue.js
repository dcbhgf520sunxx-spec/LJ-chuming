import { ref as o } from "vue";
import { computed as W } from "vue";
import { watch as j } from "vue";
import { provide as L } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as le } from "vue";
import { withDirectives as E } from "vue";
import { vShow as G } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as l } from "vue";
import { unref as r } from "vue";
import { createBlock as q } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as y } from "vue";
import { withModifiers as ne } from "vue";
import { createTextVNode as se } from "vue";
import { createCommentVNode as re } from "vue";
import { ElCascader as ie } from "element-plus";
import { ElDatePicker as ue } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { ElProgress as ce } from "element-plus";
import { vLoading as pe } from "element-plus";
import { g as me } from "../../../../../../modules/project-overview-1b3937a7.js";
import { _ as ve, bo as v, rV as U, o as fe, bZ as ge, I as he, G as _e, rU as ye } from "../../../../../../shared/runtime.js";
import { u as we } from "../../../../../../modules/use-product-lines-79a95221.js";
import be from "../process-detail/index.vue.js";
import "../../../../../../modules/production-line-select-f08e245b.js";
const xe = { class: "head-container" }, Ne = { class: "completion-ratio" }, De = { __name: "index", props: { processData: { type: Object, default: () => {
} } }, setup(O) {
  const A = o(), D = o([]), k = o(false), B = o(), f = o(), g = o(), h = o(), u = o(v.NET.V), w = o(), P = o([]), I = o(false), c = o([]), b = o(), x = o(), T = o([]), Q = o(), V = o(U.QUANTITY_RATIO.V), d = O, { productLines: C } = we(), M = W(() => ({ startDate: b.value, endDate: x.value })), z = o([v.NET, v.GROSS]);
  j([() => {
    var a;
    return (a = d.processData) == null ? void 0 : a.id;
  }, () => f.value, () => g.value, () => w.value, () => h.value, () => u.value], () => {
    R();
  }), j(C, (a) => {
    K(C), console.log(C, "productLines");
  }, { immediate: true, deep: true }), L("monomerId", f), L("areaId", g), L("productionLineId", h);
  const F = W(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), { maxHeight: H } = fe({ extraBox: [".head-container"], paginate: true });
  async function R() {
    var a;
    if ((a = d.processData) != null && a.id) {
      D.value = [];
      try {
        k.value = true;
        const e = await me({ productType: B.value, monomerId: f.value, areaId: g.value, projectId: d.processData.id, workshopId: w.value, productionLineId: h.value, startDate: b.value, endDate: x.value });
        D.value = e;
      } catch (e) {
        console.log("获取项目下的工序清单", e);
      } finally {
        k.value = false;
      }
    }
  }
  function J(a) {
    I.value = true, P.value = a;
  }
  function Y() {
    c.value && c.value.length > 1 ? (b.value = c.value[0], x.value = c.value[1]) : (b.value = void 0, x.value = void 0), R();
  }
  function $(a) {
    if (!a) return 0;
    try {
      if (V.value === U.QUANTITY_RATIO.V) {
        const e = Number(a.quantity) || 0, n = Number(a.completeQuantity) || 0;
        return e === 0 ? 0 : Number((n / e * 100).toFixed(2));
      } else if (u.value === v.NET.V) {
        const e = Number(a.totalNetWeight) || 0, n = Number(a.completeNetWeight) || 0;
        return e === 0 ? 0 : Number((n / e * 100).toFixed(2));
      } else {
        const e = Number(a.totalGrossWeight) || 0, n = Number(a.completeGrossWeight) || 0;
        return e === 0 ? 0 : Number((n / e * 100).toFixed(2));
      }
    } catch {
      return 0;
    }
  }
  function K(a) {
    T.value = [];
    const e = [];
    try {
      a && (JSON.parse(JSON.stringify(a.value)).map((p) => {
        p.disabled = true, p.workshopList.map((_) => {
          _.children = _.productionLineList || [], e.push(_);
        }), p.children = p.workshopList || [];
      }), T.value = e);
    } catch (n) {
      console.log("获取工厂车间生产线树失败", n);
    }
  }
  function Z(a) {
    a ? (w.value = a[0] || void 0, h.value = a[1] || void 0) : (w.value = void 0, h.value = void 0);
  }
  return (a, e) => {
    const n = N("common-radio-button"), p = ie, _ = ue, m = de, X = N("table-cell-tag"), ee = ce, te = N("common-button"), ae = N("common-table"), oe = pe;
    return S(), le("div", null, [E(s("div", null, e[7] || (e[7] = [s("div", { class: "my-code" }, "点击左边表项目行查看详情", -1)]), 512), [[G, !d.processData.id]]), E(s("div", null, [s("div", xe, [l(n, { type: "enum", modelValue: u.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => u.value = t), options: z.value, class: "filter-item" }, null, 8, ["modelValue", "options"]), l(r(ge), { monomerId: f.value, "onUpdate:monomerId": e[1] || (e[1] = (t) => f.value = t), areaId: g.value, "onUpdate:areaId": e[2] || (e[2] = (t) => g.value = t), needConvert: "", clearable: "", areaClearable: "", "project-id": d.processData.id }, null, 8, ["monomerId", "areaId", "project-id"]), l(p, { class: "filter-item", modelValue: Q.value, "onUpdate:modelValue": e[3] || (e[3] = (t) => Q.value = t), options: T.value, props: F.value, filterable: "", clearable: "", "show-all-levels": "", placeholder: "请选择车间/生产线", onChange: Z, style: { width: "250px" } }, null, 8, ["modelValue", "options", "props"]), l(_, { modelValue: c.value, "onUpdate:modelValue": e[4] || (e[4] = (t) => c.value = t), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: r(he), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: Y }, null, 8, ["modelValue", "shortcuts"])]), E((S(), q(ae, { ref_key: "tableRef", ref: A, data: D.value, "empty-text": "暂无数据", "max-height": r(H), "row-key": "id", style: { width: "100%" } }, { default: i(() => [l(m, { prop: "index", label: "序号", align: "center", width: "60px", type: "index" }), l(m, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "涉及工序", width: "100px" }, { default: i((t) => [l(X, { show: t.row.id === -1, color: "#e64242", name: "特殊" }, null, 8, ["show"]), s("span", null, y(t.row.name), 1)]), _: 1 }), l(m, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "需生产（件/kg）" }, { default: i((t) => [s("span", null, y(t.row.quantity) + "/" + y(u.value === r(v).NET.V ? t.row.totalNetWeight : t.row.totalGrossWeight), 1)]), _: 1 }), l(m, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成（件/kg）" }, { default: i((t) => [s("span", null, y(t.row.completeQuantity) + "/" + y(u.value === r(v).NET.V ? t.row.completeNetWeight : t.row.completeGrossWeight), 1)]), _: 1 }), l(m, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率", "min-width": "150px" }, { header: i(() => [s("div", Ne, [e[8] || (e[8] = s("span", null, "完成率", -1)), l(n, { modelValue: V.value, "onUpdate:modelValue": e[5] || (e[5] = (t) => V.value = t), options: r(U).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])])]), default: i((t) => [l(ee, { "text-inside": true, "stroke-width": 26, percentage: $(t.row), status: "success" }, null, 8, ["percentage"])]), _: 1 }), r(_e)(r(ye).detail) ? (S(), q(m, { key: 0, align: "center", "show-overflow-tooltip": true, label: "操作" }, { default: i((t) => [l(te, { type: "primary", size: "default", onClick: ne((ke) => J(t.row), ["stop"]) }, { default: i(() => e[9] || (e[9] = [se("查看")])), _: 2, __: [9] }, 1032, ["onClick"])]), _: 1 })) : re("", true)]), _: 1 }, 8, ["data", "max-height"])), [[oe, k.value]]), l(be, { visible: I.value, "onUpdate:visible": e[6] || (e[6] = (t) => I.value = t), "project-id": d.processData.id, processData: O.processData, "detail-data": P.value, weightStatus: u.value, dateQuery: M.value }, null, 8, ["visible", "project-id", "processData", "detail-data", "weightStatus", "dateQuery"])], 512), [[G, d.processData.id]])]);
  };
} }, Ue = ve(De, [["__scopeId", "data-v-c3324359"]]);
export {
  Ue as default
};
