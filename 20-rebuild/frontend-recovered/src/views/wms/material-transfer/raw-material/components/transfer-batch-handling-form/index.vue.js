import { ref as u } from "vue";
import { computed as j } from "vue";
import { watchEffect as ne } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as x } from "vue";
import { createBlock as w } from "vue";
import { withCtx as r } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as d } from "vue";
import { unref as E } from "vue";
import { createCommentVNode as I } from "vue";
import { toDisplayString as Q } from "vue";
import { isRef as ie } from "vue";
import { ElMessage as L } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElInput as ue } from "element-plus";
import { ElTag as de } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElForm as me } from "element-plus";
import { d as pe, e as fe, f as be, h as he, i as ye, j as ge } from "../../../../../../modules/transfer-handling-96ed23ad.js";
import { g as ve } from "../../../../../../modules/material-inventory-71cd4559.js";
import { xC as _e, fg as Te, x$ as c, sP as xe, u as we, o as Ee, am as g, b as Ve, fv as ke, r8 as Re, r9 as Ce, aR as Ie, k4 as Ue, jG as Pe, sO as Ae, k5 as Be, k6 as Se, xD as je, j_ as q, xG as Le, cS as Ne } from "../../../../../../shared/runtime.js";
const He = { class: "form-header" }, Oe = { class: "flex-rbc" }, Qe = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, qe = { style: { display: "inline-block", width: "50px" } }, We = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, materialList: { type: Array, default: () => [] } }, emits: ["success", "update:visible"], setup(b, { emit: F }) {
  const { realTimeValidate: z } = _e(), N = F, v = b;
  Te();
  const M = { transferType: [{ required: true, message: "请选择调拨类型", trigger: "change" }], projectId: [{ required: true, message: "请选择调拨项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择调拨车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择调拨仓库", trigger: "change" }], realTime: [{ validator: z, message: "请选择实际调拨时间", trigger: "change" }] }, h = u(), U = u([]), V = u([]), y = u([]), f = u([]), e = u({ list: [], transferType: c.PROJECT_WARE.V }), P = u(false), $ = u([...xe]), { visible: k, handleClose: H } = we({ emit: N, props: v, field: "visible", showHook: K }), { maxHeight: W } = Ee({ mainBox: ".wms-batch-transfer-handling", extraBox: [".el-dialog__header", ".form-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 350 }, k), D = j(() => e.value.transferType === c.PROJECT_WARE.V), O = j(() => e.value.transferType !== c.RETURN_PARTY_A.V), J = j(() => v.basicClass === g.STEEL_PLATE.V ? { minRows: 2, maxRows: 2 } : { minRows: 1, maxRows: 1 }), A = u([]);
  ne(() => {
    var a;
    let s = 0;
    y.value = v.materialList.filter((o) => o.corOperableQuantity > 0), f.value = [], A.value = [], e.value.list = y.value, e.value.list.map((o) => {
      o.realTime = o.realTime || (/* @__PURE__ */ new Date()).getTime();
    }), y.value.forEach((o) => {
      var n;
      o.boolPartyA && s++, A.value.push((n = o.project) == null ? void 0 : n.id);
    }), s ? V.value = [] : V.value = [c.RETURN_PARTY_A.V], Ve((a = y.value[0]) == null ? void 0 : a.project) && (e.value.transferType = c.PROJECT_WARE.V, V.value.push(c.PUBLIC_WARE.V));
  });
  function G(s) {
  }
  function Y() {
    f.value = [], e.value = { list: [], transferType: c.PROJECT_WARE.V }, h.value && h.value.resetFields();
  }
  function K() {
    h.value && h.value.clearValidate();
  }
  function X() {
    e.value.list.forEach((s) => {
      s.batchTransferQuantity = s.corOperableQuantity;
    });
  }
  function Z() {
    e.value.list.forEach((s) => {
      s.batchTransferQuantity = void 0;
    });
  }
  async function ee() {
    try {
      if (P.value = true, !await h.value.validate()) return;
      const a = te(v.basicClass), o = { transferType: e.value.transferType, projectId: e.value.projectId, monomerId: e.value.monomerId, areaId: e.value.areaId, workshopId: e.value.workshopId, warehouseId: e.value.warehouseId, list: [] };
      if (e.value.list.forEach((n) => {
        n.batchTransferQuantity && o.list.push({ id: n.id, quantity: n.batchTransferQuantity, outboundUnit: n.outboundUnit, outboundUnitPrecision: n.outboundUnitPrecision, outboundUnitType: n.outboundUnitType, remark: n.remark, realTime: n.realTime });
      }), await Le(o.list, { unitField: "outboundUnit", unitPrecisionField: "outboundUnitPrecision", fields: ["quantity"], toSmallest: true, toNum: true }), o.list.length === 0) {
        L.warning("请填写数据");
        return;
      }
      if (f.value = [], v.basicClass & q.STEEL.V) {
        const n = o.list.map((p) => p.id), { content: m } = await ve({ ids: n });
        o.list.map((p) => {
          const i = m == null ? void 0 : m.find((S) => S.id === p.id), B = p.outboundUnitType === Ne.MEASURE.V ? (i == null ? void 0 : i.quantity) - ((i == null ? void 0 : i.frozenQuantity) || 0) : (i == null ? void 0 : i.mete) - ((i == null ? void 0 : i.frozenMete) || 0);
          p.quantity > B && f.value.push(p);
        });
      }
      if (f.value.length > 0) {
        L.error("标红部分库存不足");
        return;
      }
      await a(o), L.success("已提交调拨申请"), N("success"), H(), setTimeout(() => {
        Y();
      }, 0);
    } catch (s) {
      console.log("调拨办理", s);
    } finally {
      P.value = false;
    }
  }
  function ae(s) {
    s === c.RETURN_PARTY_A.V ? e.value.list = y.value.filter((a) => a.boolPartyA) : e.value.list = y.value;
  }
  function te(s) {
    switch (s) {
      case g.STEEL_PLATE.V:
        return ge;
      case g.SECTION_STEEL.V:
        return ye;
      case g.STEEL_COIL.V:
        return he;
      case g.OTHER.V:
        return be;
      case g.GAS.V:
        return fe;
      default:
        return pe;
    }
  }
  return (s, a) => {
    const o = T("common-button"), n = T("common-radio"), m = re, p = ue, i = T("common-input-number"), B = de, S = ce, le = T("common-table"), se = me, oe = T("common-dialog");
    return x(), w(oe, { modelValue: E(k), "onUpdate:modelValue": a[5] || (a[5] = (t) => ie(k) ? k.value = t : null), width: "95%", "before-close": E(H), "show-close": true, "custom-class": "wms-batch-transfer-handling", title: "调拨办理", top: "10vh" }, { titleRight: r(() => [l(o, { loading: P.value, size: "default", type: "primary", onClick: ee }, { default: r(() => a[6] || (a[6] = [C(" 提 交")])), _: 1, __: [6] }, 8, ["loading"])]), default: r(() => [l(se, { ref_key: "formRef", ref: h, model: e.value, rules: M, class: "form", inline: "", "label-position": "right", "label-width": "70px", size: "default" }, { default: r(() => [d("div", He, [l(m, { label: "类型", "label-width": "55px", prop: "transferType" }, { default: r(() => [l(n, { modelValue: e.value.transferType, "onUpdate:modelValue": a[0] || (a[0] = (t) => e.value.transferType = t), "disabled-val": V.value, options: E(c).ENUM, size: "default", type: "enum", onChange: ae }, null, 8, ["modelValue", "disabled-val", "options"])]), _: 1 }), D.value ? (x(), w(m, { key: 0, label: "项目", "label-width": "55px", prop: "projectId" }, { default: r(() => [l(ke, { modelValue: e.value.projectId, "onUpdate:modelValue": a[1] || (a[1] = (t) => e.value.projectId = t), disabledVal: A.value, class: "input-underline", clearable: "", style: { width: "200px" }, onChange: G }, null, 8, ["modelValue", "disabledVal"])]), _: 1 })) : I("", true), O.value ? (x(), w(m, { key: 1, label: "仓库", "label-width": "55px", prop: "workshopId" }, { default: r(() => [l(Re, { modelValue: e.value.workshopId, "onUpdate:modelValue": a[2] || (a[2] = (t) => e.value.workshopId = t), class: "input-underline", placeholder: "仓库", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })) : I("", true), O.value ? (x(), w(m, { key: 2, label: "存储位置", "label-width": "110px", prop: "warehouseId" }, { default: r(() => [l(Ce, { modelValue: e.value.warehouseId, "onUpdate:modelValue": a[3] || (a[3] = (t) => e.value.warehouseId = t), "basic-class": b.basicClass, "workshop-id": e.value.workshopId, class: "input-underline", placeholder: "存储位置", style: { width: "200px" } }, null, 8, ["modelValue", "basic-class", "workshop-id"])]), _: 1 })) : I("", true)]), l(le, { ref: "tableRef", data: e.value.list, "data-format": $.value, "default-expand-all": false, "expand-row-keys": U.value, "max-height": E(W), "row-key": "id" }, { default: r(() => [l(Ie, { "expand-row-keys": U.value, "onUpdate:expandRowKeys": a[4] || (a[4] = (t) => U.value = t), data: e.value.list, fixed: "left", "row-key": "id" }, { default: r(({ row: t }) => [l(Ue, { "basic-class": t.basicClass, row: t }, { default: r(() => [d("p", null, [a[7] || (a[7] = C(" 项目：")), d("span", null, Q(t.projectFullName), 1)]), l(p, { modelValue: t.sourceRow.remark, "onUpdate:modelValue": (R) => t.sourceRow.remark = R, autosize: J.value, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { "max-width": "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue", "autosize"])]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(Pe, { "basic-class": b.basicClass, fixed: "left" }, null, 8, ["basic-class"]), l(Ae, { "basic-class": b.basicClass }, null, 8, ["basic-class"]), l(Be, { "basic-class": b.basicClass, "show-batch-no": false }, null, 8, ["basic-class"]), l(Se), l(je, { showSourceRow: "", label: "实际调拨时间" }), l(S, { label: "调拨数量", width: "230px", align: "center", fixed: "right" }, { header: r(() => [a[8] || (a[8] = d("span", null, "调拨数量", -1)), d("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: X }, "全部调拨"), d("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: Z }, "清空")]), default: r(({ row: { sourceRow: t } }) => {
      var R;
      return [d("span", Oe, [l(i, { modelValue: t.batchTransferQuantity, "onUpdate:modelValue": (_) => t.batchTransferQuantity = _, max: t.corOperableQuantity, min: 0, precision: t.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), d("span", Qe, [C(Q(t.outboundUnit), 1), d("span", qe, [b.basicClass & E(q).STEEL.V && f.value.findIndex((_) => _.id === t.id) > -1 && !(t.batchOutboundQuantity < ((R = f.value.find((_) => _.id === t.id)) == null ? void 0 : R.quantity)) ? (x(), w(B, { key: 0, class: "ml-2", style: { "margin-left": "2px" }, type: "danger" }, { default: r(() => a[9] || (a[9] = [C("不足")])), _: 1, __: [9] })) : I("", true)])])])];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  We as default
};
