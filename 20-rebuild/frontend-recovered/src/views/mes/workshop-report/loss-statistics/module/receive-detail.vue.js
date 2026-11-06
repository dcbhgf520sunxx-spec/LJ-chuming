import { inject as J } from "vue";
import { ref as s } from "vue";
import { watch as K } from "vue";
import { computed as Q } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as E } from "vue";
import { createBlock as j } from "vue";
import { withCtx as h } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as X } from "vue";
import { toDisplayString as N } from "vue";
import { unref as c } from "vue";
import { withDirectives as A } from "vue";
import { isRef as Z } from "vue";
import { ElTag as ee } from "element-plus";
import { ElDatePicker as te } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { vLoading as le } from "element-plus";
import { r as ne } from "../../../../../modules/loss-statistics-d681f3ee.js";
import { _ as ie, u as oe, o as re, cO as H, jl as O, aV as se, ss as ce, bv as ue, am as de, p as me } from "../../../../../shared/runtime.js";
const pe = { style: { "margin-bottom": "10px" } }, fe = { class: "subitem" }, ve = { __name: "receive-detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(S, { emit: R }) {
  const L = R, o = J("query"), V = S, C = s(), D = s(false), U = s([]), p = s([]), w = s(), g = s(), f = s(), q = s([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), b = s(0), _ = s(0), { visible: k, handleClose: z } = oe({ emit: L, props: V, field: "visible", showHook: T, closeHook: $ }), { maxHeight: M } = re({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], extraHeight: "90px", paginate: false, clientHRepMainH: true }, C);
  K(() => k, (i) => {
    f.value = o.workShopId, w.value = new Date(o.year).getTime(), (/* @__PURE__ */ new Date()).getFullYear().toString() === o.year ? (g.value = (/* @__PURE__ */ new Date()).getTime(), p.value = [new Date(o.year).getTime(), (/* @__PURE__ */ new Date()).getTime()]) : (g.value = (/* @__PURE__ */ new Date(`${o.year}-12-31`)).getTime(), p.value = [new Date(o.year).getTime(), (/* @__PURE__ */ new Date(`${o.year}-12-31`)).getTime()]);
  }, { immediate: true, deep: true });
  const x = Q(() => ({ projectIds: [V.info.projectId], workShopIds: f.value ? [f.value] : [], times: w.value ? [w.value, g.value] : [] }));
  async function T() {
    let i = [], t = [], u = [];
    D.value = true;
    try {
      o.workShopId && (x.value.workShopIds = [o.workShopId]);
      const { plantOutboundDetailList: l = [], plantReturnDetailList: r = [] } = await ne({ ...x.value });
      l.length > 0 ? (await H(l), t = await O(l, { unit: t.accountingUnit, fields: ["mete"] }), t.forEach((e) => {
        e.contractAmount = "出库";
      }), b.value = t.reduce((e, v) => e + +v.mete, 0), t.length > 0 && t.push({ contractAmount: "小计", createTime: false, mete: b.value })) : b.value = 0, r.length > 0 ? (await H(r), u = await O(r, { unit: r.accountingUnit, fields: ["mete"] }), u.forEach((e) => {
        e.contractAmount = "退库", e.mete = -e.mete;
      }), _.value = r.reduce((e, v) => e + +v.mete, 0), u.push({ contractAmount: "小计", createTime: false, mete: _.value })) : _.value = 0, i = [...t, ...u];
    } catch (l) {
      console.error(l);
    } finally {
      U.value = i, D.value = false;
    }
  }
  const F = (i) => {
    const { columns: t, data: u } = i, l = [];
    return t.forEach((r, e) => {
      if (e === 0) {
        l[e] = "合计";
        return;
      }
      if (["mete"].findIndex((d) => Array.isArray(d) ? d[0] === r.property : d === r.property) > -1) {
        const d = u.map((m) => Number(m[r.property]));
        d.every((m) => Number.isNaN(m)) ? l[e] = "" : (l[e] = d.reduce((m, n) => {
          const G = Number(n);
          return Number.isNaN(G) ? m : m + n;
        }, 0), r.property === "mete" && (l[e] = l[e] - b.value + Math.abs(_.value)));
      }
    }), l;
  };
  function P(i) {
    p.value && p.value.length > 1 ? (w.value = i[0], g.value = i[1]) : (w.value = void 0, g.value = void 0), T();
  }
  function Y(i) {
    return i.getFullYear() !== new Date(o.year).getFullYear() || i > /* @__PURE__ */ new Date();
  }
  function $() {
    f.value = void 0, p.value = void 0;
  }
  return (i, t) => {
    const u = ee, l = te, r = I("print-table"), e = ae, v = I("common-table"), B = I("common-drawer"), d = W("permission"), m = le;
    return E(), j(B, { "append-to-body": "", ref_key: "drawerRef", ref: C, title: "物料领用明细", modelValue: c(k), "onUpdate:modelValue": t[2] || (t[2] = (n) => Z(k) ? k.value = n : null), direction: "rtl", "before-close": c(z), size: "70%" }, { content: h(() => [y("div", pe, [a(u, { effect: "plain", size: "large" }, { default: h(() => [X("项目：" + N(S.info.projectName), 1)]), _: 1 })]), y("div", fe, [y("div", null, [a(c(se), { ref: "workshopInfRef", modelValue: f.value, "onUpdate:modelValue": t[0] || (t[0] = (n) => f.value = n), placeholder: "请选择车间", "factory-id": c(o).factoryId, style: { width: "200px", "margin-right": "10px" }, class: "filter-item", size: "default", clearable: "", disabled: !!c(o).workShopId, onChange: T }, null, 8, ["modelValue", "factory-id", "disabled"]), a(l, { modelValue: p.value, "onUpdate:modelValue": t[1] || (t[1] = (n) => p.value = n), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", clearable: false, style: { width: "240px" }, "disabled-date": Y, "default-time": q.value, onChange: P }, null, 8, ["modelValue", "default-time"])]), A(a(r, { "api-key": "receiveDetail", params: x.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[d, c(ce).receivePrint]])]), A((E(), j(v, { ref: "tableRef", data: U.value, "max-height": c(M), "show-summary": "", "summary-method": F, "row-key": "rowId", style: { width: "100%" } }, { default: h(() => [a(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(e, { label: "类型", prop: "contractAmount", key: "contractAmount", align: "center", width: "120" }), a(e, { label: "物料种类", prop: "basicClass", key: "basicClass", align: "center", width: "120" }, { default: h((n) => [y("div", null, N(n.row.basicClass ? c(ue).getBits(c(de).ENUM, n.row.basicClass, "L").join("|") : ""), 1)]), _: 1 }), a(e, { label: "规格", prop: "specification", key: "specification", align: "center", width: "120" }), a(e, { label: "计量单位", prop: "measureUnit", key: "measureUnit", align: "center", width: "120" }), a(e, { label: "数量", prop: "quantity", key: "quantity", align: "center", width: "120" }), a(e, { label: "核算单位", prop: "accountingUnit", key: "accountingUnit", align: "center", width: "120" }), a(e, { label: "核算量", prop: "mete", key: "mete", align: "center", width: "120" }), a(e, { label: "出（退）库日期", prop: "createTime", key: "createTime", align: "center", width: "120" }, { default: h((n) => [y("div", null, N(n.row.createTime ? c(me)(n.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), a(e, { label: "领用车间", prop: "workShop", key: "workShop", align: "center", width: "120" }), a(e, { label: "领料人", prop: "recipientName", key: "recipientName", align: "center", width: "120" }), a(e, { label: "办理人", prop: "applicantName", key: "applicantName", align: "center", width: "120" })]), _: 1 }, 8, ["data", "max-height"])), [[m, D.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ye = ie(ve, [["__scopeId", "data-v-66dc6c10"]]);
export {
  ye as default
};
