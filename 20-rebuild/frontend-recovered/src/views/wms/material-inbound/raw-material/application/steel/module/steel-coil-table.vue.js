import { computed as ne } from "vue";
import { inject as se } from "vue";
import { ref as oe } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as ce } from "vue";
import { openBlock as r } from "vue";
import { createBlock as y } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as C } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { createElementVNode as N } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as U } from "vue";
import { toDisplayString as _ } from "vue";
import { Fragment as de } from "vue";
import { createTextVNode as L } from "vue";
import { normalizeClass as re } from "vue";
import { mergeProps as ue } from "vue";
import { reactive as O } from "vue";
import { watch as z } from "vue";
import { ElTableColumn as me } from "element-plus";
import { ElInput as pe } from "element-plus";
import { ElTooltip as ge } from "element-plus";
import { am as he, sQ as fe, tC as be, aR as ye, i as V, uY as _e, c9 as I, aw as xe, aI as M, va as ke, iX as q, D as $, b as Ve } from "../../../../../../../shared/runtime.js";
const Ce = { class: "mtb-10" }, Ne = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px" } }, Pe = { class: "color-green" }, ve = { key: 1 }, Ae = { key: 1 }, Ue = { key: 1 }, Le = { key: 1 }, Se = { __name: "steel-coil-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false } }, setup(w, { expose: j }) {
  const s = w, B = he.STEEL_COIL.V, E = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: I, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: I, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: I, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: I, message: "长度必须大于0", trigger: "blur" }] }, F = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, a) => V(a.weighingTotalWeight) && V(a.unitPrice) ? +q(a.weighingTotalWeight * a.unitPrice, $.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, K = ne(() => {
    let e = Object.assign({}, E);
    return !s.boolPartyA && s.fillableAmount && (e = Object.assign(e, F)), e;
  }), T = se("matSpecRef"), { baseUnit: m } = fe(B), { cu: p, form: d } = be(), R = oe([]), { tableValidate: Y, wrongCellMask: J } = xe({ rules: K, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function Q(e, a) {
    return !!e.canPurchaseQuantity || true;
  }
  function X(e, a) {
    const l = e.findIndex((g) => g.id === a.id) !== -1;
    d.selectObj[a.mergeId].isSelected = l;
  }
  function G(e) {
    const a = !!(e != null && e.length);
    d.steelCoilList.forEach((l) => {
      d.selectObj[l.mergeId].isSelected = a;
    });
  }
  function H({ row: e, rowIndex: a }) {
    var l, g;
    if ((g = (l = p == null ? void 0 : p.submitResult) == null ? void 0 : l.data) != null && g.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function Z(e) {
    const a = O({ uid: M(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, color: void 0, brand: void 0, heatNoAndBatchNo: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0 });
    return !s.boolPartyA && s.fillableAmount && (a.unitPrice = void 0, a.amount = void 0), S(a), a;
  }
  function S(e) {
    z([() => e.weighingTotalWeight, () => e.width, () => e.thickness, m], () => ee(e)), z([() => e.theoryLength], () => te(e));
  }
  async function ee(e) {
    e.theoryLength = await ke({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
  }
  function te(e) {
    V(e.theoryLength) ? e.length = e.theoryLength * 1 : e.length = void 0;
  }
  function W(e, a) {
    V(a.unitPrice) && V(e) && (a.amount = q(e * a.unitPrice, $.YUAN));
  }
  function le(e, a, l) {
    var g, P, x, f;
    if ((P = (g = p == null ? void 0 : p.submitResult) == null ? void 0 : g.data) != null && P.includes(l.classifyId)) {
      const v = (x = p == null ? void 0 : p.submitResult) == null ? void 0 : x.data.findIndex((b) => b === l.classifyId);
      d.steelCoilList.filter((b) => b.classifyId === l.classifyId).length === 1 && ((f = p == null ? void 0 : p.submitResult) == null || f.data.splice(v, 1));
    }
    T.value ? T.value.delListItem(e, a) : d.steelCoilList.splice(a, 1);
  }
  function ae(e, a) {
    const l = O(JSON.parse(JSON.stringify(e)));
    l.uid = M(), d.steelCoilList.push(l), S(l), T.value.initSelected([l]);
  }
  function ie() {
    if (Ve(d.steelCoilList)) return true;
    const { validResult: e, dealList: a } = Y(d.steelCoilList);
    return d.steelCoilList = a, d.steelCoilList.forEach((l) => {
      l.quantity = l.length;
    }), e;
  }
  return j({ rowInit: Z, rowWatch: S, validate: ie }), (e, a) => {
    const l = me, g = pe, P = A("inbound-info-table"), x = ge, f = A("common-input-number"), v = A("common-button"), D = A("common-table"), b = ce("empty-text");
    return r(), y(D, ue({ ref: "tableRef", "cell-class-name": o(J), data: o(d).steelCoilList, "expand-row-keys": R.value, "row-style": H, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs, { onSelect: X, onSelectAll: G }), { default: c(() => [!s.boolPartyA && !s.noDetail ? (r(), y(l, { key: 0, selectable: Q, align: "center", type: "selection", width: "55" })) : C("", true), n(ye, { "expand-row-keys": R.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (t) => R.value = t), data: o(d).steelCoilList, fixed: "left", "row-key": "uid" }, { default: c(({ row: t }) => [N("div", Ce, [n(g, { modelValue: t.remark, "onUpdate:modelValue": (i) => t.remark = i, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), o(V)(t.inboundList) ? (r(), k("div", Ne, [n(P, { "basic-class": o(B), list: t.inboundList, material: t, stripe: false, style: { width: "1600px" } }, null, 8, ["basic-class", "list", "material"])])) : C("", true)]), _: 1 }, 8, ["expand-row-keys", "data"]), n(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), n(l, { align: "center", fixed: "left", label: "编号", "min-width": "110px", prop: "serialNumber" }), n(l, { "sort-by": ["serialNumber"], align: "center", fixed: "left", label: "物料种类", "min-width": "120", prop: "classifyName", "show-overflow-tooltip": "", sortable: "" }, { default: c(({ row: t }) => [n(x, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [U(N("span", null, null, 512), [[b, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), n(l, { align: "center", fixed: "left", label: "规格", "min-width": "160px", prop: "specification", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [n(x, { content: t.specificationLabels, placement: "top" }, { default: c(() => [N("span", null, _(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), n(l, { key: "weighingTotalWeight", label: `总重 (${o(m).weight.unit})`, align: "center", "min-width": "135px", prop: "weighingTotalWeight" }, { default: c(({ row: t }) => [n(f, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (i) => t.weighingTotalWeight = i, controls: false, max: 999999999, min: 0, precision: o(m).weight.precision, size: "default", "controls-position": "right", placeholder: "重量", onChange: (i) => W(i, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }, 8, ["label"]), !s.boolPartyA && !s.noDetail ? (r(), k(de, { key: 1 }, [n(l, { label: `采购重量 (${o(m).weight.unit})`, align: "right", "min-width": "120px", prop: "purchaseMete" }, { default: c(({ row: t }) => [N("span", null, [n(x, { content: "已入库量", effect: "dark", placement: "top" }, { default: c(() => [N("span", Pe, _(t.inboundMete), 1)]), _: 2 }, 1024), L(" / " + _(t.purchaseMete), 1)])]), _: 1 }, 8, ["label"]), n(l, { key: "weighingTotalWeight", label: `实收量 (${o(m).weight.unit})`, align: "center", "min-width": "135px", prop: "weighingTotalWeight" }, { default: c(({ row: t }) => {
      var i, u;
      return [(u = (i = o(d).selectObj) == null ? void 0 : i[t.mergeId]) != null && u.isSelected ? (r(), y(f, { key: 0, modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (h) => t.weighingTotalWeight = h, class: re({ "over-weight-tip": t.hasOver }), controls: false, max: 999999999, min: 0, precision: o(m).weight.precision, size: "default", "controls-position": "right", placeholder: "实收量", onBlur: (h) => e.handleOverMete(t), onChange: (h) => W(h, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onBlur", "onChange"])) : (r(), k("span", ve, _(t.weighingTotalWeight || "-"), 1))];
    }), _: 1 }, 8, ["label"])], 64)) : C("", true), n(l, { label: `厚 (${o(m).thickness.unit})`, align: "center", "min-width": "100px", prop: "thickness", sortable: "" }, { default: c(({ row: t }) => [n(f, { modelValue: t.thickness, "onUpdate:modelValue": (i) => t.thickness = i, controls: false, max: 999999, min: 0, precision: o(m).thickness.precision, size: "default", "controls-position": "right", placeholder: "厚" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), n(l, { label: `宽 (${o(m).width.unit})`, align: "center", "min-width": "135px", prop: "width" }, { default: c(({ row: t }) => [n(f, { modelValue: t.width, "onUpdate:modelValue": (i) => t.width = i, controls: false, max: 999999, min: 0, precision: o(m).width.precision, size: "default", "controls-position": "right", placeholder: "宽" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), n(l, { label: `长 (${o(m).length.unit})`, align: "center", "min-width": "135px", prop: "length" }, { default: c(({ row: t }) => [n(f, { modelValue: t.length, "onUpdate:modelValue": (i) => t.length = i, controls: false, max: 999999999, min: 0, precision: o(m).length.precision, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), n(l, { align: "center", label: "颜色", "min-width": "140px", prop: "color" }, { default: c(({ row: t }) => {
      var i, u;
      return [s.boolPartyA || s.noDetail || !s.boolPartyA && !s.noDetail && ((u = (i = o(d).selectObj) == null ? void 0 : i[t.mergeId]) != null && u.isSelected) ? (r(), y(g, { key: 0, modelValue: t.color, "onUpdate:modelValue": (h) => t.color = h, modelModifiers: { trim: true }, maxlength: "20", size: "default", placeholder: "颜色" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : U((r(), k("span", Ae, [L(_(t.color), 1)])), [[b]])];
    }), _: 1 }), !s.boolPartyA && w.fillableAmount ? (r(), y(_e, { key: 2 })) : C("", true), n(l, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: c(({ row: t }) => {
      var i, u;
      return [s.boolPartyA || s.noDetail || !s.boolPartyA && !s.noDetail && ((u = (i = o(d).selectObj) == null ? void 0 : i[t.mergeId]) != null && u.isSelected) ? (r(), y(g, { key: 0, modelValue: t.brand, "onUpdate:modelValue": (h) => t.brand = h, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : U((r(), k("span", Ue, [L(_(t.brand), 1)])), [[b]])];
    }), _: 1 }), n(l, { align: "center", label: "卷号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: c(({ row: t }) => {
      var i, u;
      return [s.boolPartyA || s.noDetail || !s.boolPartyA && !s.noDetail && ((u = (i = o(d).selectObj) == null ? void 0 : i[t.mergeId]) != null && u.isSelected) ? (r(), y(g, { key: 0, modelValue: t.heatNoAndBatchNo, "onUpdate:modelValue": (h) => t.heatNoAndBatchNo = h, modelModifiers: { trim: true }, size: "default", placeholder: "卷号", maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : U((r(), k("span", Le, [L(_(t.heatNoAndBatchNo), 1)])), [[b]])];
    }), _: 1 }), s.boolPartyA || s.noDetail ? (r(), y(l, { key: 3, align: "center", fixed: "right", label: "操作", width: "160" }, { default: c(({ row: t, $index: i }) => [n(v, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (u) => ae(t, i) }, null, 8, ["onClick"]), n(v, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (u) => le(t.sn, i, t) }, null, 8, ["onClick"])]), _: 1 })) : C("", true)]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  Se as default
};
