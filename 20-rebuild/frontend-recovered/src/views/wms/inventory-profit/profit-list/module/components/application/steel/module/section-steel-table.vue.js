import { ref as fe } from "vue";
import { inject as w } from "vue";
import { computed as ye } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as be } from "vue";
import { openBlock as L } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as n } from "vue";
import { createVNode as i } from "vue";
import { unref as r } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as m } from "vue";
import { withDirectives as Ie } from "vue";
import { toDisplayString as S } from "vue";
import { normalizeClass as Se } from "vue";
import { createCommentVNode as q } from "vue";
import { createSlots as Ve } from "vue";
import { mergeProps as We } from "vue";
import { reactive as P } from "vue";
import { watchEffect as ke } from "vue";
import { watch as N } from "vue";
import { ElInput as ve } from "element-plus";
import { ElTableColumn as Le } from "element-plus";
import { ElTooltip as _e } from "element-plus";
import { am as Ne, sQ as xe, v7 as Ce, v5 as Ue, xW as Te, xX as we, ll as qe, aR as Pe, fv as je, r8 as Ae, r9 as Ee, xY as Re, c9 as j, aw as Oe, cP as A, aI as E, sU as $e, i as b, v9 as De, iX as V, D as R, b as Me } from "../../../../../../../../../shared/runtime.js";
import ze from "../../price-set-columns.vue.js";
import { _ as Be } from "../../../../../../../../../modules/supplier-select-0ce6adf5.js";
const Fe = { class: "mtb-10", style: { "margin-left": "30px" } }, Qe = { __name: "section-steel-table", props: { repeatList: { type: Array, default: () => [] } }, setup(O, { expose: $ }) {
  var T;
  const W = fe([]), D = O, M = Ne.SECTION_STEEL.V;
  function z({ row: e, rowIndex: t }) {
    var l;
    if ((l = D.repeatList) != null && l.includes(e.uid)) return { backgroundColor: "#ffdede" };
  }
  const s = (T = w("crud")) == null ? void 0 : T.form, k = w("matSpecRef"), { baseUnit: h } = xe(M), { overDiffTip: B, weightOverDiff: F, diffSubmitValidate: K } = Ce(h), { projectAllType: x } = Ue(), { workshopNameV2: C } = Te(), { warehouseV2: U } = we(), { suppliers: Y } = qe(), J = (e, t) => b(t.weighingTotalWeight) && b(t.unitPrice) ? +V(t.weighingTotalWeight * t.unitPrice, R.YUAN) == +e : false, X = (e, t) => b(e) ? e >= 0 : true, Q = ye(() => {
    const e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { pattern: j, message: "定尺长度必须大于0", trigger: "blur" }], standardId: [{ required: true, message: "请选择标准", trigger: "change" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: X, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: K, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: j, message: "重量必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], materialIsWhole: [{ required: true, message: "请选择整料/余料", trigger: "change" }] };
    return s.boolPartyA ? Object.assign(e, { projectId: [{ required: true, message: "请选择项目", trigger: "blur" }] }) : Object.assign(e, { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: J, message: "金额有误，请手动修改", trigger: "blur" }] }), e;
  }), G = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1], ["supplierId", -1], ["materialIsWhole", -1]]), { tableValidate: H, wrongCellMask: Z, cleanUpData: ee } = Oe({ rules: Q, errorMsg: "请修正【型材清单】中标红的信息", ditto: G });
  function te(e) {
    var o, f;
    let t;
    e.classify.basicClass === A.SECTION_STEEL.V && (t = (f = (o = e.nationalStandardOptions) == null ? void 0 : o.find((g) => g.boolDefault === true)) == null ? void 0 : f.standardId);
    const l = P({ uid: E(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, unitWeight: e.unitWeight, nationalStandardOptions: e.nationalStandardOptions, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, heatNoAndBatchNo: void 0, brand: void 0, projectId: s.sectionSteelList.length > 0 ? -1 : void 0, workshopId: s.sectionSteelList.length > 0 ? -1 : void 0, warehouseId: s.sectionSteelList.length > 0 ? -1 : void 0, supplierId: s.sectionSteelList.length > 0 ? -1 : void 0, materialIsWhole: s.sectionSteelList.length > 0 ? -1 : void 0, mete: void 0, standardId: t, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0 });
    if (e.classify.basicClass === A.SECTION_STEEL.V) {
      let g;
      const y = [];
      for (const c in l.specificationMap) c.indexOf("standard") > -1 ? g = l.specificationMap[c] : y.push(l.specificationMap[c]);
      l.sectionSteelSpec = g, l.doNotSectionSteelSpec = y.join(" * ");
    }
    return v(l), l;
  }
  function v(e) {
    ke(() => F(e)), N([() => e.length, () => e.unitWeight, h], () => ae(e), { immediate: true }), N([() => e.theoryWeight, () => e.quantity], () => {
      ie(e);
    }, { immediate: true }), N([() => e.length, () => e.quantity], () => {
      le(e);
    }, { immediate: true });
  }
  async function ae(e) {
    e.theoryWeight = await $e({ length: e.length, unitWeight: e.unitWeight });
  }
  function le(e) {
    b(e.length) && e.quantity ? e.totalLength = De({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function ie(e) {
    b(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = V(e.theoryWeight * e.quantity, h.value.weight.precision), e.weighingTotalWeight = V(e.theoryWeight * e.quantity, h.value.weight.precision), e.mete = e.weighingTotalWeight) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0, e.mete = void 0), ne(e);
  }
  function ne(e) {
    b(e.unitPrice) && b(e.weighingTotalWeight) ? e.amount = V(e.weighingTotalWeight * e.unitPrice, R.YUAN) : e.amount = void 0;
  }
  function se(e, t) {
    var o;
    const l = P(JSON.parse(JSON.stringify(e)));
    l.uid = E(), l.rowIndex = s.steelPlateList.length, l.projectId = e.projectId ? e.projectId : -1, l.workshopId = e.workshopId ? e.workshopId : -1, l.warehouseId = e.warehouseId ? e.warehouseId : -1, l.supplierId = e.supplierId ? e.supplierId : -1, l.materialIsWhole = e.materialIsWhole ? e.materialIsWhole : -1, s.sectionSteelList.push(l), v(l), (o = k.value) == null || o.initSelected([l]);
  }
  function oe(e, t, l) {
    k.value ? k.value.delListItem(e, t) : s.sectionSteelList.splice(t, 1);
  }
  function de(e) {
    const t = x.value.find((l) => l.id === e.projectId);
    e.project = t;
  }
  function re(e) {
    const t = C.value.find((l) => l.id === e.workshopId);
    e.workshop = t;
  }
  function ue(e) {
    const t = U.value.find((l) => l.id === e.warehouseId);
    e.warehouse = t;
  }
  function ce(e, t) {
    const l = t == null ? void 0 : t.find((o) => o.standardId === e.standardId);
    e.unitWeight = l == null ? void 0 : l.unitWeight;
  }
  function pe() {
    if (Me(s.sectionSteelList)) return true;
    const { validResult: e, dealList: t } = H(s.sectionSteelList);
    return e && he(t), e;
  }
  function he(e) {
    ee(e), e.forEach((t, l) => {
      var o, f, g, y;
      s.sectionSteelList[l].projectId = t.projectId, s.sectionSteelList[l].project = (o = x.value) == null ? void 0 : o.find((c) => s.sectionSteelList[l].projectId === c.id), s.sectionSteelList[l].workshopId = t.workshopId, s.sectionSteelList[l].workshop = (f = C.value) == null ? void 0 : f.find((c) => s.sectionSteelList[l].workshopId === c.id), s.sectionSteelList[l].warehouseId = t.warehouseId, s.sectionSteelList[l].warehouse = (g = U.value) == null ? void 0 : g.find((c) => s.sectionSteelList[l].warehouseId === c.id), s.sectionSteelList[l].supplierId = t.supplierId, s.sectionSteelList[l].supplier = (y = Y.value) == null ? void 0 : y.find((c) => s.sectionSteelList[l].supplierId === c.id), s.sectionSteelList[l].materialIsWhole = t.materialIsWhole;
    });
  }
  return $({ rowInit: te, rowWatch: v, validate: pe }), (e, t) => {
    const l = ve, o = Le, f = _e, g = I("common-select"), y = I("common-input-number"), c = I("common-button"), me = I("common-table"), ge = be("empty-text");
    return L(), _(me, We({ "cell-class-name": r(Z), data: r(s).sectionSteelList, "row-style": z, "show-empty-symbol": false, stripe: false, "return-source-data": "", "expand-row-keys": W.value, "row-key": "uid" }, e.$attrs), { default: n(() => [i(Pe, { "expand-row-keys": W.value, "onUpdate:expandRowKeys": t[0] || (t[0] = (a) => W.value = a), data: r(s).sectionSteelList, "row-key": "uid", fixed: "left" }, { default: n(({ row: a }) => [u("div", Fe, [i(l, { modelValue: a.remark, "onUpdate:modelValue": (d) => a.remark = d, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), i(o, { align: "center", label: "序号", type: "index", width: "60" }), i(o, { align: "center", label: "编号", prop: "serialNumber" }, { header: n(() => t[1] || (t[1] = [u("span", { style: { color: "red" } }, "*", -1), m("编号 ")])), _: 1 }), i(o, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { header: n(() => t[2] || (t[2] = [u("span", { style: { color: "red" } }, "*", -1), m("物料种类 ")])), default: n(({ row: a }) => [i(f, { content: a.classifyParentFullName, disabled: !a.classifyParentFullName, "show-after": 500, placement: "top" }, { default: n(() => [Ie(u("span", null, null, 512), [[ge, a.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), i(o, { align: "center", label: "规格", "min-width": "200px", prop: "specification", "show-overflow-tooltip": "" }, { header: n(() => t[3] || (t[3] = [u("span", { style: { color: "red" } }, "*", -1), m("规格 ")])), default: n(({ row: a }) => [i(f, { content: a.specificationLabels, placement: "top" }, { default: n(() => [u("span", null, S(a.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), i(o, { align: "center", label: "标准", "min-width": "200px", prop: "standardId", "show-overflow-tooltip": "" }, { header: n(() => t[4] || (t[4] = [u("span", { style: { color: "red" } }, "*", -1), m("标准 ")])), default: n(({ row: a }) => [i(g, { modelValue: a.standardId, "onUpdate:modelValue": (d) => a.standardId = d, dataStructure: { key: "standardId", label: "name", value: "standardId" }, options: a.nationalStandardOptions || [], placeholder: "请选择标准", size: "default", style: { width: "100%" }, type: "other", onChange: (d) => ce(a, a.nationalStandardOptions) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), i(o, { label: `定尺长度 (${r(h).length.unit})`, align: "center", "min-width": "150", prop: "length" }, { header: n(() => [t[5] || (t[5] = u("span", { style: { color: "red" } }, "*", -1)), m("定尺长度 (" + S(r(h).length.unit) + ") ", 1)]), default: n(({ row: a }) => [i(y, { modelValue: a.length, "onUpdate:modelValue": (d) => a.length = d, controls: false, max: 999999999, min: 0, precision: r(h).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), i(o, { label: `数量 (${r(h).measure.unit})`, align: "center", prop: "quantity" }, { header: n(() => [t[6] || (t[6] = u("span", { style: { color: "red" } }, "*", -1)), m("数量 (" + S(r(h).measure.unit) + ") ", 1)]), default: n(({ row: a }) => [i(y, { modelValue: a.quantity, "onUpdate:modelValue": (d) => a.quantity = d, controls: false, min: 1, precision: r(h).measure.precision, step: 5, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), i(o, { label: "总长度 (m)", align: "center", "min-width": "170", prop: "totalLength" }, { header: n(() => t[7] || (t[7] = [u("span", { style: { color: "red" } }, "*", -1), m("总长度 (m) ")])), _: 1 }), i(o, { key: "weighingTotalWeight", label: `总重 (${r(h).weight.unit})`, align: "center", "min-width": "100px", prop: "weighingTotalWeight" }, { header: n(() => [t[8] || (t[8] = u("span", { style: { color: "red" } }, "*", -1)), m("总重 (" + S(r(h).weight.unit) + ") ", 1)]), default: n(({ row: a }) => [i(f, { content: `理论重量：${a.theoryTotalWeight} kg， ${r(B)}`, disabled: !a.hasOver, class: "item", effect: "dark", placement: "top" }, { default: n(() => [i(y, { modelValue: a.weighingTotalWeight, "onUpdate:modelValue": (d) => a.weighingTotalWeight = d, class: Se({ "over-weight-tip": a.hasOver }), controls: false, max: 999999999, min: 0, precision: r(h).weight.precision, "controls-position": "right", placeholder: "重量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"]), r(s).boolPartyA ? q("", true) : (L(), _(ze, { key: 0, "is-required-identifier": "" })), i(o, { align: "center", label: "品牌", "min-width": "150", prop: "brand" }, { default: n(({ row: a }) => [i(l, { modelValue: a.brand, "onUpdate:modelValue": (d) => a.brand = d, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(o, { align: "center", label: "炉批号/卷号", "min-width": "150", prop: "heatNoAndBatchNo" }, { default: n(({ row: a }) => [i(l, { modelValue: a.heatNoAndBatchNo, "onUpdate:modelValue": (d) => a.heatNoAndBatchNo = d, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号/卷号", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(o, { align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, Ve({ default: n(({ row: a, $index: d }) => [i(je, { modelValue: a.projectId, "onUpdate:modelValue": (p) => a.projectId = p, "show-extra": d !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (p) => de(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 2 }, [r(s).boolPartyA ? { name: "header", fn: n(() => [t[9] || (t[9] = u("span", { style: { color: "red" } }, "*", -1)), t[10] || (t[10] = m("所属项目 "))]), key: "0" } : void 0]), 1024), i(o, { align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { header: n(() => t[11] || (t[11] = [u("span", { style: { color: "red" } }, "*", -1), m("仓库 ")])), default: n(({ row: a, $index: d }) => [i(Ae, { modelValue: a.workshopId, "onUpdate:modelValue": (p) => a.workshopId = p, "show-extra": d !== 0, clearable: "", placeholder: "请选择仓库", style: { width: "100%" }, onChange: (p) => re(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), i(o, { align: "center", label: "存储位置", prop: "warehouseId", width: "140px" }, { header: n(() => t[12] || (t[12] = [u("span", { style: { color: "red" } }, "*", -1), m("存储位置 ")])), default: n(({ row: a, $index: d }) => [i(Ee, { modelValue: a.warehouseId, "onUpdate:modelValue": (p) => a.warehouseId = p, "basic-class": a.basicClass, "show-extra": d !== 0, "workshop-id": a.workshopId, clearable: "", placeholder: "请选择存储位置", style: { width: "100%" }, onChange: (p) => ue(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra", "workshop-id", "onChange"])]), _: 1 }), r(s).boolPartyA ? q("", true) : (L(), _(o, { key: 1, align: "center", label: "供应商", prop: "supplierId", width: "140px" }, { default: n(({ row: a, $index: d }) => [i(Be, { ref: "supplierRef", modelValue: a.supplierId, "onUpdate:modelValue": (p) => a.supplierId = p, "basic-class": r(s).materialType, "show-extra": d !== 0, clearable: "", filterable: "", mode: "cross" }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra"])]), _: 1 })), i(o, { align: "center", label: "整料/余料", prop: "materialIsWhole", width: "140px" }, { header: n(() => t[13] || (t[13] = [u("span", { style: { color: "red" } }, "*", -1), m("整料/余料 ")])), default: n(({ row: a, $index: d }) => [i(g, { modelValue: a.materialIsWhole, "onUpdate:modelValue": (p) => a.materialIsWhole = p, options: r(Re).ENUM, "show-extra": d !== 0, clearable: "", placeholder: "请选择整料/余料", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), i(o, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: n(({ row: a, $index: d }) => [i(c, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (p) => se(a, a.rowIndex) }, null, 8, ["onClick"]), i(c, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (p) => oe(a.sn, d, a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  Qe as default
};
