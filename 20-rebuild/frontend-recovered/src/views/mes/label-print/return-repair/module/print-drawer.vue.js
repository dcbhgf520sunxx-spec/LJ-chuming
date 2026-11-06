import { ref as i } from "vue";
import { provide as x } from "vue";
import { computed as se } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as U } from "vue";
import { createBlock as j } from "vue";
import { withCtx as o } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as y } from "vue";
import { withDirectives as ue } from "vue";
import { unref as r } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as pe } from "vue";
import { createSlots as me } from "vue";
import { isRef as de } from "vue";
import { ElMessage as ce } from "element-plus";
import { ElTag as fe } from "element-plus";
import { ElTableColumn as be } from "element-plus";
import { ElInputNumber as ye } from "element-plus";
import { vLoading as ve } from "element-plus";
import { g as ge, m as _e, a as he } from "./print-header.vue.js";
import { u as we, o as Ce, a3 as Te, mz as xe, bs as z, D as k, p as B, bo as ke, bd as Ne } from "../../../../../shared/runtime.js";
import { e as Ve } from "../../../../../modules/index-069ba252.js";
import Re from "../../components/task-printed-record-drawer.vue.js";
import { o as H } from "../../../../../modules/one-code-number-list-af2f89eb.js";
import Ie from "../../components/label-dlg.vue.js";
import "../../../../../modules/label-6ff6c88d.js";
import "../../../../../modules/use-label-print-e19db37a.js";
import "../../../../../modules/constant_2-1ad5d80f.js";
import "../../../../../modules/label-logo-8a01bd73.js";
import "../../../../../modules/index-f09320a8.js";
import "../../../../../modules/index-90569c81.js";
import "../../../../../modules/index-3b2e6e51.js";
const $e = { __name: "print-drawer", props: { visible: { type: Boolean, default: false }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(K, { emit: G }) {
  const D = i(), Y = G, N = K, { visible: v, handleClose: J } = we({ emit: Y, props: N, field: "visible", showHook: te }), { maxHeight: X } = Ce({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, () => D.value.loaded), E = i([]), g = i(false), M = i([]);
  x("selections", M);
  const V = i(false), R = i({}), F = i(), I = i(false), _ = i(), h = Te.ARTIFACT.V;
  x("productType", h);
  const Z = xe.ARTIFACT.V;
  x("printType", Z);
  x("labelProjectId", se(() => N.detailInfo?.projectId));
  const P = se(() => {
    var e, t;
    return (t = (e = _.value) == null ? void 0 : e.printConfig) == null ? void 0 : t.type;
  }), ee = i(), w = i(false), W = i(), m = i([]), c = i([]), C = i();
  function te() {
    q();
  }
  function ae(e) {
    M.value = e;
  }
  async function q() {
    var e, t;
    if ((e = N.detailInfo) != null && e.projectId) {
      g.value = true;
      try {
        const { content: s } = await ge({ projectId: (t = N.detailInfo) == null ? void 0 : t.projectId });
        E.value = s.map((n) => (n.printedQuantity = n.printQuantity, n.printQuantity = n.returnQuantity, n.quantity = n.returnQuantity, n));
      } catch (s) {
        console.log(s);
      } finally {
        g.value = false;
      }
    }
  }
  function Q(e, t) {
    const { printConfig: s, spliceQrCodeUrl: n, QR_SCAN_PATH: A, requestUrl: O, companyName: f } = _.value, S = { projectName: e.project.shortName, projectSerialNumber: e.project.serialNumber, printTime: e.printTime ? B(e.printTime, "{y}/{m}/{d}") : B((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: e.monomer.name, areaName: e.area.name, name: e.name, serialNumber: e.serialNumber, oneCode: e.boolOneCode ? t ? `${t}/${e.quantity}` : "-" : "", quantity: e.quantity, specification: e.specification, drawingNumber: e.drawingNumber, weight: s.weight === ke.NET.V ? e.netWeight.toFixed(k.COM_WT__KG) : e.grossWeight.toFixed(k.COM_WT__KG), length: e.length, isReturnRepair: true }, L = O, d = { id: e.id, ftype: Ne.MEW_PRODUCTION, factoryId: e.factoryId, taskId: e == null ? void 0 : e.taskId, whId: e == null ? void 0 : e.warehouseId, type: h, wt: s.weight, sa: Number(s.showArea), sm: Number(s.showMonomer) };
    return d.taskId || delete d.taskId, d.whId || delete d.whId, e.boolOneCode && (d.num = t), { productType: h, labelType: P.value, component: S, manufacturerName: s.manufacturerName || f, qrCode: n(`${L}${A.ARTIFACT_TASK}`, d), quantityName: "任务数(件)", printConfig: s };
  }
  async function le() {
    var e;
    if (!((e = c.value) != null && e.length)) {
      ce.warning("请选择需要打印的一物一码编号");
      return;
    }
    try {
      const { row: t } = W.value;
      t.numberList = c.value, t.printQuantity = c.value.length, await $(t);
    } catch (t) {
      console.log("一物一码打印标签失败", t);
    } finally {
      w.value = false;
    }
  }
  function ne(e) {
    e.boolOneCode ? (m.value = e.numberStatusDTOS, W.value = { row: e }, c.value = [], w.value = true) : $(e);
  }
  function oe(e) {
    ee.value = e, e.boolOneCode ? (m.value = e.numberStatusDTOS, C.value = m.value.length ? m.value[0].number : null, R.value = Q(e, C.value)) : (m.value = [], R.value = Q(e)), V.value = true;
  }
  function ie(e) {
    F.value = e.warehouseId, I.value = true;
  }
  async function $(e) {
    try {
      await _.value.print([e]);
    } catch (t) {
      console.log("打印标签失败", t);
    }
  }
  return x("headerObj", { getLabelInfo: Q, printLabelFunc: Ve }), (e, t) => {
    const s = fe, n = be, A = b("table-cell-tag"), O = ye, f = b("common-button"), S = b("common-table"), L = b("common-dialog"), d = b("common-drawer"), re = ve;
    return U(), j(d, { ref_key: "drawerRef", ref: D, title: "标签打印", modelValue: r(v), "onUpdate:modelValue": t[5] || (t[5] = (a) => de(v) ? v.value = a : null), direction: "rtl", "before-close": r(J), size: "80%" }, { titleAfter: o(() => [l(s, { type: "success" }, { default: o(() => t[6] || (t[6] = [y("项目")])), _: 1, __: [6] })]), titleRight: o(() => [l(_e, { onRefresh: q, ref_key: "headRef", ref: _ }, null, 512)]), content: o(() => [ue((U(), j(S, { data: E.value, "max-height": r(X), style: { width: "100%" }, onSelectionChange: ae }, { default: o(() => [l(n, { align: "center", type: "selection", width: "55" }), l(n, { label: "序号", type: "index", align: "center", width: "60" }), l(n, { key: "name", "show-overflow-tooltip": "", align: "center", label: "名称", "min-width": "80px", prop: "name" }, { default: o((a) => [l(A, { offset: 15, show: !!a.row.boolPrinted, color: "#e64242", name: "已打印" }, null, 8, ["show"]), u("span", null, p(a.row.name), 1)]), _: 1 }), l(n, { key: "serialNumber", "show-overflow-tooltip": "", label: "编号", "min-width": "140px", prop: "serialNumber" }, { default: o((a) => [u("span", null, p(a.row.serialNumber), 1)]), _: 1 }), l(n, { key: "specification", "show-overflow-tooltip": "", label: "规格", "min-width": "140px", prop: "specification" }, { default: o((a) => [u("span", null, p(a.row.specification), 1)]), _: 1 }), l(n, { key: "length", label: `长度
(mm)`, "show-overflow-tooltip": "", align: "center", "min-width": "80px", prop: "length" }, { default: o((a) => [y(p(r(z)(a.row.length, r(k).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), l(n, { key: "material", "show-overflow-tooltip": "", label: "材质", "min-width": "80px", prop: "material" }, { default: o((a) => [u("span", null, p(a.row.material), 1)]), _: 1 }), l(n, { key: "returnQuantity", "show-overflow-tooltip": "", align: "center", label: "返厂数量", "min-width": "80px", prop: "returnQuantity" }, { default: o((a) => [u("span", null, p(a.row.returnQuantity), 1)]), _: 1 }), l(n, { key: "netWeight", label: `单净重
(kg)`, "show-overflow-tooltip": "", align: "center", "min-width": "80px", prop: "netWeight" }, { default: o((a) => [y(p(r(z)(a.row.netWeight, r(k).COM_WT__KG)), 1)]), _: 1 }), l(n, { key: "shipQuantity", align: "center", "show-overflow-tooltip": "", label: "发运数量", "min-width": "80px", prop: "shipQuantity" }, { default: o((a) => [u("span", null, p(a.row.shipQuantity), 1)]), _: 1 }), l(n, { key: "printQuantity", align: "center", label: "打印数量", prop: "printQuantity", width: "120px" }, { default: o(({ row: { sourceRow: a } }) => [!g.value && r(v) ? (U(), j(O, { key: 0, modelValue: a.printQuantity, "onUpdate:modelValue": (T) => a.printQuantity = T, disabled: a.boolOneCode, min: 0, step: 1, "controls-position": "right", size: "small", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])) : pe("", true)]), _: 1 }), l(n, { align: "center", fixed: "right", label: "操作", width: "225px" }, { default: o(({ row: { sourceRow: a } }) => [l(f, { icon: "el-icon-printer", size: "small", type: "success", onClick: (T) => ne(a) }, null, 8, ["onClick"]), l(f, { icon: "el-icon-view", size: "small", type: "primary", onClick: (T) => oe(a) }, null, 8, ["onClick"]), l(f, { size: "small", type: "info", onClick: (T) => ie(a) }, { default: o(() => t[7] || (t[7] = [y("打印记录")])), _: 2, __: [7] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[re, g.value]]), l(Re, { visible: I.value, "onUpdate:visible": t[0] || (t[0] = (a) => I.value = a), getPrintRecord: r(he), "task-id": F.value }, null, 8, ["visible", "getPrintRecord", "task-id"]), l(r(Ie), { visible: V.value, "onUpdate:visible": t[2] || (t[2] = (a) => V.value = a), "label-data": R.value, labelType: P.value, productType: r(h) }, me({ _: 2 }, [m.value.length ? { name: "oneCode", fn: o(() => [l(r(H), { modelValue: C.value, "onUpdate:modelValue": t[1] || (t[1] = (a) => C.value = a), list: m.value, "max-height": 80, multiple: false, tagWidth: 100, style: { "margin-bottom": "15px" } }, { suffix: o(({ data: a }) => [t[8] || (t[8] = u("span", { style: { "margin-left": "5px", "margin-right": "5px" } }, " | ", -1)), u("span", null, p(a.name), 1)]), _: 1 }, 8, ["modelValue", "list"])]), key: "0" } : void 0]), 1032, ["visible", "label-data", "labelType", "productType"]), l(L, { modelValue: w.value, "onUpdate:modelValue": t[4] || (t[4] = (a) => w.value = a), center: false, "close-on-click-modal": false, title: "选择一物一码编号", width: "450px" }, { titleRight: o(() => [l(f, { size: "small", type: "primary", onClick: le }, { default: o(() => t[9] || (t[9] = [y("确认")])), _: 1, __: [9] })]), default: o(() => [l(r(H), { modelValue: c.value, "onUpdate:modelValue": t[3] || (t[3] = (a) => c.value = a), list: m.value }, { suffix: o(({ data: a }) => [t[10] || (t[10] = u("span", { style: { "margin-left": "5px", "margin-right": "5px" } }, " | ", -1)), u("span", null, p(a.name), 1)]), _: 1 }, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  $e as default
};
