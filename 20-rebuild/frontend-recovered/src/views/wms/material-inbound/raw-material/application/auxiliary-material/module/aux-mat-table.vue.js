import { ref as Q } from "vue";
import { inject as me } from "vue";
import { computed as pe } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as fe } from "vue";
import { openBlock as i } from "vue";
import { createBlock as f } from "vue";
import { withCtx as o } from "vue";
import { createCommentVNode as V } from "vue";
import { createVNode as s } from "vue";
import { unref as m } from "vue";
import { createElementVNode as h } from "vue";
import { createElementBlock as _ } from "vue";
import { toDisplayString as p } from "vue";
import { withDirectives as $ } from "vue";
import { createTextVNode as S } from "vue";
import { Fragment as ye } from "vue";
import { mergeProps as be } from "vue";
import { reactive as F } from "vue";
import { watch as D } from "vue";
import { ElTableColumn as ge } from "element-plus";
import { ElInput as he } from "element-plus";
import { ElTooltip as _e } from "element-plus";
import { Edit as xe } from "@element-plus/icons-vue";
import { View as ke } from "@element-plus/icons-vue";
import { ElPopover as Pe } from "element-plus";
import { am as Ue, tC as Ve, aR as ve, i as I, yt as Ae, uY as Ie, cS as N, z as Se, c9 as Ne, aw as Ce, aI as Y, iX as C, D as G } from "../../../../../../../shared/runtime.js";
import { u as Oe } from "../../../../../../../modules/use-over-receive-ba08adae.js";
const je = { class: "mtb-10", style: { "margin-left": "30px" } }, Me = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px" } }, qe = { key: 1 }, Be = { key: 0 }, De = { class: "color-green" }, Re = { key: 1 }, Te = { class: "color-green" }, Ee = { key: 1 }, Le = { key: 1 }, ze = { key: 1 }, Qe = { key: 1 }, $e = { style: { "margin-left": "5px", cursor: "pointer" } }, Fe = { key: 0 }, Ye = { key: 1 }, Ge = { class: "color-green" }, Ke = { class: "color-green" }, We = { key: 1 }, Je = { key: 1 }, tt = { __name: "aux-mat-table", props: { boolPartyA: { type: Boolean, default: false }, boolApplyPurchase: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, basicClass: { type: [String, Number], default: Ue.MATERIAL.V }, noDetail: { type: Boolean, default: false } }, setup(P, { expose: K }) {
  const c = P, v = Q(), O = me("matSpecRef"), { cu: x, form: u } = Ve(), j = Q([]), W = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, l) => l.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: Ne, message: "核算量必须大于0", trigger: "blur" }] }, J = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, l) => I(l.mete) && I(l.unitPrice) ? +C(l.mete * l.unitPrice, G.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, X = pe(() => {
    let e = Object.assign({}, W);
    return !c.boolPartyA && c.fillableAmount && (e = Object.assign(e, J)), e;
  }), { tableValidate: H, wrongCellMask: Z } = Ce({ rules: X }), { handleOverQuantity: R, handleOverMete: T } = Oe({ meteField: "mete" });
  function w(e, l) {
    return !!e.canPurchaseQuantity || true;
  }
  function ee(e, l) {
    const a = e.findIndex((d) => d.id === l.id) !== -1;
    u.selectObj[l.mergeId].isSelected = a;
  }
  function te(e) {
    const l = !!(e != null && e.length);
    u.auxMatList.forEach((a) => {
      u.selectObj[a.mergeId].isSelected = l;
    });
  }
  function ae(e = false) {
    u.auxMatList.forEach((l) => {
      var a, d;
      (d = (a = u.selectObj) == null ? void 0 : a[l.mergeId]) != null && d.isSelected && v.value.toggleRowSelection(l, true);
    });
  }
  function le({ row: e, rowIndex: l }) {
    var a, d;
    if ((d = (a = x == null ? void 0 : x.submitResult) == null ? void 0 : a.data) != null && d.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ne(e) {
    const l = F({ uid: Y(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, outboundUnitType: e.classify.outboundUnitType, unitNet: e.unitNet, accountingUnitNet: e.accountingUnitNet, mete: void 0, quantity: void 0 });
    return !c.boolPartyA && c.fillableAmount && (l.unitPrice = void 0, l.amount = void 0), l;
  }
  function ie(e) {
    D([() => e.boolApplyPurchase, () => e == null ? void 0 : e.applyPurchase], () => {
      var l, a, d, b;
      e.boolApplyPurchase && ((a = (l = u.selectObj) == null ? void 0 : l[e.mergeId]) != null && a.isSelected) && (e.quantity = (d = e == null ? void 0 : e.applyPurchase) == null ? void 0 : d.reduce((g, k) => g + (k.quantity || 0), 0), e.mete = (b = e == null ? void 0 : e.applyPurchase) == null ? void 0 : b.reduce((g, k) => g + (k.mete || 0), 0));
    }, { deep: true }), D(() => e, () => {
      var l, a, d;
      if (!c.boolPartyA && !c.noDetail && ((a = (l = u.selectObj) == null ? void 0 : l[e.mergeId]) != null && a.isSelected)) {
        const b = (d = u.selectObj[e.mergeId]) == null ? void 0 : d.isSelected;
        u.selectObj[e.mergeId] = { ...u.selectObj[e.mergeId], ...e, isSelected: b };
      }
    }, { deep: true }), D(() => e.mete, () => {
      se(e.mete, e);
    });
  }
  function se(e, l, a) {
    I(l.unitPrice) && I(e) && (l.amount = C(e * l.unitPrice, G.YUAN)), ce(l, a || l);
  }
  function oe(e, l, a) {
    var d, b, g, k;
    if ((b = (d = x == null ? void 0 : x.submitResult) == null ? void 0 : d.data) != null && b.includes(a.classifyId)) {
      const M = (g = x == null ? void 0 : x.submitResult) == null ? void 0 : g.data.findIndex((A) => A === a.classifyId);
      u.auxMatList.filter((A) => A.classifyId === a.classifyId).length === 1 && ((k = x == null ? void 0 : x.submitResult) == null || k.data.splice(M, 1));
    }
    O.value ? O.value.delListItem(e, l) : u.auxMatList.splice(l, 1);
  }
  function E(e, { unitNet: l, accountingPrecision: a }) {
    c.boolPartyA || (e.mete = C(e.quantity * l, a));
  }
  function ce(e, { accountingUnitNet: l, measurePrecision: a }) {
    !c.boolPartyA && e.measureUnit && (e.quantity = C(e.mete * l, a));
  }
  function ue(e, l) {
    const a = F(JSON.parse(JSON.stringify(e)));
    a.uid = Y(), u.auxMatList.push(a), O.value.initSelected([a]);
  }
  function de() {
    const e = u.auxMatList.filter((a) => {
      var d;
      return !!(c.boolPartyA || c.noDetail || (d = u.selectObj[a.mergeId]) != null && d.isSelected);
    }), { validResult: l } = H(e);
    return l;
  }
  function re(e, l) {
    var a;
    (a = v == null ? void 0 : v.value) == null || a.toggleRowSelection(e, l);
  }
  return K({ rowInit: ne, toggleRowSelection: re, setSelect: ae, rowWatch: ie, validate: de }), (e, l) => {
    const a = ge, d = he, b = _e, g = B("common-input-number"), k = xe, M = ke, q = B("common-table"), A = Pe, L = B("common-button"), z = fe("empty-text");
    return i(), f(q, be({ ref_key: "tableRef", ref: v, "cell-class-name": m(Z), data: m(u).auxMatList, "expand-row-keys": j.value, "row-style": le, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs, { onSelect: ee, onSelectAll: te }), { default: o(() => [!c.boolPartyA && !c.noDetail ? (i(), f(a, { key: 0, selectable: w, align: "center", type: "selection", width: "55" })) : V("", true), s(ve, { "expand-row-keys": j.value, "onUpdate:expandRowKeys": l[0] || (l[0] = (t) => j.value = t), data: m(u).auxMatList, fixed: "left", "row-key": "uid" }, { default: o(({ row: t }) => [h("div", je, [s(d, { modelValue: t.remark, "onUpdate:modelValue": (n) => t.remark = n, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), m(I)(t.inboundList) ? (i(), _("div", Me, [s(m(Ae), { "basic-class": P.basicClass, list: t.inboundList, material: t, stripe: false, style: { width: "1600px" } }, null, 8, ["basic-class", "list", "material"])])) : V("", true)]), _: 1 }, 8, ["expand-row-keys", "data"]), s(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(a, { align: "center", fixed: "left", label: "编号", "min-width": "110px", prop: "serialNumber", "show-overflow-tooltip": "" }), s(a, { align: "center", fixed: "left", label: "物料种类", "min-width": "150", prop: "classifyName", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [s(b, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [h("span", null, p(t.classifyName || "-"), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(a, { align: "center", fixed: "left", label: "规格", "min-width": "200px", prop: "specification", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [s(b, { content: t.specificationLabels, placement: "top" }, { default: o(() => [h("span", null, p(t.specification || "-"), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(a, { align: "center", label: "计量单位", "min-width": "70px", prop: "measureUnit" }, { default: o(({ row: t }) => [h("span", null, p(t.measureUnit || "-"), 1)]), _: 1 }), c.boolPartyA || c.noDetail ? (i(), f(a, { key: 1, align: "center", label: "数量", "min-width": "120px", prop: "quantity" }, { default: o(({ row: t }) => [t.measureUnit ? (i(), f(g, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (n) => t.quantity = n, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, size: "default", step: 1, placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : $((i(), _("span", qe, null, 512)), [[z]])]), _: 1 })) : (i(), f(a, { key: 2, label: "采购数量", align: "right", "min-width": "100px", prop: "purchaseQuantity" }, { default: o(({ row: t }) => [t.measureUnit ? (i(), _("span", Be, [s(b, { content: "已入库数量", effect: "dark", placement: "top" }, { default: o(() => [h("span", De, p(t.inboundQuantity), 1)]), _: 2 }, 1024), S(" / " + p(t.purchaseQuantity), 1)])) : $((i(), _("span", Re, null, 512)), [[z]])]), _: 1 })), s(a, { align: "center", label: "核算单位", "min-width": "70px", prop: "accountingUnit" }, { default: o(({ row: t }) => [h("span", null, p(t.accountingUnit || "-"), 1)]), _: 1 }), c.boolPartyA || c.noDetail ? (i(), f(a, { key: 3, align: "center", label: "核算量", "min-width": "120px", prop: "mete" }, { default: o(({ row: t }) => [s(g, { modelValue: t.mete, "onUpdate:modelValue": (n) => t.mete = n, controls: false, max: 999999999, min: 1e-6, precision: t.accountingPrecision, size: "default", step: 1, placeholder: "核算量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 })) : (i(), f(a, { key: 4, label: "采购量", align: "right", "min-width": "100px", prop: "purchaseMete" }, { default: o(({ row: t }) => [h("span", null, [s(b, { content: "已入库量", effect: "dark", placement: "top" }, { default: o(() => [h("span", Te, p(t.inboundMete), 1)]), _: 2 }, 1024), S(" / " + p(t.purchaseMete), 1)])]), _: 1 })), !c.boolPartyA && P.fillableAmount && P.noDetail ? (i(), f(Ie, { key: 5, "weight-attribute": "mete" })) : V("", true), s(a, { align: "center", label: "颜色", "min-width": "120px", prop: "color" }, { default: o(({ row: t }) => {
      var n, r;
      return [c.boolPartyA || c.noDetail || !c.boolPartyA && !c.noDetail && ((r = (n = m(u).selectObj) == null ? void 0 : n[t.mergeId]) != null && r.isSelected) ? (i(), f(d, { key: 0, modelValue: t.color, "onUpdate:modelValue": (y) => t.color = y, modelModifiers: { trim: true }, maxlength: "20", size: "default", placeholder: "颜色" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), _("span", Ee, p(t.color || "-"), 1))];
    }), _: 1 }), s(a, { align: "center", label: "品牌", "min-width": "120px", prop: "brand" }, { default: o(({ row: t }) => {
      var n, r;
      return [c.boolPartyA || c.noDetail || !c.boolPartyA && !c.noDetail && ((r = (n = m(u).selectObj) == null ? void 0 : n[t.mergeId]) != null && r.isSelected) ? (i(), f(d, { key: 0, modelValue: t.brand, "onUpdate:modelValue": (y) => t.brand = y, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), _("span", Le, p(t.brand || "-"), 1))];
    }), _: 1 }), !c.boolPartyA && !c.noDetail ? (i(), _(ye, { key: 6 }, [s(a, { align: "center", label: "本次实收数", "min-width": "120px", prop: "quantity" }, { default: o(({ row: t }) => {
      var n, r;
      return [!P.boolApplyPurchase && t.measureUnit && ((r = (n = m(u).selectObj) == null ? void 0 : n[t.mergeId]) != null && r.isSelected) && t.outboundUnitType === m(N).MEASURE.V ? (i(), f(g, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (y) => t.quantity = y, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, size: "default", step: 1, placeholder: "本次实收数", onBlur: (y) => m(R)(t), onChange: (y) => E(t, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur", "onChange"])) : (i(), _("span", ze, p(t.quantity || "-"), 1))];
    }), _: 1 }), s(a, { align: "center", label: "本次实收量", "min-width": "120px", prop: "mete" }, { default: o(({ row: t }) => {
      var n, r;
      return [!P.boolApplyPurchase && ((r = (n = m(u).selectObj) == null ? void 0 : n[t.mergeId]) != null && r.isSelected) && t.outboundUnitType === m(N).ACCOUNTING.V ? (i(), f(g, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (y) => t.mete = y, controls: false, max: 999999999, min: 1e-6, precision: t.accountingPrecision, size: "default", step: 1, placeholder: "实收量", onBlur: (y) => m(T)(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (i(), _("span", Qe, p(t.mete || "-"), 1))];
    }), _: 1 }), P.boolApplyPurchase ? (i(), f(a, { key: 0, align: "center", fixed: "right", label: "操作", width: "70" }, { default: o(({ row: t }) => [s(A, { width: 900, placement: "top", trigger: "click" }, { reference: o(() => {
      var n, r;
      return [h("span", $e, [(r = (n = m(u).selectObj) == null ? void 0 : n[t.mergeId]) != null && r.isSelected ? (i(), f(k, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle" } })) : (i(), f(M, { key: 1, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle" } }))])];
    }), default: o(() => [s(q, { data: t.applyPurchase, "show-empty-symbol": false, "return-source-data": "", style: { width: "100%" } }, { default: o(() => [s(a, { align: "center", label: "序号", type: "index", width: "60" }), s(a, { "show-overflow-tooltip": true, align: "center", label: "申购单号", "min-width": "140", prop: "serialNumber" }), s(a, { "show-overflow-tooltip": true, align: "center", label: "项目", "min-width": "140", prop: "project" }, { default: o(({ row: n }) => [n.project ? (i(), _("span", Fe, p(m(Se)(n.project)), 1)) : (i(), _("span", Ye, "-"))]), _: 1 }), s(a, { label: "采购数量", align: "right", "min-width": "100px", prop: "purchaseQuantity" }, { default: o(({ row: n }) => [h("span", null, [s(b, { content: "已入库数量", effect: "dark", placement: "top" }, { default: o(() => [h("span", Ge, p(n.inboundQuantity), 1)]), _: 2 }, 1024), S(" / " + p(n.purchaseQuantity), 1)])]), _: 1 }), s(a, { label: "采购量", align: "right", "min-width": "100px", prop: "purchaseMete" }, { default: o(({ row: n }) => [h("span", null, [s(b, { content: "已入库量", effect: "dark", placement: "top" }, { default: o(() => [h("span", Ke, p(n.inboundMete), 1)]), _: 2 }, 1024), S(" / " + p(n.purchaseMete), 1)])]), _: 1 }), s(a, { align: "center", label: "本次实收数", "min-width": "120px", prop: "quantity" }, { default: o(({ row: n }) => {
      var r, y;
      return [t.measureUnit && ((y = (r = m(u).selectObj) == null ? void 0 : r[t.mergeId]) != null && y.isSelected) && t.outboundUnitType === m(N).MEASURE.V ? (i(), f(g, { key: 0, modelValue: n.quantity, "onUpdate:modelValue": (U) => n.quantity = U, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, size: "default", step: 1, placeholder: "本次实收数", onBlur: (U) => m(R)(n), onChange: (U) => E(n, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur", "onChange"])) : (i(), _("span", We, p(n.quantity || "-"), 1))];
    }), _: 2 }, 1024), s(a, { align: "center", label: "本次实收量", "min-width": "120px", prop: "mete" }, { default: o(({ row: n }) => {
      var r, y;
      return [(y = (r = m(u).selectObj) == null ? void 0 : r[t.mergeId]) != null && y.isSelected && t.outboundUnitType === m(N).ACCOUNTING.V ? (i(), f(g, { key: 0, modelValue: n.mete, "onUpdate:modelValue": (U) => n.mete = U, controls: false, max: 999999999, min: 1e-6, precision: t.accountingPrecision, size: "default", step: 1, placeholder: "实收量", onBlur: (U) => m(T)(n) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (i(), _("span", Je, p(n.mete || "-"), 1))];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["data"])]), _: 2 }, 1024)]), _: 1 })) : V("", true)], 64)) : V("", true), c.boolPartyA || c.noDetail ? (i(), f(a, { key: 7, align: "center", fixed: "right", label: "操作", width: "160" }, { default: o(({ row: t, $index: n }) => [s(L, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (r) => ue(t, n) }, null, 8, ["onClick"]), s(L, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (r) => oe(t.sn, n, t) }, null, 8, ["onClick"])]), _: 1 })) : V("", true)]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  tt as default
};
