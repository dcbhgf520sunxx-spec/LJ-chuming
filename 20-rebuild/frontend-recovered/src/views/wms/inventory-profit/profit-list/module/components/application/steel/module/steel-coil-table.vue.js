import { ref as ce } from "vue";
import { inject as T } from "vue";
import { computed as pe } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as me } from "vue";
import { openBlock as L } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as o } from "vue";
import { createVNode as s } from "vue";
import { unref as d } from "vue";
import { createElementVNode as c } from "vue";
import { createTextVNode as m } from "vue";
import { withDirectives as he } from "vue";
import { toDisplayString as V } from "vue";
import { createCommentVNode as j } from "vue";
import { createSlots as ge } from "vue";
import { mergeProps as fe } from "vue";
import { reactive as R } from "vue";
import { watchEffect as be } from "vue";
import { watch as x } from "vue";
import { ElInput as ye } from "element-plus";
import { ElTableColumn as Ie } from "element-plus";
import { ElTooltip as Ve } from "element-plus";
import { am as ke, sQ as we, v7 as Ce, v5 as Le, xW as _e, xX as xe, ll as Ue, aR as ve, fv as Ne, r8 as We, r9 as Pe, xY as Te, c9 as U, aw as je, aI as A, va as Re, i as f, iX as q, D as S, b as Ae } from "../../../../../../../../../shared/runtime.js";
import qe from "../../price-set-columns.vue.js";
import { _ as Se } from "../../../../../../../../../modules/supplier-select-0ce6adf5.js";
const $e = { class: "mtb-10", style: { "margin-left": "30px" } }, Fe = { __name: "steel-coil-table", props: { repeatList: { type: Array, default: () => [] } }, setup($, { expose: D }) {
  var P;
  const k = ce([]), z = $, B = ke.STEEL_COIL.V;
  function E({ row: e, rowIndex: l }) {
    var a;
    if ((a = z.repeatList) != null && a.includes(e.uid)) return { backgroundColor: "#ffdede" };
  }
  const i = (P = T("crud")) == null ? void 0 : P.form, w = T("matSpecRef"), { baseUnit: p } = we(B), { overDiffTip: De, weightOverDiff: M, diffSubmitValidate: ze } = Ce(p), { projectAllType: v } = Le(), { workshopNameV2: N } = _e(), { warehouseV2: W } = xe(), { suppliers: O } = Ue(), F = (e, l) => f(l.weighingTotalWeight) && f(l.unitPrice) ? +q(l.weighingTotalWeight * l.unitPrice, S.YUAN) == +e : false, K = (e, l) => f(e) ? e > 0 : true, Y = pe(() => {
    const e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: U, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: U, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: U, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { validator: K, message: "长度必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], materialIsWhole: [{ required: true, message: "请选择整料/余料", trigger: "change" }] };
    return i.boolPartyA ? Object.assign(e, { projectId: [{ required: true, message: "请选择项目", trigger: "blur" }] }) : Object.assign(e, { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: F, message: "金额有误，请手动修改", trigger: "blur" }] }), e;
  }), J = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1], ["supplierId", -1], ["materialIsWhole", -1]]), { tableValidate: X, wrongCellMask: Q, cleanUpData: G } = je({ rules: Y, errorMsg: "请修正【钢卷清单】中标红的信息", ditto: J });
  function H(e) {
    const l = R({ uid: A(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, color: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0, heatNoAndBatchNo: void 0, brand: void 0, projectId: i.steelCoilList.length > 0 ? -1 : void 0, workshopId: i.steelCoilList.length > 0 ? -1 : void 0, warehouseId: i.steelCoilList.length > 0 ? -1 : void 0, supplierId: i.steelCoilList.length > 0 ? -1 : void 0, materialIsWhole: i.steelCoilList.length > 0 ? -1 : void 0, mete: void 0 });
    return C(l), l;
  }
  function C(e) {
    be(() => M(e)), x([() => e.weighingTotalWeight, () => e.width, () => e.thickness, p], () => Z(e), { immediate: true }), x([() => e.theoryLength], () => te(e), { immediate: true }), x(() => e.weighingTotalWeight, () => {
      ee(e);
    }, { immediate: true });
  }
  async function Z(e) {
    e.theoryLength = await Re({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness }), e.quantity = e.theoryLength, e.mete = e.weighingTotalWeight;
  }
  function ee(e) {
    f(e.unitPrice) && f(e.weighingTotalWeight) ? e.amount = q(e.weighingTotalWeight * e.unitPrice, S.YUAN) : e.amount = void 0;
  }
  function te(e) {
    f(e.theoryLength) ? e.length = e.theoryLength * 1 : e.length = void 0;
  }
  function le(e, l) {
    var r;
    const a = R(JSON.parse(JSON.stringify(e)));
    a.uid = A(), a.rowIndex = i.steelPlateList.length, a.projectId = e.projectId ? e.projectId : -1, a.workshopId = e.workshopId ? e.workshopId : -1, a.warehouseId = e.warehouseId ? e.warehouseId : -1, a.supplierId = e.supplierId ? e.supplierId : -1, a.materialIsWhole = e.materialIsWhole ? e.materialIsWhole : -1, i.steelCoilList.push(a), C(a), (r = w.value) == null || r.initSelected([a]);
  }
  function ae(e, l, a) {
    w.value ? w.value.delListItem(e, l) : i.steelCoilList.splice(l, 1);
  }
  function se(e) {
    const l = v.value.find((a) => a.id === e.projectId);
    e.project = l;
  }
  function ie(e) {
    const l = N.value.find((a) => a.id === e.workshopId);
    e.workshop = l;
  }
  function oe(e) {
    const l = W.value.find((a) => a.id === e.warehouseId);
    e.warehouse = l;
  }
  function ne() {
    if (Ae(i.steelCoilList)) return true;
    const { validResult: e, dealList: l } = X(i.steelCoilList);
    return e && re(l), e;
  }
  function re(e) {
    G(e), e.forEach((l, a) => {
      var r, b, g, y;
      i.steelCoilList[a].projectId = l.projectId, i.steelCoilList[a].project = (r = v.value) == null ? void 0 : r.find((h) => i.steelCoilList[a].projectId === h.id), i.steelCoilList[a].workshopId = l.workshopId, i.steelCoilList[a].workshop = (b = N.value) == null ? void 0 : b.find((h) => i.steelCoilList[a].workshopId === h.id), i.steelCoilList[a].warehouseId = l.warehouseId, i.steelCoilList[a].warehouse = (g = W.value) == null ? void 0 : g.find((h) => i.steelCoilList[a].warehouseId === h.id), i.steelCoilList[a].supplierId = l.supplierId, i.steelCoilList[a].supplier = (y = O.value) == null ? void 0 : y.find((h) => i.steelCoilList[a].supplierId === h.id), i.steelCoilList[a].materialIsWhole = l.materialIsWhole;
    });
  }
  return D({ rowInit: H, rowWatch: C, validate: ne }), (e, l) => {
    const a = ye, r = Ie, b = Ve, g = I("common-input-number"), y = I("common-select"), h = I("common-button"), de = I("common-table"), ue = me("empty-text");
    return L(), _(de, fe({ "cell-class-name": d(Q), data: d(i).steelCoilList, "row-style": E, "show-empty-symbol": false, stripe: false, "return-source-data": "", "expand-row-keys": k.value, "row-key": "uid" }, e.$attrs), { default: o(() => [s(ve, { "expand-row-keys": k.value, "onUpdate:expandRowKeys": l[0] || (l[0] = (t) => k.value = t), data: d(i).steelCoilList, "row-key": "uid", fixed: "left" }, { default: o(({ row: t }) => [c("div", $e, [s(a, { modelValue: t.remark, "onUpdate:modelValue": (n) => t.remark = n, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(r, { align: "center", label: "序号", type: "index", width: "60" }), s(r, { align: "center", label: "编号", prop: "serialNumber" }, { header: o(() => l[1] || (l[1] = [c("span", { style: { color: "red" } }, "*", -1), m("编号 ")])), _: 1 }), s(r, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { header: o(() => l[2] || (l[2] = [c("span", { style: { color: "red" } }, "*", -1), m("物料种类 ")])), default: o(({ row: t }) => [s(b, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [he(c("span", null, null, 512), [[ue, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(r, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { header: o(() => l[3] || (l[3] = [c("span", { style: { color: "red" } }, "*", -1), m("规格 ")])), default: o(({ row: t }) => [s(b, { content: t.specificationLabels, placement: "top" }, { default: o(() => [c("span", null, V(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(r, { key: "weighingTotalWeight", label: `总重 (${d(p).weight.unit})`, align: "center", "min-width": "100", prop: "weighingTotalWeight" }, { header: o(() => [l[4] || (l[4] = c("span", { style: { color: "red" } }, "*", -1)), m("总重 (" + V(d(p).weight.unit) + ") ", 1)]), default: o(({ row: t }) => [s(g, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (n) => t.weighingTotalWeight = n, controls: false, max: 999999999, min: 0, precision: d(p).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(r, { align: "center", label: "颜色", "min-width": "140px", prop: "color" }, { default: o(({ row: t }) => [s(a, { modelValue: t.color, "onUpdate:modelValue": (n) => t.color = n, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(r, { label: `厚 (${d(p).thickness.unit})`, align: "center", prop: "thickness" }, { header: o(() => [l[5] || (l[5] = c("span", { style: { color: "red" } }, "*", -1)), m("厚 (" + V(d(p).thickness.unit) + ") ", 1)]), default: o(({ row: t }) => [s(g, { modelValue: t.thickness, "onUpdate:modelValue": (n) => t.thickness = n, controls: false, max: 99999999, min: 0, precision: d(p).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(r, { label: `宽 (${d(p).width.unit})`, align: "center", prop: "width" }, { header: o(() => [l[6] || (l[6] = c("span", { style: { color: "red" } }, "*", -1)), m("宽 (" + V(d(p).width.unit) + ") ", 1)]), default: o(({ row: t }) => [s(g, { modelValue: t.width, "onUpdate:modelValue": (n) => t.width = n, controls: false, max: 99999999, min: 0, precision: d(p).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(r, { label: "长 (m)", align: "center", prop: "length" }, { header: o(() => l[7] || (l[7] = [c("span", { style: { color: "red" } }, "*", -1), m("长 (m) ")])), default: o(({ row: t }) => [s(g, { modelValue: t.length, "onUpdate:modelValue": (n) => t.length = n, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), d(i).boolPartyA ? j("", true) : (L(), _(qe, { key: 0, "is-required-identifier": "" })), s(r, { align: "center", label: "品牌", "min-width": "150", prop: "brand" }, { default: o(({ row: t }) => [s(a, { modelValue: t.brand, "onUpdate:modelValue": (n) => t.brand = n, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(r, { align: "center", label: "炉批号/卷号", "min-width": "150", prop: "heatNoAndBatchNo" }, { default: o(({ row: t }) => [s(a, { modelValue: t.heatNoAndBatchNo, "onUpdate:modelValue": (n) => t.heatNoAndBatchNo = n, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号/卷号", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(r, { align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, ge({ default: o(({ row: t, $index: n }) => [s(Ne, { modelValue: t.projectId, "onUpdate:modelValue": (u) => t.projectId = u, "show-extra": n !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (u) => se(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 2 }, [d(i).boolPartyA ? { name: "header", fn: o(() => [l[8] || (l[8] = c("span", { style: { color: "red" } }, "*", -1)), l[9] || (l[9] = m("所属项目 "))]), key: "0" } : void 0]), 1024), s(r, { align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { header: o(() => l[10] || (l[10] = [c("span", { style: { color: "red" } }, "*", -1), m("仓库 ")])), default: o(({ row: t, $index: n }) => [s(We, { modelValue: t.workshopId, "onUpdate:modelValue": (u) => t.workshopId = u, "show-extra": n !== 0, clearable: "", placeholder: "请选择仓库", style: { width: "100%" }, onChange: (u) => ie(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), s(r, { align: "center", label: "存储位置", prop: "warehouseId", width: "140px" }, { header: o(() => l[11] || (l[11] = [c("span", { style: { color: "red" } }, "*", -1), m("存储位置 ")])), default: o(({ row: t, $index: n }) => [s(Pe, { modelValue: t.warehouseId, "onUpdate:modelValue": (u) => t.warehouseId = u, "basic-class": t.basicClass, "show-extra": n !== 0, "workshop-id": t.workshopId, clearable: "", placeholder: "请选择存储位置", style: { width: "100%" }, onChange: (u) => oe(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra", "workshop-id", "onChange"])]), _: 1 }), d(i).boolPartyA ? j("", true) : (L(), _(r, { key: 1, align: "center", label: "供应商", prop: "supplierId", width: "140px" }, { default: o(({ row: t, $index: n }) => [s(Se, { ref: "supplierRef", modelValue: t.supplierId, "onUpdate:modelValue": (u) => t.supplierId = u, "basic-class": d(i).materialType, "show-extra": n !== 0, clearable: "", filterable: "", mode: "cross" }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra"])]), _: 1 })), s(r, { align: "center", label: "整料/余料", prop: "materialIsWhole", width: "140px" }, { header: o(() => l[12] || (l[12] = [c("span", { style: { color: "red" } }, "*", -1), m("整料/余料 ")])), default: o(({ row: t, $index: n }) => [s(y, { modelValue: t.materialIsWhole, "onUpdate:modelValue": (u) => t.materialIsWhole = u, options: d(Te).ENUM, "show-extra": n !== 0, clearable: "", placeholder: "请选择整料/余料", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), s(r, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: o(({ row: t, $index: n }) => [s(h, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (u) => le(t, t.rowIndex) }, null, 8, ["onClick"]), s(h, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (u) => ae(t.sn, n, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  Fe as default
};
