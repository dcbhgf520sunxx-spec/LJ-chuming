import { inject as Q } from "vue";
import { reactive as ae } from "vue";
import { computed as j } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as ne } from "vue";
import { openBlock as U } from "vue";
import { createElementBlock as oe } from "vue";
import { withDirectives as v } from "vue";
import { vShow as le } from "vue";
import { unref as e } from "vue";
import { createElementVNode as re } from "vue";
import { createVNode as l } from "vue";
import { withKeys as I } from "vue";
import { createBlock as M } from "vue";
import { createCommentVNode as se } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as ie } from "vue";
import { Fragment as ue } from "vue";
import { ElMessage as de } from "element-plus";
import W from "moment";
import { ElDatePicker as pe } from "element-plus";
import { ElInput as me } from "element-plus";
import { ElInputNumber as ce } from "element-plus";
import { ElFormItem as fe } from "element-plus";
import { ElForm as _e } from "element-plus";
import { ElPopover as ge } from "element-plus";
import { ElTag as ye } from "element-plus";
import { l as D, m as be, bi as c, B as he, i as w, D as C, bL as Ve, bd as Ee, I as Ne, C as Ce, E as Te } from "../../../../../shared/runtime.js";
import { p as ke } from "../../../../../modules/print-record-2e0b6340.js";
import { b as Se } from "../../../../../modules/index-069ba252.js";
import { u as Le } from "../../../../../modules/use-label-print-e19db37a.js";
function Re(E) {
  return D({ module: "mes", url: "package/page", method: "get", params: E });
}
function Ae(E) {
  return D({ module: "mes", url: `package/${E}`, method: "get" });
}
function Ue(E) {
  return D({ module: "mes", url: "package", method: "delete", data: { ids: [E] } });
}
const Oe = { get: Re, del: Ue }, ve = { __name: "header", emits: ["getDetail"], setup(E, { expose: B, emit: q }) {
  const G = q, x = Q("permission"), { user: Y } = be(["user"]), H = { serialNumber: void 0, userName: void 0, startDate: void 0, endDate: void 0, remark: void 0, productSerialNumber: void 0, materialTypeArr: { value: void 0, resetAble: false }, productType: c.STRUCTURE.V, projectId: { value: void 0, resetAble: false } }, { crud: r, query: a } = he(H), _ = ae({ manufacturerName: Y.value.companyName, copies: 1 }), O = j(() => {
    if (w(r.selections)) return r.selections.map((o) => o.id);
  });
  function $() {
    if (!w(O.value)) return de.warning("至少选择一条需要打印的包单信息"), false;
  }
  const { batchPrint: X, print: J } = Le({ getPrintTotalNumber: () => j(() => _.copies).value, getLabelInfo: K, printFinallyHook: r.toQuery, getLoadingTextFunc: (o) => `${o.serialNumber}`, printLabelFunc: Se, needAddPrintRecord: true, addPrintRecordReq: ke }), F = Q("detailStore"), S = { [c.STRUCTURE.V]: "artifactList", [c.MACHINE_PART.V]: "partList", [c.AUXILIARY_MATERIAL.V]: "auxiliaryMaterialList" };
  async function K(o) {
    const t = [], L = [], R = [];
    let f = {};
    try {
      F[o.id] ? f = F[o.id] : (f = await Ae(o.id), G("getDetail", o.id, f));
      const u = f[S[c.AUXILIARY_MATERIAL.V]], g = f[S[c.STRUCTURE.V]];
      if ((u == null ? void 0 : u.length) > 0 && (g == null ? void 0 : g.length) > 0) {
        for (let i = 0; i < u.length; i++) {
          const s = u[i], { name: d, specification: y, measureUnit: b, serialNumber: p, material: n, packageQuantity: h, grossWeight: k, plate: N, length: V } = s;
          L.push({ serialNumber: p, name: d, specification: y, measureUnit: b, material: n, quantity: h, totalWeight: (h * k).toFixed(C.COM_WT__KG), plate: N, length: V ? V.toFixed(C.MES_ENCLOSURE_L__MM) : 0 });
        }
        for (let i = 0; i < g.length; i++) {
          const s = g[i], { name: d, specification: y, measureUnit: b, serialNumber: p, material: n, packageQuantity: h, grossWeight: k, plate: N, length: V } = s;
          R.push({ serialNumber: p, name: d, specification: y, measureUnit: b, material: n, quantity: h, totalWeight: (h * k).toFixed(C.COM_WT__KG), plate: N, length: V ? V.toFixed(C.MES_ENCLOSURE_L__MM) : 0 });
        }
      } else for (const i in S) {
        const s = f[S[i]];
        if (s != null && s.length) for (let d = 0; d < s.length; d++) {
          const y = s[d], { name: b, specification: p, measureUnit: n, serialNumber: h, material: k, packageQuantity: N, grossWeight: V, plate: te, length: z } = y;
          t.push({ serialNumber: h, name: b, specification: p, measureUnit: n, material: k, quantity: N, totalWeight: (N * V).toFixed(C.COM_WT__KG), plate: te, length: z ? z.toFixed(C.MES_ENCLOSURE_L__MM) : 0 });
        }
      }
    } catch (u) {
      console.log("获取详情失败", u);
    }
    return { packageInfo: { serialNumber: o.serialNumber, list: t, structureList: R, auxList: L, productType: o.productType, project: o.project, companyName: _.manufacturerName }, qrCode: JSON.stringify({ id: o.id, type: Ve.MES_PACKAGE, ftype: Ee.MES_PACKAGE_SHIP }) };
  }
  function Z() {
    a.date && a.date.length > 1 ? (a.startDate = W(a.date[0]).valueOf(), a.endDate = W(a.date[1]).valueOf()) : (a.startDate = void 0, a.endDate = void 0), r.toQuery();
  }
  function ee(o) {
    o || (_.copies = 1);
  }
  return B({ print: J, getLabelInfo: K }), (o, t) => {
    const L = A("project-radio-button"), R = A("component-radio-button"), f = pe, T = me, u = ce, g = fe, i = _e, s = A("common-button"), d = ge, y = ye, b = A("print-table"), p = ne("permission");
    return U(), oe(ue, null, [v(re("div", null, [l(L, { size: "default", modelValue: e(a).projectId, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(a).projectId = n), class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(R, { modelValue: e(a).productType, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(a).productType = n), options: e(c).ENUM, type: "enum", size: "default", class: "filter-item", disabledVal: [e(c).ENCLOSURE.V], onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"]), l(f, { modelValue: e(a).date, "onUpdate:modelValue": t[2] || (t[2] = (n) => e(a).date = n), type: "daterange", "unlink-panels": "", "range-separator": "至", "start-placeholder": "开始日期", "end-placeholder": "结束日期", size: "default", class: "filter-item", style: { width: "370px" }, clearable: "", shortcuts: e(Ne), onChange: Z }, null, 8, ["modelValue", "shortcuts"]), l(T, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[3] || (t[3] = (n) => e(a).serialNumber = n), placeholder: "输入包单搜索", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "", onKeyup: I(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(T, { modelValue: e(a).userName, "onUpdate:modelValue": t[4] || (t[4] = (n) => e(a).userName = n), placeholder: "输入打包人名称搜索", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "", onKeyup: I(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(T, { modelValue: e(a).remark, "onUpdate:modelValue": t[5] || (t[5] = (n) => e(a).remark = n), placeholder: "输入备注搜索", class: "filter-item", style: { width: "140px" }, size: "default", clearable: "", onKeyup: I(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), e(a).productType !== e(c).AUXILIARY_MATERIAL.V ? (U(), M(T, { key: 0, modelValue: e(a).productSerialNumber, "onUpdate:modelValue": t[6] || (t[6] = (n) => e(a).productSerialNumber = n), placeholder: "输入产品编号搜索", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: I(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"])) : se("", true), l(e(Ce))], 512), [[le, e(r).searchToggle]]), l(e(Te), null, { optRight: m(() => [l(d, { placement: "bottom-start", width: "400", trigger: "click" }, { reference: m(() => [l(s, { type: "primary", size: "default" }, { default: m(() => t[9] || (t[9] = [P("标签打印设置")])), _: 1, __: [9] })]), default: m(() => [l(i, { ref: "form", model: _ }, { default: m(() => [l(g, { label: "份数" }, { default: m(() => [l(u, { modelValue: _.copies, "onUpdate:modelValue": t[7] || (t[7] = (n) => _.copies = n), step: 1, min: 1, size: "default", style: { width: "250px" }, onChange: ee }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }), v((U(), M(y, { hit: "", effect: "plain", size: "large", style: { "margin-left": "5px" } }, { default: m(() => [P(ie(`份数：${_.copies}`), 1)]), _: 1 })), [[p, e(x).print]]), v(l(b, { "api-key": "mesPackingList", params: O.value, "before-print": $, size: "default", type: "warning", class: "filter-item", style: { "margin-left": "5px !important" } }, null, 8, ["params"]), [[p, e(x).printPackList]])]), viewLeft: m(() => [v((U(), M(s, { type: "success", size: "default", disabled: e(r).selections.length === 0, onClick: t[8] || (t[8] = (n) => e(X)(e(r).selections)) }, { default: m(() => t[10] || (t[10] = [P("批量打印标签")])), _: 1, __: [10] }, 8, ["disabled"])), [[p, e(x).print]])]), _: 1 })], 64);
  };
} }, Fe = Object.freeze(Object.defineProperty({ __proto__: null, default: ve }, Symbol.toStringTag, { value: "Module" }));
export {
  ve as _,
  Oe as c,
  Ae as d,
  Fe as h
};
