import { ref as ne } from "vue";
import { inject as q } from "vue";
import { computed as oe } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as ie } from "vue";
import { openBlock as m } from "vue";
import { createBlock as V } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { unref as f } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as p } from "vue";
import { withDirectives as k } from "vue";
import { toDisplayString as x } from "vue";
import { createElementBlock as L } from "vue";
import { createCommentVNode as A } from "vue";
import { createSlots as re } from "vue";
import { mergeProps as de } from "vue";
import { reactive as S } from "vue";
import { watch as ue } from "vue";
import { ElInput as pe } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElTooltip as me } from "element-plus";
import { v5 as fe, xW as ge, xX as he, ll as ye, aR as be, fv as Ie, r8 as Ve, r9 as ke, aw as _e, aI as $, i as b, iX as D, D as M, b as we } from "../../../../../../../../../shared/runtime.js";
import Ue from "../../price-set-columns.vue.js";
import { _ as ve } from "../../../../../../../../../modules/supplier-select-0ce6adf5.js";
const xe = { class: "mtb-10", style: { "margin-left": "30px" } }, Le = { key: 1 }, Re = { __name: "gas-table", props: { repeatList: { type: Array, default: () => [] } }, setup(W, { expose: z }) {
  var R;
  const _ = ne([]), T = W;
  function B({ row: e, rowIndex: a }) {
    var s;
    if ((s = T.repeatList) != null && s.includes(e.uid)) return { backgroundColor: "#ffdede" };
  }
  const l = (R = q("crud")) == null ? void 0 : R.form, w = q("matSpecRef"), { projectAllType: P } = fe(), { workshopNameV2: C } = ge(), { warehouseV2: N } = he(), { suppliers: E } = ye(), F = (e, a) => b(a.mete) && b(a.unitPrice) ? +D(a.mete * a.unitPrice, M.YUAN) == +e : false, O = (e, a) => a.measureUnit && b(a.measurePrecision) ? !!e : true, K = oe(() => {
    const e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: O, message: "数量必须大于0", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] };
    return l.boolPartyA ? Object.assign(e, { projectId: [{ required: true, message: "请选择项目", trigger: "blur" }] }) : Object.assign(e, { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: F, message: "金额有误，请手动修改", trigger: "blur" }] }), e;
  }), J = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1], ["supplierId", -1], ["materialIsWhole", -1]]), { tableValidate: X, wrongCellMask: Y, cleanUpData: Q } = _e({ rules: K, errorMsg: "请修正【气体清单】中标红的信息", ditto: J });
  function G(e) {
    const a = S({ uid: $(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, accountingUnitNet: e.accountingUnitNet, quantity: void 0, color: void 0, brand: void 0, projectId: l.gasList.length > 0 ? -1 : void 0, workshopId: l.gasList.length > 0 ? -1 : void 0, warehouseId: l.gasList.length > 0 ? -1 : void 0, supplierId: l.gasList.length > 0 ? -1 : void 0, mete: void 0 });
    return l.boolPartyA || (a.unitPrice = void 0, a.amount = void 0), U(a), a;
  }
  function U(e) {
    ue([() => e.mete], () => j(e), { immediate: true });
  }
  function j(e) {
    b(e.unitPrice) && b(e.mete) ? e.amount = D(e.mete * e.unitPrice, M.YUAN) : e.amount = void 0;
  }
  function H(e, a) {
    var i;
    const s = S(JSON.parse(JSON.stringify(e)));
    s.uid = $(), s.rowIndex = l.steelPlateList.length, s.projectId = e.projectId ? e.projectId : -1, s.workshopId = e.workshopId ? e.workshopId : -1, s.warehouseId = e.warehouseId ? e.warehouseId : -1, s.supplierId = e.supplierId ? e.supplierId : -1, s.materialIsWhole = e.materialIsWhole ? e.materialIsWhole : -1, l.gasList.push(s), U(s), (i = w.value) == null || i.initSelected([s]);
  }
  function Z(e, a, s) {
    w.value ? w.value.delListItem(e, a) : l.gasList.splice(a, 1);
  }
  function ee(e) {
    const a = P.value.find((s) => s.id === e.projectId);
    e.project = a;
  }
  function ae(e) {
    const a = C.value.find((s) => s.id === e.workshopId);
    e.workshop = a;
  }
  function te(e) {
    const a = N.value.find((s) => s.id === e.warehouseId);
    e.warehouse = a;
  }
  function se() {
    if (we(l.gasList)) return true;
    const { validResult: e, dealList: a } = X(l.gasList);
    return e && le(a), e;
  }
  function le(e) {
    Q(e), e.forEach((a, s) => {
      var i, g, h, y;
      l.gasList[s].projectId = a.projectId, l.gasList[s].project = (i = P.value) == null ? void 0 : i.find((c) => l.gasList[s].projectId === c.id), l.gasList[s].workshopId = a.workshopId, l.gasList[s].workshop = (g = C.value) == null ? void 0 : g.find((c) => l.gasList[s].workshopId === c.id), l.gasList[s].warehouseId = a.warehouseId, l.gasList[s].warehouse = (h = N.value) == null ? void 0 : h.find((c) => l.gasList[s].warehouseId === c.id), l.gasList[s].supplierId = a.supplierId, l.gasList[s].supplier = (y = E.value) == null ? void 0 : y.find((c) => l.gasList[s].supplierId === c.id);
    });
  }
  return z({ rowInit: G, rowWatch: U, validate: se }), (e, a) => {
    const s = pe, i = ce, g = me, h = v("common-input-number"), y = v("common-button"), c = v("common-table"), I = ie("empty-text");
    return m(), V(c, de({ "cell-class-name": f(Y), data: f(l).gasList, "row-style": B, "show-empty-symbol": false, stripe: false, "return-source-data": "", "expand-row-keys": _.value, "row-key": "uid" }, e.$attrs), { default: n(() => [o(be, { "expand-row-keys": _.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (t) => _.value = t), data: f(l).gasList, "row-key": "uid", fixed: "left" }, { default: n(({ row: t }) => [d("div", xe, [o(s, { modelValue: t.remark, "onUpdate:modelValue": (r) => t.remark = r, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), o(i, { align: "center", label: "序号", type: "index", width: "60" }), o(i, { align: "center", label: "编号", prop: "serialNumber" }, { header: n(() => a[1] || (a[1] = [d("span", { style: { color: "red" } }, "*", -1), p("编号 ")])), _: 1 }), o(i, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { header: n(() => a[2] || (a[2] = [d("span", { style: { color: "red" } }, "*", -1), p("物料种类 ")])), default: n(({ row: t }) => [o(g, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: n(() => [k(d("span", null, null, 512), [[I, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), o(i, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { header: n(() => a[3] || (a[3] = [d("span", { style: { color: "red" } }, "*", -1), p("规格 ")])), default: n(({ row: t }) => [o(g, { content: t.specificationLabels, placement: "top" }, { default: n(() => [d("span", null, x(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), o(i, { align: "center", label: "计量单位", prop: "measureUnit" }, { header: n(() => a[4] || (a[4] = [d("span", { style: { color: "red" } }, "*", -1), p("计量单位 ")])), default: n(({ row: t }) => [k((m(), L("span", null, [p(x(t.measureUnit), 1)])), [[I]])]), _: 1 }), o(i, { align: "center", label: "数量", prop: "quantity" }, { header: n(() => a[5] || (a[5] = [d("span", { style: { color: "red" } }, "*", -1), p("数量 ")])), default: n(({ row: t }) => [t.measureUnit ? (m(), V(h, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (r) => t.quantity = r, controls: false, min: 0, precision: t.measurePrecision, step: 1, placeholder: "数量", size: "mini" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : k((m(), L("span", Le, null, 512)), [[I]])]), _: 1 }), o(i, { align: "center", label: "核算单位", prop: "accountingUnit" }, { header: n(() => a[6] || (a[6] = [d("span", { style: { color: "red" } }, "*", -1), p("核算单位 ")])), default: n(({ row: t }) => [k((m(), L("span", null, [p(x(t.accountingUnit), 1)])), [[I]])]), _: 1 }), o(i, { align: "center", label: "核算量", prop: "mete" }, { header: n(() => a[7] || (a[7] = [d("span", { style: { color: "red" } }, "*", -1), p("核算量 ")])), default: n(({ row: t }) => [o(h, { modelValue: t.mete, "onUpdate:modelValue": (r) => t.mete = r, controls: false, max: 999999999, min: 1e-6, precision: t.accountingPrecision, step: 1, placeholder: "核算量", size: "mini", onChange: (r) => j(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), f(l).boolPartyA ? A("", true) : (m(), V(Ue, { key: 0, "is-required-identifier": "", "weight-attribute": "mete" })), o(i, { align: "center", label: "品牌", "min-width": "150", prop: "brand" }, { default: n(({ row: t }) => [o(s, { modelValue: t.brand, "onUpdate:modelValue": (r) => t.brand = r, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "mini" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(i, { align: "center", label: "颜色", "min-width": "140px", prop: "color" }, { default: n(({ row: t }) => [o(s, { modelValue: t.color, "onUpdate:modelValue": (r) => t.color = r, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "mini" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(i, { align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, re({ default: n(({ row: t, $index: r }) => [o(Ie, { modelValue: t.projectId, "onUpdate:modelValue": (u) => t.projectId = u, "show-extra": r !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (u) => ee(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 2 }, [f(l).boolPartyA ? { name: "header", fn: n(() => [a[8] || (a[8] = d("span", { style: { color: "red" } }, "*", -1)), a[9] || (a[9] = p("所属项目 "))]), key: "0" } : void 0]), 1024), o(i, { align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { header: n(() => a[10] || (a[10] = [d("span", { style: { color: "red" } }, "*", -1), p("仓库 ")])), default: n(({ row: t, $index: r }) => [o(Ve, { modelValue: t.workshopId, "onUpdate:modelValue": (u) => t.workshopId = u, "show-extra": r !== 0, clearable: "", placeholder: "请选择仓库", style: { width: "100%" }, onChange: (u) => ae(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), o(i, { align: "center", label: "存储位置", prop: "warehouseId", width: "140px" }, { header: n(() => a[11] || (a[11] = [d("span", { style: { color: "red" } }, "*", -1), p("存储位置 ")])), default: n(({ row: t, $index: r }) => [o(ke, { modelValue: t.warehouseId, "onUpdate:modelValue": (u) => t.warehouseId = u, "basic-class": t.basicClass, "show-extra": r !== 0, "workshop-id": t.workshopId, clearable: "", placeholder: "请选择存储位置", style: { width: "100%" }, onChange: (u) => te(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra", "workshop-id", "onChange"])]), _: 1 }), f(l).boolPartyA ? A("", true) : (m(), V(i, { key: 1, align: "center", label: "供应商", prop: "supplierId", width: "140px" }, { default: n(({ row: t, $index: r }) => [o(ve, { ref: "supplierRef", modelValue: t.supplierId, "onUpdate:modelValue": (u) => t.supplierId = u, "basic-class": f(l).materialType, "show-extra": r !== 0, clearable: "", filterable: "", mode: "cross" }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra"])]), _: 1 })), o(i, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: n(({ row: t, $index: r }) => [o(y, { icon: "el-icon-document-copy", size: "mini", type: "success", onClick: (u) => H(t, t.rowIndex) }, null, 8, ["onClick"]), o(y, { icon: "el-icon-delete", size: "mini", type: "danger", onClick: (u) => Z(t.sn, r, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  Re as default
};
