import { ref as i } from "vue";
import { computed as h } from "vue";
import { watch as P } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as p } from "vue";
import { createBlock as f } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as g } from "vue";
import { createElementVNode as x } from "vue";
import { toDisplayString as v } from "vue";
import { isRef as T } from "vue";
import { ElMessage as U } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { ElPopconfirm as W } from "element-plus";
import { _ as F, jX as z, o as Q, u as $, xY as w, pA as q, ba as K } from "../../../../../shared/runtime.js";
const X = { __name: "outbound-detail", props: { modelValue: { type: Boolean, default: false }, showType: { type: String, default: "detail" }, outboundListCurrentRow: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:modelValue", "deleteRow"], setup(k, { emit: R }) {
  const b = R, m = k, C = i(), _ = i(false), V = i([]), d = i([]), j = i([...z, ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), B = h(() => "出库明细表"), { maxHeight: N } = Q({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => h(() => !_.value)), { visible: s, handleClose: D } = $({ emit: b, props: m, closeHook: L });
  P(s, async (a) => {
    var n;
    a && (d.value = ((n = m.outboundListCurrentRow) == null ? void 0 : n.currentOutBoundOptions) || []);
  }, { immediate: true });
  async function H(a, n) {
    try {
      a.uid = m.outboundListCurrentRow.uid, d.value.splice(n, 1), U.success("已删除"), b("deleteRow", a);
    } catch (c) {
      console.log("删除", c);
    }
  }
  function L() {
  }
  function I(a) {
    return K(a, { props: ["quantity", "mete"] });
  }
  return (a, n) => {
    const c = u("table-cell-tag"), o = S, M = u("common-button"), O = W, A = u("common-table"), E = u("common-drawer");
    return p(), f(E, { ref_key: "drawerRef", ref: C, modelValue: l(s), "onUpdate:modelValue": n[0] || (n[0] = (t) => T(s) ? s.value = t : null), "content-loading": _.value, "close-on-click-modal": false, "before-close": l(D), title: B.value, "show-close": true, size: "80%", "custom-class": "raw-mat-application-review-form" }, { content: r(() => [e(A, { data: d.value, "data-format": j.value, "max-height": l(N), "show-summary": "", "summary-method": I, "expand-row-keys": V.value, "row-key": "id" }, { default: r(() => [e(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }, { default: r(({ row: { sourceRow: t }, $index: y }) => [t.boolPartyA ? (p(), f(c, { key: 0, show: !!t.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : g("", true), !t.boolPartyA && t.materialIsWhole === l(w).ODDMENT.V ? (p(), f(c, { key: 1, color: l(w).V[t.materialIsWhole].COLOR, name: l(w).VL[t.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : g("", true), x("span", null, v(y + 1), 1)]), _: 1 }), e(o, { key: "project", align: "left", label: "项目", prop: "project", "show-overflow-tooltip": "", "min-width": "100" }), e(o, { key: "serialNumber", align: "left", label: "物料编码", prop: "serialNumber", "show-overflow-tooltip": "", "min-width": "100" }), e(o, { key: "classifyName", align: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "", "min-width": "100" }), e(o, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" }, { default: r(({ row: { sourceRow: t } }) => [x("span", null, v(l(q)(t)), 1)]), _: 1 }), e(o, { key: "brand", align: "left", label: "品牌", prop: "brand", "show-overflow-tooltip": "", width: "100" }), e(o, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "80px" }), e(o, { key: "outboundQuantity", prop: "outboundQuantity", label: "出库数量", align: "center", "min-width": "80px" }), e(o, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "80px" }), e(o, { key: "outboundMete", prop: "outboundMete", label: "出库核算量", align: "center", "min-width": "80px" }), e(o, { align: "center", fixed: "right", label: "操作", width: "80px" }, { default: r((t) => [e(O, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (y) => H(t.row, t.$index) }, { reference: r(() => [e(M, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, J = F(X, [["__scopeId", "data-v-a7aad8cd"]]);
export {
  J as default
};
