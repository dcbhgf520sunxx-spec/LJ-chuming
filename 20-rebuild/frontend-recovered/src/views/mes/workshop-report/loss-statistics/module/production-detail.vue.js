import { ref as r } from "vue";
import { inject as W } from "vue";
import { watch as X } from "vue";
import { computed as Z } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as y } from "vue";
import { createBlock as b } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as I } from "vue";
import { unref as o } from "vue";
import { withDirectives as T } from "vue";
import { isRef as ae } from "vue";
import { ElTag as te } from "element-plus";
import { ElDatePicker as oe } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElPagination as ne } from "element-plus";
import { vLoading as re } from "element-plus";
import { g as ie, p as se, a as de } from "../../../../../modules/loss-statistics-d681f3ee.js";
import { _ as ue, u as ce, J as pe, o as me, aV as fe, L as ge, ss as he, ba as _e } from "../../../../../shared/runtime.js";
const ve = { class: "head-container" }, we = { style: { "margin-bottom": "10px" } }, ye = { class: "subitem" }, be = { __name: "production-detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(D, { emit: z }) {
  const H = z, x = D, C = r(), _ = r(false), N = r([]), d = r(), S = r(), P = r([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), i = r([]), v = r(), p = r(), { visible: m, handleClose: E } = ce({ emit: H, props: x, field: "visible", showHook: f, closeHook: M }), { handleSizeChange: R, handleCurrentChange: j, total: B, setTotalPage: $, queryPage: w } = pe({ fetchHook: f }), { maxHeight: q } = me({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], extraHeight: "90px", paginate: true, clientHRepMainH: true }, C), F = r([]), l = W("query");
  X(() => m, (t) => {
    d.value = l.workShopId, v.value = new Date(l.year).getTime(), (/* @__PURE__ */ new Date()).getFullYear().toString() === l.year ? (p.value = (/* @__PURE__ */ new Date()).getTime(), i.value = [new Date(l.year).getTime(), (/* @__PURE__ */ new Date()).getTime()]) : (p.value = (/* @__PURE__ */ new Date(`${l.year}-12-31`)).getTime(), i.value = [new Date(l.year).getTime(), (/* @__PURE__ */ new Date(`${l.year}-12-31`)).getTime()]);
  }, { immediate: true, deep: true });
  const s = Z(() => ({ projectId: x.info.projectId, workShopId: d.value, startDate: v.value, endDate: p.value }));
  async function f() {
    let t = [];
    _.value = true;
    try {
      const e = await ie({ ...s.value });
      S.value = e;
    } catch (e) {
      console.error(e);
    }
    try {
      l.workShopId && (s.value.workShopId = l.workShopId);
      const { content: e = [], totalElements: g } = await se({ ...s.value, ...w });
      t = e, $(g);
    } catch (e) {
      console.error(e);
    } finally {
      N.value = t, _.value = false;
    }
  }
  function L(t) {
    return _e(t, { props: ["productionNumber", "weight"] });
  }
  function M() {
    d.value = void 0, i.value = void 0;
  }
  function U(t) {
    i.value && i.value.length > 1 ? (v.value = t[0], p.value = t[1]) : (s.value.startDate = void 0, s.value.endDate = void 0), f();
  }
  function Y(t) {
    return t.getFullYear() !== new Date(l.year).getFullYear() || t > /* @__PURE__ */ new Date();
  }
  return (t, e) => {
    const g = te, J = oe, n = le, O = V("common-table"), A = ne, G = V("common-drawer"), K = ee("permission"), Q = re;
    return y(), b(G, { "append-to-body": "", ref_key: "drawerRef", ref: C, title: "生产明细", modelValue: o(m), "onUpdate:modelValue": e[2] || (e[2] = (u) => ae(m) ? m.value = u : null), direction: "rtl", "before-close": o(E), size: "70%" }, { content: c(() => [h("div", ve, [h("div", we, [a(g, { effect: "plain", size: "large" }, { default: c(() => [k("项目：" + I(D.info.projectName), 1)]), _: 1 }), a(g, { style: { "margin-left": "10px" }, ffect: "plain", size: "large" }, { default: c(() => [k("生产总量（吨）：" + I(S.value), 1)]), _: 1 })]), h("div", ye, [h("div", null, [a(o(fe), { ref: "workshopInfRef", modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (u) => d.value = u), placeholder: "请选择车间", "factory-id": o(l).factoryId, style: { width: "200px" }, class: "filter-item", size: "default", clearable: "", disabled: !!o(l).workShopId, onChange: f }, null, 8, ["modelValue", "factory-id", "disabled"]), a(J, { modelValue: i.value, "onUpdate:modelValue": e[1] || (e[1] = (u) => i.value = u), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, clearable: false, "disabled-date": Y, "default-time": P.value, onChange: U }, null, 8, ["modelValue", "default-time"])]), T((y(), b(ge, { params: s.value, fn: o(de) }, { default: c(() => e[3] || (e[3] = [k(" 生产明细 ")])), _: 1, __: [3] }, 8, ["params", "fn"])), [[K, o(he).productionExport]])])]), T((y(), b(O, { ref: "tableRef", data: N.value, "data-format": F.value, "max-height": o(q), "show-summary": "", "summary-method": L, "row-key": "rowId", style: { width: "100%" } }, { default: c(() => [a(n, { label: "序号", type: "index", align: "center", width: "60" }), a(n, { "show-overflow-tooltip": true, label: "单体", prop: "monomerName", key: "monomerName", align: "center", "min-width": "160px" }), a(n, { label: "区域", prop: "areaName", key: "areaName", align: "center", width: "120" }), a(n, { label: "名称", prop: "productName", key: "productName", align: "center", width: "120" }), a(n, { label: "编号", prop: "serialNumber", key: "serialNumber", align: "center", width: "120" }), a(n, { label: "规格", prop: "specification", key: "specification", align: "center", width: "140px" }), a(n, { label: "长度", prop: "length", key: "length", align: "center", width: "120" }), a(n, { label: "材质", prop: "material", key: "material", align: "center", width: "120" }), a(n, { label: "生产数", prop: "productionNumber", key: "productionNumber", align: "center", width: "120" }), a(n, { label: "重量（kg）", prop: "weight", key: "weight", align: "center", width: "120" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[Q, _.value]]), a(A, { total: o(B), "current-page": o(w).pageNumber, "page-size": o(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(R), onCurrentChange: o(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ce = ue(be, [["__scopeId", "data-v-14600b46"]]);
export {
  Ce as default
};
