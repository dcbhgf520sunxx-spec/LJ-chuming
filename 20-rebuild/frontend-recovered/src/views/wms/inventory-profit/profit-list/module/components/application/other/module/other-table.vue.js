import { ref as oe } from "vue";
import { inject as q } from "vue";
import { computed as ne } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as ie } from "vue";
import { openBlock as m } from "vue";
import { createBlock as V } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as p } from "vue";
import { withDirectives as k } from "vue";
import { toDisplayString as x } from "vue";
import { createElementBlock as L } from "vue";
import { unref as f } from "vue";
import { createCommentVNode as A } from "vue";
import { createSlots as re } from "vue";
import { mergeProps as de } from "vue";
import { reactive as S } from "vue";
import { watch as ue } from "vue";
import { ElInput as pe } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElTooltip as me } from "element-plus";
import { v5 as fe, xW as he, xX as ge, ll as ye, aR as be, fv as Ie, r8 as Ve, r9 as ke, aw as _e, aI as $, i as b, iX as D, D as M, b as we } from "../../../../../../../../../shared/runtime.js";
import Ue from "../../price-set-columns.vue.js";
import { _ as ve } from "../../../../../../../../../modules/supplier-select-0ce6adf5.js";
const xe = { class: "mtb-10", style: { "margin-left": "30px" } }, Le = { key: 1 }, Re = { __name: "other-table", props: { repeatList: { type: Array, default: () => [] } }, setup(W, { expose: z }) {
  var R;
  const _ = oe([]), T = W;
  function B({ row: e, rowIndex: t }) {
    var l;
    if ((l = T.repeatList) != null && l.includes(e.uid)) return { backgroundColor: "#ffdede" };
  }
  const s = (R = q("crud")) == null ? void 0 : R.form, w = q("matSpecRef"), { projectAllType: P } = fe(), { workshopNameV2: C } = he(), { warehouseV2: N } = ge(), { suppliers: E } = ye(), F = (e, t) => b(t.mete) && b(t.unitPrice) ? +D(t.mete * t.unitPrice, M.YUAN) == +e : false, O = (e, t) => t.measureUnit && b(t.measurePrecision) ? !!e : true, K = ne(() => {
    const e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: O, message: "数量必须大于0", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] };
    return s.boolPartyA ? Object.assign(e, { projectId: [{ required: true, message: "请选择项目", trigger: "blur" }] }) : Object.assign(e, { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: F, message: "金额有误，请手动修改", trigger: "blur" }] }), e;
  }), J = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1], ["supplierId", -1], ["materialIsWhole", -1]]), { tableValidate: X, wrongCellMask: Y, cleanUpData: Q } = _e({ rules: K, errorMsg: "请修正【办公用品清单】中标红的信息", ditto: J });
  function G(e) {
    const t = S({ uid: $(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, accountingUnitNet: e.accountingUnitNet, quantity: void 0, color: void 0, brand: void 0, projectId: s.otherList.length > 0 ? -1 : void 0, workshopId: s.otherList.length > 0 ? -1 : void 0, warehouseId: s.otherList.length > 0 ? -1 : void 0, supplierId: s.otherList.length > 0 ? -1 : void 0, mete: void 0 });
    return s.boolPartyA || (t.unitPrice = void 0, t.amount = void 0), U(t), t;
  }
  function U(e) {
    ue([() => e.mete], () => j(e), { immediate: true });
  }
  function j(e) {
    b(e.unitPrice) && b(e.mete) ? e.amount = D(e.mete * e.unitPrice, M.YUAN) : e.amount = void 0;
  }
  function H(e, t) {
    var i;
    const l = S(JSON.parse(JSON.stringify(e)));
    l.uid = $(), l.rowIndex = s.steelPlateList.length, l.projectId = e.projectId ? e.projectId : -1, l.workshopId = e.workshopId ? e.workshopId : -1, l.warehouseId = e.warehouseId ? e.warehouseId : -1, l.supplierId = e.supplierId ? e.supplierId : -1, l.materialIsWhole = e.materialIsWhole ? e.materialIsWhole : -1, s.otherList.push(l), U(l), (i = w.value) == null || i.initSelected([l]);
  }
  function Z(e, t, l) {
    w.value ? w.value.delListItem(e, t) : s.otherList.splice(t, 1);
  }
  function ee(e) {
    const t = P.value.find((l) => l.id === e.projectId);
    e.project = t;
  }
  function te(e) {
    const t = C.value.find((l) => l.id === e.workshopId);
    e.workshop = t;
  }
  function ae(e) {
    const t = N.value.find((l) => l.id === e.warehouseId);
    e.warehouse = t;
  }
  function le() {
    if (we(s.otherList)) return true;
    const { validResult: e, dealList: t } = X(s.otherList);
    return e && se(t), e;
  }
  function se(e) {
    Q(e), e.forEach((t, l) => {
      var i, h, g, y;
      s.otherList[l].projectId = t.projectId, s.otherList[l].project = (i = P.value) == null ? void 0 : i.find((c) => s.otherList[l].projectId === c.id), s.otherList[l].workshopId = t.workshopId, s.otherList[l].workshop = (h = C.value) == null ? void 0 : h.find((c) => s.otherList[l].workshopId === c.id), s.otherList[l].warehouseId = t.warehouseId, s.otherList[l].warehouse = (g = N.value) == null ? void 0 : g.find((c) => s.otherList[l].warehouseId === c.id), s.otherList[l].supplierId = t.supplierId, s.otherList[l].supplier = (y = E.value) == null ? void 0 : y.find((c) => s.otherList[l].supplierId === c.id);
    });
  }
  return z({ rowInit: G, rowWatch: U, validate: le }), (e, t) => {
    const l = pe, i = ce, h = me, g = v("common-input-number"), y = v("common-button"), c = v("common-table"), I = ie("empty-text");
    return m(), V(c, de({ "cell-class-name": f(Y), data: f(s).otherList, "row-style": B, "show-empty-symbol": false, stripe: false, "return-source-data": "", "expand-row-keys": _.value, "row-key": "uid" }, e.$attrs), { default: o(() => [n(be, { "expand-row-keys": _.value, "onUpdate:expandRowKeys": t[0] || (t[0] = (a) => _.value = a), data: e.list, "row-key": "uid", fixed: "left" }, { default: o(({ row: a }) => [d("div", xe, [n(l, { modelValue: a.remark, "onUpdate:modelValue": (r) => a.remark = r, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(i, { align: "center", label: "序号", type: "index", width: "60" }), n(i, { align: "center", label: "编号", prop: "serialNumber" }, { header: o(() => t[1] || (t[1] = [d("span", { style: { color: "red" } }, "*", -1), p("编号 ")])), _: 1 }), n(i, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { header: o(() => t[2] || (t[2] = [d("span", { style: { color: "red" } }, "*", -1), p("物料种类 ")])), default: o(({ row: a }) => [n(h, { content: a.classifyParentFullName, disabled: !a.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [k(d("span", null, null, 512), [[I, a.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), n(i, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { header: o(() => t[3] || (t[3] = [d("span", { style: { color: "red" } }, "*", -1), p("规格 ")])), default: o(({ row: a }) => [n(h, { content: a.specificationLabels, placement: "top" }, { default: o(() => [d("span", null, x(a.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), n(i, { align: "center", label: "计量单位", prop: "measureUnit" }, { header: o(() => t[4] || (t[4] = [d("span", { style: { color: "red" } }, "*", -1), p("计量单位 ")])), default: o(({ row: a }) => [k((m(), L("span", null, [p(x(a.measureUnit), 1)])), [[I]])]), _: 1 }), n(i, { align: "center", label: "数量", prop: "quantity" }, { header: o(() => t[5] || (t[5] = [d("span", { style: { color: "red" } }, "*", -1), p("数量 ")])), default: o(({ row: a }) => [a.measureUnit ? (m(), V(g, { key: 0, modelValue: a.quantity, "onUpdate:modelValue": (r) => a.quantity = r, controls: false, min: 0, precision: a.measurePrecision, step: 1, placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : k((m(), L("span", Le, null, 512)), [[I]])]), _: 1 }), n(i, { align: "center", label: "核算单位", prop: "accountingUnit" }, { header: o(() => t[6] || (t[6] = [d("span", { style: { color: "red" } }, "*", -1), p("核算单位 ")])), default: o(({ row: a }) => [k((m(), L("span", null, [p(x(a.accountingUnit), 1)])), [[I]])]), _: 1 }), n(i, { align: "center", label: "核算量", prop: "mete" }, { header: o(() => t[7] || (t[7] = [d("span", { style: { color: "red" } }, "*", -1), p("核算量 ")])), default: o(({ row: a }) => [n(g, { modelValue: a.mete, "onUpdate:modelValue": (r) => a.mete = r, controls: false, max: 999999999, min: 1e-6, precision: a.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (r) => j(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), f(s).boolPartyA ? A("", true) : (m(), V(Ue, { key: 0, "is-required-identifier": "", "weight-attribute": "mete" })), n(i, { align: "center", label: "品牌", "min-width": "150", prop: "brand" }, { default: o(({ row: a }) => [n(l, { modelValue: a.brand, "onUpdate:modelValue": (r) => a.brand = r, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), n(i, { align: "center", label: "颜色", "min-width": "140px", prop: "color" }, { default: o(({ row: a }) => [n(l, { modelValue: a.color, "onUpdate:modelValue": (r) => a.color = r, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), n(i, { align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, re({ default: o(({ row: a, $index: r }) => [n(Ie, { modelValue: a.projectId, "onUpdate:modelValue": (u) => a.projectId = u, "show-extra": r !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (u) => ee(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 2 }, [f(s).boolPartyA ? { name: "header", fn: o(() => [t[8] || (t[8] = d("span", { style: { color: "red" } }, "*", -1)), t[9] || (t[9] = p("所属项目 "))]), key: "0" } : void 0]), 1024), n(i, { align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { header: o(() => t[10] || (t[10] = [d("span", { style: { color: "red" } }, "*", -1), p("仓库 ")])), default: o(({ row: a, $index: r }) => [n(Ve, { modelValue: a.workshopId, "onUpdate:modelValue": (u) => a.workshopId = u, "show-extra": r !== 0, clearable: "", placeholder: "请选择仓库", style: { width: "100%" }, onChange: (u) => te(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), n(i, { align: "center", label: "存储位置", prop: "warehouseId", width: "140px" }, { header: o(() => t[11] || (t[11] = [d("span", { style: { color: "red" } }, "*", -1), p("存储位置 ")])), default: o(({ row: a, $index: r }) => [n(ke, { modelValue: a.warehouseId, "onUpdate:modelValue": (u) => a.warehouseId = u, "basic-class": a.basicClass, "show-extra": r !== 0, "workshop-id": a.workshopId, clearable: "", placeholder: "请选择存储位置", style: { width: "100%" }, onChange: (u) => ae(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra", "workshop-id", "onChange"])]), _: 1 }), f(s).boolPartyA ? A("", true) : (m(), V(i, { key: 1, align: "center", label: "供应商", prop: "supplierId", width: "140px" }, { default: o(({ row: a, $index: r }) => [n(ve, { ref: "supplierRef", modelValue: a.supplierId, "onUpdate:modelValue": (u) => a.supplierId = u, "basic-class": f(s).materialType, "show-extra": r !== 0, clearable: "", filterable: "", mode: "cross" }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra"])]), _: 1 })), n(i, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: o(({ row: a, $index: r }) => [n(y, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (u) => H(a, a.rowIndex) }, null, 8, ["onClick"]), n(y, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (u) => Z(a.sn, r, a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  Re as default
};
