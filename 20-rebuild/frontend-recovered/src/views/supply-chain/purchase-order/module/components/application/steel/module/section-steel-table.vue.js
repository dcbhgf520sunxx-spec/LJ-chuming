import { inject as C } from "vue";
import { computed as me } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as fe } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as a } from "vue";
import { withCtx as u } from "vue";
import { unref as i } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as D } from "vue";
import { withDirectives as he } from "vue";
import { createElementVNode as E } from "vue";
import { toDisplayString as q } from "vue";
import { normalizeClass as pe } from "vue";
import { mergeProps as ye } from "vue";
import { isRef as $ } from "vue";
import { Fragment as be } from "vue";
import { reactive as _e } from "vue";
import { watchEffect as ve } from "vue";
import { watch as T } from "vue";
import { ElTableColumn as We } from "element-plus";
import { ElTooltip as Ve } from "element-plus";
import { Edit as qe } from "@element-plus/icons-vue";
import { ElInput as Te } from "element-plus";
import { am as Re, sQ as Se, v7 as B, v8 as ke, c9 as N, uY as xe, bR as O, v6 as Ce, i as R, iX as U, D as Ne, aw as Ue, aI as Ie, sU as Le, v9 as Me, b as Pe, uZ as De } from "../../../../../../../../shared/runtime.js";
const Ee = { key: 1 }, $e = { key: 1 }, Be = { key: 1 }, we = { __name: "section-steel-table", setup(Oe, { expose: z }) {
  var M;
  const b = Re.SECTION_STEEL.V, I = C("matSpecRef"), c = C("cu"), n = (M = C("cu")) == null ? void 0 : M.form, { baseUnit: r } = Se(b), { overDiffTip: F, weightOverDiff: w, currentCfg: S } = B(r, { cfgType: "purchase", weightField: "weighingTotalWeight", compareWeightField: "purchaseTotalWeight", weightTip: "申购重量" }), { overDiffTip: Y, weightOverDiff: A, diffSubmitValidate: K } = B(r), { specSelectMaxHeight: Q, specRef: X, drawerRef: j, editRow: H, editList: k, materialSelectVisible: _, handleClickEditSpec: Z, handleSpecChange: G } = ke(), J = (e, s) => R(s.weighingTotalWeight) && R(s.unitPrice) ? +U(s.weighingTotalWeight * s.unitPrice, Ne.YUAN) == +e : false, ee = me(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { pattern: N, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: N, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: n.useRequisitions ? null : K, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: N, message: "重量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: J, message: "金额有误，请手动修改", trigger: "blur" }] })), { handleMeteChangeCalcPrice: te } = De("weighingTotalWeight"), { tableValidate: ie, wrongCellMask: ae } = Ue({ rules: ee, errorMsg: "请修正【型材清单】中标红的信息" });
  function le({ row: e, rowIndex: s }) {
    var l, d;
    if ((d = (l = c == null ? void 0 : c.submitResult) == null ? void 0 : l.data) != null && d.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ne(e) {
    const s = _e({ uid: Ie(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifySerialNumber: e.classify.serialNumber, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, unitWeight: e.unitWeight, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false });
    return L(s), s;
  }
  function L(e) {
    ve(() => {
      n.useRequisitions ? w(e) : A(e);
    }), T([() => e.length, () => e.unitWeight, r], () => se(e)), T([() => e.theoryWeight, () => e.quantity], () => {
      ue(e);
    }), T([() => e.length, () => e.quantity], () => {
      oe(e);
    }), T([() => e.weighingTotalWeight], () => te(e));
  }
  async function se(e) {
    e.theoryWeight = await Le({ length: e.length, unitWeight: e.unitWeight });
  }
  function oe(e) {
    R(e.length) && e.quantity ? e.totalLength = Me({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function ue(e) {
    R(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = U(e.theoryWeight * e.quantity, r.value.weight.precision), e.weighingTotalWeight = U(e.theoryWeight * e.quantity, r.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function ce(e, s, l) {
    var d, v, m, W;
    if ((v = (d = c == null ? void 0 : c.submitResult) == null ? void 0 : d.data) != null && v.includes(l.classifyId)) {
      const x = (m = c == null ? void 0 : c.submitResult) == null ? void 0 : m.data.findIndex((f) => f === l.classifyId);
      n.sectionSteelList.filter((f) => f.classifyId === l.classifyId).length === 1 && ((W = c == null ? void 0 : c.submitResult) == null || W.data.splice(x, 1));
    }
    I.value ? I.value.delListItem(e, s) : n.sectionSteelList.splice(s, 1);
  }
  function re() {
    if (Pe(n.sectionSteelList)) return true;
    const { validResult: e, dealList: s } = ie(n.sectionSteelList);
    return n.sectionSteelList = s, e;
  }
  return z({ rowInit: ne, rowWatch: L, validate: re }), (e, s) => {
    const l = We, d = Ve, v = qe, m = p("common-input-number"), W = Te, x = p("common-radio-button"), P = p("common-button"), f = p("common-table"), de = p("common-drawer"), ge = fe("empty-text");
    return g(), V(be, null, [a(f, ye({ "cell-class-name": i(ae), data: i(n).sectionSteelList, "row-style": le, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: u(() => [a(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), i(n).useRequisitions ? (g(), y(l, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : D("", true), a(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), a(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: u(({ row: t }) => [a(d, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: u(() => [he(E("span", null, null, 512), [[ge, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(l, { align: "center", fixed: "left", label: "规格", "min-width": "140", prop: "specification", "show-overflow-tooltip": "" }, { default: u(({ row: t }) => {
      var o;
      return [!i(n).useRequisitions || i(n).useRequisitions && ((o = i(S)) == null ? void 0 : o.spec) & i(b) ? (g(), y(v, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (h) => i(Z)(t) }, null, 8, ["onClick"])) : D("", true), a(d, { content: t.specificationLabels, placement: "top" }, { default: u(() => [E("span", null, q(t.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), a(l, { label: `定尺长度 (${i(r).length.unit})`, align: "center", "min-width": "120", prop: "length" }, { default: u(({ row: t }) => {
      var o;
      return [!i(n).useRequisitions || i(n).useRequisitions && ((o = i(S)) == null ? void 0 : o.length) & i(b) ? (g(), y(m, { key: 0, modelValue: t.length, "onUpdate:modelValue": (h) => t.length = h, controls: false, max: 999999999, min: 0, precision: i(r).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (g(), V("span", Ee, q(t.length), 1))];
    }), _: 1 }, 8, ["label"]), a(l, { label: `数量 (${i(r).measure.unit})`, align: "center", "min-width": "120", prop: "quantity" }, { default: u(({ row: t }) => {
      var o;
      return [!i(n).useRequisitions || i(n).useRequisitions && ((o = i(S)) == null ? void 0 : o.quantity) & i(b) ? (g(), y(m, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (h) => t.quantity = h, controls: false, max: i(n).useRequisitions ? t.canPurchaseQuantity : 999999999, min: 1, precision: i(r).measure.precision, step: 5, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : (g(), V("span", $e, q(t.quantity), 1))];
    }), _: 1 }, 8, ["label"]), a(l, { label: "总长度 (m)", align: "center", "min-width": "120", prop: "totalLength" }), a(l, { key: "weighingTotalWeight", label: `总重 (${i(r).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: u(({ row: t }) => [i(n).useRequisitions ? (g(), V("span", Be, q(t.weighingTotalWeight || "-"), 1)) : (g(), y(d, { key: 0, content: `单位重量：${t.unitWeight} kg/m， ${i(n).useRequisitions ? `申购重量：${t.purchaseTotalWeight} kg， ${i(F)}` : `理论重量：${t.theoryTotalWeight} kg， ${i(Y)}`}`, disabled: !t.hasOver, class: "item", effect: "dark", placement: "top" }, { default: u(() => [a(m, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (o) => t.weighingTotalWeight = o, class: pe({ "over-weight-tip": t.hasOver }), controls: false, max: 999999999, min: 0, precision: i(r).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"]))]), _: 1 }, 8, ["label"]), a(xe), a(l, { align: "center", label: "品牌", prop: "brand" }, { default: u(({ row: t }) => [a(W, { modelValue: t.brand, "onUpdate:modelValue": (o) => t.brand = o, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(l, { align: "center", label: "计量方式", prop: "weightMeasurementMode", width: "140px" }, { default: u(({ row: t }) => [a(x, { modelValue: t.weightMeasurementMode, "onUpdate:modelValue": (o) => t.weightMeasurementMode = o, options: i(O).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [i(O).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), a(l, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: u(({ row: t, $index: o }) => [a(P, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (h) => ce(t.sn, o, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), a(de, { ref_key: "drawerRef", ref: j, modelValue: i(_), "onUpdate:modelValue": s[1] || (s[1] = (t) => $(_) ? _.value = t : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "型材规格选择" }, { content: u(() => [a(Ce, { ref_key: "specRef", ref: X, modelValue: i(k), "onUpdate:modelValue": s[0] || (s[0] = (t) => $(k) ? k.value = t : null), classifyId: i(H).classifyId, "max-height": i(Q), "show-classify": false, visible: i(_), "expand-query": "", mode: "selector", onChange: i(G) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  we as default
};
