import { inject as W } from "vue";
import { computed as Se } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as Ve } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as Te } from "vue";
import { createVNode as s } from "vue";
import { withCtx as r } from "vue";
import { unref as i } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as y } from "vue";
import { withDirectives as We } from "vue";
import { createElementVNode as D } from "vue";
import { toDisplayString as Ce } from "vue";
import { normalizeClass as Ie } from "vue";
import { mergeProps as Ue } from "vue";
import { isRef as R } from "vue";
import { Fragment as Ne } from "vue";
import { reactive as xe } from "vue";
import { watchEffect as ke } from "vue";
import { watch as S } from "vue";
import { ElTableColumn as qe } from "element-plus";
import { ElTooltip as Le } from "element-plus";
import { Edit as De } from "@element-plus/icons-vue";
import { ElInput as Re } from "element-plus";
import { am as je, sQ as Oe, v7 as j, v8 as Pe, v5 as Be, uY as Ee, fE as C, fv as Fe, v6 as $e, i as p, iX as I, D as Me, aw as Ae, aI as ze, sU as Ye, v9 as He, b as O, uZ as Ke } from "../../../../../../../../shared/runtime.js";
import { u as Qe, _ as Xe } from "../../../../../../../../modules/factory-select-b8d0a4ac.js";
const et = { __name: "section-steel-table", setup(Ze, { expose: P }) {
  var L;
  const B = je.SECTION_STEEL.V, U = W("matSpecRef"), n = (L = W("cu")) == null ? void 0 : L.form, m = W("cu");
  function E({ row: e, rowIndex: l }) {
    var a, c, d;
    if ((c = (a = m == null ? void 0 : m.submitResult) == null ? void 0 : a.data) != null && c.includes(e.classifyId) && ((d = m == null ? void 0 : m.submitResult) == null ? void 0 : d.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const { baseUnit: u } = Oe(B), { overDiffTip: F, weightOverDiff: $ } = j(u, { cfgType: "purchase", weightField: "weighingTotalWeight", compareWeightField: "purchaseTotalWeight", weightTip: "申购重量" }), { overDiffTip: M, weightOverDiff: A, diffSubmitValidate: z } = j(u), { specSelectMaxHeight: Y, specRef: H, drawerRef: K, editRow: Q, editList: V, materialSelectVisible: _, handleClickEditSpec: X, handleSpecChange: Z } = Pe(), G = (e, l) => p(l.weighingTotalWeight) && p(l.unitPrice) ? +I(l.weighingTotalWeight * l.unitPrice, Me.YUAN) == +e : false, J = (e, l) => n.level === C.FACTORY.V ? !!e : true, N = (e, l) => p(e) ? e > 0 : true, w = (e, l) => p(e) ? e >= 0 : true, ee = (e, l) => p(l.purchaseSN) ? !!e : z(e, l), te = Se(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { validator: N, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ validator: w, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: ee, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: N, message: "重量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: G, message: "金额有误，请手动修改", trigger: "blur" }], factoryId: [{ validator: J, message: "请选择工厂", trigger: "blur" }] })), { handleMeteChangeCalcPrice: ae } = Ke("weighingTotalWeight"), ie = /* @__PURE__ */ new Map([["projectId", -1]]), { tableValidate: le, wrongCellMask: ne, cleanUpData: se } = Ae({ rules: te, errorMsg: "请修正【型材清单】中标红的信息", ditto: ie });
  function oe(e) {
    var f;
    const l = (f = e.nationalStandardOptions.find((g) => g.boolDefault === true)) == null ? void 0 : f.standardId, a = xe({ uid: ze(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifySerialNumber: e.classify.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, unitWeight: e.unitWeight, nationalStandardOptions: e.nationalStandardOptions, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false, standardId: l, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0, projectId: n.sectionSteelList.length > 0 ? -1 : void 0 });
    let c;
    const d = [];
    for (const g in a.specificationMap) g.indexOf("standard") > -1 ? c = a.specificationMap[g] : d.push(a.specificationMap[g]);
    return a.sectionSteelSpec = c, a.doNotSectionSteelSpec = d.join(" * "), x(a), a;
  }
  function x(e) {
    ke(() => {
      q(e), e.purchaseSN ? $(e) : A(e);
    }), S([() => e.length, () => e.unitWeight, u], () => ce(e)), S([() => e.theoryWeight, () => e.quantity], () => {
      de(e);
    }), S([() => e.length, () => e.quantity], () => {
      re(e);
    }), S([() => e.weighingTotalWeight], () => ae(e));
  }
  async function ce(e) {
    e.theoryWeight = await Ye({ length: e.length, unitWeight: e.unitWeight }), console.log(e.theoryWeight, "theoryWeight");
  }
  function re(e) {
    p(e.length) && e.quantity ? e.totalLength = He({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function de(e) {
    console.log(e, "row"), p(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = I(e.theoryWeight * e.quantity, u.value.weight.precision), e.weighingTotalWeight = I(e.theoryWeight * e.quantity, u.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function ue(e, l, a) {
    if (a.purchaseSN) {
      n.sectionSteelList.splice(l, 1);
      const c = ["list", "originList"];
      for (let d = 0; d < c.length; d++) if (p(n[c[d]])) {
        const f = n[c[d]].findIndex((g) => g.id === a.id);
        f > -1 && n[c[d]].splice(f, 1);
      }
    } else U.value ? U.value.delListItem(e, l) : n.sectionSteelList.splice(l, 1);
  }
  function fe() {
    const e = n.sectionSteelList.filter((a) => true);
    if (O(e)) return true;
    const { validResult: l } = le(e);
    return l && k(e), l;
  }
  function k(e) {
    se(e), e.forEach((l, a) => {
      n.sectionSteelList[a].projectId = l.projectId;
    });
  }
  const { projectAllType: ge } = Be();
  function pe(e) {
    const l = ge.value.find((a) => a.id === e.projectId);
    e.project = l;
  }
  const { factories: me } = Qe();
  function q(e) {
    const l = me.value.find((a) => a.id === e.factoryId);
    e.factoryDTO = l;
  }
  function he() {
    if (O(n.sectionSteelList)) return true;
    const e = n.sectionSteelList.filter((l) => true);
    k(e);
  }
  return P({ rowInit: oe, rowWatch: x, validate: fe, TSValidate: he }), (e, l) => {
    const a = qe, c = Le, d = De, f = v("common-input-number"), g = Re, be = v("common-button"), ye = v("common-table"), _e = v("common-drawer"), ve = Ve("empty-text");
    return h(), Te(Ne, null, [s(ye, Ue({ "cell-class-name": i(ne), data: i(n).sectionSteelList, "row-style": E, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: r(() => [s(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), i(n).useRequisitions ? (h(), b(a, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : y("", true), s(a, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), s(a, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => [s(c, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: r(() => [We(D("span", null, null, 512), [[ve, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(a, { align: "center", fixed: "left", label: "型号", "min-width": "140", prop: "specification", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => [i(n).boolUsed ? y("", true) : (h(), b(d, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (o) => i(X)(t) }, null, 8, ["onClick"])), s(c, { content: t.specificationLabels, placement: "top" }, { default: r(() => [D("span", null, Ce(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(a, { label: `定尺长度 (${i(u).length.unit})`, align: "center", "min-width": "120", prop: "length" }, { default: r(({ row: t }) => [s(f, { modelValue: t.length, "onUpdate:modelValue": (o) => t.length = o, controls: false, disabled: !!i(n).boolUsed, max: 999999999, min: 0, precision: i(u).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(a, { label: `数量 (${i(u).measure.unit})`, align: "center", "min-width": "120", prop: "quantity" }, { default: r(({ row: t }) => [s(f, { modelValue: t.quantity, "onUpdate:modelValue": (o) => t.quantity = o, controls: false, disabled: !!i(n).boolUsed, max: 999999999, min: 0, precision: i(u).measure.precision, step: 5, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(a, { label: "总长度 (m)", align: "center", "min-width": "120", prop: "totalLength" }), s(a, { key: "weighingTotalWeight", label: `总重 (${i(u).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: r(({ row: t }) => [s(c, { content: t.purchaseSN ? `申购重量：${t.purchaseTotalWeight} kg， ${i(F)}` : `理论重量：${t.theoryTotalWeight} kg， ${i(M)}`, disabled: !t.hasOver, class: "item", effect: "dark", placement: "top" }, { default: r(() => [s(f, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (o) => t.weighingTotalWeight = o, class: Ie({ "over-weight-tip": t.hasOver }), controls: false, disabled: !!i(n).boolUsed, max: 999999999, min: 0, precision: i(u).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"]), s(Ee), s(a, { align: "center", label: "品牌", prop: "brand" }, { default: r(({ row: t }) => [s(g, { modelValue: t.brand, "onUpdate:modelValue": (o) => t.brand = o, modelModifiers: { trim: true }, disabled: !!i(n).boolUsed, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), i(n).level === i(C).FACTORY.V ? (h(), b(a, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: r(({ row: t, $index: o }) => [s(i(Fe), { modelValue: t.projectId, "onUpdate:modelValue": (T) => t.projectId = T, branchCompanyId: i(n).branchCompanyId, disabled: !!i(n).boolUsed, projectAttribute: i(n).projectAttribute, "show-extra": o !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (T) => pe(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : y("", true), i(n).level === i(C).FACTORY.V ? (h(), b(a, { key: 2, align: "center", label: "所属工厂", prop: "factoryId", width: "140px" }, { default: r(({ row: t }) => [s(Xe, { modelValue: t.factoryId, "onUpdate:modelValue": (o) => t.factoryId = o, disabled: !!i(n).boolUsed, placeholder: "选择工厂", onChange: (o) => q(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : y("", true), i(n).boolUsed ? y("", true) : (h(), b(a, { key: 3, align: "center", fixed: "right", label: "操作", width: "70" }, { default: r(({ row: t, $index: o }) => [s(be, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (T) => ue(t.sn, o, t) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]), s(_e, { ref_key: "drawerRef", ref: K, modelValue: i(_), "onUpdate:modelValue": l[1] || (l[1] = (t) => R(_) ? _.value = t : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "型材规格选择" }, { content: r(() => [s($e, { ref_key: "specRef", ref: H, modelValue: i(V), "onUpdate:modelValue": l[0] || (l[0] = (t) => R(V) ? V.value = t : null), classifyId: i(Q).classifyId, "max-height": i(Y), "show-classify": false, visible: i(_), "expand-query": "", mode: "selector", onChange: i(Z) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  et as default
};
