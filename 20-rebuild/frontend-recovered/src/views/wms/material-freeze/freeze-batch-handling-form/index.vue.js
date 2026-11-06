import { ref as u } from "vue";
import { computed as Y } from "vue";
import { watchEffect as J } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as M } from "vue";
import { createBlock as S } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as V } from "vue";
import { unref as v } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as W } from "vue";
import { createCommentVNode as X } from "vue";
import { isRef as Z } from "vue";
import { ElMessage as R } from "element-plus";
import { ElTag as ee } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElInput as te } from "element-plus";
import { ElForm as se } from "element-plus";
import { a as F, g as le, o as ne, s as ie, b as oe, c as re } from "../../../../modules/freeze-handling-a93ff3c0.js";
import { g as ue } from "../../../../modules/material-inventory-71cd4559.js";
import { sP as ce, u as me, o as de, am as d, x$ as fe, jG as pe, sO as be, k5 as he, k6 as ye, j_ as z, xG as _e, cS as xe } from "../../../../shared/runtime.js";
const ge = { class: "flex-rbc" }, Ee = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, ve = { style: { display: "inline-block", width: "50px" } }, Ve = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, materialList: { type: Array, default: () => [] } }, emits: ["success", "update:visible"], setup(b, { emit: A }) {
  const U = A, h = b, Q = {}, f = u(), P = u([]), B = u([]), T = u([]), c = u([]), m = u({ list: [] }), w = u(false), I = u([...ce]), { visible: x, handleClose: L } = me({ emit: U, props: h, field: "visible", showHook: q }), { maxHeight: N } = de({ mainBox: ".wms-batch-transfer-handling", extraBox: [".el-dialog__header", ".form-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 350 }, x), O = Y(() => h.basicClass === d.STEEL_PLATE.V ? { minRows: 2, maxRows: 2 } : { minRows: 1, maxRows: 1 });
  J(() => {
    let t = 0;
    T.value = h.materialList.filter((e) => e.corOperableQuantity > 0), c.value = [], m.value.list = T.value, T.value.forEach((e) => {
      e.boolPartyA && t++;
    }), t ? B.value = [] : B.value = [fe.RETURN_PARTY_A.V];
  });
  function H() {
    c.value = [], m.value = { list: [] }, f.value && f.value.resetFields();
  }
  function q() {
    f.value && f.value.clearValidate();
  }
  function $() {
    m.value.list.forEach((t) => {
      t.batchTransferQuantity = t.corOperableQuantity;
    });
  }
  function j() {
    m.value.list.forEach((t) => {
      t.batchTransferQuantity = void 0;
    });
  }
  async function D() {
    try {
      if (w.value = true, !await f.value.validate()) return;
      const e = G(h.basicClass), r = { list: [] };
      if (m.value.list.forEach((l) => {
        l.batchTransferQuantity && r.list.push({ materialId: l.id, quantity: l.batchTransferQuantity, outboundUnit: l.outboundUnit, outboundUnitPrecision: l.outboundUnitPrecision, outboundUnitType: l.outboundUnitType, remark: l.remark });
      }), await _e(r.list, { unitField: "outboundUnit", unitPrecisionField: "outboundUnitPrecision", fields: ["quantity"], toSmallest: true, toNum: true }), r.list.length === 0) {
        R.warning("请填写数据");
        return;
      }
      if (c.value = [], h.basicClass & z.STEEL.V) {
        const l = r.list.map((i) => i.materialId), { content: y } = await ue({ ids: l });
        r.list.map((i) => {
          const a = y == null ? void 0 : y.find((k) => k.id === i.materialId), C = i.outboundUnitType === xe.MEASURE.V ? (a == null ? void 0 : a.quantity) - ((a == null ? void 0 : a.frozenQuantity) || 0) : (a == null ? void 0 : a.mete) - ((a == null ? void 0 : a.frozenMete) || 0);
          i.quantity > C && c.value.push(i);
        });
      }
      if (c.value.length > 0) {
        R.error("标红部分库存不足");
        return;
      }
      await e(r.list), R.success("已提交冻结申请"), U("success"), L(), setTimeout(() => {
        H();
      }, 0);
    } catch (t) {
      console.log("冻结办理", t);
    } finally {
      w.value = false;
    }
  }
  function G(t) {
    switch (t) {
      case d.STEEL_PLATE.V:
        return re;
      case d.SECTION_STEEL.V:
        return oe;
      case d.STEEL_COIL.V:
        return ie;
      case d.MATERIAL.V:
        return F;
      case d.OTHER.V:
        return ne;
      case d.GAS.V:
        return le;
      default:
        return F;
    }
  }
  return (t, e) => {
    const r = E("common-button"), l = E("common-input-number"), y = ee, i = ae, a = te, C = E("common-table"), k = se, K = E("common-dialog");
    return M(), S(K, { modelValue: v(x), "onUpdate:modelValue": e[0] || (e[0] = (s) => Z(x) ? x.value = s : null), "before-close": v(L), "show-close": true, "custom-class": "wms-batch-transfer-handling", title: "冻结办理", top: "10vh", width: "90%" }, { titleRight: o(() => [n(r, { loading: w.value, size: "default", type: "primary", onClick: D }, { default: o(() => e[1] || (e[1] = [V(" 提 交")])), _: 1, __: [1] }, 8, ["loading"])]), default: o(() => [n(k, { ref_key: "formRef", ref: f, model: m.value, rules: Q, class: "form", inline: "", "label-position": "right", "label-width": "70px", size: "default" }, { default: o(() => [n(C, { ref: "tableRef", data: m.value.list, "data-format": I.value, "default-expand-all": false, "expand-row-keys": P.value, "max-height": v(N), "row-key": "id" }, { default: o(() => [n(pe, { "basic-class": b.basicClass }, null, 8, ["basic-class"]), n(be, { "basic-class": b.basicClass }, null, 8, ["basic-class"]), n(he, { "basic-class": b.basicClass, "show-batch-no": false }, null, 8, ["basic-class"]), n(ye), n(i, { align: "center", fixed: "right", label: "冻结数量", width: "230px" }, { header: o(() => [e[2] || (e[2] = p("span", null, "冻结数量", -1)), p("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: $ }, "全部冻结"), p("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: j }, "清空")]), default: o(({ row: { sourceRow: s } }) => {
      var g;
      return [p("span", ge, [n(l, { modelValue: s.batchTransferQuantity, "onUpdate:modelValue": (_) => s.batchTransferQuantity = _, max: s.corOperableQuantity, min: 0, precision: s.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), p("span", Ee, [V(W(s.outboundUnit), 1), p("span", ve, [b.basicClass & v(z).STEEL.V && c.value.findIndex((_) => _.id === s.id) > -1 && !(s.batchOutboundQuantity < ((g = c.value.find((_) => _.id === s.id)) == null ? void 0 : g.quantity)) ? (M(), S(y, { key: 0, class: "ml-2", style: { "margin-left": "2px" }, type: "danger" }, { default: o(() => e[3] || (e[3] = [V("不足")])), _: 1, __: [3] })) : X("", true)])])])];
    }), _: 1 }), n(i, { fixed: "right", label: "备注", width: "230px" }, { default: o(({ row: { sourceRow: s } }) => [n(a, { modelValue: s.remark, "onUpdate:modelValue": (g) => s.remark = g, autosize: O.value, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { "max-width": "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue", "autosize"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Ve as default
};
