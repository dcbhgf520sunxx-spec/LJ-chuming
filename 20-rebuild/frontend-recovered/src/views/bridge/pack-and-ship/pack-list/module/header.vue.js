import { inject as x } from "vue";
import { reactive as W } from "vue";
import { computed as D } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as J } from "vue";
import { withDirectives as b } from "vue";
import { vShow as Z } from "vue";
import { unref as e } from "vue";
import { createElementVNode as ee } from "vue";
import { createVNode as l } from "vue";
import { withKeys as E } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as P } from "vue";
import { createBlock as R } from "vue";
import { toDisplayString as te } from "vue";
import { Fragment as ae } from "vue";
import { ElMessage as ne } from "element-plus";
import z from "moment";
import { ElDatePicker as oe } from "element-plus";
import { ElInput as le } from "element-plus";
import { ElInputNumber as re } from "element-plus";
import { ElFormItem as ie } from "element-plus";
import { ElForm as se } from "element-plus";
import { ElPopover as de } from "element-plus";
import { ElTag as ue } from "element-plus";
import { l as T, m as pe, bw as m, B as me, i as O, D as j, bL as ce, bd as fe, I as _e, C as ge, E as ye } from "../../../../../shared/runtime.js";
import { p as be } from "../../../../../modules/print-record-c36add77.js";
import { b as Ve } from "../../../../../modules/index-069ba252.js";
import { u as he } from "../../../../../modules/use-label-print-47f6f6b0.js";
function ke(u) {
  return T({ module: "bridge", url: "package/page", method: "get", params: u });
}
function Ne(u) {
  return T({ module: "bridge", url: `package/${u}`, method: "get" });
}
function Ce(u) {
  return T({ module: "bridge", url: "package", method: "delete", data: { ids: [u] } });
}
const Le = { get: ke, del: Ce }, ve = { __name: "header", emits: ["getDetail"], setup(u, { expose: B, emit: F }) {
  const K = F, V = x("permission"), { user: Q } = pe(["user"]), U = { serialNumber: void 0, userName: void 0, startDate: void 0, endDate: void 0, remark: void 0, materialTypeArr: { value: void 0, resetAble: false }, productType: m.BOX.V, projectId: { value: void 0, resetAble: false } }, { crud: r, query: a } = me(U), s = W({ manufacturerName: Q.value.companyName, copies: 1 }), I = D(() => {
    if (O(r.selections)) return r.selections.map((n) => n.id);
  });
  function M() {
    if (!O(I.value)) return ne.warning("至少选择一条需要打印的包单信息"), false;
  }
  const { batchPrint: w, print: q } = he({ getPrintTotalNumber: () => D(() => s.copies).value, getLabelInfo: L, printFinallyHook: r.toQuery, getLoadingTextFunc: (n) => `${n.serialNumber}`, printLabelFunc: Ve, needAddPrintRecord: true, addPrintRecordReq: be }), A = x("detailStore"), G = { [m.BOX.V]: "boxList", [m.MACHINE_PART.V]: "partList", [m.AUXILIARY_MATERIAL.V]: "materialList" };
  async function L(n) {
    var c;
    let t = [], p = {};
    try {
      A[n.id] ? p = A[n.id] : (p = await Ne(n.id), K("getDetail", n.id, p)), t = (c = p[G[n.productType]]) == null ? void 0 : c.map((d) => {
        const { serialNumber: h, material: k, packageQuantity: f, netWeight: _, plate: N, length: g } = d;
        return { serialNumber: h, material: k, quantity: f, totalWeight: (f * _).toFixed(j.COM_WT__KG), plate: N, length: g ? g.toFixed(j.MES_ENCLOSURE_L__MM) : 0 };
      });
    } catch (d) {
      console.log("获取详情失败", d);
    }
    return { packageInfo: { serialNumber: n.serialNumber, list: t, productType: n.productType, project: n.project, companyName: s.manufacturerName }, qrCode: JSON.stringify({ id: n.id, type: ce.MES_PACKAGE, ftype: fe.BRIDGE_PACKAGE_SHIP }) };
  }
  function H() {
    a.date && a.date.length > 1 ? (a.startDate = z(a.date[0]).valueOf(), a.endDate = z(a.date[1]).valueOf()) : (a.startDate = void 0, a.endDate = void 0), r.toQuery();
  }
  function $(n) {
    n || (s.copies = 1);
  }
  return B({ print: q, getLabelInfo: L }), (n, t) => {
    const p = y("project-radio-button"), S = y("component-radio-button"), c = oe, d = le, h = re, k = ie, f = se, _ = y("common-button"), N = de, g = ue, Y = y("print-table"), C = X("permission");
    return v(), J(ae, null, [b(ee("div", null, [l(p, { size: "default", modelValue: e(a).projectId, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(a).projectId = o), class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(S, { modelValue: e(a).productType, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(a).productType = o), options: e(m).ENUM, type: "enum", size: "default", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(c, { modelValue: e(a).date, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(a).date = o), type: "daterange", "unlink-panels": "", "range-separator": "至", "start-placeholder": "开始日期", "end-placeholder": "结束日期", size: "default", class: "filter-item", style: { width: "400px" }, clearable: "", shortcuts: e(_e), onChange: H }, null, 8, ["modelValue", "shortcuts"]), l(d, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(a).serialNumber = o), placeholder: "输入包单搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: E(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(d, { modelValue: e(a).userName, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(a).userName = o), placeholder: "输入打包人名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: E(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(d, { modelValue: e(a).remark, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(a).remark = o), placeholder: "输入备注搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: E(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(ge))], 512), [[Z, e(r).searchToggle]]), l(e(ye), null, { optRight: i(() => [l(N, { placement: "bottom-start", width: "400", trigger: "click" }, { reference: i(() => [l(_, { type: "primary", size: "default" }, { default: i(() => t[8] || (t[8] = [P("标签打印设置")])), _: 1, __: [8] })]), default: i(() => [l(f, { ref: "form", model: s }, { default: i(() => [l(k, { label: "份数" }, { default: i(() => [l(h, { modelValue: s.copies, "onUpdate:modelValue": t[6] || (t[6] = (o) => s.copies = o), step: 1, min: 1, size: "default", style: { width: "250px" }, onChange: $ }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }), b((v(), R(g, { hit: "", effect: "plain", size: "large", style: { "margin-left": "5px" } }, { default: i(() => [P(te(`份数：${s.copies}`), 1)]), _: 1 })), [[C, e(V).print]]), b(l(Y, { "api-key": "bridgePackingList", params: I.value, "before-print": M, size: "default", type: "warning", class: "filter-item", style: { "margin-left": "5px !important" } }, null, 8, ["params"]), [[C, e(V).printPackList]])]), viewLeft: i(() => [b((v(), R(_, { type: "success", size: "default", disabled: e(r).selections.length === 0, onClick: t[7] || (t[7] = (o) => e(w)(e(r).selections)) }, { default: i(() => t[9] || (t[9] = [P("批量打印标签")])), _: 1, __: [9] }, 8, ["disabled"])), [[C, e(V).print]])]), _: 1 })], 64);
  };
} }, Se = Object.freeze(Object.defineProperty({ __proto__: null, default: ve }, Symbol.toStringTag, { value: "Module" }));
export {
  ve as _,
  Le as c,
  Ne as d,
  Se as h
};
