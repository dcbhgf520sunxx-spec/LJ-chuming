import { ref as c } from "vue";
import { computed as Y } from "vue";
import { watchEffect as J } from "vue";
import { watch as X } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as Q } from "vue";
import { createBlock as W } from "vue";
import { withCtx as n } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as m } from "vue";
import { unref as v } from "vue";
import { toDisplayString as Z } from "vue";
import { createCommentVNode as ee } from "vue";
import { isRef as ae } from "vue";
import { ElMessage as I } from "element-plus";
import { ElFormItem as te } from "element-plus";
import { ElTag as se } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElForm as oe } from "element-plus";
import { a as A, g as ne, o as re, s as ue, b as ce, c as de } from "../../../../../../modules/application-0ee072a2.js";
import { g as me } from "../../../../../../modules/material-inventory-71cd4559.js";
import { fg as fe, sP as pe, u as be, o as he, am as f, x$ as ye, bl as H, y3 as _e, jG as ge, sO as ve, k5 as xe, k6 as Ee, j_ as P, xG as we, cS as ke } from "../../../../../../shared/runtime.js";
import { _ as Te } from "../../../../../../modules/workshop-select-210dd661.js";
const Ve = { class: "form-header" }, Ce = { class: "flex-rbc" }, Ie = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, Le = { style: { display: "inline-block", width: "50px" } }, We = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, materialList: { type: Array, default: () => [] } }, emits: ["success", "update:visible"], setup(p, { emit: O }) {
  const L = O, h = p;
  fe();
  const N = { directionWorkshopId: [{ required: true, message: "请选择移库目的仓库", trigger: "change" }], directionWarehouseId: [{ required: true, message: "请选择移库目的存储位置", trigger: "change" }] }, b = c(), B = c([]), U = c([]), w = c([]), d = c([]), t = c({ list: [] }), k = c(false), F = c([...pe]), { visible: y, handleClose: R } = be({ emit: L, props: h, field: "visible", showHook: z }), { maxHeight: q } = he({ mainBox: ".wms-batch-transfer-handling", extraBox: [".el-dialog__header", ".form-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 350 }, y);
  Y(() => h.basicClass === f.STEEL_PLATE.V ? { minRows: 2, maxRows: 2 } : { minRows: 1, maxRows: 1 });
  function M() {
    d.value = [], t.value = { list: [] }, b.value && b.value.resetFields();
  }
  function z() {
    b.value && b.value.clearValidate();
  }
  function $() {
    t.value.list.forEach((s) => {
      s.batchTransferQuantity = s.corOperableQuantity;
    });
  }
  J(() => {
    let s = 0;
    w.value = h.materialList.filter((e) => e.corOperableQuantity > 0), d.value = [], t.value.list = w.value, w.value.forEach((e) => {
      e.boolPartyA && s++;
    }), s ? U.value = [] : U.value = [ye.RETURN_PARTY_A.V], t.value.list.forEach((e) => {
      e.basicClass === H.STEEL_COIL.V && (e.batchTransferQuantity = e.corOperableQuantity);
    });
  });
  function S() {
    t.value.list.forEach((s) => {
      s.batchTransferQuantity = void 0;
    });
  }
  async function j() {
    try {
      if (k.value = true, !await b.value.validate()) return;
      const e = D(h.basicClass), r = { directionWorkshopId: t.value.directionWorkshopId, directionWarehouseId: t.value.directionWarehouseId, detailList: [] };
      if (t.value.list.forEach((o) => {
        o.batchTransferQuantity && r.detailList.push({ materialId: o.id, quantity: o.batchTransferQuantity, outboundUnit: o.outboundUnit, outboundUnitPrecision: o.outboundUnitPrecision, outboundUnitType: o.outboundUnitType, remark: o.remark });
      }), await we(r.detailList, { unitField: "outboundUnit", unitPrecisionField: "outboundUnitPrecision", fields: ["quantity"], toSmallest: true, toNum: true }), r.detailList.length === 0) {
        I.warning("请填写数据");
        return;
      }
      if (d.value = [], h.basicClass & P.STEEL.V) {
        const o = r.detailList.map((u) => u.materialId), { content: _ } = await me({ ids: o });
        r.detailList.map((u) => {
          const l = _ == null ? void 0 : _.find((V) => V.id === u.id), T = u.outboundUnitType === ke.MEASURE.V ? (l == null ? void 0 : l.quantity) - ((l == null ? void 0 : l.frozenQuantity) || 0) : (l == null ? void 0 : l.mete) - ((l == null ? void 0 : l.frozenMete) || 0);
          u.quantity > T && d.value.push(u);
        });
      }
      if (d.value.length > 0) {
        I.error("标红部分库存不足");
        return;
      }
      await e(r), I.success("已提交移库申请"), L("success"), R(), setTimeout(() => {
        M();
      }, 0);
    } catch (s) {
      console.log("移库办理", s);
    } finally {
      k.value = false;
    }
  }
  function D(s) {
    switch (s) {
      case f.STEEL_PLATE.V:
        return de;
      case f.SECTION_STEEL.V:
        return ce;
      case f.STEEL_COIL.V:
        return ue;
      case f.MATERIAL.V:
        return A;
      case f.OTHER.V:
        return re;
      case f.GAS.V:
        return ne;
      default:
        return A;
    }
  }
  return X(() => y.value, async (s) => {
    s === false && (await M(), await S());
  }), (s, e) => {
    const r = E("common-button"), o = te, _ = E("common-input-number"), u = se, l = le, T = ie, V = E("common-table"), G = oe, K = E("common-dialog");
    return Q(), W(K, { modelValue: v(y), "onUpdate:modelValue": e[2] || (e[2] = (a) => ae(y) ? y.value = a : null), "before-close": v(R), "show-close": true, "custom-class": "wms-batch-transfer-handling", title: "移库办理", top: "10vh", width: "90%" }, { titleRight: n(() => [i(r, { loading: k.value, size: "default", type: "primary", onClick: j }, { default: n(() => e[3] || (e[3] = [C(" 提 交")])), _: 1, __: [3] }, 8, ["loading"])]), default: n(() => [i(G, { ref_key: "formRef", ref: b, model: t.value, rules: N, class: "form", inline: "", "label-position": "right", "label-width": "70px", size: "default" }, { default: n(() => [m("div", Ve, [i(o, { label: "目的移库仓库", "label-width": "150px", prop: "directionWorkshopId" }, { default: n(() => [i(Te, { modelValue: t.value.directionWorkshopId, "onUpdate:modelValue": e[0] || (e[0] = (a) => t.value.directionWorkshopId = a), class: "input-underline", placeholder: "目的移库仓库", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), i(o, { label: "目的移库存储位置", "label-width": "150px", prop: "directionWarehouseId" }, { default: n(() => [i(_e, { modelValue: t.value.directionWarehouseId, "onUpdate:modelValue": e[1] || (e[1] = (a) => t.value.directionWarehouseId = a), "basic-class": p.basicClass, "workshop-id": t.value.directionWorkshopId, class: "input-underline", placeholder: "存储位置", style: { width: "200px" } }, null, 8, ["modelValue", "basic-class", "workshop-id"])]), _: 1 })]), i(V, { ref: "tableRef", data: t.value.list, "data-format": F.value, "default-expand-all": false, "expand-row-keys": B.value, "max-height": v(q), "row-key": "id" }, { default: n(() => [i(ge, { "basic-class": p.basicClass }, null, 8, ["basic-class"]), i(ve, { "basic-class": p.basicClass }, null, 8, ["basic-class"]), i(xe, { "basic-class": p.basicClass, "show-batch-no": false }, null, 8, ["basic-class"]), i(Ee), i(l, { align: "center", fixed: "right", label: "移库数量", width: "230px" }, { header: n(() => [e[4] || (e[4] = m("span", null, "移库数量", -1)), m("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: $ }, "全部移库"), m("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: S }, "清空")]), default: n(({ row: { sourceRow: a } }) => {
      var x;
      return [m("span", Ce, [i(_, { modelValue: a.batchTransferQuantity, "onUpdate:modelValue": (g) => a.batchTransferQuantity = g, disabled: a.basicClass === v(H).STEEL_COIL.V, max: a.corOperableQuantity, min: 0, precision: a.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"]), m("span", Ie, [C(Z(a.outboundUnit) + " ", 1), m("span", Le, [p.basicClass & v(P).STEEL.V && d.value.findIndex((g) => g.id === a.id) > -1 && !(a.batchOutboundQuantity < ((x = d.value.find((g) => g.id === a.id)) == null ? void 0 : x.quantity)) ? (Q(), W(u, { key: 0, class: "ml-2", style: { "margin-left": "2px" }, type: "danger" }, { default: n(() => e[5] || (e[5] = [C(" 不足 ")])), _: 1, __: [5] })) : ee("", true)])])])];
    }), _: 1 }), i(l, { key: "remark", "show-overflow-tooltip": true, align: "left", fixed: "right", label: "备注", "min-width": "100", prop: "remark" }, { default: n(({ row: { sourceRow: a } }) => [i(T, { modelValue: a.remark, "onUpdate:modelValue": (x) => a.remark = x, modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "备注", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  We as default
};
