import { inject as Te } from "vue";
import { ref as We } from "vue";
import { computed as Ue } from "vue";
import { resolveComponent as $ } from "vue";
import { resolveDirective as Se } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as i } from "vue";
import { withCtx as o } from "vue";
import { createBlock as k } from "vue";
import { createCommentVNode as T } from "vue";
import { unref as l } from "vue";
import { createElementVNode as P } from "vue";
import { withDirectives as E } from "vue";
import { toDisplayString as b } from "vue";
import { Fragment as O } from "vue";
import { normalizeClass as J } from "vue";
import { createTextVNode as w } from "vue";
import { mergeProps as Ne } from "vue";
import { isRef as H } from "vue";
import { reactive as X } from "vue";
import { watchEffect as Ce } from "vue";
import { watch as M } from "vue";
import { ElTableColumn as Ie } from "element-plus";
import { ElInput as Ae } from "element-plus";
import { ElTooltip as Be } from "element-plus";
import { Edit as $e } from "@element-plus/icons-vue";
import { am as Oe, sQ as we, tC as qe, v7 as Le, v8 as Re, aR as De, i as U, yt as ze, uY as je, v6 as Ee, c9 as C, aw as Me, aI as G, sT as Fe, iX as F, D as Z, b as Qe } from "../../../../../../../shared/runtime.js";
import { u as Ye } from "../../../../../../../modules/use-over-receive-ba08adae.js";
import Ke from "../../components/inbound-quantity-column.vue.js";
const Je = { class: "mtb-10" }, He = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Xe = { class: "color-green" }, Ge = { class: "color-green" }, Ze = { key: 1 }, et = { key: 1 }, tt = { key: 1 }, lt = { key: 1 }, at = { key: 1 }, it = { key: 1 }, rt = { __name: "steel-plate-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false } }, setup(Q, { expose: ee }) {
  const c = Q, v = Oe.STEEL_PLATE.V, q = Te("matSpecRef"), { baseUnit: r } = we(v), { cu: g, form: p } = qe(), L = We([]), { overDiffTip: Y, weightOverDiff: te, diffSubmitValidate: le, currentCfg: W } = Le(r), { handleOverQuantity: ae, handleOverMete: S } = Ye({ meteField: "weighingTotalWeight" }), { specSelectMaxHeight: ie, specRef: ne, drawerRef: se, editRow: oe, editList: R, materialSelectVisible: I, handleClickEditSpec: ce, handleSpecChange: de } = Re(), re = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: C, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: C, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: le, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: C, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: C, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: C, message: "数量必须大于0", trigger: "blur" }] }, ue = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (t, s) => U(s.weighingTotalWeight) && U(s.unitPrice) ? +F(s.weighingTotalWeight * s.unitPrice, Z.YUAN) == +t : false, message: "金额有误，请手动修改", trigger: "blur" }] }, me = Ue(() => {
    let t = Object.assign({}, re);
    return !c.boolPartyA && c.fillableAmount && (t = Object.assign(t, ue)), t;
  }), { tableValidate: pe, wrongCellMask: he } = Me({ rules: me, errorMsg: "请修正【钢板清单】中标红的信息" });
  function ge(t, s) {
    return !!t.canPurchaseQuantity || true;
  }
  function fe(t, s) {
    const n = t.findIndex((y) => y.id === s.id) !== -1;
    p.selectObj[s.mergeId].isSelected = n;
  }
  function be(t) {
    const s = !!(t != null && t.length);
    p.steelPlateList.forEach((n) => {
      p.selectObj[n.mergeId].isSelected = s;
    });
  }
  function ye({ row: t, rowIndex: s }) {
    var n, y;
    if ((y = (n = g == null ? void 0 : g.submitResult) == null ? void 0 : n.data) != null && y.includes(t.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function _e(t) {
    const s = X({ uid: G(), sn: t.sn, specificationLabels: t.specificationLabels, serialNumber: t.serialNumber, classifyId: t.classify.id, classifyFullName: t.classify.fullName, classifyName: t.classify.name, classifySerialNumber: t.classify.serialNumber, classifyParentFullName: t.classify.parentFullName, basicClass: t.classify.basicClass, specification: t.spec, specificationMap: t.specKV, measureUnit: t.classify.measureUnit, accountingUnit: t.classify.accountingUnit, accountingPrecision: t.classify.accountingPrecision, measurePrecision: t.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return !c.boolPartyA && c.fillableAmount && (s.unitPrice = void 0, s.amount = void 0), D(s), s;
  }
  function D(t) {
    Ce(() => te(t)), M([() => t.length, () => t.width, () => t.thickness, r], () => ke(t)), M([() => t.theoryWeight, () => t.quantity], () => Ve(t)), M(() => t.weighingTotalWeight, () => {
      z(t);
    });
  }
  async function ke(t) {
    t.theoryWeight = await Fe({ classifyId: t.classifyId, name: t.classifyFullName, length: t.length, width: t.width, thickness: t.thickness });
  }
  function Ve(t) {
    U(t.theoryWeight) && t.quantity ? (t.theoryTotalWeight = t.theoryWeight * t.quantity, t.weighingTotalWeight = F(t.theoryWeight * t.quantity)) : (t.theoryTotalWeight = void 0, t.weighingTotalWeight = void 0);
  }
  function z(t) {
    U(t.unitPrice) && U(t.weighingTotalWeight) && (t.amount = F(t.weighingTotalWeight * t.unitPrice, Z.YUAN));
  }
  function ve(t, s, n) {
    var y, V, f, A;
    if ((V = (y = g == null ? void 0 : g.submitResult) == null ? void 0 : y.data) != null && V.includes(n.classifyId)) {
      const B = (f = g == null ? void 0 : g.submitResult) == null ? void 0 : f.data.findIndex((N) => N === n.classifyId);
      p.steelPlateList.filter((N) => N.classifyId === n.classifyId).length === 1 && ((A = g == null ? void 0 : g.submitResult) == null || A.data.splice(B, 1));
    }
    q.value ? q.value.delListItem(t, s) : p.steelPlateList.splice(s, 1);
  }
  function xe(t, s) {
    const n = X(JSON.parse(JSON.stringify(t)));
    n.uid = G(), p.steelPlateList.push(n), D(n), q.value.initSelected([n]);
  }
  function Pe() {
    if (Qe(p.steelPlateList)) return true;
    const { validResult: t, dealList: s } = pe(p.steelPlateList);
    return p.steelPlateList = s, t;
  }
  return ee({ rowInit: _e, rowWatch: D, validate: Pe }), (t, s) => {
    const n = Ie, y = Ae, V = Be, f = $("common-input-number"), A = $e, B = $("common-button"), K = $("common-table"), N = $("common-drawer"), j = Se("empty-text");
    return m(), _(O, null, [i(K, Ne({ ref: "tableRef", "cell-class-name": l(he), data: l(p).steelPlateList, "expand-row-keys": L.value, "row-style": ye, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, t.$attrs, { onSelect: fe, onSelectAll: be }), { default: o(() => [!c.boolPartyA && !c.noDetail ? (m(), k(n, { key: 0, selectable: ge, align: "center", type: "selection", width: "55" })) : T("", true), i(De, { "expand-row-keys": L.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (e) => L.value = e), data: l(p).steelPlateList, "row-key": "uid" }, { default: o(({ row: e }) => [P("div", Je, [i(y, { modelValue: e.remark, "onUpdate:modelValue": (a) => e.remark = a, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), l(U)(e.inboundList) ? (m(), _("div", He, [i(l(ze), { "basic-class": l(v), list: e.inboundList, material: e, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : T("", true)]), _: 1 }, 8, ["expand-row-keys", "data"]), i(n, { align: "center", label: "序号", type: "index", width: "60" }), i(n, { align: "center", label: "编号", "min-width": "110px", prop: "serialNumber" }), i(n, { "sort-by": ["serialNumber"], align: "center", label: "物料种类", "min-width": "120", prop: "classifyName", "show-overflow-tooltip": "", sortable: "" }, { default: o(({ row: e }) => [i(V, { content: e.classifyParentFullName, disabled: !e.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [E(P("span", null, null, 512), [[j, e.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), i(n, { align: "center", label: "规格", "min-width": "100px", prop: "specification", "show-overflow-tooltip": "" }, { default: o(({ row: e }) => [i(V, { content: e.specificationLabels, placement: "top" }, { default: o(() => [P("span", null, b(e.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), i(n, { label: `厚 (${l(r).thickness.unit})`, align: "center", "min-width": "100px", prop: "thickness", sortable: "" }, { default: o(({ row: e }) => {
      var a, d, u;
      return [c.boolPartyA || c.noDetail || (d = (a = l(p).selectObj) == null ? void 0 : a[e.mergeId]) != null && d.isSelected && ((u = l(W)) == null ? void 0 : u.thickness) & l(v) && !e.boolApplyPurchase ? (m(), k(f, { key: 0, modelValue: e.thickness, "onUpdate:modelValue": (h) => e.thickness = h, controls: false, max: 999999, min: 0, precision: l(r).thickness.precision, size: "default", "controls-position": "right", placeholder: "厚" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : T("", true)];
    }), _: 1 }, 8, ["label"]), i(n, { label: `宽 (${l(r).width.unit})`, align: "center", "min-width": "135px", prop: "width" }, { default: o(({ row: e }) => [i(f, { modelValue: e.width, "onUpdate:modelValue": (a) => e.width = a, controls: false, max: 999999, min: 0, precision: l(r).width.precision, size: "default", "controls-position": "right", placeholder: "宽", onBlur: (a) => l(S)(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), i(n, { label: `长 (${l(r).length.unit})`, align: "center", "min-width": "135px", prop: "length" }, { default: o(({ row: e }) => [i(f, { modelValue: e.length, "onUpdate:modelValue": (a) => e.length = a, controls: false, max: 999999, min: 0, precision: l(r).length.precision, size: "default", placeholder: "长", onBlur: (a) => l(S)(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), c.boolPartyA || c.noDetail ? (m(), _(O, { key: 1 }, [i(n, { label: `数量 (${l(r).measure.unit})`, align: "center", "min-width": "135px", prop: "quantity" }, { default: o(({ row: e }) => [i(f, { modelValue: e.quantity, "onUpdate:modelValue": (a) => e.quantity = a, controls: false, max: 999999999, min: 1, precision: l(r).measure.precision, size: "default", step: 1, "controls-position": "right", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), i(n, { key: "weighingTotalWeight", label: `总重 (${l(r).weight.unit})`, align: "center", "min-width": "135px", prop: "weighingTotalWeight" }, { default: o(({ row: e }) => [i(V, { content: `理论重量：${e.theoryTotalWeight} kg， ${l(Y)}`, disabled: !e.hasOver, class: "item", effect: "dark", placement: "top" }, { default: o(() => [i(f, { modelValue: e.weighingTotalWeight, "onUpdate:modelValue": (a) => e.weighingTotalWeight = a, class: J({ "over-weight-tip": e.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, size: "default", "controls-position": "right", placeholder: "重量", onChange: (a) => z(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onChange"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"])], 64)) : (m(), _(O, { key: 2 }, [i(n, { label: `采购数量 (${l(r).measure.unit})`, align: "right", "min-width": "100px", prop: "purchaseQuantity" }, { default: o(({ row: e }) => [P("span", null, [i(V, { content: "已入库数量", effect: "dark", placement: "top" }, { default: o(() => [P("span", Xe, b(e.inboundQuantity), 1)]), _: 2 }, 1024), w(" / " + b(e.purchaseQuantity), 1)])]), _: 1 }, 8, ["label"]), i(n, { label: `采购重量 (${l(r).weight.unit})`, align: "right", "min-width": "110px", prop: "purchaseMete" }, { default: o(({ row: e }) => [P("span", null, [i(V, { content: "已入库量", effect: "dark", placement: "top" }, { default: o(() => [P("span", Ge, b(e.inboundMete), 1)]), _: 2 }, 1024), w(" / " + b(e.purchaseMete), 1)])]), _: 1 }, 8, ["label"])], 64)), !c.boolPartyA && Q.fillableAmount ? (m(), k(je, { key: 3 })) : T("", true), i(n, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: o(({ row: e }) => {
      var a, d;
      return [c.boolPartyA || c.noDetail || !c.boolPartyA && !c.noDetail && ((d = (a = l(p).selectObj) == null ? void 0 : a[e.mergeId]) != null && d.isSelected) ? (m(), k(y, { key: 0, modelValue: e.brand, "onUpdate:modelValue": (u) => e.brand = u, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : E((m(), _("span", Ze, [w(b(e.brand), 1)])), [[j]])];
    }), _: 1 }), i(n, { align: "center", label: "炉批号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: o(({ row: e }) => {
      var a, d;
      return [c.boolPartyA || c.noDetail || !c.boolPartyA && !c.noDetail && ((d = (a = l(p).selectObj) == null ? void 0 : a[e.mergeId]) != null && d.isSelected) ? (m(), k(y, { key: 0, modelValue: e.heatNoAndBatchNo, "onUpdate:modelValue": (u) => e.heatNoAndBatchNo = u, modelModifiers: { trim: true }, size: "default", placeholder: "炉批号", maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : E((m(), _("span", et, [w(b(e.heatNoAndBatchNo), 1)])), [[j]])];
    }), _: 1 }), !c.boolPartyA && !c.noDetail ? (m(), _(O, { key: 4 }, [i(l(Ke), { "base-unit": l(r), "basic-class": l(v), "current-cfg": l(W), form: l(p), handleOverQuantity: l(ae) }, { editColumn: o(({ row: e }) => [i(n, { align: "center", label: "规格", "min-width": "100px", prop: "specification", "show-overflow-tooltip": "" }, { default: o(({ row: a }) => {
      var d, u, h;
      return [(u = (d = l(p).selectObj) == null ? void 0 : d[e.mergeId]) != null && u.isSelected && ((h = l(W)) == null ? void 0 : h.spec) & l(v) ? (m(), k(A, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (x) => l(ce)(a) }, null, 8, ["onClick"])) : T("", true), i(V, { content: a.specificationLabels, placement: "top" }, { default: o(() => [P("span", null, b(a.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 2 }, 1024), i(n, { label: `厚 (${l(r).thickness.unit})`, align: "center", "min-width": "100px", prop: "thickness" }, { default: o(({ row: a }) => {
      var d, u, h;
      return [c.boolPartyA || (u = (d = l(p).selectObj) == null ? void 0 : d[e.mergeId]) != null && u.isSelected && ((h = l(W)) == null ? void 0 : h.thickness) & l(v) ? (m(), k(f, { key: 0, modelValue: a.thickness, "onUpdate:modelValue": (x) => a.thickness = x, controls: false, max: 999999, min: 0, precision: l(r).thickness.precision, size: "default", "controls-position": "right", placeholder: "厚" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (m(), _("span", tt, b(a.thickness), 1))];
    }), _: 2 }, 1032, ["label"]), i(n, { label: `宽 (${l(r).width.unit})`, align: "center", "min-width": "100px", prop: "width" }, { default: o(({ row: a }) => {
      var d, u, h;
      return [c.boolPartyA || (u = (d = l(p).selectObj) == null ? void 0 : d[e.mergeId]) != null && u.isSelected && ((h = l(W)) == null ? void 0 : h.width) & l(v) ? (m(), k(f, { key: 0, modelValue: a.width, "onUpdate:modelValue": (x) => a.width = x, controls: false, max: 999999, min: 0, precision: l(r).width.precision, size: "default", "controls-position": "right", placeholder: "宽", onBlur: (x) => l(S)(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (m(), _("span", lt, b(a.width), 1))];
    }), _: 2 }, 1032, ["label"]), i(n, { label: `长 (${l(r).length.unit})`, align: "center", "min-width": "100px", prop: "length" }, { default: o(({ row: a }) => {
      var d, u, h;
      return [c.boolPartyA || (u = (d = l(p).selectObj) == null ? void 0 : d[e.mergeId]) != null && u.isSelected && ((h = l(W)) == null ? void 0 : h.length) & l(v) ? (m(), k(f, { key: 0, modelValue: a.length, "onUpdate:modelValue": (x) => a.length = x, controls: false, max: 999999999, min: 0, precision: l(r).length.precision, size: "default", placeholder: "长", onBlur: (x) => l(S)(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (m(), _("span", at, b(e.length), 1))];
    }), _: 2 }, 1032, ["label"])]), _: 1 }, 8, ["base-unit", "basic-class", "current-cfg", "form", "handleOverQuantity"]), i(n, { label: `理论重量 (${l(r).weight.unit})`, align: "center", "min-width": "100px", prop: "theoryTotalWeight" }, null, 8, ["label"]), i(n, { key: "weighingTotalWeight", label: `实收量 (${l(r).weight.unit})`, align: "center", "min-width": "135px", prop: "weighingTotalWeight" }, { default: o(({ row: e }) => [i(V, { content: `理论重量：${e.theoryTotalWeight} kg， ${l(Y)}`, disabled: !e.hasOver, class: "item", effect: "dark", placement: "top" }, { default: o(() => {
      var a, d;
      return [(d = (a = l(p).selectObj) == null ? void 0 : a[e.mergeId]) != null && d.isSelected ? (m(), k(f, { key: 0, modelValue: e.weighingTotalWeight, "onUpdate:modelValue": (u) => e.weighingTotalWeight = u, class: J({ "over-weight-tip": e.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, size: "default", "controls-position": "right", placeholder: "实收量", onBlur: (u) => l(S)(e), onChange: (u) => z(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onBlur", "onChange"])) : (m(), _("span", it, b(e.weighingTotalWeight || "-"), 1))];
    }), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"])], 64)) : T("", true), c.boolPartyA || c.noDetail ? (m(), k(n, { key: 5, align: "center", fixed: "right", label: "操作", width: "160" }, { default: o(({ row: e, $index: a }) => [i(B, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (d) => xe(e, a) }, null, 8, ["onClick"]), i(B, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (d) => ve(e.sn, a, e) }, null, 8, ["onClick"])]), _: 1 })) : T("", true)]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]), i(N, { ref_key: "drawerRef", ref: se, modelValue: l(I), "onUpdate:modelValue": s[2] || (s[2] = (e) => H(I) ? I.value = e : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: o(() => [i(Ee, { ref_key: "specRef", ref: ne, modelValue: l(R), "onUpdate:modelValue": s[1] || (s[1] = (e) => H(R) ? R.value = e : null), classifyId: l(oe).classifyId, "max-height": l(ie), "show-classify": false, visible: l(I), "expand-query": "", mode: "selector", onChange: l(de) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  rt as default
};
