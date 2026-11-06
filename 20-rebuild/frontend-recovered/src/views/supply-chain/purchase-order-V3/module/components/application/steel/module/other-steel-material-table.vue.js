import { inject as N } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as re } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as o } from "vue";
import { withCtx as r } from "vue";
import { unref as i } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as g } from "vue";
import { withDirectives as y } from "vue";
import { createElementVNode as L } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as S } from "vue";
import { mergeProps as ce } from "vue";
import { isRef as T } from "vue";
import { Fragment as de } from "vue";
import { reactive as ue } from "vue";
import { watchEffect as me } from "vue";
import { watch as fe } from "vue";
import { ElTableColumn as pe } from "element-plus";
import { ElTooltip as be } from "element-plus";
import { Edit as ge } from "@element-plus/icons-vue";
import { ElInput as ye } from "element-plus";
import { v4 as he, v5 as _e, uY as ve, fE as k, fv as Ve, v6 as Ce, aw as Ue, aI as Ie, i as h, b as B, uZ as Ne, iX as F, D as xe } from "../../../../../../../../shared/runtime.js";
import { u as Se, _ as ke } from "../../../../../../../../modules/factory-select-b8d0a4ac.js";
const Pe = { key: 1 }, Ee = { __name: "other-steel-material-table", setup(Re, { expose: A }) {
  var q;
  const P = N("matSpecRef"), n = (q = N("cu")) == null ? void 0 : q.form, m = N("cu");
  function D({ row: e, rowIndex: a }) {
    var l, c, d;
    if ((c = (l = m == null ? void 0 : m.submitResult) == null ? void 0 : l.data) != null && c.includes(e.classifyId) && ((d = m == null ? void 0 : m.submitResult) == null ? void 0 : d.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const E = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, a) => h(e) ? e >= 0 : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (e, a) => h(e) ? F(e, a.accountingPrecision) > 0 : true, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, a) => h(a.mete) && h(a.unitPrice) ? +F(a.mete * a.unitPrice, xe.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }], factoryId: [{ validator: (e, a) => n.level === k.FACTORY.V ? !!e : true, message: "请选择工厂", trigger: "blur" }] }, { handleMeteChangeCalcPrice: $ } = Ne("mete"), z = /* @__PURE__ */ new Map([["projectId", -1]]), { tableValidate: Y, wrongCellMask: O, cleanUpData: Q } = Ue({ rules: E, ditto: z }), { specSelectMaxHeight: H, specRef: K, drawerRef: W, editRow: X, editList: U, materialSelectVisible: _, handleClickEditSpec: Z, handleSpecChange: G } = he();
  function J(e) {
    const a = ue({ uid: Ie(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifySerialNumber: e.classify.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.model, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, outboundUnitType: e.classify.outboundUnitType, unitNet: e.unitNet, accountingUnitNet: e.accountingUnitNet, mete: void 0, quantity: void 0, projectId: n.otherSteelMaterialList.length > 0 ? -1 : void 0 });
    return R(a), a;
  }
  function R(e) {
    me(() => {
      M(e);
    }), fe([() => e.mete], () => {
      $(e);
    }, { immediate: true });
  }
  function w(e, a, l) {
    if (l.purchaseSN) {
      n.otherSteelMaterialList.splice(a, 1);
      const c = ["list", "originList"];
      for (let d = 0; d < c.length; d++) if (h(n[c[d]])) {
        const p = n[c[d]].findIndex((v) => v.id === l.id);
        p > -1 && n[c[d]].splice(p, 1);
      }
    } else P.value ? P.value.delListItem(e, a) : n.otherSteelMaterialList.splice(a, 1);
  }
  function Te(e) {
  }
  function Be(e) {
  }
  function ee() {
    const e = n.otherSteelMaterialList.filter((l) => true);
    if (B(e)) return true;
    const { validResult: a } = Y(e);
    return a && j(e), a;
  }
  function j(e) {
    Q(e), e.forEach((a, l) => {
      n.otherSteelMaterialList[l].projectId = a.projectId;
    });
  }
  const { projectAllType: te } = _e();
  function ae(e) {
    const a = te.value.find((l) => l.id === e.projectId);
    e.project = a;
  }
  const { factories: le } = Se();
  function M(e) {
    const a = le.value.find((l) => l.id === e.factoryId);
    e.factoryDTO = a;
  }
  function ne() {
    if (B(n.otherSteelMaterialList)) return true;
    const e = n.otherSteelMaterialList.filter((a) => true);
    j(e);
  }
  return A({ rowInit: J, validate: ee, rowWatch: R, TSValidate: ne }), (e, a) => {
    const l = pe, c = be, d = ge, p = V("common-input-number"), v = ye, ie = V("common-button"), oe = V("common-table"), se = V("common-drawer"), b = re("empty-text");
    return u(), C(de, null, [o(oe, ce({ "cell-class-name": i(O), data: i(n).otherSteelMaterialList, "row-style": D, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: r(() => [o(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), i(n).useRequisitions ? (u(), f(l, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : g("", true), o(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), o(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => [o(c, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: r(() => [y(L("span", null, null, 512), [[b, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), o(l, { align: "center", fixed: "left", label: "型号", prop: "specification", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => [i(n).boolUsed ? g("", true) : (u(), f(d, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (s) => i(Z)(t) }, null, 8, ["onClick"])), o(c, { content: t.specificationLabels, placement: "top" }, { default: r(() => [y(L("span", null, null, 512), [[b, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), o(l, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: r(({ row: t }) => [y((u(), C("span", null, [x(S(t.measureUnit), 1)])), [[b]])]), _: 1 }), o(l, { align: "center", label: "数量", prop: "quantity" }, { default: r(({ row: t }) => [t.measureUnit ? (u(), f(p, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (s) => t.quantity = s, controls: false, disabled: !!i(n).boolUsed, max: 999999999, min: 0, precision: t.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (s) => void 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : y((u(), C("span", Pe, [x(S(t.quantity || "-"), 1)])), [[b]])]), _: 1 }), o(l, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: r(({ row: t }) => [y((u(), C("span", null, [x(S(t.accountingUnit), 1)])), [[b]])]), _: 1 }), o(l, { align: "center", label: "核算量", prop: "mete" }, { default: r(({ row: t }) => [o(p, { modelValue: t.mete, "onUpdate:modelValue": (s) => t.mete = s, controls: false, disabled: !!i(n).boolUsed, max: 999999999, min: 1e-6, precision: t.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (s) => void 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])]), _: 1 }), o(ve, { "weight-attribute": "mete" }), o(l, { align: "center", label: "颜色", prop: "color" }, { default: r(({ row: t }) => [o(v, { modelValue: t.color, "onUpdate:modelValue": (s) => t.color = s, modelModifiers: { trim: true }, disabled: !!i(n).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), o(l, { align: "center", label: "品牌", prop: "brand" }, { default: r(({ row: t }) => [o(v, { modelValue: t.brand, "onUpdate:modelValue": (s) => t.brand = s, modelModifiers: { trim: true }, disabled: !!i(n).boolUsed, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), i(n).level === i(k).FACTORY.V ? (u(), f(l, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: r(({ row: t, $index: s }) => [o(i(Ve), { modelValue: t.projectId, "onUpdate:modelValue": (I) => t.projectId = I, branchCompanyId: i(n).branchCompanyId, disabled: !!i(n).boolUsed, projectAttribute: i(n).projectAttribute, "show-extra": s !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (I) => ae(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : g("", true), i(n).level === i(k).FACTORY.V ? (u(), f(l, { key: 2, align: "center", label: "所属工厂", prop: "factoryId", width: "140px" }, { default: r(({ row: t }) => [o(ke, { modelValue: t.factoryId, "onUpdate:modelValue": (s) => t.factoryId = s, disabled: !!i(n).boolUsed, placeholder: "选择工厂", onChange: (s) => M(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : g("", true), i(n).boolUsed ? g("", true) : (u(), f(l, { key: 3, align: "center", fixed: "right", label: "操作", width: "70" }, { default: r(({ row: t, $index: s }) => [o(ie, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (I) => w(t.sn, s, t) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]), o(se, { ref_key: "drawerRef", ref: W, modelValue: i(_), "onUpdate:modelValue": a[1] || (a[1] = (t) => T(_) ? _.value = t : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "其它钢材选择" }, { content: r(() => [o(Ce, { ref_key: "specRef", ref: K, modelValue: i(U), "onUpdate:modelValue": a[0] || (a[0] = (t) => T(U) ? U.value = t : null), classifyId: i(X).classifyId, "max-height": i(H), "show-classify": false, visible: i(_), "expand-query": "", mode: "selector", onChange: i(G) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  Ee as default
};
