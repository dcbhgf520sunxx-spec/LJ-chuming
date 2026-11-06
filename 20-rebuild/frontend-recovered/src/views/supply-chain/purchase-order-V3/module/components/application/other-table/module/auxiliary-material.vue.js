import { inject as I } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as re } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as s } from "vue";
import { withCtx as r } from "vue";
import { unref as n } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as g } from "vue";
import { withDirectives as y } from "vue";
import { createElementVNode as L } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as k } from "vue";
import { mergeProps as ce } from "vue";
import { isRef as T } from "vue";
import { Fragment as ue } from "vue";
import { reactive as de } from "vue";
import { watchEffect as me } from "vue";
import { watch as fe } from "vue";
import { ElTableColumn as pe } from "element-plus";
import { ElTooltip as be } from "element-plus";
import { Edit as ge } from "@element-plus/icons-vue";
import { ElInput as ye } from "element-plus";
import { v4 as he, v5 as _e, uY as ve, fE as P, fv as Ve, v6 as Ce, aw as Ue, aI as xe, i as h, b as B, uZ as Ie, iX as F, D as Ne } from "../../../../../../../../shared/runtime.js";
import { u as ke, _ as Pe } from "../../../../../../../../modules/factory-select-b8d0a4ac.js";
const Re = { key: 1 }, Ee = { __name: "auxiliary-material", setup(Se, { expose: A }) {
  var q;
  const R = I("matSpecRef"), i = (q = I("cu")) == null ? void 0 : q.form, m = I("cu");
  function D({ row: e, rowIndex: t }) {
    var l, c, u;
    if ((c = (l = m == null ? void 0 : m.submitResult) == null ? void 0 : l.data) != null && c.includes(e.classifyId) && ((u = m == null ? void 0 : m.submitResult) == null ? void 0 : u.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const E = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, t) => h(e) ? e >= 0 : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (e, t) => h(e) ? F(e, t.accountingPrecision) > 0 : true, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, t) => h(t.mete) && h(t.unitPrice) ? +F(t.mete * t.unitPrice, Ne.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }], factoryId: [{ validator: (e, t) => i.level === P.FACTORY.V ? !!e : true, message: "请选择工厂", trigger: "blur" }] }, { handleMeteChangeCalcPrice: $ } = Ie("mete"), z = /* @__PURE__ */ new Map([["projectId", -1]]), { tableValidate: Y, wrongCellMask: O, cleanUpData: Q } = Ue({ rules: E, ditto: z }), { specSelectMaxHeight: H, specRef: K, drawerRef: W, editRow: X, editList: U, materialSelectVisible: _, handleClickEditSpec: Z, handleSpecChange: G } = he();
  function J(e) {
    const t = de({ uid: xe(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, classifySerialNumber: e.classify.serialNumber, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, outboundUnitType: e.classify.outboundUnitType, unitNet: e.unitNet, accountingUnitNet: e.accountingUnitNet, mete: void 0, quantity: void 0, projectId: i.auxiliaryMaterialList.length > 0 ? -1 : void 0 });
    return S(t), t;
  }
  function S(e) {
    me(() => {
      M(e);
    }), fe([() => e.mete], () => $(e), { immediate: true });
  }
  function w(e, t, l) {
    if (l.purchaseSN) {
      i.auxiliaryMaterialList.splice(t, 1);
      const c = ["list", "originList"];
      for (let u = 0; u < c.length; u++) if (h(i[c[u]])) {
        const p = i[c[u]].findIndex((v) => v.id === l.id);
        p > -1 && i[c[u]].splice(p, 1);
      }
    } else R.value ? R.value.delListItem(e, t) : i.auxiliaryMaterialList.splice(t, 1);
  }
  function Te(e) {
  }
  function Be(e) {
  }
  function ee() {
    const e = i.auxiliaryMaterialList.filter((l) => true);
    if (B(e)) return true;
    const { validResult: t } = Y(e);
    return t && j(e), t;
  }
  function j(e) {
    Q(e), e.forEach((t, l) => {
      i.auxiliaryMaterialList[l].projectId = t.projectId;
    });
  }
  const { projectAllType: ae } = _e();
  function te(e) {
    const t = ae.value.find((l) => l.id === e.projectId);
    e.project = t;
  }
  const { factories: le } = ke();
  function M(e) {
    const t = le.value.find((l) => l.id === e.factoryId);
    e.factoryDTO = t;
  }
  function ie() {
    if (B(i.auxiliaryMaterialList)) return true;
    const e = i.auxiliaryMaterialList.filter((t) => true);
    j(e);
  }
  return A({ rowInit: J, validate: ee, rowWatch: S, TSValidate: ie }), (e, t) => {
    const l = pe, c = be, u = ge, p = V("common-input-number"), v = ye, ne = V("common-button"), se = V("common-table"), oe = V("common-drawer"), b = re("empty-text");
    return d(), C(ue, null, [s(se, ce({ "cell-class-name": n(O), data: n(i).auxiliaryMaterialList, "row-style": D, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: r(() => [s(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), n(i).useRequisitions ? (d(), f(l, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : g("", true), s(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: r(({ row: a }) => [s(c, { content: a.classifyParentFullName, disabled: !a.classifyParentFullName, "show-after": 500, placement: "top" }, { default: r(() => [y(L("span", null, null, 512), [[b, a.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(l, { align: "center", fixed: "left", label: "型号", prop: "specification", "show-overflow-tooltip": "" }, { default: r(({ row: a }) => [n(i).boolUsed ? g("", true) : (d(), f(u, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (o) => n(Z)(a) }, null, 8, ["onClick"])), s(c, { content: a.specificationLabels, placement: "top" }, { default: r(() => [y(L("span", null, null, 512), [[b, a.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(l, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: r(({ row: a }) => [y((d(), C("span", null, [N(k(a.measureUnit), 1)])), [[b]])]), _: 1 }), s(l, { align: "center", label: "数量", prop: "quantity" }, { default: r(({ row: a }) => [a.measureUnit ? (d(), f(p, { key: 0, modelValue: a.quantity, "onUpdate:modelValue": (o) => a.quantity = o, controls: false, disabled: !!n(i).boolUsed, max: 999999999, min: 0, precision: a.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (o) => void 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : y((d(), C("span", Re, [N(k(a.quantity || "-"), 1)])), [[b]])]), _: 1 }), s(l, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: r(({ row: a }) => [y((d(), C("span", null, [N(k(a.accountingUnit), 1)])), [[b]])]), _: 1 }), s(l, { align: "center", label: "核算量", prop: "mete" }, { default: r(({ row: a }) => [s(p, { modelValue: a.mete, "onUpdate:modelValue": (o) => a.mete = o, controls: false, disabled: !!n(i).boolUsed, max: 999999999, min: 1e-6, precision: a.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (o) => void 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])]), _: 1 }), s(ve, { "weight-attribute": "mete" }), s(l, { align: "center", label: "颜色", prop: "color" }, { default: r(({ row: a }) => [s(v, { modelValue: a.color, "onUpdate:modelValue": (o) => a.color = o, modelModifiers: { trim: true }, disabled: !!n(i).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(l, { align: "center", label: "品牌", prop: "brand" }, { default: r(({ row: a }) => [s(v, { modelValue: a.brand, "onUpdate:modelValue": (o) => a.brand = o, modelModifiers: { trim: true }, disabled: !!n(i).boolUsed, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), n(i).level === n(P).FACTORY.V ? (d(), f(l, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: r(({ row: a, $index: o }) => [s(n(Ve), { modelValue: a.projectId, "onUpdate:modelValue": (x) => a.projectId = x, branchCompanyId: n(i).branchCompanyId, disabled: !!n(i).boolUsed, projectAttribute: n(i).projectAttribute, "show-extra": o !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (x) => te(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : g("", true), n(i).level === n(P).FACTORY.V ? (d(), f(l, { key: 2, align: "center", label: "所属工厂", prop: "factoryId", width: "140px" }, { default: r(({ row: a }) => [s(Pe, { modelValue: a.factoryId, "onUpdate:modelValue": (o) => a.factoryId = o, disabled: !!n(i).boolUsed, placeholder: "选择工厂", onChange: (o) => M(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : g("", true), n(i).boolUsed ? g("", true) : (d(), f(l, { key: 3, align: "center", fixed: "right", label: "操作", width: "70" }, { default: r(({ row: a, $index: o }) => [s(ne, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (x) => w(a.sn, o, a) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]), s(oe, { ref_key: "drawerRef", ref: W, modelValue: n(_), "onUpdate:modelValue": t[1] || (t[1] = (a) => T(_) ? _.value = a : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢卷选择" }, { content: r(() => [s(Ce, { ref_key: "specRef", ref: K, modelValue: n(U), "onUpdate:modelValue": t[0] || (t[0] = (a) => T(U) ? U.value = a : null), classifyId: n(X).classifyId, "max-height": n(H), "show-classify": false, visible: n(_), "expand-query": "", mode: "selector", onChange: n(G) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  Ee as default
};
