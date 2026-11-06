import { ref as c } from "vue";
import { inject as W } from "vue";
import { computed as x } from "vue";
import { watch as P } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as w } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as s } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as v } from "vue";
import { createElementVNode as k } from "vue";
import { isRef as Q } from "vue";
import { ElDescriptionsItem as K } from "element-plus";
import { ElDescriptions as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElTooltip as q } from "element-plus";
import { a as G } from "../../../../modules/mes-receipt-review-377f871a.js";
import { _ as J, jX as Z, o as $, u as ee, i as b, cO as ae, jl as te, z as oe, xY as h, pz as le, pA as ne, ba as re } from "../../../../shared/runtime.js";
const se = { __name: "auto-detail", props: { modelValue: { type: Boolean, default: false } }, emits: ["refresh", "update:modelValue", "deleteRow"], setup(N, { emit: V }) {
  const B = V, j = N, C = c(), m = c(false), D = c([]), r = W("mainCurrentRow"), y = c([]), z = c([...Z, ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), R = x(() => "冻结明细"), { maxHeight: I } = $({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => x(() => !m.value)), { visible: p, handleClose: L } = ee({ emit: B, props: j, closeHook: E });
  P(p, async (o) => {
    o && await T();
  }, { immediate: true });
  async function T() {
    if (b(r.value)) try {
      m.value = true;
      const o = await G({ id: r.value.taskOrderId });
      let i = [];
      b(o) && (i = [o]), y.value = await A(i);
    } catch (o) {
      console.log("加载失败", o);
    } finally {
      m.value = false;
    }
  }
  async function A(o) {
    return await ae(o), o = await te(o, { toSmallest: false, toNum: false }), o;
  }
  function E() {
  }
  function F(o) {
    return re(o, { props: ["frozenQuantity", "frozenMete"] });
  }
  return (o, i) => {
    const u = K, H = X, g = f("table-cell-tag"), l = Y, M = q, O = f("common-table"), S = f("common-drawer");
    return _(), w(S, { ref_key: "drawerRef", ref: C, modelValue: t(p), "onUpdate:modelValue": i[0] || (i[0] = (e) => Q(p) ? p.value = e : null), "content-loading": m.value, "close-on-click-modal": false, "before-close": t(L), title: R.value, "show-close": true, size: "80%", "custom-class": "raw-mat-application-review-form" }, { content: n(() => [a(H, { column: 2, border: "", style: { "margin-bottom": "10px" } }, { default: n(() => [a(u, { label: "项目", "label-class-name": "contractLabel" }, { default: n(() => [d(s(t(b)(t(r).project) ? t(oe)(t(r).project) : "-"), 1)]), _: 1 }), a(u, { label: "工单号", "label-class-name": "contractLabel" }, { default: n(() => [d(s(t(r).taskOrderNumber || "-"), 1)]), _: 1 }), a(u, { label: "车间", "label-class-name": "contractLabel" }, { default: n(() => {
      var e;
      return [d(s(((e = t(r).mesWorkshop) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 }), a(u, { label: "领用人", "label-class-name": "contractLabel" }, { default: n(() => {
      var e;
      return [d(s(((e = t(r).applicant) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 })]), _: 1 }), a(O, { data: y.value, "data-format": z.value, "max-height": t(I), "show-summary": "", "summary-method": F, "expand-row-keys": D.value, "row-key": "id" }, { default: n(() => [a(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }, { default: n(({ row: { sourceRow: e }, $index: U }) => [e.boolPartyA ? (_(), w(g, { key: 0, show: !!e.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : v("", true), !e.boolPartyA && e.materialIsWhole === t(h).ODDMENT.V ? (_(), w(g, { key: 1, color: t(h).V[e.materialIsWhole].COLOR, name: t(h).VL[e.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : v("", true), k("span", null, s(U + 1), 1)]), _: 1 }), a(l, { key: "serialNumber", align: "left", label: "物料编码", prop: "serialNumber", "show-overflow-tooltip": "", "min-width": "100" }), a(l, { key: "classifyName", align: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "", "min-width": "100" }), a(l, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" }, { default: n(({ row: e }) => [a(M, { content: t(le)(e), placement: "left" }, { default: n(() => [k("span", null, s(t(ne)(e)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), a(l, { key: "brand", align: "left", label: "品牌", prop: "brand", "show-overflow-tooltip": "", width: "100" }), a(l, { key: "heatNoAndBatchNo", align: "left", label: "炉批号", prop: "heatNoAndBatchNo", "show-overflow-tooltip": "", "min-width": "100" }), a(l, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "80px" }), a(l, { key: "frozenQuantity", prop: "frozenQuantity", label: "数量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), a(l, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "80px" }), a(l, { key: "frozenMete", prop: "frozenMete", label: "核算", align: "center", "show-overflow-tooltip": "", "min-width": "80px" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, pe = J(se, [["__scopeId", "data-v-a0d6add9"]]);
export {
  pe as default
};
