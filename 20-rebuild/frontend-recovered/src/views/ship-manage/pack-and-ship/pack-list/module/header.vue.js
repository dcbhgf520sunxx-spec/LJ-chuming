import { ref as z } from "vue";
import { inject as R } from "vue";
import { reactive as ce } from "vue";
import { computed as w } from "vue";
import { watch as B } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as fe } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as M } from "vue";
import { withDirectives as g } from "vue";
import { vShow as ye } from "vue";
import { unref as e } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as l } from "vue";
import { createBlock as V } from "vue";
import { createCommentVNode as P } from "vue";
import { withKeys as p } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as j } from "vue";
import { toDisplayString as x } from "vue";
import { Fragment as be } from "vue";
import { ElMessage as _e } from "element-plus";
import D from "moment";
import { ElDatePicker as ge } from "element-plus";
import { ElInput as Ve } from "element-plus";
import { ElCheckbox as he } from "element-plus";
import { View as Ne } from "@element-plus/icons-vue";
import { ElIcon as Te } from "element-plus";
import { ElPopover as ve } from "element-plus";
import { ElFormItem as Ce } from "element-plus";
import { ElInputNumber as ke } from "element-plus";
import { ElForm as Ee } from "element-plus";
import { ElTag as we } from "element-plus";
import { d as Pe } from "../../../../../modules/pack-list-1d80c5dd.js";
import { d as xe, p as Ie } from "../../../../../modules/print-record-2e0b6340.js";
import { m as Le, B as Se, bj as h, cM as O, i as F, K as Ue, bL as Ae, bd as Ke, od as G, bi as Qe, bw as H, bK as I, I as ze, C as Re, E as Be } from "../../../../../shared/runtime.js";
import { g as Me } from "../../../../../modules/index-069ba252.js";
import { u as je } from "../../../../../modules/use-label-print-e19db37a.js";
import De from "./ship-label-preview.vue.js";
import "../../../../../modules/index-90569c81.js";
import "../../../../../modules/constant_2-1ad5d80f.js";
import "../../../../../modules/label-logo-8a01bd73.js";
import "../../../../../modules/index-f09320a8.js";
import "../../../../../modules/index-3b2e6e51.js";
const Oe = { style: { "margin-left": "5px" } }, Fe = { key: 0 }, at = { __name: "header", props: { currentProjectType: { type: Number } }, emits: ["getDetail", "changeUnit", "checkboxName", "checkboxMaterial", "checkboxWidth"], setup($, { expose: q, emit: W }) {
  const Y = $, _ = z(), X = z(1), J = W, N = R("permission"), { user: Z, globalProject: L } = Le(["user", "globalProject"]), ee = { serialNumber: void 0, userName: void 0, startDate: void 0, endDate: void 0, remark: void 0, productSerialNumber: void 0, materialTypeArr: { value: void 0, resetAble: false }, projectId: { value: void 0, resetAble: false }, boolAccurateQuery: false, areaBatchName: void 0, monomerName: void 0, status: void 0 }, { crud: s, query: o } = Se(ee), te = { manufacturerName: Z.value.companyName, copies: 1, labelType: h.ONE.V, showMonomer: false, showSpecification: true, showWidth: true, showName: true }, n = ce({ ...te, ...O.get("SHIP_LABEL_PRINT_CONFIG") || {} }), S = w(() => {
    if (F(s.selections)) return s.selections.map((r) => r.id);
  }), U = w(() => {
    const r = [];
    return n.showMonomer && r.push("单体"), r.join("、");
  });
  function oe() {
    if (!F(S.value)) return _e.warning("至少选择一条需要打印的包单信息"), false;
  }
  B(() => L.value, (r) => {
    var t;
    o.productType = void 0, _.value = void 0, _.value = (t = L.value) == null ? void 0 : t.productCategory;
  }, { immediate: true }), B(() => n, () => {
    O.set("SHIP_LABEL_PRINT_CONFIG", n);
  }, { immediate: true, deep: true });
  const { batchPrint: ae, print: le } = je({ getPrintTotalNumber: () => w(() => n.copies).value, getLabelInfo: K, printFinallyHook: s.toQuery, getLoadingTextFunc: (r) => `${r.serialNumber}`, printLabelFunc: Me, needAddPrintRecord: true, addPrintRecordReq: Y.currentProjectType === Ue.BRIDGE.V ? xe : Ie }), A = R("detailStore");
  async function K(r) {
    var f;
    let t = [];
    const T = [], c = [];
    let u = {};
    try {
      A[r.id] ? (u = A[r.id], console.log(u, "_data")) : (u = await Pe(r.id), J("getDetail", r.id, u)), t = u.detailsList;
    } catch (v) {
      console.log("获取详情失败", v);
    }
    return { packageInfo: { serialNumber: r.serialNumber, list: t, structureList: c, auxList: T, productType: r.productType, labelType: n.labelType, project: r.project, monomerName: r.monomerName || ((f = r.monomer) == null ? void 0 : f.name) || "", companyName: n.manufacturerName, unitValue: X.value, showMonomer: n.showMonomer, showSpecification: n.showSpecification, showWidth: n.showWidth, showName: n.showName }, qrCode: JSON.stringify({ id: r.id, type: Ae.MES_PACKAGE, ftype: Ke.MES_PACKAGE_SHIP }) };
  }
  function ne() {
    o.date && o.date.length > 1 ? (o.startDate = D(o.date[0]).valueOf(), o.endDate = D(o.date[1]).valueOf()) : (o.startDate = void 0, o.endDate = void 0), s.toQuery();
  }
  function re(r) {
    r || (n.copies = 1);
  }
  return q({ print: le, getLabelInfo: K }), (r, t) => {
    const T = y("project-radio-button"), c = y("component-radio-button"), u = ge, d = Ve, f = he, v = y("common-radio-button"), se = Ne, ie = Te, C = y("common-button"), Q = ve, k = Ce, ue = ke, de = Ee, me = we, pe = y("print-table"), E = fe("permission");
    return m(), M(be, null, [g(b("div", null, [l(T, { size: "default", modelValue: e(o).projectId, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).projectId = a), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), _.value !== e(G).BOX.V ? (m(), V(c, { key: 0, modelValue: e(o).productType, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).productType = a), options: e(Qe).ENUM, default: "", type: "enum", size: "default", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : P("", true), _.value === e(G).BOX.V ? (m(), V(c, { key: 1, modelValue: e(o).productType, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).productType = a), options: e(H).ENUM, disabledVal: [e(H).AUXILIARY_MATERIAL.V], default: "", type: "enum", size: "default", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"])) : P("", true), l(c, { modelValue: e(o).status, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).status = a), options: [e(I).UNENTRUCK, e(I).ENTRUCK, e(I).SHIPMENT], type: "enum", size: "small", showOptionAll: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(u, { modelValue: e(o).date, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).date = a), type: "daterange", "unlink-panels": "", "range-separator": "至", "start-placeholder": "开始日期", "end-placeholder": "结束日期", size: "default", class: "filter-item", style: { width: "330px" }, clearable: "", shortcuts: e(ze), onChange: ne }, null, 8, ["modelValue", "shortcuts"]), b("div", null, [l(d, { modelValue: e(o).monomerName, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).monomerName = a), placeholder: "输入单体搜索", class: "filter-item", maxlength: "25", style: { width: "180px" }, size: "default", clearable: "", onKeyup: p(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(d, { modelValue: e(o).areaBatchName, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).areaBatchName = a), placeholder: "输入批次搜索", class: "filter-item", maxlength: "25", style: { width: "180px" }, size: "default", clearable: "", onKeyup: p(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(d, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(o).serialNumber = a), placeholder: "输入包单搜索", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "", onKeyup: p(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(d, { modelValue: e(o).userName, "onUpdate:modelValue": t[8] || (t[8] = (a) => e(o).userName = a), placeholder: "输入打包人名称搜索", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "", onKeyup: p(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(d, { modelValue: e(o).remark, "onUpdate:modelValue": t[9] || (t[9] = (a) => e(o).remark = a), placeholder: "输入备注搜索", class: "filter-item", style: { width: "140px" }, size: "default", clearable: "", onKeyup: p(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(d, { modelValue: e(o).productSerialNumber, "onUpdate:modelValue": t[10] || (t[10] = (a) => e(o).productSerialNumber = a), placeholder: "输入产品编号搜索", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: p(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(Re)), l(f, { modelValue: e(o).boolAccurateQuery, "onUpdate:modelValue": t[11] || (t[11] = (a) => e(o).boolAccurateQuery = a), label: "精确査询", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"])])], 512), [[ye, e(s).searchToggle]]), l(e(Be), null, { optRight: i(() => [l(Q, { placement: "bottom-start", width: "400", trigger: "click" }, { reference: i(() => [l(C, { type: "primary", size: "default" }, { default: i(() => t[16] || (t[16] = [j("标签打印设置")])), _: 1, __: [16] })]), default: i(() => [l(de, { ref: "form", model: n, "label-width": "70px" }, { default: i(() => [l(k, { label: "标签样式" }, { default: i(() => [l(v, { modelValue: n.labelType, "onUpdate:modelValue": t[12] || (t[12] = (a) => n.labelType = a), options: e(h).ENUM, type: "enum" }, null, 8, ["modelValue", "options"]), l(Q, { title: e(h).VL[n.labelType], width: 400, placement: "right", teleported: "", trigger: "hover" }, { reference: i(() => [b("div", Oe, [l(C, { size: "default", type: "info" }, { default: i(() => [l(ie, null, { default: i(() => [l(se)]), _: 1 })]), _: 1 })])]), default: i(() => [l(De, { "label-type": n.labelType, "show-monomer": n.showMonomer }, null, 8, ["label-type", "show-monomer"])]), _: 1 }, 8, ["title"])]), _: 1 }), l(k, { label: "显示选项" }, { default: i(() => [l(f, { modelValue: n.showMonomer, "onUpdate:modelValue": t[13] || (t[13] = (a) => n.showMonomer = a), label: "单体" }, null, 8, ["modelValue"])]), _: 1 }), l(k, { label: "份数" }, { default: i(() => [l(ue, { modelValue: n.copies, "onUpdate:modelValue": t[14] || (t[14] = (a) => n.copies = a), step: 1, min: 1, size: "default", style: { width: "250px" }, onChange: re }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }), g((m(), V(me, { hit: "", effect: "plain", size: "large", style: { "margin-left": "5px" } }, { default: i(() => [b("span", null, x(`标签样式：${e(h).VL[n.labelType]}，`), 1), U.value ? (m(), M("span", Fe, x(`显示选项：${U.value}，`), 1)) : P("", true), b("span", null, x(`份数：${n.copies}`), 1)]), _: 1 })), [[E, e(N).print]]), g(l(pe, { params: S.value, "api-key": "mesPackingList", "before-print": oe, size: "default", type: "warning", class: "filter-item", style: { "margin-left": "5px !important" } }, null, 8, ["params"]), [[E, e(N).printPackList]])]), viewLeft: i(() => [g((m(), V(C, { type: "success", size: "default", disabled: e(s).selections.length === 0, onClick: t[15] || (t[15] = (a) => e(ae)(e(s).selections)) }, { default: i(() => t[17] || (t[17] = [j("批量打印标签")])), _: 1, __: [17] }, 8, ["disabled"])), [[E, e(N).print]])]), _: 1 })], 64);
  };
} };
export {
  at as default
};
