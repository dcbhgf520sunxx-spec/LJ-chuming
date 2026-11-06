import { ref as he } from "vue";
import { inject as j } from "vue";
import { computed as me } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as ge } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as N } from "vue";
import { withCtx as i } from "vue";
import { createVNode as s } from "vue";
import { unref as r } from "vue";
import { createElementVNode as c } from "vue";
import { createTextVNode as h } from "vue";
import { withDirectives as fe } from "vue";
import { toDisplayString as b } from "vue";
import { normalizeClass as ye } from "vue";
import { createCommentVNode as A } from "vue";
import { createSlots as be } from "vue";
import { mergeProps as Ie } from "vue";
import { reactive as R } from "vue";
import { watchEffect as Ve } from "vue";
import { watch as U } from "vue";
import { ElInput as ke } from "element-plus";
import { ElTableColumn as we } from "element-plus";
import { ElTooltip as Pe } from "element-plus";
import { am as ve, sQ as We, v7 as _e, v5 as Ne, xW as Ue, xX as xe, ll as Le, aR as Te, fv as Ce, r8 as qe, r9 as je, xY as Ae, c9 as Re, aw as $e, aI as $, sT as Se, i as f, iX as k, D as S, b as ze } from "../../../../../../../../../shared/runtime.js";
import De from "../../price-set-columns.vue.js";
import { _ as Ee } from "../../../../../../../../../modules/supplier-select-0ce6adf5.js";
const Be = { class: "mtb-10", style: { "margin-left": "30px" } }, Ye = { __name: "steel-plate-table", props: { repeatList: { type: Array, default: () => [] } }, setup(z, { expose: D }) {
  var q;
  const w = he([]), E = z, B = ve.STEEL_PLATE.V;
  function M({ row: e, rowIndex: l }) {
    var a;
    if ((a = E.repeatList) != null && a.includes(e.uid)) return { backgroundColor: "#ffdede" };
  }
  const n = (q = j("crud")) == null ? void 0 : q.form, P = j("matSpecRef"), { baseUnit: u } = We(B), { overDiffTip: O, weightOverDiff: F, diffSubmitValidate: K } = _e(u), { projectAllType: x } = Ne(), { workshopNameV2: L } = Ue(), { warehouseV2: T } = xe(), { suppliers: Y } = Le(), J = (e, l) => f(l.weighingTotalWeight) && f(l.unitPrice) ? +k(l.weighingTotalWeight * l.unitPrice, S.YUAN) == +e : false, X = (e, l) => f(e) ? e >= 0 : true, v = (e, l) => f(e) ? e > 0 : true, Q = me(() => {
    const e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { validator: v, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: v, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: K, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: Re, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { validator: v, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: X, message: "数量必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], materialIsWhole: [{ required: true, message: "请选择整料/余料", trigger: "change" }] };
    return n.boolPartyA ? Object.assign(e, { projectId: [{ required: true, message: "请选择项目", trigger: "blur" }] }) : Object.assign(e, { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: J, message: "金额有误，请手动修改", trigger: "blur" }] }), e;
  }), G = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1], ["supplierId", -1], ["materialIsWhole", -1]]), { tableValidate: H, wrongCellMask: Z, cleanUpData: ee } = $e({ rules: Q, errorMsg: "请修正【钢板清单】中标红的信息", ditto: G });
  function te(e) {
    const l = R({ uid: $(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, heatNoAndBatchNo: void 0, brand: void 0, projectId: n.steelPlateList.length > 0 ? -1 : void 0, workshopId: n.steelPlateList.length > 0 ? -1 : void 0, warehouseId: n.steelPlateList.length > 0 ? -1 : void 0, supplierId: n.steelPlateList.length > 0 ? -1 : void 0, materialIsWhole: n.steelPlateList.length > 0 ? -1 : void 0, mete: void 0 });
    return W(l), l;
  }
  function W(e) {
    Ve(() => F(e)), U([() => e.length, () => e.width, () => e.thickness, u], () => {
      le(e);
    }), U([() => e.theoryWeight, () => e.quantity], () => {
      ae(e);
    }), U(() => e.weighingTotalWeight, () => {
      C(e);
    });
  }
  async function le(e) {
    e.theoryWeight = await Se({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function ae(e) {
    f(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = k(e.theoryWeight * e.quantity, u.value.weight.precision), e.weighingTotalWeight = k(e.theoryWeight * e.quantity, u.value.weight.precision), e.mete = e.weighingTotalWeight) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0, e.mete = void 0);
  }
  function C(e) {
    f(e.unitPrice) && f(e.weighingTotalWeight) ? e.amount = k(e.weighingTotalWeight * e.unitPrice, S.YUAN) : e.amount = void 0;
  }
  function se(e, l) {
    var d;
    const a = R(JSON.parse(JSON.stringify(e)));
    a.uid = $(), a.rowIndex = n.steelPlateList.length, a.projectId = e.projectId ? e.projectId : -1, a.workshopId = e.workshopId ? e.workshopId : -1, a.warehouseId = e.warehouseId ? e.warehouseId : -1, a.supplierId = e.supplierId ? e.supplierId : -1, a.materialIsWhole = e.materialIsWhole ? e.materialIsWhole : -1, n.steelPlateList.push(a), W(a), (d = P.value) == null || d.initSelected([a]);
  }
  function ie(e, l, a) {
    P.value ? P.value.delListItem(e, l) : n.steelPlateList.splice(l, 1);
  }
  function ne(e) {
    const l = x.value.find((a) => a.id === e.projectId);
    e.project = l;
  }
  function oe(e) {
    const l = L.value.find((a) => a.id === e.workshopId);
    e.workshop = l;
  }
  function re(e) {
    const l = T.value.find((a) => a.id === e.warehouseId);
    e.warehouse = l;
  }
  function de() {
    if (ze(n.steelPlateList)) return true;
    const { validResult: e, dealList: l } = H(n.steelPlateList);
    return e && ue(l), e;
  }
  function ue(e) {
    ee(e), e.forEach((l, a) => {
      var d, y, g, I;
      n.steelPlateList[a].projectId = l.projectId, n.steelPlateList[a].project = (d = x.value) == null ? void 0 : d.find((m) => n.steelPlateList[a].projectId === m.id), n.steelPlateList[a].workshopId = l.workshopId, n.steelPlateList[a].workshop = (y = L.value) == null ? void 0 : y.find((m) => n.steelPlateList[a].workshopId === m.id), n.steelPlateList[a].warehouseId = l.warehouseId, n.steelPlateList[a].warehouse = (g = T.value) == null ? void 0 : g.find((m) => n.steelPlateList[a].warehouseId === m.id), n.steelPlateList[a].supplierId = l.supplierId, n.steelPlateList[a].supplier = (I = Y.value) == null ? void 0 : I.find((m) => n.steelPlateList[a].supplierId === m.id), n.steelPlateList[a].materialIsWhole = l.materialIsWhole;
    });
  }
  return D({ rowInit: te, rowWatch: W, validate: de }), (e, l) => {
    const a = ke, d = we, y = Pe, g = V("common-input-number"), I = V("common-select"), m = V("common-button"), ce = V("common-table"), pe = ge("empty-text");
    return _(), N(ce, Ie({ "cell-class-name": r(Z), data: r(n).steelPlateList, "row-style": M, "show-empty-symbol": false, stripe: false, "return-source-data": "", "expand-row-keys": w.value, "row-key": "uid" }, e.$attrs), { default: i(() => [s(Te, { "expand-row-keys": w.value, "onUpdate:expandRowKeys": l[0] || (l[0] = (t) => w.value = t), data: r(n).steelPlateList, "row-key": "uid", fixed: "left" }, { default: i(({ row: t }) => [c("div", Be, [s(a, { modelValue: t.remark, "onUpdate:modelValue": (o) => t.remark = o, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(d, { align: "center", label: "序号", type: "index", width: "60" }), s(d, { align: "center", label: "编号", prop: "serialNumber" }, { header: i(() => l[1] || (l[1] = [c("span", { style: { color: "red" } }, "*", -1), h("编号 ")])), _: 1 }), s(d, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { header: i(() => l[2] || (l[2] = [c("span", { style: { color: "red" } }, "*", -1), h("物料种类 ")])), default: i(({ row: t }) => [s(y, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: i(() => [fe(c("span", null, null, 512), [[pe, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(d, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { header: i(() => l[3] || (l[3] = [c("span", { style: { color: "red" } }, "*", -1), h("规格 ")])), default: i(({ row: t }) => [s(y, { content: t.specificationLabels, placement: "top" }, { default: i(() => [c("span", null, b(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(d, { label: `厚 (${r(u).thickness.unit})`, align: "center", "min-width": "100", prop: "thickness" }, { header: i(() => [l[4] || (l[4] = c("span", { style: { color: "red" } }, "*", -1)), h("厚 (" + b(r(u).thickness.unit) + ") ", 1)]), default: i(({ row: t }) => [s(g, { modelValue: t.thickness, "onUpdate:modelValue": (o) => t.thickness = o, controls: false, max: 99999999, min: 0, precision: r(u).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(d, { label: `宽 (${r(u).width.unit})`, align: "center", "min-width": "100", prop: "width" }, { header: i(() => [l[5] || (l[5] = c("span", { style: { color: "red" } }, "*", -1)), h("宽 (" + b(r(u).width.unit) + ") ", 1)]), default: i(({ row: t }) => [s(g, { modelValue: t.width, "onUpdate:modelValue": (o) => t.width = o, controls: false, max: 99999999, min: 0, precision: r(u).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(d, { label: `长 (${r(u).length.unit})`, align: "center", "min-width": "100", prop: "length" }, { header: i(() => [l[6] || (l[6] = c("span", { style: { color: "red" } }, "*", -1)), h("长 (" + b(r(u).length.unit) + ") ", 1)]), default: i(({ row: t }) => [s(g, { modelValue: t.length, "onUpdate:modelValue": (o) => t.length = o, controls: false, max: 999999999, min: 0, precision: r(u).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(d, { label: `数量 (${r(u).measure.unit})`, align: "center", prop: "quantity" }, { header: i(() => [l[7] || (l[7] = c("span", { style: { color: "red" } }, "*", -1)), h("数量 (" + b(r(u).measure.unit) + ") ", 1)]), default: i(({ row: t }) => [s(g, { modelValue: t.quantity, "onUpdate:modelValue": (o) => t.quantity = o, controls: false, min: 1, precision: r(u).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(d, { key: "weighingTotalWeight", label: `总重 (${r(u).weight.unit})`, align: "center", "min-width": "100", prop: "weighingTotalWeight" }, { header: i(() => [l[8] || (l[8] = c("span", { style: { color: "red" } }, "*", -1)), h("总重 (" + b(r(u).weight.unit) + ") ", 1)]), default: i(({ row: t }) => [s(y, { content: `理论重量：${t.theoryTotalWeight} kg， ${r(O)}`, disabled: !t.hasOver, class: "item", effect: "dark", placement: "top" }, { default: i(() => [s(g, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (o) => t.weighingTotalWeight = o, class: ye({ "over-weight-tip": t.hasOver }), controls: false, max: 999999999, min: 0, precision: r(u).weight.precision, "controls-position": "right", placeholder: "重量", size: "default", style: { width: "100%" }, onChange: (o) => C(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onChange"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"]), r(n).boolPartyA ? A("", true) : (_(), N(De, { key: 0, "is-required-identifier": "" })), s(d, { align: "center", label: "品牌", "min-width": "150", prop: "brand" }, { default: i(({ row: t }) => [s(a, { modelValue: t.brand, "onUpdate:modelValue": (o) => t.brand = o, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(d, { align: "center", label: "炉批号/卷号", "min-width": "150", prop: "heatNoAndBatchNo" }, { default: i(({ row: t }) => [s(a, { modelValue: t.heatNoAndBatchNo, "onUpdate:modelValue": (o) => t.heatNoAndBatchNo = o, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号/卷号", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(d, { align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, be({ default: i(({ row: t, $index: o }) => [s(r(Ce), { modelValue: t.projectId, "onUpdate:modelValue": (p) => t.projectId = p, "show-extra": o !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (p) => ne(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 2 }, [r(n).boolPartyA ? { name: "header", fn: i(() => [l[9] || (l[9] = c("span", { style: { color: "red" } }, "*", -1)), l[10] || (l[10] = h("所属项目 "))]), key: "0" } : void 0]), 1024), s(d, { align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { header: i(() => l[11] || (l[11] = [c("span", { style: { color: "red" } }, "*", -1), h("仓库 ")])), default: i(({ row: t, $index: o }) => [s(qe, { modelValue: t.workshopId, "onUpdate:modelValue": (p) => t.workshopId = p, "show-extra": o !== 0, clearable: "", placeholder: "请选择仓库", style: { width: "100%" }, onChange: (p) => oe(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), s(d, { align: "center", label: "存储位置", prop: "warehouseId", width: "140px" }, { header: i(() => l[12] || (l[12] = [c("span", { style: { color: "red" } }, "*", -1), h("存储位置 ")])), default: i(({ row: t, $index: o }) => [s(je, { modelValue: t.warehouseId, "onUpdate:modelValue": (p) => t.warehouseId = p, "basic-class": t.basicClass, "show-extra": o !== 0, "workshop-id": t.workshopId, clearable: "", placeholder: "请选择存储位置", style: { width: "100%" }, onChange: (p) => re(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra", "workshop-id", "onChange"])]), _: 1 }), r(n).boolPartyA ? A("", true) : (_(), N(d, { key: 1, align: "center", label: "供应商", prop: "supplierId", width: "140px" }, { default: i(({ row: t, $index: o }) => [s(Ee, { ref: "supplierRef", modelValue: t.supplierId, "onUpdate:modelValue": (p) => t.supplierId = p, "basic-class": r(n).materialType, "show-extra": o !== 0, showType: false, clearable: "", filterable: "", mode: "cross" }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra"])]), _: 1 })), s(d, { align: "center", label: "整料/余料", prop: "materialIsWhole", width: "140px" }, { header: i(() => l[13] || (l[13] = [c("span", { style: { color: "red" } }, "*", -1), h("整料/余料 ")])), default: i(({ row: t, $index: o }) => [s(I, { modelValue: t.materialIsWhole, "onUpdate:modelValue": (p) => t.materialIsWhole = p, options: r(Ae).ENUM, "show-extra": o !== 0, clearable: "", placeholder: "请选择整料/余料", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), s(d, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: i(({ row: t, $index: o }) => [s(m, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (p) => se(t, t.rowIndex) }, null, 8, ["onClick"]), s(m, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (p) => ie(t.sn, o, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  Ye as default
};
