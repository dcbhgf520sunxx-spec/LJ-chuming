import { inject as x } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as ce } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as s } from "vue";
import { withCtx as c } from "vue";
import { unref as i } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as b } from "vue";
import { withDirectives as y } from "vue";
import { createElementVNode as B } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as k } from "vue";
import { mergeProps as re } from "vue";
import { isRef as F } from "vue";
import { Fragment as de } from "vue";
import { reactive as ue } from "vue";
import { watchEffect as me } from "vue";
import { watch as fe } from "vue";
import { ElTableColumn as pe } from "element-plus";
import { ElTooltip as ge } from "element-plus";
import { Edit as be } from "@element-plus/icons-vue";
import { ElInput as ye } from "element-plus";
import { v4 as he, v5 as _e, uY as ve, fE as P, fv as Ce, v6 as Ve, aw as Ie, aI as Ue, i as h, b as T, uZ as xe, iX as A, D as Ne } from "../../../../../../../../shared/runtime.js";
import { u as ke, _ as Pe } from "../../../../../../../../modules/factory-select-b8d0a4ac.js";
const Re = { key: 1 }, Me = { __name: "other", setup(Se, { expose: D }) {
  var L;
  const R = x("matSpecRef"), n = (L = x("cu")) == null ? void 0 : L.form, m = x("cu");
  function E({ row: e, rowIndex: a }) {
    var l, r, d;
    if ((r = (l = m == null ? void 0 : m.submitResult) == null ? void 0 : l.data) != null && r.includes(e.classifyId) && ((d = m == null ? void 0 : m.submitResult) == null ? void 0 : d.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const M = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, a) => h(e) ? e >= 0 : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (e, a) => h(e) ? A(e, a.accountingPrecision) > 0 : true, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, a) => h(a.mete) && h(a.unitPrice) ? +A(a.mete * a.unitPrice, Ne.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }], factoryId: [{ validator: (e, a) => n.level === P.FACTORY.V ? !!e : true, message: "请选择工厂", trigger: "blur" }] }, { handleMeteChangeCalcPrice: $ } = xe("mete"), Y = /* @__PURE__ */ new Map([["projectId", -1]]), { tableValidate: z, wrongCellMask: O, cleanUpData: Q } = Ie({ rules: M, ditto: Y }), { specSelectMaxHeight: w, specRef: H, drawerRef: K, editRow: W, editList: V, materialSelectVisible: _, handleClickEditSpec: X, handleSpecChange: Z } = he();
  function G(e) {
    const a = ue({ uid: Ue(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifySerialNumber: e.classify.serialNumber, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, mete: void 0, quantity: void 0, projectId: n.otherList.length > 0 ? -1 : void 0 });
    return S(a), a;
  }
  function S(e) {
    me(() => {
      q(e);
    }), fe([() => e.mete], () => $(e), { immediate: true });
  }
  function J(e, a, l) {
    if (l.purchaseSN) {
      n.otherList.splice(a, 1);
      const r = ["list", "originList"];
      for (let d = 0; d < r.length; d++) if (h(n[r[d]])) {
        const p = n[r[d]].findIndex((I) => I.id === l.id);
        p > -1 && n[r[d]].splice(p, 1);
      }
    } else R.value ? R.value.delListItem(e, a) : n.otherList.splice(a, 1);
  }
  function Fe(e) {
  }
  function Te(e) {
  }
  function ee() {
    const e = n.otherList.filter((l) => true);
    if (T(e)) return true;
    const { validResult: a } = z(e);
    return a && j(e), a;
  }
  function j(e) {
    Q(e), e.forEach((a, l) => {
      n.otherList[l].projectId = a.projectId;
    });
  }
  const { projectAllType: te } = _e();
  function ae(e) {
    const a = te.value.find((l) => l.id === e.projectId);
    e.project = a;
  }
  const { factories: le } = ke();
  function q(e) {
    const a = le.value.find((l) => l.id === e.factoryId);
    e.factoryDTO = a;
  }
  function ne() {
    if (T(n.otherList)) return true;
    const e = n.otherList.filter((a) => true);
    j(e);
  }
  return D({ rowInit: G, validate: ee, rowWatch: S, TSValidate: ne }), (e, a) => {
    const l = pe, r = ge, d = be, p = v("common-input-number"), I = ye, ie = v("common-button"), se = v("common-table"), oe = v("common-drawer"), g = ce("empty-text");
    return u(), C(de, null, [s(se, re({ "cell-class-name": i(O), data: i(n).otherList, "row-style": E, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: c(() => [s(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), i(n).useRequisitions ? (u(), f(l, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : b("", true), s(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [s(r, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [y(B("span", null, null, 512), [[g, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(l, { align: "center", fixed: "left", label: "型号", prop: "specification", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [i(n).boolUsed ? b("", true) : (u(), f(d, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (o) => i(X)(t) }, null, 8, ["onClick"])), s(r, { content: t.specificationLabels, placement: "top" }, { default: c(() => [y(B("span", null, null, 512), [[g, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(l, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: c(({ row: t }) => [y((u(), C("span", null, [N(k(t.measureUnit), 1)])), [[g]])]), _: 1 }), s(l, { align: "center", label: "数量", prop: "quantity" }, { default: c(({ row: t }) => [t.measureUnit ? (u(), f(p, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (o) => t.quantity = o, controls: false, disabled: !!i(n).boolUsed, max: 999999999, min: 0, precision: t.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (o) => void 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : y((u(), C("span", Re, [N(k(t.quantity || "-"), 1)])), [[g]])]), _: 1 }), s(l, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: c(({ row: t }) => [y((u(), C("span", null, [N(k(t.accountingUnit), 1)])), [[g]])]), _: 1 }), s(l, { align: "center", label: "核算量", prop: "mete" }, { default: c(({ row: t }) => [s(p, { modelValue: t.mete, "onUpdate:modelValue": (o) => t.mete = o, controls: false, disabled: !!i(n).boolUsed, max: 999999999, min: 1e-6, precision: t.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (o) => void 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])]), _: 1 }), s(ve, { "weight-attribute": "mete" }), s(l, { align: "center", label: "品牌", prop: "brand" }, { default: c(({ row: t }) => [s(I, { modelValue: t.brand, "onUpdate:modelValue": (o) => t.brand = o, modelModifiers: { trim: true }, disabled: !!i(n).boolUsed, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), i(n).level === i(P).FACTORY.V ? (u(), f(l, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: c(({ row: t, $index: o }) => [s(i(Ce), { modelValue: t.projectId, "onUpdate:modelValue": (U) => t.projectId = U, branchCompanyId: i(n).branchCompanyId, disabled: !!i(n).boolUsed, projectAttribute: i(n).projectAttribute, "show-extra": o !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (U) => ae(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : b("", true), i(n).level === i(P).FACTORY.V ? (u(), f(l, { key: 2, align: "center", label: "所属工厂", prop: "factoryId", width: "140px" }, { default: c(({ row: t }) => [s(Pe, { modelValue: t.factoryId, "onUpdate:modelValue": (o) => t.factoryId = o, disabled: !!i(n).boolUsed, placeholder: "选择工厂", onChange: (o) => q(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : b("", true), i(n).boolUsed ? (u(), f(l, { key: 3, align: "center", fixed: "right", label: "操作", width: "70" }, { default: c(({ row: t, $index: o }) => [s(ie, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (U) => J(t.sn, o, t) }, null, 8, ["onClick"])]), _: 1 })) : b("", true)]), _: 1 }, 16, ["cell-class-name", "data"]), s(oe, { ref_key: "drawerRef", ref: K, modelValue: i(_), "onUpdate:modelValue": a[1] || (a[1] = (t) => F(_) ? _.value = t : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢卷选择" }, { content: c(() => [s(Ve, { ref_key: "specRef", ref: H, modelValue: i(V), "onUpdate:modelValue": a[0] || (a[0] = (t) => F(V) ? V.value = t : null), classifyId: i(W).classifyId, "max-height": i(w), "show-classify": false, visible: i(_), "expand-query": "", mode: "selector", onChange: i(Z) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  Me as default
};
