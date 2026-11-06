import { ref as se } from "vue";
import { inject as R } from "vue";
import { computed as ne } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as oe } from "vue";
import { openBlock as m } from "vue";
import { createBlock as x } from "vue";
import { withCtx as s } from "vue";
import { createVNode as n } from "vue";
import { unref as f } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as p } from "vue";
import { withDirectives as V } from "vue";
import { toDisplayString as v } from "vue";
import { createElementBlock as L } from "vue";
import { createCommentVNode as q } from "vue";
import { createSlots as re } from "vue";
import { mergeProps as ue } from "vue";
import { reactive as A } from "vue";
import { watch as de } from "vue";
import { ElInput as pe } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElTooltip as me } from "element-plus";
import { v5 as fe, xW as ye, xX as he, ll as ge, aR as be, fv as Ie, r8 as xe, r9 as Ve, aw as ke, aI as S, i as b, iX as $, D, b as _e } from "../../../../../../../../../shared/runtime.js";
import we from "../../price-set-columns.vue.js";
import { _ as Ue } from "../../../../../../../../../modules/supplier-select-0ce6adf5.js";
const ve = { class: "mtb-10", style: { "margin-left": "30px" } }, Le = { key: 1 }, je = { __name: "auxiliary-material-table", props: { repeatList: { type: Array, default: () => [] } }, setup(W, { expose: z }) {
  var j;
  const k = se([]), T = W;
  function B({ row: e, rowIndex: a }) {
    var t;
    if ((t = T.repeatList) != null && t.includes(e.uid)) return { backgroundColor: "#ffdede" };
  }
  const i = (j = R("crud")) == null ? void 0 : j.form, _ = R("matSpecRef"), { projectAllType: M } = fe(), { workshopNameV2: P } = ye(), { warehouseV2: C } = he(), { suppliers: E } = ge(), F = (e, a) => b(a.mete) && b(a.unitPrice) ? +$(a.mete * a.unitPrice, D.YUAN) == +e : false, O = (e, a) => a.measureUnit && b(a.measurePrecision) ? !!e : true, K = ne(() => {
    const e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: O, message: "数量必须大于0", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] };
    return i.boolPartyA ? Object.assign(e, { projectId: [{ required: true, message: "请选择项目", trigger: "blur" }] }) : Object.assign(e, { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: F, message: "金额有误，请手动修改", trigger: "blur" }] }), e;
  }), J = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1], ["supplierId", -1], ["materialIsWhole", -1]]), { tableValidate: X, wrongCellMask: Y, cleanUpData: Q } = ke({ rules: K, errorMsg: "请修正【辅材清单】中标红的信息", ditto: J });
  function G(e) {
    const a = A({ uid: S(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, accountingUnitNet: e.accountingUnitNet, quantity: void 0, color: void 0, brand: void 0, projectId: i.auxiliaryMaterialList.length > 0 ? -1 : void 0, workshopId: i.auxiliaryMaterialList.length > 0 ? -1 : void 0, warehouseId: i.auxiliaryMaterialList.length > 0 ? -1 : void 0, supplierId: i.auxiliaryMaterialList.length > 0 ? -1 : void 0, mete: void 0 });
    return i.boolPartyA || (a.unitPrice = void 0, a.amount = void 0), w(a), a;
  }
  function w(e) {
    console.log(e, "row1111"), de([() => e.mete], () => N(e), { immediate: true });
  }
  function N(e) {
    b(e.unitPrice) && b(e.mete) ? e.amount = $(e.mete * e.unitPrice, D.YUAN) : e.amount = void 0;
  }
  function H(e, a) {
    var o;
    const t = A(JSON.parse(JSON.stringify(e)));
    t.uid = S(), t.rowIndex = i.steelPlateList.length, t.projectId = e.projectId ? e.projectId : -1, t.workshopId = e.workshopId ? e.workshopId : -1, t.warehouseId = e.warehouseId ? e.warehouseId : -1, t.supplierId = e.supplierId ? e.supplierId : -1, t.materialIsWhole = e.materialIsWhole ? e.materialIsWhole : -1, i.auxiliaryMaterialList.push(t), w(t), (o = _.value) == null || o.initSelected([t]);
  }
  function Z(e, a, t) {
    _.value ? _.value.delListItem(e, a) : i.auxiliaryMaterialList.splice(a, 1);
  }
  function ee(e) {
    const a = M.value.find((t) => t.id === e.projectId);
    e.project = a;
  }
  function ae(e) {
    const a = P.value.find((t) => t.id === e.workshopId);
    e.workshop = a;
  }
  function le(e) {
    const a = C.value.find((t) => t.id === e.warehouseId);
    e.warehouse = a;
  }
  function te() {
    if (_e(i.auxiliaryMaterialList)) return true;
    const { validResult: e, dealList: a } = X(i.auxiliaryMaterialList);
    return e && ie(a), e;
  }
  function ie(e) {
    Q(e), e.forEach((a, t) => {
      var o, y, h, g;
      i.auxiliaryMaterialList[t].projectId = a.projectId, i.auxiliaryMaterialList[t].project = (o = M.value) == null ? void 0 : o.find((c) => i.auxiliaryMaterialList[t].projectId === c.id), i.auxiliaryMaterialList[t].workshopId = a.workshopId, i.auxiliaryMaterialList[t].workshop = (y = P.value) == null ? void 0 : y.find((c) => i.auxiliaryMaterialList[t].workshopId === c.id), i.auxiliaryMaterialList[t].warehouseId = a.warehouseId, i.auxiliaryMaterialList[t].warehouse = (h = C.value) == null ? void 0 : h.find((c) => i.auxiliaryMaterialList[t].warehouseId === c.id), i.auxiliaryMaterialList[t].supplierId = a.supplierId, i.auxiliaryMaterialList[t].supplier = (g = E.value) == null ? void 0 : g.find((c) => i.auxiliaryMaterialList[t].supplierId === c.id);
    });
  }
  return z({ rowInit: G, rowWatch: w, validate: te }), (e, a) => {
    const t = pe, o = ce, y = me, h = U("common-input-number"), g = U("common-button"), c = U("common-table"), I = oe("empty-text");
    return m(), x(c, ue({ "cell-class-name": f(Y), data: f(i).auxiliaryMaterialList, "row-style": B, "show-empty-symbol": false, stripe: false, "return-source-data": "", "expand-row-keys": k.value, "row-key": "uid" }, e.$attrs), { default: s(() => [n(be, { "expand-row-keys": k.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (l) => k.value = l), data: f(i).auxiliaryMaterialList, "row-key": "uid", fixed: "left" }, { default: s(({ row: l }) => [u("div", ve, [n(t, { modelValue: l.remark, "onUpdate:modelValue": (r) => l.remark = r, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(o, { align: "center", label: "序号", type: "index", width: "60" }), n(o, { align: "center", label: "编号", prop: "serialNumber" }, { header: s(() => a[1] || (a[1] = [u("span", { style: { color: "red" } }, "*", -1), p("编号 ")])), _: 1 }), n(o, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { header: s(() => a[2] || (a[2] = [u("span", { style: { color: "red" } }, "*", -1), p("物料种类 ")])), default: s(({ row: l }) => [n(y, { content: l.classifyParentFullName, disabled: !l.classifyParentFullName, "show-after": 500, placement: "top" }, { default: s(() => [V(u("span", null, null, 512), [[I, l.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), n(o, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { header: s(() => a[3] || (a[3] = [u("span", { style: { color: "red" } }, "*", -1), p("规格 ")])), default: s(({ row: l }) => [n(y, { content: l.specificationLabels, placement: "top" }, { default: s(() => [u("span", null, v(l.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), n(o, { align: "center", label: "计量单位", prop: "measureUnit" }, { header: s(() => a[4] || (a[4] = [u("span", { style: { color: "red" } }, "*", -1), p("计量单位 ")])), default: s(({ row: l }) => [V((m(), L("span", null, [p(v(l.measureUnit), 1)])), [[I]])]), _: 1 }), n(o, { align: "center", label: "数量", prop: "quantity" }, { header: s(() => a[5] || (a[5] = [u("span", { style: { color: "red" } }, "*", -1), p("数量 ")])), default: s(({ row: l }) => [l.measureUnit ? (m(), x(h, { key: 0, modelValue: l.quantity, "onUpdate:modelValue": (r) => l.quantity = r, controls: false, min: 0, precision: l.measurePrecision, step: 1, placeholder: "数量", size: "mini" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : V((m(), L("span", Le, null, 512)), [[I]])]), _: 1 }), n(o, { align: "center", label: "核算单位", prop: "accountingUnit" }, { header: s(() => a[6] || (a[6] = [u("span", { style: { color: "red" } }, "*", -1), p("核算单位 ")])), default: s(({ row: l }) => [V((m(), L("span", null, [p(v(l.accountingUnit), 1)])), [[I]])]), _: 1 }), n(o, { align: "center", label: "核算量", prop: "mete" }, { header: s(() => a[7] || (a[7] = [u("span", { style: { color: "red" } }, "*", -1), p("核算量 ")])), default: s(({ row: l }) => [n(h, { modelValue: l.mete, "onUpdate:modelValue": (r) => l.mete = r, controls: false, max: 999999999, min: 1e-6, precision: l.accountingPrecision, step: 1, placeholder: "核算量", size: "mini", onChange: (r) => N(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), f(i).boolPartyA ? q("", true) : (m(), x(we, { key: 0, "is-required-identifier": "", "weight-attribute": "mete" })), n(o, { align: "center", label: "品牌", "min-width": "150", prop: "brand" }, { default: s(({ row: l }) => [n(t, { modelValue: l.brand, "onUpdate:modelValue": (r) => l.brand = r, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "mini" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), n(o, { align: "center", label: "颜色", "min-width": "140px", prop: "color" }, { default: s(({ row: l }) => [n(t, { modelValue: l.color, "onUpdate:modelValue": (r) => l.color = r, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "mini" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), n(o, { align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, re({ default: s(({ row: l, $index: r }) => [n(Ie, { modelValue: l.projectId, "onUpdate:modelValue": (d) => l.projectId = d, "show-extra": r !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (d) => ee(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 2 }, [f(i).boolPartyA ? { name: "header", fn: s(() => [a[8] || (a[8] = u("span", { style: { color: "red" } }, "*", -1)), a[9] || (a[9] = p("所属项目 "))]), key: "0" } : void 0]), 1024), n(o, { align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { header: s(() => a[10] || (a[10] = [u("span", { style: { color: "red" } }, "*", -1), p("仓库 ")])), default: s(({ row: l, $index: r }) => [n(xe, { modelValue: l.workshopId, "onUpdate:modelValue": (d) => l.workshopId = d, "show-extra": r !== 0, clearable: "", placeholder: "请选择仓库", style: { width: "100%" }, onChange: (d) => ae(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), n(o, { align: "center", label: "存储位置", prop: "warehouseId", width: "140px" }, { header: s(() => a[11] || (a[11] = [u("span", { style: { color: "red" } }, "*", -1), p("存储位置 ")])), default: s(({ row: l, $index: r }) => [n(Ve, { modelValue: l.warehouseId, "onUpdate:modelValue": (d) => l.warehouseId = d, "basic-class": l.basicClass, "show-extra": r !== 0, "workshop-id": l.workshopId, clearable: "", placeholder: "请选择存储位置", style: { width: "100%" }, onChange: (d) => le(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra", "workshop-id", "onChange"])]), _: 1 }), f(i).boolPartyA ? q("", true) : (m(), x(o, { key: 1, align: "center", label: "供应商", prop: "supplierId", width: "140px" }, { default: s(({ row: l, $index: r }) => [n(Ue, { ref: "supplierRef", modelValue: l.supplierId, "onUpdate:modelValue": (d) => l.supplierId = d, "basic-class": f(i).materialType, "show-extra": r !== 0, clearable: "", filterable: "", mode: "cross" }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra"])]), _: 1 })), n(o, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: s(({ row: l, $index: r }) => [n(g, { icon: "el-icon-document-copy", size: "mini", type: "success", onClick: (d) => H(l, l.rowIndex) }, null, 8, ["onClick"]), n(g, { icon: "el-icon-delete", size: "mini", type: "danger", onClick: (d) => Z(l.sn, r, l) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  je as default
};
